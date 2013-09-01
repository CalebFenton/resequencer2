package resequencer;

import java.util.List;

public class Fingerprint {
    String Name;
    boolean Enabled;
    String[] InstallHooks;
    String[] PreReplaceCallbacks;
    String[] PostReplaceCallbacks;
    int MinSDK;
    String[] RequireFPs;
    String[] IncompatibleFPs;
    List<Region> Regions;

    public Fingerprint(String name, List<Region> regions) {
        this(name, true, null, null, null, 0, null, null, regions);
    }

    public Fingerprint(String name, boolean enabled, String[] installHooks, String[] preReplaceCallbacks,
                    String[] postReplaceCallbacks, int minSDK, String[] requireFPs, String[] incompatibleFPs,
                    List<Region> regions) {
        Name = name;
        Enabled = enabled;
        InstallHooks = installHooks;
        PreReplaceCallbacks = preReplaceCallbacks;
        PostReplaceCallbacks = postReplaceCallbacks;
        MinSDK = minSDK;
        RequireFPs = requireFPs;
        IncompatibleFPs = incompatibleFPs;
        Regions = regions;
    }
}
