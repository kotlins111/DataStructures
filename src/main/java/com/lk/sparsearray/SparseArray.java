package com.lk.sparsearray;

/**
 * @author lkk
 * @created 2020-09-25 13:56
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始数组 11*11
        //0：没有旗子 1 ：黑色 2：蓝色
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出数组
        for (int[] ints : chessArr1) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }

        }
        //转换成稀疏数组
        //遍历二维数组 得到非0的数据个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int i1 = 0; i1 < 11; i1++) {
                if (chessArr1[i][i1] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

        //创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //为稀疏数组赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //遍历二维数组 将非0的数存到稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int i1 = 0; i1 < 11; i1++) {
                if (chessArr1[i][i1] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = i1;
                    sparseArray[count][2] = chessArr1[i][i1];
                }
            }
        }
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组");
        for (int[] value : sparseArray) {
            System.out.printf("%d\t%d\t%d\t\n", value[0], value[1], value[2]);
        }
        //将稀疏数组恢复成二维数组
        //读取稀疏数组第一行 得到二维数组的大小
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        //读取数据 并赋值给二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] =sparseArray[i][2];
        }
        //输出数组
        for (int[] ints : chessArray2) {
            for (int anInt : ints) {
                System.out.printf("%d\t", anInt);
            }

        }



    }
}
