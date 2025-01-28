import java.util.Arrays;
import java.util.Scanner;

public class Parser {

    Storage storage;
    TaskList memory;
    UI ui;

    public Parser(Storage storage, TaskList tasks, UI ui) {
        this.storage = storage;
        this.memory = tasks;
        this.ui = ui;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            try {
                String input = scanner.nextLine();
                exit = parse(input);
            } catch (ToothException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean parse(String input) throws InvalidParamException {
        if (input.indexOf('|') > -1)
            throw new InvalidCommandException("Character [|] is not allowed");

        String[] pieces = input.split(" ");
        String command = pieces[0];
        String s = String.join(" ", Arrays.copyOfRange(pieces, 1, pieces.length));

        switch (command) {
            case "bye":
                return true;

            case "list":
                Brain.list(memory);
                ui.say("Here is the list of Task");
                break;

            case "mark":
                int markIndex = Integer.parseInt(s);
                memory.mark(markIndex);
                ui.say("Marked task" + markIndex);
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(s);
                memory.unmark(unmarkIndex);
                ui.say("Unmarked task" + unmarkIndex);
                break;

            case "todo":
                Brain.todo(s, memory);
                ui.say("Adding Task [todo: " + s + "]");
                break;

            case "event":
                Brain.event(s, memory);
                ui.say("Adding Task [event: " + s + "]");
                break;

            case "deadline":
                Brain.deadline(s, memory);
                ui.say("Adding Task [deadline: " + s + "]");
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(s);
                ui.say("Deleting" + deleteIndex);
                memory.delete(deleteIndex);
                break;

            case "save":
                storage.save(memory);
                ui.say("Data Saved");
                break;

            case "load":
                storage.load(memory);
                ui.say("Data Loaded");
                break;

            default:
                throw new InvalidCommandException("Command " + command + " does not exist");
        }

        return false;
    }
}
