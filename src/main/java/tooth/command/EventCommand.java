package tooth.command;

import java.time.LocalDate;

import tooth.stuff.Storage;
import tooth.stuff.TaskList;
import tooth.stuff.UI;
import tooth.task.Event;

/**
 * Command that creates a new event
 */
public class EventCommand implements Command {

    private String s;
    private LocalDate from;
    private LocalDate to;

    /**
     * Constructor of EventCommand
     * @param s the description of the Event
     */
    public EventCommand(String s, LocalDate from, LocalDate to) {
        this.s = s;
        this.from = from;
        this.to = to;
    }

    /**
     * Execute Task
     */
    public void execute(TaskList tasks, UI ui, Storage storage) {
        Event event = Event.of(s, from, to);
        tasks.add(event);
        ui.say("Added new event");
    }
}
