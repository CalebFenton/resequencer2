package resequencer;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        buildFPs();

    }

    private static void buildFPs() {
        Operation op = new Operation(Operation.OperationType.MATCH, "optest", ".*");
        List<Operation> ol = new ArrayList<Operation>();
        ol.add(op);

        // (OperationType type, String name, String beforeOp, String insideOp, String afterOp, String value,String
        // oldValue) {
        Region r = new Region("test", "", "", ol);

        List<Region> l = new ArrayList<Region>();
        l.add(r);

        Fingerprint fp = new Fingerprint("testfp", l);

        List<Fingerprint> fpl = new ArrayList<Fingerprint>();
        fpl.add(fp);
        // Fingerprints fps = new Fingerprints(fpl);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String result = gson.toJson(fpl);

        System.out.println(result);
    }
}
