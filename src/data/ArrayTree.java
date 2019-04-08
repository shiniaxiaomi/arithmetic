package data;

/**
 * Created by Yingjie.Lu on 2019/4/8.
 */

import util.ArrUtil;

/**
 * 1.满二叉树的数组实现
 * 2.树的前中后序遍历
 */
public class ArrayTree {

    private int[] arr=null;
    private int index=0;//当前索引
    private int capacity;//总容量

    public ArrayTree(int capacity) {
        this.capacity=capacity;
        this.arr=new int[capacity];
    }

    public ArrayTree(int capacity,int[] arr) {
        this.capacity=capacity;
        this.arr=new int[capacity];
        for(int i=0;i<arr.length;i++){
            this.arr[i]=arr[i];
        }
    }

    public void add(int i) throws Exception {
        if(index>capacity){
            throw new Exception("树已满！");
        }

        arr[index]=i;
        index++;
    }


    /**
     * 左孩子的索引：2*i+1
     * 右孩子的索引：2*i+2
     */

    //前序遍历：深度优先遍历
    public void preOrderPrint(int index){
        //自己
        System.out.println(arr[index]);

        //左孩子
        if(2*index+1<capacity){
            preOrderPrint(2*index+1);
        }

        //右孩子
        if(2*index+2<capacity){
            preOrderPrint(2*index+2);
        }
    }

    //中序遍历：当树是最大堆的时候，使用中序遍历可以打印排序后的结果
    public void inOrderPrint(int index){
        //左孩子
        if(2*index+1<capacity){
            inOrderPrint(2*index+1);
        }

        //自己
        System.out.println(arr[index]);

        //右孩子
        if(2*index+2<capacity){
            inOrderPrint(2*index+2);
        }
    }

    //后序遍历：先遍历完子树，再遍历自己
    public void postOrderPrint(int index){
        //左孩子
        if(2*index+1<capacity){
            postOrderPrint(2*index+1);
        }

        //右孩子
        if(2*index+2<capacity){
            postOrderPrint(2*index+2);
        }

        //自己
        System.out.println(arr[index]);
    }

    public static void main(String[] args) {

        int n=7;
        int[] arr={8, 4, 2, 7, 5, 8, 8};
        ArrayTree arrayTree = new ArrayTree(n, arr);
//        arrayTree.preOrderPrint(0);//前序遍历
//        arrayTree.inOrderPrint(0);//中序遍历
        arrayTree.postOrderPrint(0);//后序遍历


    }



}
