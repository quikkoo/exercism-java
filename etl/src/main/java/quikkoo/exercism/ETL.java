package quikkoo.exercism;

import java.util.List;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

public class ETL {
    public Map<String, Integer> transform(Map<Integer, List<String>> data) {
        ImmutableMap.Builder<String, Integer> builder = ImmutableMap.builder();
        for (Map.Entry<Integer, List<String>> entry : data.entrySet()) {
            for (String value : entry.getValue()) {
                builder.put(value.toLowerCase(), entry.getKey());
            }
        }

        return builder.build();
    }
}
