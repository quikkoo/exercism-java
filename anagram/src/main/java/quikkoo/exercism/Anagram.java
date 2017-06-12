package quikkoo.exercism;

import java.util.Arrays;
import java.util.List;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class Anagram {

    private final String subject;

    public Anagram(String subject) {
        this.subject = subject;
    }

    public List<String> matches(List<String> candidates) {
        final String lsub = subject.toLowerCase();
        final char[] ssub = lsub.toCharArray();
        Arrays.sort(ssub);

        return ImmutableList.copyOf(Iterables.filter(candidates, new Predicate<String>() {
            @Override
            public boolean apply(String candidate) {
                String lcan = candidate.toLowerCase();
                char[] scan = lcan.toCharArray();
                Arrays.sort(scan);

                return hasSameSize(lsub, lcan) && !isSame(lsub, lcan) && hasSameElements(ssub, scan);
            }
        }));
    }

    private static boolean isSame(String lhs, String rhs) {
        return lhs.equals(rhs);
    }

    private static boolean hasSameSize(String lhs, String rhs) {
        return lhs.length() == rhs.length();
    }

    private static boolean hasSameElements(char[] lhs, char[] rhs) {
        boolean result = true;
        for (int i = 0; result && i < lhs.length; i++) {
            result = lhs[i] == rhs[i];
        }

        return result;
    }
}
