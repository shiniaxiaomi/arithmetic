package data;

/**
 * Created by Yingjie.Lu on 2019/4/8.
 */

import util.ArrUtil;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 1.二叉树的链表实现
 * 2.树的前中后序遍历
 */
public class LinkedTree {


    class Node{
        Node left=null;
        Node right=null;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    Node firstNode=null;
    int size=0;
    int capacity=0;//容量
    Queue queue=null;

    public void add(int i){
        Node node = (Node) queue.peek();//先不从栈中弹出

        if(node.left==null){
            Node left=new Node(i);
            node.left=left;
            queue.add(left);
            size++;
            return;
        }

        if(node.right==null){
            Node right=new Node(i);
            node.right=right;
            queue.add(right);
            size++;
            return;
        }

        queue.poll();//只有左右孩子都有了才将栈顶元素弹出
    }

    public LinkedTree(int capacity,int[] arr) {
        this.capacity=capacity;
        queue=new ArrayBlockingQueue(capacity);

        Node firstNode = new Node(arr[0]);
        this.firstNode=firstNode;
        queue.add(firstNode);

        int i=1;
        while(!queue.isEmpty()){

            Node node = (Node) queue.peek();//先不从栈中弹出

            if(i<arr.length && node.left==null){
                Node left=new Node(arr[i++]);
                node.left=left;
                queue.add(left);
            }else{
                break;
            }

            if(i<arr.length && node.right==null){
                Node right=new Node(arr[i++]);
                node.right=right;
                queue.add(right);
            }else{
                break;
            }

            queue.poll();//只有左右孩子都有了才将栈顶元素弹出
        }
    }

    //前序遍历
    public void preOrderPrint(Node node){
        //自己
        System.out.println(node.data);

        //左孩子
        if(node.left!=null){
            preOrderPrint(node.left);
        }

        //右孩子
        if(node.right!=null){
            preOrderPrint(node.right);
        }
    }

    //中序遍历
    public void inOrderPrint(Node node){
        //左孩子
        if(node.left!=null){
            inOrderPrint(node.left);
        }

        //自己
        System.out.println(node.data);

        //右孩子
        if(node.right!=null){
            inOrderPrint(node.right);
        }
    }

    //后序遍历
    public void postOrderPrint(Node node){
        //左孩子
        if(node.left!=null){
            postOrderPrint(node.left);
        }

        //右孩子
        if(node.right!=null){
            postOrderPrint(node.right);
        }

        //自己
        System.out.println(node.data);
    }

    public static void main(String[] args) {

        int[] arr = {8, 4, 2, 7, 5, 8, 8};
        LinkedTree linkedTree = new LinkedTree(arr.length,arr);
        linkedTree.preOrderPrint(linkedTree.firstNode);
//        linkedTree.inOrderPrint(linkedTree.firstNode);
//        linkedTree.postOrderPrint(linkedTree.firstNode);

    }

}
