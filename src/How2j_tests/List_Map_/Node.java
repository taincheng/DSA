package How2j_tests.List_Map_;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public Node leftNode;
    public Node rightNode;
    public Object value;

    //插入节点
    public void add(Object v) {
        //如果当前节点没有值，插入当前节点
        if (value == null) {
            value = v;
        } else {
            //如果值比当前节点小或等于，放到左节点
            if ((Integer) v <= (Integer) value) {
                if (leftNode == null)
                    leftNode = new Node();
                leftNode.add(v);
            } else {
                if (rightNode == null)
                    rightNode = new Node();
                rightNode.add(v);
            }
        }
    }

    /*
    中序遍历
     */
    public List<Object> values_mad() {
        List<Object> list = new ArrayList<>();

        //左节点遍历结果
        if (leftNode != null) {
            list.addAll(leftNode.values_mad());
        }

        //当前节点
        list.add(value);

        //右节点遍历结果
        if (rightNode != null) {
            list.addAll(rightNode.values_mad());
        }

        return list;
    }

    /*
    左序遍历
     */
    public List<Object> values_left() {
        List<Object> list = new ArrayList<>();

        //当前节点
        list.add(value);

        //左节点遍历结果
        if (leftNode != null) {
            list.addAll(leftNode.values_left());
        }


        //右节点遍历结果
        if (rightNode != null) {
            list.addAll(rightNode.values_left());
        }

        return list;
    }

    /*
    右序遍历
     */
    public List<Object> values_rig() {
        List<Object> list = new ArrayList<>();

        //左节点遍历结果
        if (leftNode != null) {
            list.addAll(leftNode.values_rig());
        }

        //右节点遍历结果
        if (rightNode != null) {
            list.addAll(rightNode.values_rig());
        }

        //当前节点
        list.add(value);

        return list;
    }

    public static void main(String[] args) {
        int[] random = {67, 7, 30, 73, 10, 0, 78, 81, 10, 74};

        Node root = new Node();

        for (int i : random) {
            root.add(i);
        }

        System.out.println("左序遍历"+root.values_left());
        System.out.println("中序遍历"+root.values_mad());
        System.out.println("右序遍历"+root.values_rig());

    }
}
