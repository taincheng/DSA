package How2j_tests.List_Map_;

import java.util.Comparator;
import java.util.TreeSet;

public class Treeset_comparator {
    public static void main(String[] args){
        Comparator<Integer> C = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(C);
        for(int i = 0; i < 10; i++){
            treeSet.add(i);
        }

        System.out.println(treeSet);
    }
}
