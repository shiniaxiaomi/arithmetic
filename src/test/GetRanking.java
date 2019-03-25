package test;

/**
 * Created by Administrator on 2019/3/25.
 */

import sort.QuickSort;
import util.ArrUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * 求解无序数组中第n大的元素，时间复杂度为O(n),使用快速排序求解
 */
public class GetRanking {

    Random random = new Random();

    public static int var=0;

    public void quickSort(int[] arr,int l,int r,int N){

        if(l>r){
            return;
        }

        int p=partition(arr,l,r);

        if(p<N){
            quickSort(arr,p+1,r,N);
        }else if(p>N){
            quickSort(arr,l,p-1,N);
        }else{
            var=arr[p];
            return;
        }

//        quickSort(arr,l,p-1,0);
//        quickSort(arr,p+1,r,0);

    }

    private int partition(int[] arr, int l, int r) {

        int nextInt = random.nextInt(r - l + 1)+l;
        ArrUtil.swap(arr,l,nextInt);
        int buff=arr[l];

        //arr[l+1...i)<=buff ; arr(j...r]>=buff
        int i=l+1,j=r;
        while (true){
            while (i<=r && arr[i]<buff) i++;
            while(j>=l+1 && arr[j]>buff) j--;
            if(i>j) break;
            ArrUtil.swap(arr,i,j);
            i++;
            j--;
        }

        ArrUtil.swap(arr,l,j);


        return j;
    }


    public static void main(String[] args) {
        int N=5;
        int[] arr = ArrUtil.randomArr(10000, 1, 10000);
        new GetRanking().quickSort(arr,0,arr.length-1,N);
        System.out.println(var);


        Arrays.sort(arr,0,arr.length);
        System.out.println(arr[N]);

    }


}
