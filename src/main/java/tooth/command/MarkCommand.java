public class MarkCommand implements Command {

    int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.say("Marking Task: " + index);
        tasks.mark(index);
    }
}
