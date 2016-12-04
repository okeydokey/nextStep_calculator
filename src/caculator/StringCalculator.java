package caculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yhkim on 2016. 12. 3..
 */
public class StringCalculator {
    public int sum(String str) {

        if(isBlank(str)) {
            return 0;
        }

        return Arrays.stream(split(str)).mapToInt(x -> Integer.parseInt(x)).filter(x -> { if(x < 0) throw new RuntimeException(); return true; }).sum();

    }

    private String[] split(String str) {
        String delimiter = ",|:";

        Matcher m = matcherCustomDelimiter(str);

        if(m.find()) {
            delimiter += "|" + m.group(1);
            str = m.group(2);
        }

        return str.split(delimiter);
    }

    private Matcher matcherCustomDelimiter(String str) {
        return Pattern.compile("//(.)\n(.*)").matcher(str);
    }

    private boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
}
