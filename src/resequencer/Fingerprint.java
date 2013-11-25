package resequencer;

import java.util.List;

public class Fingerprint {
    private final String name;
    private final boolean disabled;
    private final String[] hooks;
    private final int minSDK;
    private final String[] require;
    private final String[] incompatible;
    private final List<MatchOperation> matchOperations;
    private final List<InjectOperation> injectOperations;
    private final List<RecodeOperation> recodeOperations;

    public Fingerprint(String name) {
        this(name, false, null, 0, null, null, null, null, null);
    }

    public Fingerprint(String name, List<MatchOperation> matchOperations, List<InjectOperation> injectOperations,
                    List<RecodeOperation> recodeOperations) {
        this(name, false, null, 0, null, null, matchOperations, injectOperations, recodeOperations);
    }

    public Fingerprint(String name, boolean disabled, String[] hooks, int minSDK, String[] require,
                    String[] incompatibles, List<MatchOperation> matchOperations,
                    List<InjectOperation> injectOperations, List<RecodeOperation> recodeOperations) {
        this.name = name;
        this.disabled = disabled;
        this.hooks = hooks;
        this.minSDK = minSDK;
        this.require = require;
        this.incompatible = incompatibles;
        this.matchOperations = matchOperations;
        this.injectOperations = injectOperations;
        this.recodeOperations = recodeOperations;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return disabled;
    }

    public String[] getInstallHooks() {
        return hooks;
    }

    public int getMinSDK() {
        return minSDK;
    }

    public String[] getRequireFPs() {
        return require;
    }

    public String[] getIncompatibleFPs() {
        return incompatible;
    }

    public List<MatchOperation> getMatchOperations() {
        return matchOperations;
    }

    public List<InjectOperation> getInjectOperations() {
        return injectOperations;
    }

    public List<RecodeOperation> getRecodeOperations() {
        return recodeOperations;
    }
}
