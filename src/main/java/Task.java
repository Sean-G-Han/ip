public class Task {
    String name;
    boolean done;

    private Task(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public static Task of(String name) {
        return new Task(name, false);
    }

    public Task complete() {
        return new Task(this.name, true);
    }

    public Task incomplete() {
        return new Task(this.name, false);
    }

    @Override
    public String toString() {
        return (done ? "[X] " : "[ ] ") + name;
    }
}
