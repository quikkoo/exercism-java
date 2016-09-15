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
    public void testDetectNoMatches() {
        Anagram detector = new Anagram("diaper");
        List<String> anagrams = detector.matches(
            ImmutableList.of("hello", "world", "zombies", "pants"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testDetectSimpleAnagram() {
        Anagram detector = new Anagram("ant");
        List<String> anagrams = detector.matches(
            ImmutableList.of("tan", "stand", "at"));
        assertThat(anagrams, hasItems("tan"));
    }

    @Test
    public void testDetectMultipleAnagrams() {
        Anagram detector = new Anagram("master");
        List<String> anagrams = detector.matches(
            ImmutableList.of("stream", "pigeon", "maters"));
        assertThat(anagrams, hasItems("stream", "maters"));
    }

    @Test
    public void testDoesNotConfuseDifferentDuplicates() {
        Anagram detector = new Anagram("galea");
        List<String> anagrams = detector.matches(
            ImmutableList.of("eagle"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testDoesNotIncludeIdenticalWords() {
        Anagram detector = new Anagram("corn");
        List<String> anagrams = detector.matches(
            ImmutableList.of("corn", "dark", "Corn", "rank", "CORN", "cron", "park"));
        assertThat(anagrams, hasItems("cron"));
    }

    @Test
    public void testEliminateAnagramsWithSameChecksum() {
        Anagram detector = new Anagram("mass");
        List<String> anagrams = detector.matches(
            ImmutableList.of("last"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testEliminateAnagramSubsets() {
        Anagram detector = new Anagram("good");
        List<String> anagrams = detector.matches(
            ImmutableList.of("dog", "goody"));
        assertThat(anagrams, is(empty()));
    }

    @Test
    public void testDetectAnagrams() {
        Anagram detector = new Anagram("listen");
        List<String> anagrams = detector.matches(
            ImmutableList.of("enlists", "google", "inlets", "banana"));
        assertThat(anagrams, hasItems("inlets"));
    }

    @Test
    public void testMoreAnagrams() {
        Anagram detector = new Anagram("allergy");
        List<String> anagrams = detector.matches(
            ImmutableList.of("gallery", "ballerina", "regally", "clergy", "largely", "leading"));
        assertThat(anagrams, hasItems("gallery", "largely", "regally"));
    }

    @Test
    public void testTreatSubjectAnagramsAsCaseInsensitive() {
        Anagram detector = new Anagram("Orchestra");
        List<String> anagrams = detector.matches(
            ImmutableList.of("cashregister", "carthorse", "radishes"));
        assertThat(anagrams, hasItems("carthorse"));
    }


    @Test
    public void testTreatCandidateAnagramsAsCaseInsensitive() {
        Anagram detector = new Anagram("orchestra");
        List<String> anagrams = detector.matches(
            ImmutableList.of("cashregister", "Carthorse", "radishes"));
        assertThat(anagrams, hasItems("Carthorse"));
    }
}
