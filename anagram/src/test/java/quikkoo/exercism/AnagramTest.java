package quikkoo.exercism;

import java.util.List;
import org.junit.Test;
import com.google.common.collect.ImmutableList;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnagramTest {

    @Test
    public void testShouldDetectNoMatches() {
        Anagram detector = new Anagram("diaper");
        List<String> anagrams = detector.matches(
            ImmutableList.of("hello", "world", "zombies", "pants"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testShouldDetectSimpleAnagram() {
        Anagram detector = new Anagram("ant");
        List<String> anagrams = detector.matches(
            ImmutableList.of("tan", "stand", "at"));
        assertThat(anagrams, hasItems("tan"));
    }

    @Test
    public void testShouldDetectMultipleAnagrams() {
        Anagram detector = new Anagram("master");
        List<String> anagrams = detector.matches(
            ImmutableList.of("stream", "pigeon", "maters"));
        assertThat(anagrams, hasItems("stream", "maters"));
    }

    @Test
    public void testShouldNotConfuseDifferentDuplicates() {
        Anagram detector = new Anagram("galea");
        List<String> anagrams = detector.matches(
            ImmutableList.of("eagle"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testShouldNotIncludeIdenticalWords() {
        Anagram detector = new Anagram("corn");
        List<String> anagrams = detector.matches(
            ImmutableList.of("corn", "dark", "Corn", "rank", "CORN", "cron", "park"));
        assertThat(anagrams, hasItems("cron"));
    }

    @Test
    public void testShouldEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");
        List<String> anagrams = detector.matches(
            ImmutableList.of("dog", "goody"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testShouldEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");
        List<String> anagrams = detector.matches(
            ImmutableList.of("last"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testShouldDetectAnagrams() {
        Anagram detector = new Anagram("listen");
        List<String> anagrams = detector.matches(
            ImmutableList.of("enlists", "google", "inlets", "banana"));
        assertThat(anagrams, hasItems("inlets"));
    }

    @Test
    public void testShouldDetectMoreMultipleAnagrams() {
        Anagram detector = new Anagram("allergy");
        List<String> anagrams = detector.matches(
            ImmutableList.of("gallery", "ballerina", "regally", "clergy", "largely", "leading"));
        assertThat(anagrams, hasItems("gallery", "largely", "regally"));
    }

    @Test
    public void testShouldTreatSubjectAnagramsAsCaseInsensitive() {
        Anagram detector = new Anagram("Orchestra");
        List<String> anagrams = detector.matches(
            ImmutableList.of("cashregister", "carthorse", "radishes"));
        assertThat(anagrams, hasItems("carthorse"));
    }

    @Test
    public void testShouldTreatCandidateAnagramsAsCaseInsensitive() {
        Anagram detector = new Anagram("orchestra");
        List<String> anagrams = detector.matches(
            ImmutableList.of("cashregister", "Carthorse", "radishes"));
        assertThat(anagrams, hasItems("Carthorse"));
    }
}
