package simplify;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.regex.Matcher;

import simplify.graph.CallGraphBuilder;
import simplify.instruction.Instruction;

public class Executor {

    private static final Logger log = Logger.getLogger(Simplifier.class.getSimpleName());

    private int maxLocalJumps;
    private int maxCallDepth;

    private final MethodContainer methods;
    private final List<Instruction> instructions;

    public Executor(MethodContainer methods, List<Instruction> instructions) {
        this.methods = methods;
        this.instructions = instructions;

        maxLocalJumps = 100;
        maxCallDepth = 5;
    }

    public void setLocalMaxDepth(int depth) {
        maxLocalJumps = depth;
    }

    public void setExternalMaxDepth(int depth) {
        maxCallDepth = depth;
    }

    public void execute() {
        buildCallGraphs();

        if (1 == 1) {
            return;
        }

        Set<String> signatures = methods.getMethodSignatures();
        for (String signature : signatures) {
            ExecutionContext ectx = new ExecutionContext(methods, signature);

            try {
                Method method = methods.getMethod(signature);
                executeMethod(ectx, method);

                MethodSimplifier.simplify(ectx, method);
            } catch (MaxCallDepthExceeded | MaxLocalJumpsExceeded | UnsupportedInstruction e) {
                log.severe(e.toString());
            }
        }
    }

    private void buildCallGraphs() {
        Set<String> signatures = methods.getMethodSignatures();
        for (String signature : signatures) {
            Method method = methods.getMethod(signature);
            CallGraphBuilder.build(method);
            System.out.println(method.getRootNode().toGraph());
        }
    }

    public void executeMethod(ExecutionContext ectx, Method method) throws MaxCallDepthExceeded, MaxLocalJumpsExceeded,
                    UnsupportedInstruction {
        log.fine("Executing method: " + ectx.getMethodSignature());

        while (ectx.getPosition() != null) {
            String line = method.getLine(ectx.getPosition());

            log.finer("\tparsing line: '" + line.trim() + "'");

            boolean matched = false;
            for (Instruction instruction : instructions) {
                Matcher m = instruction.getPattern().matcher(line);

                if (m.matches()) {
                    String[] args = new String[m.groupCount() + 1];
                    for (int i = 0; i < args.length; i++) {
                        args[i] = m.group(i);
                    }

                    instruction.execute(ectx, args);

                    if (ectx.getCallDepth() > this.maxCallDepth) {
                        throw new MaxCallDepthExceeded(ectx.getStackTrace());
                    }

                    if (ectx.getLocalJumps() > this.maxLocalJumps) {
                        throw new MaxLocalJumpsExceeded(ectx.getStackTrace());
                    }

                    matched = true;
                    break;
                }
            }

            if (!matched) {
                throw new UnsupportedInstruction(line.trim());
            }
        }
    }

}
