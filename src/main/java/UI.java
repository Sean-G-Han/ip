import javax.sound.midi.SysexMessage;

public class UI {
    private static final String logo = """
     _______          _   _    \s
    |__   __|        | | | |   \s
       | | ___   ___ | |_| |__ \s
       | |/ _ \\ / _ \\| __| '_ \\\s
       | | (_) | (_) | |_| | | |
       |_|\\___/ \\___/ \\__|_| |_|
    """;

    public static void welcome() {
        System.out.println(logo);
        System.out.println("Welcome to Tooth");
    }

    public static void bye() {
        System.out.println("Ok Bye");
        System.out.println(logo);
    }

    public static void say(String sentence) {
        System.out.println("""
                 ∧,,,,∧
                ( -O·O-)
                /    <3
                """);
        System.out.println(sentence);
    }
}
