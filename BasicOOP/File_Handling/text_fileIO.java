import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.io.IOException;
import java.nio.*;



public class text_fileIO {

    public void write(String content, String filename) {

        try {
            Path path = Paths.get(filename);

            Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read(String filename) {
        try {
            Path path = Paths.get(filename);
            if (!Files.exists(path)) {
                System.out.println("File did't exist");
                return;
            }
            for (String line : Files.readAllLines(path)) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void read_parsing(String filename) {
        try {

            Path path = Paths.get(filename);
            if (!Files.exists(path)) {
                System.out.println("File didn't exist");
                return;
            }
            String[] fields;
            for (String line : Files.readAllLines(path)) {

                if (line == null || line.trim().isEmpty()) {
                    System.out.println("Empty file");
                    return;
                }

                fields = line.split(",");

                String name = fields[0].trim();
                int roll = Integer.parseInt(fields[1].trim());
                String edu = fields[2].trim();

                Student student = new Student(name, edu, roll);
                System.out.println(student.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}