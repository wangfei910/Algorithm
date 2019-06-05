package Algorithm.Offer.T65;

/**
 * 矩阵中的路径
 * <p>
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
 * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
 * 例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author: wangfei
 * @date: 2019/5/16 11:07
 */
public class Solution {

    public static boolean hashPath(char[] matrix, int rows, int cols, char[] str) {
        //标志位，初始化为 0
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于 str 第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    //helper(初始矩阵，矩阵行数，矩阵列数，索引行坐标 i，索引纵坐标 j，字符串索引初始为 0 即先判断字符串的第一位，待判断的字符串)
    private static boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        //先根据 i 和 j 计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        //若k已经到达 str 末尾了，说明之前的都已经匹配成功了，直接返回 true 即可
        if (k == str.length - 1)
            return true;
        //要走的第一个位置置为 1，表示已经走过了
        flag[index] = 1;
        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = 0;
        return false;
    }



    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();
        char[] matrix = {'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        int rows = 3;
        int clos = 4;
        char[] str = {'b', 'c', 'c', 'e', 'd'};
        System.out.println(hashPath(matrix, rows, clos, str));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
