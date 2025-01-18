import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Brain {
    public static List<Task> memory = new ArrayList<>();

    public static void add(String item) {
        System.out.println("____________________________________________________________");
        System.out.println("added: " + item);
        System.out.println("____________________________________________________________");
        memory.add(Task.of(item));
    }

    public static void list() {
        int i = 0;
        System.out.println("____________________________________________________________");
        for (Task task : memory) {
            System.out.println(Integer.toString(i) + ": " + task);
            i++;
        }
        System.out.println("____________________________________________________________");
    }

    public static void mark(int i) {
        Task item = memory.get(i).complete();
        memory.set(i, item);
        System.out.println("____________________________________________________________");
        System.out.println("Setting as marked: " + item);
        System.out.println("____________________________________________________________");
    }

    public static void unmark(int i) {
        Task item = memory.get(i).incomplete();
        memory.set(i, item);
        System.out.println("____________________________________________________________");
        System.out.println("Setting as unmarked: " + item);
        System.out.println("____________________________________________________________");
    }

    public static void processing() {
        Scanner scanner = new Scanner(System.in);
        String echo = "";
        while (true) {
            echo = scanner.nextLine();
            String[] command = echo.split(" ");
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
            else
                add(echo);
        }
    }
}
