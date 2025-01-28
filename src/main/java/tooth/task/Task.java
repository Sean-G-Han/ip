public abstract class Task {
    protected String name;
    protected boolean done;

    protected Task(String name, boolean done) {
        this.name = name;
        this.done = done;
    }

    public abstract Task complete();

    public abstract Task incomplete();

    public  abstract String serialize();

    @Override
    public String toString() {
        return (done ? "[X] " : "[ ] ") + name;
    }
}
