import java.time.LocalDate;

public class Deadline extends Task {
    LocalDate deadline;
    private Deadline(String name, boolean done, LocalDate deadline) {
        super(name, done);
        this.deadline = deadline;
    }

    public static Deadline of(String name, LocalDate deadline) {
        return new Deadline(name, false, deadline);
    }

    public static Deadline of(String name, boolean done, LocalDate deadline) {
        return new Deadline(name, done, deadline);
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
    public String serialize() {
        return "D|" + name + "|" + deadline  + "|" + done;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (Due on: " + deadline + ")";
    }
}