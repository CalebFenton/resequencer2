package resequencer;


public class MatchResult {
    final SmaliFile file;
    final int start;
    final int end;
    final int group;

    public MatchResult(SmaliFile file, int start, int end, int group) {
        this.file = file;
        this.start = start;
        this.end = end;
        this.group = group;
    }
}