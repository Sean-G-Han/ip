import java.io.IOException;

public class Tooth {
    public static void main(String[] args) {
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
        Brain.processing();
        System.out.println("____________________________________________________________");
        System.out.println("Bye bye");
        System.out.println("____________________________________________________________");
    }
}
