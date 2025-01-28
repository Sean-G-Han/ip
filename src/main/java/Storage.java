import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static void save(ArrayList<Task> memory) {
        try {
            File f = new File("src/main/save.txt");
            FileWriter fw = new FileWriter(f);
            for (Task t : memory) {
                fw.append(t.serialize());
                fw.append("\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error : File is a directory not a file");
        } finally {
            System.out.println("Saving :");
        }
    }

    public static void load(ArrayList<Task> memory) {
        try {
            memory.clear();
            File f = new File("src/main/save.txt");
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                try {
                    Task t = Brain.create(s.nextLine());
                    memory.add(t);
                } catch (InvalidFileFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Warning: [save.txt] not found. If this is the first time booting the app, please ignore.");
        } finally {
            System.out.println("Loading :");
        }
    }
}
