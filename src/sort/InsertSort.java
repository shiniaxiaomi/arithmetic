package sort;

/**
 * Created by Administrator on 2019/3/24.
 */

import util.ArrUtil;

/**
 * 插入排序1：将下一个值放到前面已经排好序的合适的位置中，直至吧数据全部放完
 */
public class InsertSort extends SortTemplate {

    private static InsertSort insertSort=new InsertSort();

    private InsertSort(){
    }

    public static InsertSort getInstance(){
        return insertSort;
    }

//    @Override
//    public void sort(int[] arr,int l,int r) {
//        for(int i=l;i<r;i++){
//            //寻找元素arr[i]合适的插入位置
//            for(int j=i;j>0;j--){
//                if(arr[j]<arr[j-1]){
//                    ArrUtil.swap(arr,j,j-1);
//                }else{//前面的数值已经比现在效率，那么说明已经在正确的位置了，直接跳出循环
//                    break;
//                }
//            }
//        }
//    }

    //改进后的算法（当前的值只需要交换一次）
    @Override
    public void sort(int[] arr,int l,int r) {
        for(int i=l;i<r;i++){
            int buff=arr[i];//保存当前值
            int j=i;
            //维护前面已经排好序的数组
            while(j>0 && arr[j-1]>buff){//如果前面的数比当前的buff大
                arr[j]=arr[j-1];//将前面的数赋值到后面
                j--;
            }
            arr[j]=buff;//找到了合适的位置
        }
    }

    public static void main(String[] args) {

        int[] arr = ArrUtil.randomArr(10, 10, 100);
        ArrUtil.printArr(arr);
        InsertSort.getInstance().testSort(arr,0,arr.length);
        ArrUtil.printArr(arr);


    }


}
