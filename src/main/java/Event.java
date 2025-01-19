public class Event extends Task {
    String from, to;
    private Event(String name, boolean done, String from, String to){
        super(name, done);
        this.from = from;
        this.to = to;
    }

    public static Event of(String name, String from, String to) {
        return new Event(name, false, from, to);
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
    public String toString() {
        return "[E]" + super.toString() + "(From: " + from + ", To: " + to + ")";
    }
}