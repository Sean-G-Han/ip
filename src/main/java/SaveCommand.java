public class SaveCommand implements Command {

    public SaveCommand() {};

    public void execute(TaskList tasks, UI ui, Storage storage) {
        storage.save(tasks);
    }
}