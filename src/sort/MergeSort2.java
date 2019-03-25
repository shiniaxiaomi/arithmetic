package sort;

/**
 * Created by Yingjie.Lu on 2019/3/25.
 */

import util.ArrUtil;

/**
 * 自底向上的归并排序（只需要迭代即可完成）
 */
public class MergeSort2 extends SortTemplate {
    //这里的l和r都是索引值
    @Override
    public void sort(int[] arr, int l, int r) {

        for(int sz=1;sz<r-l;sz+=sz){
            //进行merge
            for(int i=l;i+sz<r;i+=2*sz){
                //对arr[i...i+sz-1]和arr[i+sz...i+s*sz-1]进行归并
                MergeSort.merge(arr,i,i+sz-1,min(i+2*sz-1,r-1));
            }
        }


    }

    private int min(int a,int b){
       return a<b?a:b;
    }

    public static void main(String[] args) {
        int[] arr = ArrUtil.randomArr(100, 1, 100);
        new MergeSort2().testSort(arr,0,arr.length);
    }
}
