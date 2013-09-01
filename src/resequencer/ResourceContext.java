package resequencer;

import java.util.List;

public class ResourceContext {
    private String apkPath;
    private String smaliPath;
    private List<String> SmaliFilePaths;
    private List<Gene> Genes;

    public String getAPKPath() {
        return apkPath;
    }

    public String getSmaliPath() {
        return smaliPath;
    }

    public List<String> getSmaliFiles() {
        return SmaliFilePaths;
    }

    public List<Gene> getGenes() {
        return Genes;
    }

    public void setAPKPath(String path) {
        apkPath = path;
    }

    public void setSmaliPath(String path) {
        smaliPath = path;
    }

    public void setSmaliFiles(List<String> files) {
        SmaliFilePaths = files;
    }

    public void setGenes(List<Gene> genes) {
        Genes = genes;
    }
}
