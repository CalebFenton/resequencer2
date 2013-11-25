package resequencer;

import java.util.ArrayList;
import java.util.List;

public class FingerprintStore {
    private List<Fingerprint> prints;

    public FingerprintStore() {
        prints = new ArrayList<Fingerprint>();
    }

    public FingerprintStore(List<Fingerprint> prints) {
        this.prints = prints;
    }

    public void addFingerprints(List<Fingerprint> prints) {
        this.prints.addAll(prints);
    }

    public List<MatchOperation> getMatchOperations() {
        List<MatchOperation> results = new ArrayList<MatchOperation>();

        for (Fingerprint f : prints) {
            for (MatchOperation op : f.getMatchOperations()) {
                results.add(op);
            }
        }

        return results;
    }
}
