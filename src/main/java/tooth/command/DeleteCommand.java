package tooth.command;

import tooth.stuff.*;

public class DeleteCommand implements Command {

    public int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        tasks.delete(index);
        ui.say("Deleted tooth.task.Task: " + index);
    }
}
