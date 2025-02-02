package tooth.stuff;

import tooth.command.FileR;
import tooth.exception.InvalidFileFormatException;
import tooth.task.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *  Stores and loads data into a save.txt
 */
public class Storage {

    public Storage() {};

    /**
     * Save data into save.txt
     *
     * @param memory the tasklist containing all the tasks
     */
    public void save(TaskList memory) {
        try {
            File f = new File("src/main/save.txt");
            FileWriter fw = new FileWriter(f);
            memory.forEach((t) -> {
                try {
                    fw.append(t.serialize());
                    fw.append("\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
            fw.close();
        } catch (IOException e) {
            throw new InvalidFileFormatException("Error : File is a directory not a file");
        }
    }

    /**
     * Load data from save.txt
     *
     * @param memory the tasklist containing all the tasks
     */
    public void load(TaskList memory) {
        try {
            memory.clear();
            File f = new File("src/main/save.txt");
            Scanner s = new Scanner(f);
            while (s.hasNext()) {
                try {
                    Task t = FileR.create(s.nextLine());
                    memory.add(t);
                } catch (InvalidFileFormatException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            throw new InvalidFileFormatException("Warning: [save.txt] not found. If this is the first time booting the app, please ignore.");
        }
    }
}
