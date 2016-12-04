package caculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by yhkim on 2016. 12. 3..
 */
public class StringCalculatorTest {
    private StringCalculator sc;

    @Before
    public void before() {
        sc = new StringCalculator();
    }

    @Test
    public void 빈문자열() {
        assertEquals(sc.sum(" "), 0);
        assertEquals(sc.sum(null), 0);
    }

    @Test
    public void 쉼표_두개() {
        assertEquals(sc.sum("1,2"), 3);
    }

    @Test
    public void 쉼표_세개() {
        assertEquals(sc.sum("1,2,3"), 6);
    }

    @Test
    public void 쉼표와_콜론_복합() {
        assertEquals(sc.sum("1,2:3"), 6);
    }

    @Test
    public void 커스텀_구분자() {
        assertEquals(sc.sum("//;\n1;2;3"), 6);
    }

    @Test(expected = RuntimeException.class)
    public void 음수() {
        sc.sum("-1");
    }
}
