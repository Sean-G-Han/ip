package tooth.command;
import tooth.stuff.*;
import tooth.task.Task;

public class FindCommand implements Command {

    String s;

    public FindCommand(String s) {
        this.s = s;
    };

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.say("Here is what I found:");
        tasks.forEach((x) -> {
            if (canFind(x)) {
                System.out.println(x);
            }
        });
    }

    private boolean canFind(Task task) {
        String temp = task.toString();
        return temp.contains(s);
    }
}
