package tooth.task;

import java.time.LocalDate;

public class Event extends Task {
    LocalDate from, to;
    private Event(String name, boolean done, LocalDate from, LocalDate to){
        super(name, done);
        this.from = from;
        this.to = to;
    }

    public static Event of(String name, LocalDate from, LocalDate to) {
        return new Event(name, false, from, to);
    }

    public static Event of(String name, boolean done, LocalDate from, LocalDate to) {
        return new Event(name, done, from, to);
    }

    @Override
    public Event complete() {
        return new Event(this.name, true, this.from, this.to);
    }

    @Override
    public Event incomplete() {
        return new Event(this.name, false, this.from, this.to);
    }

    @Override
    public String serialize() {
        return "E|" + name + "|" + to + "|" + from  + "|" + done;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (From: " + from + ", To: " + to + ")";
    }
}