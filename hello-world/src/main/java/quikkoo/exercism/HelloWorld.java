package quikkoo.exercism;

public final class HelloWorld {

    private HelloWorld() {
    }

    public static String greet() {
        return String.format("Hello, %s!", "World");
    }

    public static String greet(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        if ("".equals(name)) {
            name = "World";
        }

        return String.format("Hello, %s!", name);
    }
}
