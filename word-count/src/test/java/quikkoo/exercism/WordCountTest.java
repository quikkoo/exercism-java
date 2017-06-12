package quikkoo.exercism;

import java.util.Map;
import org.junit.Test;
import com.google.common.collect.ImmutableMap;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class WordCountTest {

    @Test
    public void testShouldCountOneWord() {
        String phrase = "word";
        Map<String, Integer> counts = ImmutableMap.of("word", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldCountOneOfEach() {
        String phrase = "one of each";
        Map<String, Integer> counts = ImmutableMap.of(
                "one", 1,
                "of", 1,
                "each", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldCountMultipleOccurences() {
        String phrase = "one fish two fish red fish blue fish";
        Map<String, Integer> counts = ImmutableMap.of(
                "one", 1,
                "fish", 4,
                "two", 1,
                "red", 1,
                "blue", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldCountEverythingJustOnce() {
        String phrase = "all the kings horses and all the kings men";
        Map<String, Integer> counts = new ImmutableMap.Builder<String, Integer>()
                .put("all", 2)
                .put("the", 2)
                .put("kings", 2)
                .put("horses", 1)
                .put("and", 1)
                .put("men", 1)
                .build();

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldIgnorePunctuation() {
        String phrase = "car : carpet as java : javascript!!&@$%^&";
        Map<String, Integer> counts = ImmutableMap.of(
                "car", 1,
                "carpet", 1,
                "as", 1,
                "java", 1,
                "javascript", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldHandleCrampedLists() {
        String phrase = "one,two,three";
        Map<String, Integer> counts = ImmutableMap.of(
                "one", 1,
                "two", 1,
                "three", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldIncludeNumbers() {
        String phrase = "testing, 1, 2 testing";
        Map<String, Integer> counts = ImmutableMap.of(
                "testing", 2,
                "1", 1,
                "2", 1);
 
        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldNormalizeCase() {
        String phrase = "go Go GO";
        Map<String, Integer> counts = ImmutableMap.of("go", 3);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldAllowApostrophes() {
        String phrase = "First: don't laugh. Then: don't cry.";
        Map<String, Integer> counts = ImmutableMap.of(
                "first", 1,
                "don't", 2,
                "laugh", 1,
                "then", 1,
                "cry", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldTreatSymbolsAsSeparators() {
        String phrase = "hey,my_spacebar_is_broken.";
        Map<String, Integer> counts = ImmutableMap.of(
                "hey", 1,
                "my", 1,
                "spacebar", 1,
                "is", 1,
                "broken", 1);

        assertThat(WordCount.calculate(phrase), is(counts));
    }

    @Test
    public void testShouldCountsWordsWithQuotations() {
        String phrase = "Joe can't tell between 'large' and large.";
        Map<String, Integer> counts = new ImmutableMap.Builder<String, Integer>()
                .put("joe", 1)
                .put("can't", 1)
                .put("tell", 1)
                .put("between", 1)
                .put("large", 2)
                .put("and", 1)
                .build();

        assertThat(WordCount.calculate(phrase), is(counts));
    }
}
