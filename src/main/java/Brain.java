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
        int i = 1;
        System.out.println("____________________________________________________________");
        for (Task task : memory) {
            System.out.println(Integer.toString(i) + ": " + task);
            i++;
        }
        System.out.println("____________________________________________________________");
    }

    public static void processing() {
        Scanner scanner = new Scanner(System.in);
        String echo = "";
        while (true) {
            echo = scanner.nextLine();
            if (echo.equals("bye"))
                break;
            else if (echo.equals("list"))
                list();
            else
                add(echo);
        }
    }
}
