package resequencer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static Logger log = Logger.getLogger(SequenceMatcher.class.getSimpleName());
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws Exception {
        FingerprintStore store = FingerprintLoader.loadFingerprintsFromDirectory("resources/test/fingerprints/");

        log.info(gson.toJson(store));
        
        /*
         * String config = buildFPs();
         * 
         * FingerprintStore s = parseConfig(config); // System.out.println(gson.toJson(s));
         * 
         * List<SequenceFile> files = new ArrayList<SequenceFile>(); SequenceFile sf = new
         * SequenceFile("resources/test/smali/test1.smali"); System.out.println(sf.content); files.add(sf);
         * 
         * SequenceMatcher.execute(files, s.getMatchOperations());
         */
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

        System.out.println(result);

        return result;
    }
}
