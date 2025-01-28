public class TodoCommand implements Command {

    public String s;

    public TodoCommand(String s) {
        this.s = s;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) {
        ToDo todo = ToDo.of(s);
        tasks.add(todo);
        ui.say("Added new todo");
    }
}
