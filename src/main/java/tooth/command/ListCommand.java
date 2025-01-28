package tooth.command;

import tooth.stuff.*;

public class ListCommand implements Command {
    int index = 0;

    public ListCommand() {};

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.say("List:");
        tasks.forEach((t) -> {
            System.out.println(index + " " + t.toString());
            index++;
        });
    }
}
