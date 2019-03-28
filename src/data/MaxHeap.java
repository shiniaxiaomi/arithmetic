package data;

/**
 * Created by Yingjie.Lu on 2019/3/28.
 */

import util.ArrUtil;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 最大堆：
 *  需要满足的性质：
 *      1.堆中的某个节点的值总是不大于其父节点的值
 *      2.必须是一颗完全二叉树(除了最后一层，其他层数的节点个数必须是最大值)
 *
 *  实现：
 *      1.可以使用链表实现
 *      2.可以使用数组实现（经典实现）
 *          //从数组的1号索引开始
 *          parent(i)=i/2;
 *          left child (i)=2*i;
 *          right child (i)=2*i+1
 *
 *  特点：用于动态数据的维护
 */
public class MaxHeap {

    private int[] data;
    int index=1;//索引从1开始，index指向的是下一个要存放元素的索引
    int capacity;//堆的容量

    MaxHeap(int n){
        data=new int[n+1];//从数组的1号索引开始
        this.capacity=n;
    }

    //使用heapify算法直接构建最大堆（通过数组直接构建一个最大堆）
    MaxHeap(int[] arr,int n){
        data=new int[n+1];//从数组的1号索引开始
        this.capacity=n;
        index=n+1;
        for(int i=0;i<arr.length;i++){
            data[i+1]=arr[i];
        }

        for(int i=index/2;i>0;i--){
            shiftDown(i);
        }
    }

    public int size(){
        return index-1;
    }

    public boolean isEmpty(){
        return (index-1)==0;
    }

    //添加数据
    public void insert(int n) throws Exception {
        if(index>capacity+1){
            throw new Exception("堆已满！");
        }
        data[index]=n;
        index++;

        shiftUp(index-1);

    }

    private void shiftUp(int k){
        while (k>1 && data[k]>data[k/2]){
            ArrUtil.swap(data,k,k/2);
            k=k/2;//更新k
        }
    }

    public int popMax(){

        int buff=data[1];
        data[1]=data[index-1];
        index--;

        shiftDown(1);

        return buff;
    }

    private void shiftDown(int k){

        if(2*k>(index-1)){//没有节点
            return;
        }else if(2*k==(index-1)){//有只左节点
            if(data[k]<data[2*k]){
                ArrUtil.swap(data,k,2*k);
                shiftDown(2*k);
            }
        }else{//有两个节点
            if(data[2*k]>data[2*k+1]){
                ArrUtil.swap(data,k,2*k);
                shiftDown(2*k);
            }else{
                ArrUtil.swap(data,k,2*k+1);
                shiftDown(2*k+1);
            }
        }

    }


    public void printData(){

        int n=1;
        for(int i=1;i<index;i++){
            System.out.print(data[i]+" ");
            if(n==i){
                System.out.println();
                n=2*i+1;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        int n=10;

        int[] ints = ArrUtil.randomArr(n, 1, 10);
        MaxHeap maxHeap=new MaxHeap(ints,n);

//        MaxHeap maxHeap=new MaxHeap(n);
//        for(int i=0;i<n;i++){
//            maxHeap.insert(ints[i]);
//        }

        System.out.println();
        for(int i=0;i<n;i++){
            System.out.print(maxHeap.popMax()+" ");
        }


    }

}
