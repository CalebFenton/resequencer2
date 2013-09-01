package plugins;

import java.io.InputStream;
import java.util.List;

import net.xeoh.plugins.base.Plugin;
import resequencer.ResourceContext;

public interface ResequencerPlugin extends Plugin {
    public String getName();

    public String getAuthor();

    public String getVersion();

    public void beforeDecompile(ResourceContext context);

    public void beforeResequence(ResourceContext context);

    public void beforeCompile(ResourceContext context);

    public void beforeExit(ResourceContext context);

    public List<InputStream> getFingerprints();

    public List<InputStream> getGenes();

    public List<String> getGlobalVariables();
}
