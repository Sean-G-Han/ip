import java.util.ArrayList;
import java.util.function.Consumer;

public class TaskList {

    private final ArrayList<Task> memory = new ArrayList<>();

    public TaskList(){};

    public void add(Task item) {
        memory.add(item);
    }

    public void delete(int i) throws InvalidParamException {
        if (i > memory.size() - 1) {
            throw new InvalidParamException("Index " + i + " is out of range");
        } else {
            memory.remove(i);
        }
    }

    public void clear() {
        memory.clear();
    }

    public void mark(int i) throws InvalidParamException{
        if (i > memory.size() - 1) {
            throw new InvalidParamException("Index " + i + " is out of range");
        } else {
            Task item = memory.get(i).complete();
            memory.set(i, item);
        }
    }

    public void unmark(int i) throws InvalidParamException {
        if (i > memory.size() - 1) {
            throw new InvalidParamException("Index " + i + " is out of range");
        } else {
            Task item = memory.get(i).incomplete();
            memory.set(i, item);
        }
    }

    public void forEach(Consumer<? super Task> action) {
        memory.forEach(action);
    }
}
