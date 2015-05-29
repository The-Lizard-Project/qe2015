package pl.lizardproject.qe2015;

import java.util.ArrayList;
import java.util.List;

public class NumberListParser {

    public static List<Double> parseList(String list, String separator) {
        final String[] split = list.split(separator);
        List<Double> numbers = new ArrayList<>(split.length);
        for (String str : split) {
            try {
                numbers.add(Double.parseDouble(str));
            } catch (NumberFormatException ignored) {
            }
        }
        return numbers;
    }
}
