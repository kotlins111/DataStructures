package com.lk.queue;

import java.util.Scanner;

/**
 * @author lkk
 * @created 2020-09-25 21:04
 */
public class CircleArrayQueue {
    public static void main(String[] args) {
        //创建一个队列
        CircleQueue arrayQueue = new CircleQueue(4);
        char key; //用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true; //控制循环
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(show):退出队列");
            System.out.println("a(show):添加数据到队列");
            System.out.println("g(show):取出数据从队列");
            System.out.println("h(show):取出数据队列的头部");
            key = scanner.next().charAt(0); //接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h': //查看队列头部
                    try {
                        int res = arrayQueue.headPeek();
                        System.out.printf("队列头部的数据是%d\n", res);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

class CircleQueue {
    private int maxSize; //队列大小
    private int front; //队列头部
    private int rear; //队列尾部
    private int[] arr;

    //创建一个队列的构造器
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0; //指向队列头部 并不包含头部
        rear = 0; // 指向队列尾部 包含尾部
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列

    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满，无法加入");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据 出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空，无法取出数据");
        }
        int temp = arr[front];
        front = (front + 1) % maxSize;
        return temp;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历数组
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        //从front开始遍历 ，遍历多少个元素
        //
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头部 头数据
    public int headPeek() {
        if (isEmpty()) {
//          System.out.println("队列空");
            throw new RuntimeException("QueueEmptyException");
        }
        return arr[front];
    }

}
