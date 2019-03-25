package sort;

import util.ArrUtil;

/**
 * Created by Administrator on 2019/3/24.
 */

/**
 * 自顶向下的归并排序（利用了递归）
 */
public class MergeSort extends SortTemplate {


    @Override
    public void sort(int[] arr,int l,int r) {

        mergeSort(arr,l,r-1);

    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public static void merge(int[] arr,int l,int mid,int r){

        int[] buff=new int[r-l+1];
        for(int i=l;i<=r;i++){
            buff[i-l]=arr[i];
        }

        int i=l,j=mid+1;
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=buff[j-l];
                j++;
            }else if(j>r){
                arr[k]=buff[i-l];
                i++;
            }else if(buff[i-l]<buff[j-l]){
                arr[k]=buff[i-l];
                i++;
            }else {
                arr[k]=buff[j-l];
                j++;
            }
        }

    }


    //递归使用归并排序，对arr[l...r]的范围进行排序
    private void mergeSort(int[] arr,int left,int right){

        //当元素小到15时，转用插入排序
//        if(right-left<15){
//            InsertSort.getInstance().sort(arr,left,right+1);
//            return;
//        }

        if(left>=right){
            return;
        }

        int middle=(left+right)/2;
        mergeSort(arr,left,middle);
        mergeSort(arr,middle+1,right);

        //只有当数组是无序的时候，才进行merge操作
        if(arr[middle]>arr[middle+1]){
            merge(arr,left,middle,right);
        }

    }


    public static void main(String[] args) {
        int[] arr = ArrUtil.randomArr(50000, 1, 100);
        new MergeSort().testSort(arr,0,arr.length);
//        ArrUtil.printArr(arr);
}
}
