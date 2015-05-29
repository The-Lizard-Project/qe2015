package pl.lizardproject.qe2015;

import java.util.ArrayList;
import java.util.List;

public class NumberListParser {

    public static List<Integer> parseList(String list, String separator) {
        final String[] split = list.split(separator);
        List<Integer> numbers = new ArrayList<>(split.length);
        for(String str : split) {
            try {
                numbers.add(Integer.parseInt(str));
            } catch(NumberFormatException ignored) {
            }
        }
        return numbers;
    }
}
