import java.util.Scanner;

public class Tooth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String toothLogo =
                        "  / \\      / \\    \n" +
                        " |           |    \n" +
                        " | |X|  |X|  |    \n" +
                        " |    0      |    \n" +
                        " \\ [][][][]  /    \n" +
                        "  \\_________/     \n";
        System.out.println("____________________________________________________________");
        System.out.println(toothLogo + "Hello I am Tooth\n" + "What do you want?");
        System.out.println("____________________________________________________________");
        String echo = "";
        while (true) {
            echo = scanner.nextLine();
            if (echo.equals("bye"))
                break;
            System.out.println(echo);
            System.out.println("____________________________________________________________");
        }
        System.out.println("Bye bye");
        System.out.println("____________________________________________________________");
    }
}
