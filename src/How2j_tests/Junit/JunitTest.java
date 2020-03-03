package How2j_tests.Junit;

import junit.framework.Assert;
import org.junit.Test;

public class JunitTest {
    @Test
    public void testAdd(){
        test test = new test();
        int result = test.add(1,2,3);
        Assert.assertEquals(result,6);
    }
}
