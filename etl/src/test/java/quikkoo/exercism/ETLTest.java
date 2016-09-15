package quikkoo.exercism;

import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ETLTest {

    private final ETL etl = new ETL();

    @Test
    public void testTransformOneValue() {
        Map<Integer, List<String>> actual = ImmutableMap.of(
                1, (List<String>) ImmutableList.of("A"));
        Map<String, Integer> expected = ImmutableMap.of(
                "a", 1);
        assertThat(etl.transform(actual), is(expected));
    }

    @Test
    public void testTransformMoreValues() {
        Map<Integer, List<String>> actual = ImmutableMap.of(
                1, (List<String>) ImmutableList.of("A", "E", "I", "O", "U"));
        Map<String, Integer> expected = ImmutableMap.of(
                "a", 1,
                "e", 1,
                "i", 1,
                "o", 1,
                "u", 1);
        assertThat(etl.transform(actual), is(expected));
    }

    @Test
    public void testTransformMoreKeys() {
        Map<Integer, List<String>> actual = ImmutableMap.of(
                1, (List<String>) ImmutableList.of("A", "E"),
                2, (List<String>) ImmutableList.of("D", "G"));
        Map<String, Integer> expected = ImmutableMap.of(
                "a", 1,
                "e", 1,
                "d", 2,
                "g", 2);
        assertThat(etl.transform(actual), is(expected));
    }

    @Test
    public void testTransformFullDataset() {
        Map<Integer, List<String>> actual = new ImmutableMap.Builder<Integer, List<String>>().
                put(1, (List<String>) ImmutableList.of("A", "E", "I", "O", "U", "L", "N", "R", "S", "T")).
                put(2, (List<String>) ImmutableList.of("D", "G")).
                put(3, (List<String>) ImmutableList.of("B", "C", "M", "P")).
                put(4, (List<String>) ImmutableList.of("F", "H", "V", "W", "Y")).
                put(5, (List<String>) ImmutableList.of("K")).
                put(8, (List<String>) ImmutableList.of("J", "X")).
                put(10, (List<String>) ImmutableList.of("Q", "Z")).
                build();
        Map<String, Integer> expected = new ImmutableMap.Builder<String, Integer>().
                put("a", 1).put("b",  3).put("c", 3).put("d", 2).put("e", 1).
                put("f", 4).put("g",  2).put("h", 4).put("i", 1).put("j", 8).
                put("k", 5).put("l",  1).put("m", 3).put("n", 1).put("o", 1).
                put("p", 3).put("q", 10).put("r", 1).put("s", 1).put("t", 1).
                put("u", 1).put("v",  4).put("w", 4).put("x", 8).put("y", 4).
                put("z", 10).
                build();
        assertThat(etl.transform(actual), is(expected));
    }
}
