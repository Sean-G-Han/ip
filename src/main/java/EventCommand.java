import java.time.LocalDate;

public class EventCommand implements Command {

    String s;
    LocalDate from;
    LocalDate to;

    public EventCommand(String s, LocalDate from, LocalDate to) {
        this.s = s;
        this.from = from;
        this.to = to;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        Event event = Event.of(s, from, to);
        tasks.add(event);
        ui.say("Added new event");
    }
}
