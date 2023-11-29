package bookAnalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean exists() {
        File bookFile = new File("src/" + name + ".txt");
        return bookFile.exists();
    }

    public String getContent() throws IOException {
        File bookFile = new File("src/" + name + ".txt");
        StringBuilder contentBuilder = new StringBuilder();

        try ( BufferedReader reader = new BufferedReader(new FileReader(bookFile)) ) {
            String line;
            while ( (line = reader.readLine()) != null ) {
                contentBuilder.append(line).append("\n");
            }
        }

        return contentBuilder.toString();
    }
}
