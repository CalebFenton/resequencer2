package resequencer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class SequenceFile extends File {
    private static final long serialVersionUID = 2674346051117459428L;

    public String content;

    public SequenceFile(final String path) throws IOException {
        super(path);

        content = FileUtils.readFileToString(this);
    }

    public void save() throws IOException {
        FileUtils.writeStringToFile(this, content);
    }
}
