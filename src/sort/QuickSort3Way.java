package sort;

/**
 * Created by Administrator on 2019/3/25.
 */

import util.ArrUtil;

import java.util.Random;

/**
 * 3路快排
 */
public class QuickSort3Way extends SortTemplate {

    Random random = new Random();

    @Override
    public void sort(int[] arr, int l, int r) {
        quickSort(arr, l, r);
    }


    public void quickSort(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int mid[] = partition(arr, l, r);

        quickSort(arr, l, mid[0]);
        quickSort(arr, mid[1], r);


    }

    private int[] partition(int[] arr, int l, int r) {

        int nextInt = random.nextInt(r - l + 1) + l;
        ArrUtil.swap(arr, l, nextInt);

        int buff = arr[l];
        int lt = l;//arr[l+1...lt]<buff
        int gt = r + 1;//arr[lt+1...i)=buff
        int i = l + 1;//arr[gt...r]>v
        while (i < gt) {
            if (arr[i] > buff) {
                ArrUtil.swap(arr, i, gt - 1);
                gt--;
            } else if (arr[i] == buff) {
                i++;
            } else if (arr[i] < buff) {
                ArrUtil.swap(arr, i, lt + 1);
                i++;
                lt++;
            }
        }
        ArrUtil.swap(arr, l, lt);


        return new int[]{lt - 1, gt};

    }


    public static void main(String[] args) {
        int[] arr = ArrUtil.randomArr(1000000, 1, 100);
        new QuickSort3Way().testSort(arr, 0, arr.length - 1);
//        ArrUtil.printArr(arr);
    }
}
