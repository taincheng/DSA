package How2j_tests.Junit;

import org.junit.Test;

public class test {

    public int add(int ... a){
        int c = 0;
        for(int i = 0; i < a.length; i ++){
            c = c + a[i];
        }
        return c;
    }
}
