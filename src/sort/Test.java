package sort;

import util.ArrUtil;

/**
 * Created by Administrator on 2019/3/24.
 */
public class Test {


    public static void main(String[] args) {
        int n=50000;
        int[] arr1 = ArrUtil.randomArr(n, 10, 100);
        int[] arr2 = ArrUtil.copy(arr1);

        new SelectionSort().testSort(arr1,0,n);
        InsertSort.getInstance().testSort(arr2,0,n);
    }

}
