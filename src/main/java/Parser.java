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
                Brain.list();
                break;

            case "mark":
                int markIndex = Integer.parseInt(s);
                memory.mark(markIndex);
                break;

            case "unmark":
                int unmarkIndex = Integer.parseInt(s);
                memory.unmark(unmarkIndex);
                break;

            case "todo":
                Brain.todo(s);
                break;

            case "event":
                Brain.event(s);
                break;

            case "deadline":
                Brain.deadline(s);
                break;

            case "delete":
                int deleteIndex = Integer.parseInt(s);
                memory.delete(deleteIndex);
                break;

            case "save":
                Storage.save(memory);
                break;

            case "load":
                Storage.load(memory);
                break;

            default:
                throw new InvalidCommandException("Command " + command + " does not exist");
        }

        return false;
    }
}
