package tooth.command;

import tooth.stuff.Storage;
import tooth.stuff.TaskList;
import tooth.stuff.UI;

/**
 * Command that marks a certain task as complete in TaskList
 */
public class MarkCommand implements Command {

    private int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Execute task
     */
    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.say("Marking tooth.task.Task: " + index);
        tasks.mark(index);
    }
}
