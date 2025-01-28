public class UnmarkCommand implements Command {

    int index;

    public UnmarkCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.say("Unmarking Task: " + index);
        tasks.unmark(index);
    }
}
