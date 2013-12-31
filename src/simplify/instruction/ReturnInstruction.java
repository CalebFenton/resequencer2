package simplify.instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import simplify.ExecutionContext;
import simplify.Method;
import simplify.Simplifier;

public class ReturnInstruction implements ControlInstruction {

    private static final Logger log = Logger.getLogger(Simplifier.class.getSimpleName());

    private static final Pattern PATTERN = Pattern.compile("(return[^ ]*)[ ]?([vp]\\d+)?");

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public void execute(ExecutionContext ectx, String... args) {
        String op = args[1];
        String name = args[2];

        if (!op.equals("return-void")) {
            ectx.getRegister(args[2]);
        }
    }

    @Override
    public List<String> getPossibleBranchLabels(Method method, String... args) {
        return new ArrayList<String>();
    }

}
