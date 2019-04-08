package sort;

/**
 * Created by Yingjie.Lu on 2019/3/25.
 */

import util.ArrUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * 快速排序：将数组递归的分成两部分，使得左边数组<buff，右边数组>buff，直至完成排序
 */
public class QuickSort extends SortTemplate{

    Random random = new Random();

    @Override
    public void sort(int[] arr, int l, int r) {

        quickSort(arr,l,r);
    }

    private void quickSort(int[] arr,int l,int r){

        //当数组个数为0时返回
        if(l>r){
            return;
        }

        //找到中间的分界点
        int p = partition2(arr, l, r);

        quickSort(arr,l,p-1);//处理数组的左半边
        quickSort(arr,p+1,r);//处理数组的右半边

    }

    //方法一：对于大量重复数值的数组不能够快速的进行排序
    //在arr[l...r]中，找到索引p，使得arr[l...p-1]<arr[p],arr[p+1...r]>arr[p]
    private int partition(int[] arr,int l,int r){
        //在arr[l+1...i]的元素小于arr[l]
        //在arr[i+1...j)的元素大于arr[l]
        //j指向的是下一个要判断的元素

        int nextInt = random.nextInt(r - l + 1)+l;
        ArrUtil.swap(arr,l,nextInt);

        int buff=arr[l];
        int i=l;
        for(int j=l+1;j<=r;j++){
            if(arr[j]<buff){
                ArrUtil.swap(arr,i+1,j);
                i++;
            }
        }
        ArrUtil.swap(arr,l,i);

        return i;
    }

    //方法二：解决大量重复数值的问题，防止其退化成O(n^2)的时间复杂度
    //从数组的左右两边向中间扫描，
    private int partition2(int[] arr,int l,int r){

        int nextInt = random.nextInt(r - l + 1)+l;
        ArrUtil.swap(arr,l,nextInt);
        int buff=arr[l];

        //arr[l+1...i)<=buff ; arr(j...r]>=buff
        int i=l+1,j=r;
        while(true){
            while ( i<=r && arr[i]<buff) i++;
            while ( j>=l+1 && arr[j]>buff) j--;
            if(i>j) break;
            ArrUtil.swap(arr,i,j);
            i++;
            j--;
        }

        ArrUtil.swap(arr,l,j);


        return j;
    }


    public static void main(String[] args) {

        int[] arr = ArrUtil.randomArr(1000000, 1, 1000);
        new QuickSort().testSort(arr,0,arr.length-1);
//        ArrUtil.printArr(arr);
    }

}
