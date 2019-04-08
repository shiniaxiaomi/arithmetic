package sort;

/**
 * Created by Administrator on 2019/3/25.
 */

import util.ArrUtil;

import java.util.Random;

/**
 * 快速排序（3路快排）：将数组递归分成3部分，左边数组<buff，中间数组=buff，右边数组>buff，直至完成排序
 */
public class QuickSort3Way extends SortTemplate {

    Random random = new Random();

    @Override
    public void sort(int[] arr, int l, int r) {
        quickSort(arr,l,r);
    }

    private void quickSort(int[] arr,int l,int r){

        if(l>=r){
            return;
        }

        int[] p = partition(arr, l, r);

        quickSort(arr,l,p[0]);
        quickSort(arr,p[1],r);

    }

    private int[] partition(int[] arr, int l, int r) {

        int nextInt = random.nextInt(r - l + 1)+l;
        ArrUtil.swap(arr,l,nextInt);

        int buff=arr[l];

        //arr[l+1...lt]<buff,arr[lt+1...i-1]=buff,arr[gt...r]>v
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while(i<gt){
            if(arr[i]<buff){
                ArrUtil.swap(arr,i,lt+1);//将等于buff的第一个元素和当前元素交换
                i++;
                lt++;
            }else if(arr[i]==buff){
                i++;
            }else{
                ArrUtil.swap(arr,i,gt-1);//将大于buff的前一个元素和当前元素交换，当前指针保持不变
                gt--;
            }
        }
        ArrUtil.swap(arr,l,lt);


        return new int[]{lt-1,gt};
    }

    public static void main(String[] args) {

        int[] arr = ArrUtil.randomArr(1000000, 1, 100000);
        new QuickSort3Way().testSort(arr,0,arr.length-1);
//        ArrUtil.printArr(arr);
    }
}
