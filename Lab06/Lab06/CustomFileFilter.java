package Lab06;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileFilter implements FilenameFilter {
    private List<String> allowedExtensions;
    private List<String> allowedWords;

    public CustomFileFilter() {
        allowedExtensions = new ArrayList<>();
        allowedWords = new ArrayList<>();
        readExtensionsFromFile("extension.in");
        readWordsFromFile("words.in");
    }

    private void readExtensionsFromFile(String filename) {
        try {
            Path path = Paths.get(filename);
            allowedExtensions = Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readWordsFromFile(String filename) {
        try {
            Path path = Paths.get(filename);
            allowedWords = Files.lines(path)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean accept(File dir, String name) {
        if (dir == null || name == null) {
            return false;
        }

        File file = new File(dir, name);

        if (!file.isFile()) {
            return false;
        }

        String fileName = file.getName();
        for (String ext : allowedExtensions) {
            if (fileName.toLowerCase().endsWith(ext.toLowerCase())) {
                for (String word : allowedWords) {
                    if (fileName.toLowerCase().contains(word.toLowerCase())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        File directory = new File("director");

        CustomFileFilter customFilter = new CustomFileFilter();

        String[] files = directory.list(customFilter);

        if (files != null) {
            for (String file : files) {
                System.out.println(file);
            }
        }
    }
}
