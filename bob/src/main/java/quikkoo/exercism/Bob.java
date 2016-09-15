package quikkoo.exercism;

import java.util.regex.Pattern;

public class Bob {

    private final Pattern fine = Pattern.compile("^[\\s\\v\\x{00A0}\\x{2002}]*$");
    private final Pattern whoa = Pattern.compile("^[^\\p{Ll}]*[A-Z][^\\p{Ll}]*$");
    private final Pattern sure = Pattern.compile("^.*\\?[\\s\\v]*$");

    public String hey(String question) {
        if (fine.matcher(question).matches()) {
            return "Fine. Be that way!";
        }
        if (whoa.matcher(question).matches()) {
            return "Whoa, chill out!";
        }
        if (sure.matcher(question).matches()) {
            return "Sure.";
        }
        return "Whatever.";
    }
}
