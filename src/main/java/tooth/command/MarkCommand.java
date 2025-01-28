package tooth.command;

import tooth.stuff.*;

public class MarkCommand implements Command {

    int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.say("Marking tooth.task.Task: " + index);
        tasks.mark(index);
    }
}
