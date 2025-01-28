package tooth.command;
import tooth.stuff.*;

public class ByeCommand implements Command {
    public ByeCommand() {};

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ui.bye();
    }
}
