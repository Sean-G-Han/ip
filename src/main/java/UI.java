import javax.sound.midi.SysexMessage;

public class UI {

    public UI() {};

    private final String logo = """
     _______          _   _    \s
    |__   __|        | | | |   \s
       | | ___   ___ | |_| |__ \s
       | |/ _ \\ / _ \\| __| '_ \\\s
       | | (_) | (_) | |_| | | |
       |_|\\___/ \\___/ \\__|_| |_|
    """;

    public void welcome() {
        System.out.println(logo);
        System.out.println("Welcome to Tooth");
    }

    public void bye() {
        System.out.println("Ok Bye");
        System.out.println(logo);
    }

    public void say(String sentence) {
        System.out.println("""
                 ∧,,,,∧
                ( -O·O-)
                /    <3
                """);
        System.out.println(sentence);
    }
}
