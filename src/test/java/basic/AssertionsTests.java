package basic;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionsTests {

    @Test
    public void thisTestShouldFail() {
        Assert.assertEquals(1, 2);
    }

    @Test
    public void thisTestShouldPass() {
        Assert.assertEquals(1, 1);
        String expectedText = "asd";
        Assert.assertEquals("asd", expectedText);
        Assert.assertTrue(true);
    }
}