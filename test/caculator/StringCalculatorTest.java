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
        assertEquals(0, sc.sum(" "));
        assertEquals(0, sc.sum(null));
    }

    @Test
    public void 문자열_한개() {
        assertEquals(1, sc.sum("1"));
    }

    @Test
    public void 쉼표_두개() {
        assertEquals(3, sc.sum("1,2"));
    }

    @Test
    public void 쉼표_세개() {
        assertEquals(6, sc.sum("1,2,3"));
    }

    @Test
    public void 쉼표와_콜론_복합() {
        assertEquals(6, sc.sum("1,2:3"));
    }

    @Test
    public void 커스텀_구분자() {
        assertEquals(6, sc.sum("//;\n1;2;3"));
    }

    @Test(expected = RuntimeException.class)
    public void 음수() {
        sc.sum("-1");
    }
}
