package resequencer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SmaliFile extends File {
    private static final long serialVersionUID = 2674346051117459428L;

    public String content;

    public SmaliFile(final String path) throws IOException {
        super(path);

        content = readFile(path, Charset.forName("UTF-8"));
    }

    public void save() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(this.getAbsolutePath()));
        writer.write(content);
        writer.close();
    }

    private static String readFile(final String path, final Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));

        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
