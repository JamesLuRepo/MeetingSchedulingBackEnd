package test.testUtils;

import main.utils.TimeCalculator;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTimeCalculator {


    @Test
    public void testShowTime(){
        assertEquals("2020-05-23 12:34",TimeCalculator.showTime("2020-05-23 12:24:43",10));
        assertEquals("2020-07-23 14:44",TimeCalculator.showTime("2020-07-23 14:20:43",24));
    }

    @Test
    public void testGetMillisecondsFromTime() {
        assertEquals(1595478043000L,TimeCalculator.getMillisecondsFromTime("2020-07-23 14:20:43"));
        assertEquals(1590200683000L,TimeCalculator.getMillisecondsFromTime("2020-05-23 12:24:43"));

    }
}
