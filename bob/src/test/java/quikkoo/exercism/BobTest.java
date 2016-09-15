package quikkoo.exercism;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BobTest {

    private final Bob bob = new Bob();

    @Test
    public void testSaySomething() {
        String response = bob.hey("Tom-ay-to, tom-aaaah-to.");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShouting() {
        String response = bob.hey("WATCH OUT!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testAskingAQuestion() {
        String response = bob.hey("Does this cryogenic chamber make me look fat?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testAskingANumericQuestion() {
        String response = bob.hey("You are, what, like 15?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testTalkingForcefully() {
        String response = bob.hey("Let's go make out behind the gym!");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testUsingAcronymsInRegularSpeech() {
        String response = bob.hey("It's OK if you don't want to go to the DMV.");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testForcefulQuestions() {
        String response = bob.hey("WHAT THE HELL WERE YOU THINKING?");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShoutingNumbers() {
        String response = bob.hey("1, 2, 3 GO!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testOnlyNumbers() {
        String response = bob.hey("1, 2, 3");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testQuestionWithOnlyNumbers() {
        String response = bob.hey("4?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testShoutingWithSpecialCharacters() {
        String response = bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testShoutingWithUmlauts() {
        String response = bob.hey("\u00dcML\u00c4\u00dcTS!");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testCalmlySpeakingWithUmlauts() {
        String response = bob.hey("\u00dcML\u00e4\u00dcTS!");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testShoutingWithNoExclamationMark() {
        String response = bob.hey("I HATE YOU");
        assertThat(response, is("Whoa, chill out!"));
    }

    @Test
    public void testStatementContainingQuestionMark() {
        String response = bob.hey("Ending with ? means a question.");
        assertThat(response, is("Whatever."));
    }

    @Test
    public void testPrattlingOn() {
        String response = bob.hey("Wait! Hang on. Are you going to be OK?");
        assertThat(response, is("Sure."));
    }

    @Test
    public void testSilence() {
        String response = bob.hey("");
        assertThat(response, is("Fine. Be that way!"));
    }

    @Test
    public void testProlongedSilence() {
        String response = bob.hey("    ");
        assertThat(response, is("Fine. Be that way!"));
    }
}
