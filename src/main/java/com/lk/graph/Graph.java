package com.lk.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author lkk
 * @created 2020-11-13 17:38
 */
public class Graph {
     private ArrayList<String> vertexList;  // 存储节点集合
     private int [][] edges; //存储图对应的邻接矩阵
     private int numEdges;  // 表示边的数目

    public static void main(String[] args) {
        //测试
        int n =5; //结点个数
        String VertexValue[] ={"A","B","C","D","E"};
        //创建图
        Graph graph = new Graph(n);
        //循环添加结点
        for (String s : VertexValue) graph.insertVertex(s);
        //添加边
        //A-B A-C B-C B-D B-E
        graph.insertEdge(0,1,1);//A-B
        graph.insertEdge(0,2,1);//A-C
        graph.insertEdge(1,2,1);//B-C
        graph.insertEdge(1,3,1);//b-d
        graph.insertEdge(1,4,1);//b-e
        //显示邻接矩阵
        graph.showGraph();
    }
     //构造器

    public Graph(int n) {
         // 初始化矩阵和vertexList

        edges=new int[n][n];
        vertexList=new ArrayList<String>(n);
        numEdges=0;

    }
    //常用方法
    //返回节点的个数
    public  int getNumVert(){
        return vertexList.size();
    }
    //得到边的数目
    public int getNumEdges(){
        return numEdges;
    }
    //返回节点i (下标)对应的数据 0->'A'
    public String getValueByIndex(int index ){
        return vertexList.get(index);
    }
    //返回v1 v2 的权值
    public int getWeight(int v1,int v2 ){
        return edges[v1][v2];
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] edge : edges) {
            System.err.println(Arrays.toString(edge));
        }
    }
    //插入节点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边
    /*
    * @param v1 表示点的下标 即是第几个顶点
    * @param v2 表示第二个顶点对应的下标
    * @param weight 表示 1 表示有关联
    *
    */
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] =weight;
        edges[v2][v1] =weight;
        numEdges++;
    }
}
