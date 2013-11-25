package resequencer;

public class RecodeOperation extends Operation {
    private final String Target;
    private final String Replacement;

    public RecodeOperation(String name, String before, String inside, String after, String target, String replacement) {
        super(name, before, inside, after);

        Target = target;
        Replacement = replacement;
    }

    public String getTarget() {
        return Target;
    }

    public String getReplacement() {
        return Replacement;
    }
}
