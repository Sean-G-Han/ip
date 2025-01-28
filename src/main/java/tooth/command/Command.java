package tooth.command;
import tooth.stuff.*;

public interface Command {
    void execute(TaskList tasks, UI ui, Storage storage);
}
