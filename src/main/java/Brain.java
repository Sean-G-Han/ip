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

    public static void list() {
        int i = 0;
        for (Task task : memory) {
            System.out.println(Integer.toString(i) + ": " + task);
            i++;
        }
    }

    public static void mark(int i) {
        Task item = memory.get(i).complete();
        memory.set(i, item);
        System.out.println("Setting as marked: " + item);
    }

    public static void unmark(int i) {
        Task item = memory.get(i).incomplete();
        memory.set(i, item);
        System.out.println("Setting as unmarked: " + item);
    }

    public static void todo(String s) {
        ToDo todo = ToDo.of(s);
        add(todo);
    }

    public static void event(String s) {
        int fromIndex = s.indexOf("/from") + 6;
        int toIndex = s.indexOf("/to") + 4;
        String from = s.substring(fromIndex, toIndex - 4).trim();
        String to = s.substring(toIndex).trim();
        String item = s.substring(0, fromIndex - 6).trim();
        Event event = Event.of(item, from, to);
        add(event);
    }

    public static void deadline(String s) {
        int byIndex = s.indexOf("/by") + 4;
        String by = s.substring(byIndex).trim();
        String item = s.substring(0, byIndex - 4).trim();
        Deadline deadline = Deadline.of(item, by);
        add(deadline);
    }

    public static void processing() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
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
            }
            else if (command[0].equals("unmark")) {
                int i = Integer.parseInt(command[1]);
                unmark(i);
            }
            else if (command[0].equals("todo"))
                todo(s);
            else if (command[0].equals("event"))
                event(s);
            else if (command[0].equals("deadline"))
                deadline(s);
        }
    }
}
