import java.util.Arrays;
import java.util.Scanner;

public class Parser {
    public static void process() {
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

    public static boolean parse(String input) throws InvalidParamException {
        if (input.indexOf('|') > -1)
            throw new InvalidCommandException("Character [|] is not allowed");

        TaskList memory = Brain.memory;
        String[] pieces = input.split(" ");
        String command = pieces[0];
        String s = String.join(" ", Arrays.copyOfRange(pieces, 1, pieces.length));

        switch (command) {
            case "bye":
                return true;

            case "list":
                UI.say("Here is the list of Task");
                Brain.list();
                break;

            case "mark":
                int markIndex = Integer.parseInt(s);
                UI.say("Marked task" + markIndex);
                memory.mark(markIndex);
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(s);
                UI.say("Unmarked task" + unmarkIndex);
                memory.unmark(unmarkIndex);
                break;

            case "todo":
                UI.say("Adding Task [todo: " + s + "]");
                Brain.todo(s);
                break;

            case "event":
                UI.say("Adding Task [event: " + s + "]");
                Brain.event(s);
                break;

            case "deadline":
                UI.say("Adding Task [deadline: " + s + "]");
                Brain.deadline(s);
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(s);
                UI.say("Deleting" + deleteIndex);
                memory.delete(deleteIndex);
                break;

            case "save":
                Storage.save(memory);
                UI.say("Data Saved");
                break;

            case "load":
                Storage.load(memory);
                UI.say("Data Loaded");
                break;

            default:
                throw new InvalidCommandException("Command " + command + " does not exist");
        }

        return false;
    }
}
