package util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Administrator on 2019/3/16.
 */

/**
 * 数组的工具类
 */
public class ArrUtil {

    //打印数组
    public static void printArr(int[] arr){
        String s = Arrays.toString(arr);
        System.out.println(s);
    }

    //随机生成num个整数，数值在min-max之间
    public static int[] randomArr(int num,int min,int max){
        int[] arr=new int[num];
        Random random = new Random();
        for(int i=0;i<num;i++){
            arr[i] = min+random.nextInt(max-min);
        }
        return arr;
    }

    //交换数组中的两个数
    public static void swap(int[] arr,int index1,int index2){
        int buff = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=buff;
    }

    public static boolean isSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }

    //复制数组
    public static int[] copy(int[] arr){
        int[] clone = arr.clone();
        return clone;
    }



    public static void main(String[] args) {
        int[] arr = randomArr(10, 4, 10);
        printArr(arr);
    }




}
