package resequencer;

public abstract class Operation {
    private String Name;
    private String Before;
    private String Inside;
    private String After;

    public Operation() {

    }

    public Operation(String name, String before, String inside, String after) {
        Name = name;
        Before = before;
        Inside = inside;
        After = after;
    }

    public String getName() {
        return Name;
    }

    public String getBefore() {
        return Before;
    }

    public String getInside() {
        return Inside;
    }

    public String getAfter() {
        return After;
    }
}
