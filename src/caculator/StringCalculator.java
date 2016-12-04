package caculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yhkim on 2016. 12. 3..
 */
public class StringCalculator {
    public int sum(String str) {
        String realToken = "\\+";

        // Arrays.asList(new String[]{",", ":"}) 사용할 경우 list 에 요소를 add 할 수 없다
//        List<String> tokens = Arrays.asList(new String[]{",", ":"});

        List<String> tokens = new ArrayList<>();
        tokens.add(",");
        tokens.add(":");

        str = str.trim();

        if(isBlank(str)) {
            return 0;
        }

        if(str.indexOf("//") == 0) {
            int endIdx = str.indexOf("\n");
            tokens.add(str.substring("//".length(), endIdx + "\n".length() - 1));
            str = str.substring(endIdx + "\n".length());
        }

        for(String token : tokens) {
            str = str.replaceAll(token, realToken);
        }

        List<Integer> targets = new ArrayList<>();

        for(String target : str.split(realToken)) {
            targets.add(Integer.parseInt(target));
        }

        int i = 0;

        for(Integer targetInt : targets) {
            if(targetInt < 0) {
                throw new RuntimeException("음수!");
            }

            i += targetInt;

        }

//        Arrays.stream(str.split(realToken)).mapToInt(x -> Integer.parseInt(x)).sum();

        return i;
    }

    private boolean isBlank(String str) {
        return str == null || str.isEmpty();
    }
}
