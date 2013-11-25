package plugins;

import java.io.InputStream;
import java.util.List;

import net.xeoh.plugins.base.Plugin;

public interface ResequencerPlugin extends Plugin {
    public String getName();

    public String getAuthor();

    public String getVersion();

    public void beforeDecompile(String apkPath, String dexPath);

    public void beforeResequence(String smaliDir);

    public void beforeCompile(String smaliDir);

    public void beforeRepackage(String apkPath, String dexPath);

    public List<InputStream> getFingerprints();

    public List<InputStream> getGenes();

    public List<String> getGlobalVariables();
}
