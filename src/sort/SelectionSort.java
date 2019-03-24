package sort;

import util.ArrUtil;

/**
 * Created by Administrator on 2019/3/16.
 */

/**
 * 选择排序类
 */
public class SelectionSort extends SortTemplate{

    //定义排序的算法
    @Override
    public void sort(int[] arr,int l,int r) {
        for(int i=l;i<r;i++){
            int minIndex=i;
            //找到最小值
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[minIndex]){
                    minIndex=j;
                }
            }
            ArrUtil.swap(arr,i,minIndex);//交换两个数值
        }
    }


    public static void main(String[] args) {
        int[] arr = ArrUtil.randomArr(10000, 0, 10);//随机生成数组
        new SelectionSort().testSort(arr,0,arr.length);//进行选择排序
    }
}
