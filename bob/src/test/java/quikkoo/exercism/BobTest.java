package quikkoo.exercism;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BobTest {

    private final Bob bob = new Bob();

    @Test
    public void testShouldRespondToAStatement() {
        String response = bob.hey("Tom-ay-to, tom-aaaah-to.");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouldRespondToShouting() {
        String response = bob.hey("WATCH OUT!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShouldRespondToQuestions() {
        String response = bob.hey("Does this cryogenic chamber make me look fat?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testShouldRespondToQuestionsEndingWithNumbers() {
        String response = bob.hey("You are, what, like 15?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testShouldRespondToForcefulTalking() {
        String response = bob.hey("Let's go make out behind the gym!");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouldRespondToAcronymsInRegularSpeech() {
        String response = bob.hey("It's OK if you don't want to go to the DMV.");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouldRespondToForcefulQuestionsAsShouting() {
        String response = bob.hey("WHAT THE HELL WERE YOU THINKING?");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShouldRespondToShoutingWithSpecialCharacters() {
        String response = bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShouldRespondToNumbersWhenShouting() {
        String response = bob.hey("1, 2, 3 GO!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShouldRespondToNumbersAsSpeech() {
        String response = bob.hey("1, 2, 3");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouldRespondToQuestionsWithOnlyNumbers() {
        String response = bob.hey("4?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testShouldRespondToShoutingWithNoExclamationMark() {
        String response = bob.hey("I HATE YOU");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShouldRespondToStatementsContainingQuestionMark() {
        String response = bob.hey("Ending with ? means a question.");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouldRespondToPrattlingOn() {
        String response = bob.hey("Wait! Hang on. Are you going to be OK?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testShouldRespondToSilence() {
        String response = bob.hey("");
        assertThat(response, is("Fine. Be that way!"));
    }

    @Test
    public void testShouldRespondToProlongedSilence() {
        String response = bob.hey("          ");
        assertThat(response, is("Fine. Be that way!"));
    }

    @Test
    public void testShouldRespondToOthersBlankCharacters() {
        String response = bob.hey("\n\r \t\u000B\u00A0\u2002");
        assertThat(response, is("Fine. Be that way!"));
    }

    @Test
    public void testShouldRespondToMultipleLineQuestions() {
        String response = bob.hey("\nDoes this cryogenic chamber make me look fat?\nno");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouldRespondToNonLettersWithQuestion() {
        String response = bob.hey(":) ?");
        assertThat(response, is("Sure."));
    }
}
