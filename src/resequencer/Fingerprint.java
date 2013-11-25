package resequencer;

import java.util.List;

public class Fingerprint {
    private final String Name;
    private final boolean Enabled;
    private final String[] InstallHooks;
    private final int MinSDK;
    private final String[] RequireFPs;
    private final String[] IncompatibleFPs;
    private final List<MatchOperation> MatchOperations;
    private final List<InjectOperation> InjectOperations;
    private final List<RecodeOperation> RecodeOperations;

    public Fingerprint(String name) {
        this(name, true, null, 0, null, null, null, null, null);
    }

    public Fingerprint(String name, List<MatchOperation> matchOperations, List<InjectOperation> injectOperations,
                    List<RecodeOperation> recodeOperations) {
        this(name, true, null, 0, null, null, matchOperations, injectOperations, recodeOperations);
    }

    public Fingerprint(String name, boolean enabled, String[] installHooks, int minSDK, String[] requireFPs,
                    String[] incompatibleFPs, List<MatchOperation> matchOperations,
                    List<InjectOperation> injectOperations, List<RecodeOperation> recodeOperations) {
        Name = name;
        Enabled = enabled;
        InstallHooks = installHooks;
        MinSDK = minSDK;
        RequireFPs = requireFPs;
        IncompatibleFPs = incompatibleFPs;
        MatchOperations = matchOperations;
        InjectOperations = injectOperations;
        RecodeOperations = recodeOperations;
    }

    public String getName() {
        return Name;
    }

    public boolean isEnabled() {
        return Enabled;
    }

    public String[] getInstallHooks() {
        return InstallHooks;
    }

    public int getMinSDK() {
        return MinSDK;
    }

    public String[] getRequireFPs() {
        return RequireFPs;
    }

    public String[] getIncompatibleFPs() {
        return IncompatibleFPs;
    }

    public List<MatchOperation> getMatchOperations() {
        return MatchOperations;
    }

    public List<InjectOperation> getInjectOperations() {
        return InjectOperations;
    }

    public List<RecodeOperation> getRecodeOperations() {
        return RecodeOperations;
    }
}
