package test;

/**
 * Created by Administrator on 2019/3/25.
 */

import util.ArrUtil;

import java.util.Arrays;

/**
 * 求解逆序对,时间复杂度为O(Nlogn)，使用归并排序求解
 */
public class NegativeSequencePair {

    public static int sum=0;

    public int solve(int[] arr){



        return 1;
    }

    //l和r均为索引
    public void mergeSort(int[] arr,int l,int r){
        if(l>=r){
            return;
        }

        int mid=(l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);

        merge(arr,l,r);
    }

    private void merge(int[] arr, int l, int r) {
        //复制一份数组，进行辅助排序
        int[] buff=new int[r-l+1];
        for(int i=l;i<=r;i++){
            buff[i-l]=arr[i];
        }

        //将数组分成arr[l,mid]和arr[mid+1...r]两个部分
        int mid=(l+r)/2;
        int left=l;
        int right=mid+1;

        //进行求解逆序对
        for(int i=l;i<=r;i++){
            if(left>mid){
                arr[i]=buff[right-l];
                right++;
            }else if(right>r){

                arr[i]=buff[left-l];
                left++;
            }else if(buff[left-l]<buff[right-l]){
                arr[i]=buff[right-l];
                right++;
            }else{
                sum=sum+(r-right+1);//累加逆序对

                arr[i]=buff[left-l];
                left++;
            }
        }

    }


    public static void main(String[] args) {
        int n=5;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=n-i;
        }


        new NegativeSequencePair().mergeSort(arr,0,arr.length-1);

        ArrUtil.printArr(arr);
        System.out.println(NegativeSequencePair.sum);

    }

}
