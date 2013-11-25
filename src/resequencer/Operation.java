package resequencer;

public abstract class Operation {
    private String name;
    private String before;
    private String inside;
    private String after;

    public Operation() {

    }

    public Operation(String name, String before, String inside, String after) {
        this.name = name;
        this.before = before;
        this.inside = inside;
        this.after = after;
    }

    public String getName() {
        return name;
    }

    public String getBefore() {
        return before;
    }

    public String getInside() {
        return inside;
    }

    public String getAfter() {
        return after;
    }
}
