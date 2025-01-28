import java.time.LocalDate;

public class DeadlineCommand implements Command {

    String s;
    LocalDate by;

    public DeadlineCommand(String s, LocalDate by) {
        this.s = s;
        this.by = by;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        Deadline deadline = Deadline.of(s, by);
        tasks.add(deadline);
        ui.say("Added new deadline");
    }
}
