package resequencer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class MatchOperation extends Operation {
    private final String Target;

    private transient int groupCount;
    private transient int groupOffset;
    private transient List<MatchResult> results;

    public MatchOperation(String name, String target) {
        this(name, null, null, null, target);
    }

    public MatchOperation(String name, String before, String inside, String after, String target) {
        super(name, before, inside, after);

        Target = target;

        groupCount = Pattern.compile(target).matcher("").groupCount();
    }

    public String getTarget() {
        return Target;
    }

    public int getGroupCount() {
        if (groupCount == 0) {
            groupCount = Pattern.compile(getTarget()).matcher("").groupCount();
        }

        return groupCount;
    }

    public void setMatchResults(List<MatchResult> results) {
        this.results = results;
    }

    public void setGroupOffset(int groupOffset) {
        this.groupOffset = groupOffset;
    }

    public void addMatchResult(SmaliFile file, int start, int end, int group) {
        if (results == null) {
            // Gson uses InstanceCreator. Constructor is not called.
            results = new ArrayList<MatchResult>();
        }

        results.add(new MatchResult(file, start, end, group - groupOffset));
    }

    public List<MatchResult> getMatchResults() {
        return results;
    }
}
