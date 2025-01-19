public class ToDo extends Task {
    private ToDo(String name, boolean done){
        super(name, done);
    }

    public static ToDo of(String name) {
        return new ToDo(name, false);
    }

    @Override
    public ToDo complete() {
        return new ToDo(this.name, true);
    }

    @Override
    public ToDo incomplete() {
        return new ToDo(this.name, false);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}