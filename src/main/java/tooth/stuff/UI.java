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
        System.out.println("Welcome to tooth.stuff.Tooth");
        line();
    }

    public void bye() {
        System.out.println("Ok Bye");
        System.out.println(logo);
    }

    private void line() {
        System.out.println("-------------------------------");
    }

    public void say(String sentence) {
        line();
        System.out.println("≽^  •⩊•^≼");
        System.out.println(sentence);
        line();
    }

    public void complain(String sentence) {
        line();
        System.out.println("≽^ ꐦㅍ_ㅍ^≼");
        System.out.println(sentence);
        line();
    }
}
