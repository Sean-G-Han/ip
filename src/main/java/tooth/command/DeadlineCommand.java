package tooth.command;

import java.time.LocalDate;

import tooth.stuff.Storage;
import tooth.stuff.TaskList;
import tooth.stuff.UI;
import tooth.task.Deadline;

/**
 * Command that creates a new deadline
 */
public class DeadlineCommand implements Command {
    private String s;
    private LocalDate by;

    /**
     * Constructor of DeadlineCommand
     * @param s the description of the Deadline
     */
    public DeadlineCommand(String s, LocalDate by) {
        this.s = s;
        this.by = by;
    }

    /**
     * Executes task
     */
    public void execute(TaskList tasks, UI ui, Storage storage) {
        Deadline deadline = Deadline.of(s, by);
        tasks.add(deadline);
        ui.say("Added new deadline");
    }
}
