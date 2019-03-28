package data;

/**
 * Created by Yingjie.Lu on 2019/3/28.
 */

import util.ArrUtil;

/**
 * 索引最大堆：
 *      1.加入索引数组 indexes[]
 *      2.加入了反向查找数组 rev[]
 *          rev[i] 表示索引i在indexes数组（堆）中的位置
 *          具有如下性值：
 *              indexes[i]=j
 *              rev[j]=i
 *              indexes[rev[i]]=i
 *              rev[indexes[i]]=i
 */
public class IndexMaxHeap {

    private int[] data;
    private int[] indexes;//存储数据对应的索引
    private int[] rev;//反向查找数组

    int index=1;//索引从1开始，index指向的是下一个要存放元素的索引
    int capacity;//堆的容量

    IndexMaxHeap(int n){
        data=new int[n+1];//从数组的1号索引开始
        indexes=new int[n+1];
        rev=new int[n+1];
        //初始化为0，表示为null
        for(int i=0;i<rev.length;i++){
            rev[i]=0;
        }
        this.capacity=n;
    }

    public int size(){
        return index-1;
    }

    public boolean isEmpty(){
        return (index-1)==0;
    }

    //添加数据

    /**
     * @param i 数据的索引
     * @param n 数据
     */
    public void insert(int i,int n) throws Exception {
        if(index>capacity+1){
            throw new Exception("堆已满！");
        }
        if(i+1>capacity+1){
            throw new Exception("索引越界！");
        }
        i+=1;//将用户传入的从0开始的索引变成从1开始

        data[i]=n;
        indexes[index]=i;//将数据索引保存在indexes数组中
        rev[i]=index;//维护反向查找数组

        index++;
        shiftUp(index-1);

    }

    private void shiftUp(int k){
        while (k>1 && data[indexes[k]]>data[indexes[k/2]]){
            ArrUtil.swap(indexes,k,k/2);//交换indexes数组中的元素，data数组不动
            rev[indexes[k]]=k;
            rev[indexes[k/2]]=k/2;
            k=k/2;//更新k
        }
    }

    public int popMax(){

        int buff=data[indexes[1]];//获取堆顶的元素
        indexes[1]=indexes[index-1];//交换indexes数组中的索引
        rev[indexes[index-1]]=0;//清除被删除的元素
        rev[indexes[1]]=1;
        index--;

        shiftDown(1);

        return buff;
    }

    private void shiftDown(int k){

        if(2*k>(index-1)){//没有节点
            return;
        }else if(2*k==(index-1)){//有只左节点
            if(data[indexes[k]]<data[indexes[2*k]]){
                ArrUtil.swap(indexes,k,2*k);
                rev[indexes[k]]=k;
                rev[indexes[2*k]]=2*k;
                shiftDown(2*k);
            }
        }else{//有两个节点
            if(data[indexes[2*k]]>data[indexes[2*k+1]]){
                ArrUtil.swap(indexes,k,2*k);
                rev[indexes[k]]=k;
                rev[indexes[2*k]]=2*k;
                shiftDown(2*k);
            }else{
                ArrUtil.swap(indexes,k,2*k+1);
                rev[indexes[k]]=k;
                rev[indexes[2*k+1]]=2*k+1;
                shiftDown(2*k+1);
            }
        }

    }

    //给定索引来获取原数组中的数据
    public int getData(int index) throws Exception {
        if(!contains(index)){
            throw new Exception("堆索引越界！");
        }

        return data[index+1];
    }

    /**
     * 修改原数组中的数据
     * @param index 用户给定的索引
     * @param data  要修改的data
     */
    public void changeData(int index,int data) throws Exception {
        if(!contains(index)){
            throw new Exception("堆索引越界！");
        }

        index+=1;
        //修改原数组中的数据
        this.data[index]=data;

        //维护indexes数组中的最大堆的性质，时间复杂度是O(n)
//        for(int i=1;i<indexes.length;i++){
//            if(indexes[i]==index){
//                //如果在indexes中找到了值为index的索引，然后将吧索引shiftUp和shitfDown一下，就保证了最大堆的性质
//                shiftUp(i);
//                shiftDown(i);
//                return;
//            }
//        }

        //利用反向查找技术，维护indexes数组中的最大堆的性质，时间复杂度是O(1)
        int i=rev[index];
        shiftUp(i);
        shiftDown(i);
    }

    //查看给定索引在不在堆中
    private boolean contains(int index) throws Exception {
        if(!(index>=1 && index<=capacity)){
            throw new Exception("数组索引越界！");
        }

        return rev[index]!=0;
    }

    //打印堆中的数据
    public void printHeapData(){
        int n=1;
        for(int i=1;i<index;i++){
            System.out.print(data[indexes[i]]+" ");
            if(n==i){
                System.out.println();
                n=2*i+1;
            }
        }
        System.out.println();
        System.out.println("----------");
    }
    //打印原数组中的数据
    public void printData(){
        int n=1;
        for(int i=1;i<index;i++){
            System.out.print(data[i]+" ");
            if(n==i){
                System.out.println();
                n=2*i+1;
            }
        }
        System.out.println();
        System.out.println("----------");
    }

    public static void main(String[] args) throws Exception {

        int n=10;

        int[] ints = ArrUtil.randomArr(n, 1, 10);

        IndexMaxHeap indexMaxHeap=new IndexMaxHeap(n);
        for(int i=0;i<n;i++){
            indexMaxHeap.insert(i,ints[i]);
        }


//        System.out.println();
//        for(int i=0;i<n;i++){
//            System.out.print(indexMaxHeap.popMax()+" ");
//        }

        indexMaxHeap.printData();//打印原数组中的数据
        indexMaxHeap.printHeapData();//打印堆中的数据
        indexMaxHeap.changeData(2,999);//修改原数组中的数据
        indexMaxHeap.printHeapData();//再打印堆中的数据


    }

}
