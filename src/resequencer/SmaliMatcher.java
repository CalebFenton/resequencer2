package resequencer;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmaliMatcher {
    private static Logger log = Logger.getLogger(SmaliMatcher.class.getSimpleName());

    public static void execute(final List<SmaliFile> files, List<MatchOperation> ops) {
        HashMap<Integer, MatchOperation> opByGroup = new HashMap<Integer, MatchOperation>();

        int position = 2;
        StringBuilder masterSequence = new StringBuilder("(");
        for (MatchOperation op : ops) {
            op.setGroupOffset(position);

            int endPosition = position + 1 + op.getGroupCount();
            for (; position < endPosition; position++) {
                opByGroup.put(position, op);
            }
            masterSequence.append("(").append(op.getTarget()).append(")|");
        }
        masterSequence.deleteCharAt(masterSequence.length() - 1).append(")");

        log.info("master=" + masterSequence);

        Pattern p = Pattern.compile(masterSequence.toString());
        for (SmaliFile file : files) {
            Matcher m = p.matcher(file.content);

            while (m.find()) {
                for (int group : opByGroup.keySet()) {
                    String captured = m.group(group);
                    if ((captured != null) && !captured.isEmpty()) {
                        MatchOperation op = opByGroup.get(group);

                        log.info("grp=" + group + ", op=" + op.getName() + ", [" + m.start() + "," + m.end()
                                        + "], cap=" + captured);

                        op.addMatchResult(file, m.start(), m.end(), group);
                    }
                }
            }
        }
    }
}
