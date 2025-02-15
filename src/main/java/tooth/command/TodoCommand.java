package tooth.command;

import tooth.stuff.Storage;
import tooth.stuff.TaskList;
import tooth.stuff.UI;
import tooth.task.ToDo;

/**
 * Command that creates a todo task
 */
public class TodoCommand implements Command {

    private String s;

    public TodoCommand(String s) {
        this.s = s;
    }

    /**
     * Execute task
     */
    public void execute(TaskList tasks, UI ui, Storage storage) {
        int prevNumTask = tasks.numTask();
        ToDo todo = ToDo.of(s);
        tasks.add(todo);
        ui.say("Added new todo");
        assert prevNumTask < tasks.numTask();
    }
}
