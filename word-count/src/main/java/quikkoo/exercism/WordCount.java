package quikkoo.exercism;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

public final class WordCount {

    private static final Pattern PATTERN = Pattern.compile("[^'a-zA-Z0-9]+");

    private WordCount() {
    }

    public static Map<String, Integer> count(String phrase) {
        String[] words = PATTERN.split(phrase);

        Map<String, Integer> result = new TreeMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toLowerCase();
            Integer count = getCount(result, word) + 1;
            result.put(word, count);
        }

        return ImmutableMap.copyOf(result);
    }

    private static Integer getCount(Map<String, Integer> result, String word) {
        return Optional
                .fromNullable(result.get(word))
                .or(0);
    }
}
