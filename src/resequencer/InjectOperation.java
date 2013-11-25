package resequencer;

public class InjectOperation extends Operation {
    private final String Injection;

    public InjectOperation(String name, String before, String inside, String after, String injection) {
        super(name, before, inside, after);

        Injection = injection;
    }

    public String getInjection() {
        return Injection;
    }
}
