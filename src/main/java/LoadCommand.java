public class LoadCommand implements Command {

    public LoadCommand() {};

    public void execute(TaskList tasks, UI ui, Storage storage) {
        storage.load(tasks);
        ui.say("Loaded tasks");
    }
}