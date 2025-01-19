public class Deadline extends Task {
    String deadline;
    private Deadline(String name, boolean done, String deadline){
        super(name, done);
        this.deadline = deadline;
    }

    public static Deadline of(String name, String deadline) {
        return new Deadline(name, false, deadline);
    }

    @Override
    public Deadline complete() {
        return new Deadline(this.name, true, this.deadline);
    }

    @Override
    public Deadline incomplete() {
        return new Deadline(this.name, false, this.deadline);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(Due on: " + deadline + ")";
    }
}