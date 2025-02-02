package tooth.stuff;

public class UI {

    public UI() {};

    /* Tooth's Logo */
    private final String logo = """
     _______          _   _    \s
    |__   __|        | | | |   \s
       | | ___   ___ | |_| |__ \s
       | |/ _ \\ / _ \\| __| '_ \\\s
       | | (_) | (_) | |_| | | |
       |_|\\___/ \\___/ \\__|_| |_|
    """;

    /**
     * Welcomes user
     */
    public void welcome() {
        System.out.println(logo);
        System.out.println("Welcome to Tooth");
        line();
    }

    /**
     * Close program
     */
    public void bye() {
        System.out.println("Ok Bye");
        System.out.println(logo);
    }

    /**
     * Draws a line
     */
    private void line() {
        System.out.println("-------------------------------");
    }

    /**
     * Used to tell user sucess status
     *
     * @param sentence the string to reply user
     */
    public void say(String sentence) {
        line();
        System.out.println("≽^  •⩊•^≼");
        System.out.println(sentence);
        line();
    }

    /**
     * Used to tell user failure status
     *
     * @param sentence the string to reply user
     */
    public void complain(String sentence) {
        line();
        System.out.println("≽^ ꐦㅍ_ㅍ^≼");
        System.out.println(sentence);
        line();
    }
}
