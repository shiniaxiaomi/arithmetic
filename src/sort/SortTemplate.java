package sort;

import util.ArrUtil;

import java.util.Date;

/**
 * Created by Administrator on 2019/3/16.
 */
public abstract class SortTemplate {

    public void testSort(int[] arr,int l,int r){
        long start = new Date().getTime();
        sort(arr,l,r);
        long end = new Date().getTime();
        if(!ArrUtil.isSort(arr)){
            System.out.println("排序失败！");
        }else{
            System.out.println("共花费了"+(end-start)+"ms");
        }
    }

    //用户需要实现的排序算法
    public abstract void  sort(int[] arr,int l,int r);
}
