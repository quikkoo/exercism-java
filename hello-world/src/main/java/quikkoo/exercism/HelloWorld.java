package quikkoo.exercism;

public final class HelloWorld {

    private static final String GREETING = "Hello, %s!";

    private HelloWorld() {
    }

    public static String greet() {
        return String.format(GREETING, "World");
    }

    public static String greet(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        return String.format(GREETING, name);
    }
}
