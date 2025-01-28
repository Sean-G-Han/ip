import java.io.IOException;
import java.util.Scanner;

public class Tooth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Storage storage = new Storage();
        TaskList tasks = new TaskList();
        UI ui = new UI();
        Parser parser = new Parser();
        ui.welcome();
        while (true) {
            try {
                String input = scanner.nextLine();
                Command c = parser.parse(input);
                c.execute(tasks, ui, storage);
            } catch (ToothException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
