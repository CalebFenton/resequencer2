package simplify.instruction;

import java.util.regex.Pattern;

import simplify.ExecutionContext;

public class NopInstruction implements Instruction {

    // nop, comments, directives and empty lines
    private static final Pattern PATTERN = Pattern.compile("^\\s*(?:nop|#.*|\\..*)?");

    @Override
    public Pattern getPattern() {
        return PATTERN;
    }

    @Override
    public void execute(ExecutionContext ectx, String... args) {
        // *nop nop* who's there? nop!
    }

}
