package resequencer;

import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    /**
     * @param args
     */
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws Exception {
        String config = buildFPs();

        FingerprintStore s = parseConfig(config);
        // System.out.println(gson.toJson(s));

        List<SmaliFile> files = new ArrayList<SmaliFile>();
        SmaliFile sf = new SmaliFile("resources/test/smali/fufdie/ueycmkn/adbsp.smali");
        System.out.println(sf.content);
        files.add(sf);

        SmaliMatcher.execute(files, s.getMatchOperations());
    }

    private static FingerprintStore parseConfig(String config) {
        FingerprintStore s = gson.fromJson(config, FingerprintStore.class);

        return s;
    }

    private static String buildFPs() {
        List<MatchOperation> ol = new ArrayList<MatchOperation>();
        ol.add(new MatchOperation("optest", "const-string [vp]\\d+, \\\"(.*?)\\\""));
        ol.add(new MatchOperation("optest2", "const v.*"));

        Fingerprint fp = new Fingerprint("testfp", ol, null, null);

        List<Fingerprint> fpl = new ArrayList<Fingerprint>();
        fpl.add(fp);

        FingerprintStore s = new FingerprintStore(fpl);

        String result = gson.toJson(s);

        // System.out.println(result);

        return result;
    }
}
