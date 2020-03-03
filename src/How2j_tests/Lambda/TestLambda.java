package How2j_tests.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author TianCheng
 * @Date 2019/9/3 8:50
 */
public class TestLambda {
    @Test
    public void test(){
        cal(1,2, ((x, y) -> {
            int a = x + y;
            System.out.println("result : " + a);
        }));
    }

    public void cal(int x, int y, InterCal interCal){
        interCal.calTest(x,y);
    }

}
