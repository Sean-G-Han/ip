import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Brain {
    public static List<Task> memory = new ArrayList<>();

    public static void add(Task item) {
        System.out.println("Got it, adding:");
        System.out.println(item.toString());
        System.out.println("Number of Tasks: " + Integer.toString(memory.size() + 1));
        memory.add(item);
    }

    public static void list() throws MemoryIsEmptyException {
        if (memory.isEmpty()) {
            throw new MemoryIsEmptyException("Memory is Empty");
        } else {
            int i = 0;
            for (Task task : memory) {
                System.out.println(Integer.toString(i) + ": " + task);
                i++;
            }
        }
    }

    public static void mark(int i) throws InvalidParamException{
        if (i > memory.size() - 1) {
            throw new InvalidParamException("Index " + i + " is out of range");
        } else {
            Task item = memory.get(i).complete();
            memory.set(i, item);
            System.out.println("Setting as marked: " + item);
        }
    }

    public static void unmark(int i) throws InvalidParamException {
        if (i > memory.size() - 1) {
            throw new InvalidParamException("Index " + i + " is out of range");
        } else {
            Task item = memory.get(i).incomplete();
            memory.set(i, item);
            System.out.println("Setting as unmarked: " + item);
        }
    }

    public static void delete(int i) throws InvalidParamException {
        if (i > memory.size() - 1) {
            throw new InvalidParamException("Index " + i + " is out of range");
        } else {
            System.out.println("Got it, removing:");
            System.out.println(memory.get(i).toString());
            System.out.println("Number of Tasks: " + Integer.toString(memory.size() - 1));
            memory.remove(i);
        }
    }
    public static void todo(String s) throws InvalidParamException {
        if (s.isEmpty()) {
            throw new InvalidParamException("Todo requires a description");
        } else {
            ToDo todo = ToDo.of(s);
            add(todo);
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
            String from = s.substring(fromIndex + 6, toIndex).trim();
            String to = s.substring(toIndex + 4).trim();
            String item = s.substring(0, fromIndex).trim();
            Event event = Event.of(item, from, to);
            add(event);
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
            String by = s.substring(byIndex + 4).trim();
            String item = s.substring(0, byIndex).trim();
            Deadline deadline = Deadline.of(item, by);
            add(deadline);
        }
    }

    public static void processing() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                String[] command = input.split(" ");
                String s = String.join(" ", Arrays.copyOfRange(command, 1, command.length));
                if (command[0].equals("bye"))
                    break;
                else if (command[0].equals("list"))
                    list();
                else if (command[0].equals("mark")) {
                    int i = Integer.parseInt(command[1]);
                    mark(i);
                } else if (command[0].equals("unmark")) {
                    int i = Integer.parseInt(command[1]);
                    unmark(i);
                } else if (command[0].equals("todo"))
                    todo(s);
                else if (command[0].equals("event"))
                    event(s);
                else if (command[0].equals("deadline"))
                    deadline(s);
                else if (command[0].equals("delete")) {
                    int i = Integer.parseInt(command[1]);
                    delete(i);
                } else
                    throw new InvalidCommandException("Command " + command[0] + " does not exist");

            } catch (ToothException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
