package resequencer;

import java.util.ArrayList;
import java.util.List;

public class FingerprintStore {
    public List<Fingerprint> fingerprints;

    public FingerprintStore(List<Fingerprint> fingerprints) {
        this.fingerprints = fingerprints;
    }

    public List<MatchOperation> getMatchOperations() {
        List<MatchOperation> results = new ArrayList<MatchOperation>();

        for (Fingerprint f : fingerprints) {
            for (MatchOperation op : f.getMatchOperations()) {
                results.add(op);
            }
        }

        return results;
    }
}
