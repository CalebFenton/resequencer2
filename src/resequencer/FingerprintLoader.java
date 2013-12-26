package resequencer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class FingerprintLoader {
    private static final Logger log = Logger.getLogger(SequenceMatcher.class.getSimpleName());
    // private static final Encoding = ""
    private static final Type listOfPrints = new TypeToken<List<Fingerprint>>() {
    }.getType();

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static FingerprintStore loadFingerprintsFromDirectory(String path) throws IOException {
        Collection<File> files = FileUtils.listFiles(new File(path), null, false);

        FingerprintStore store = new FingerprintStore();
        for (File file : files) {
            try {
                // FileUtils.readFileToString(file, "UTF-8")
                InputStream in = new FileInputStream(file);
                store.addFingerprints(parseFingerprints(in));
            } catch (FileNotFoundException e) {
                log.severe("File magically disappeared: " + file + "\n" + e);
            }
        }

        return store;
    }

    public static FingerprintStore loadFingerprintsFromResources(String path) throws IOException {
        ClassLoader loader = FingerprintLoader.class.getClassLoader();
        InputStream in = loader.getResourceAsStream(path);
        List<String> files = IOUtils.readLines(in);

        FingerprintStore store = new FingerprintStore();
        for (String file : files) {
            in = loader.getResourceAsStream(file);
            store.addFingerprints(parseFingerprints(in));
        }

        return store;
    }

    private static List<Fingerprint> parseFingerprints(InputStream in) throws IOException {
        String lines = IOUtils.toString(in, "UTF-8");

        return gson.fromJson(lines, listOfPrints);
    }

    private static List<Fingerprint> parseFingerprints(String prints) throws IOException {
        return gson.fromJson(prints, listOfPrints);
    }

}
