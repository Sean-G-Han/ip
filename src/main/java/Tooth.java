import java.io.IOException;

public class Tooth {

    public static void main(String[] args) {
        Storage storage = new Storage();
        TaskList tasks = new TaskList();
        UI ui = new UI();
        ui.welcome();
        Brain.processing(storage, tasks, ui);
        ui.bye();
    }
}
