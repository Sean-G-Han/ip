import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Brain {

    public static TaskList memory = new TaskList();

    public static Task create(String serializedString) throws InvalidFileFormatException {
        String[] parts = serializedString.split("\\|");
        if (parts[0].equals("T")) {
            if (parts.length != 3)
                throw new InvalidFileFormatException("Wrong Number of Parameters: " + serializedString);
            String name = parts[1];
            boolean done = Boolean.parseBoolean(parts[2]);
            return ToDo.of(name, done);
        } else if (parts[0].equals("D")) {
            if (parts.length != 4)
                throw new InvalidFileFormatException("Wrong Number of Parameters: " + serializedString);
            String name = parts[1];
            LocalDate deadline = LocalDate.parse(parts[2]);
            boolean done = Boolean.parseBoolean(parts[3]);
            return Deadline.of(name, done, deadline);
        } else if (parts[0].equals("E")) {
            if (parts.length != 5)
                throw new InvalidFileFormatException("Wrong Number of Parameters: " + serializedString);
            String name = parts[1];
            LocalDate from = LocalDate.parse(parts[2]);
            LocalDate to = LocalDate.parse(parts[3]);
            boolean done = Boolean.parseBoolean(parts[4]);
            return Event.of(name, done, from, to);
        }
        throw new InvalidFileFormatException("Header is wrong");
    }

    public static void list() throws MemoryIsEmptyException {
        memory.forEach(System.out::println);
    }

    public static void todo(String s) throws InvalidParamException {
        if (s.isEmpty()) {
            throw new InvalidParamException("Todo requires a description");
        } else {
            ToDo todo = ToDo.of(s);
            memory.add(todo);
        }
    }

    public static void event(String s) throws InvalidParamException {
        int fromIndex = s.indexOf("/from");
        int toIndex = s.indexOf("/to");
        if (s.isEmpty()) {
            throw new InvalidParamException("Event requires a description");
        } else if (fromIndex == -1 || toIndex == -1) {
            throw new InvalidParamException("Missing either /to or /from field");
        } else if (fromIndex == 0) {
            throw new InvalidParamException("Missing the title");
        } else {
            LocalDate from = LocalDate.parse(s.substring(fromIndex + 6, toIndex).trim());
            LocalDate to = LocalDate.parse(s.substring(toIndex + 4).trim());
            String item = s.substring(0, fromIndex).trim();
            Event event = Event.of(item, from, to);
            memory.add(event);
        }
    }

    public static void deadline(String s) {
        int byIndex = s.indexOf("/by");
        if (s.isEmpty()) {
            throw new InvalidParamException("Event requires a description");
        } else if (byIndex == -1) {
            throw new InvalidParamException("Missing /by field");
        } else if (byIndex == 0) {
            throw new InvalidParamException("Missing the title");
        } else {
            LocalDate by = LocalDate.parse(s.substring(byIndex + 4).trim());
            String item = s.substring(0, byIndex).trim();
            Deadline deadline = Deadline.of(item, by);
            memory.add(deadline);
        }
    }

    public static void processing() {
        Parser.process();
    }
}
