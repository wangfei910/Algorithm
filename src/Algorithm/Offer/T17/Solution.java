package Algorithm.Offer.T17;

import Algorithm.common.TreeNode;

/**
 * 判断树的子结构
 *
 * @author wangfei
 */
public class Solution {

    /**
     * 1. 不论树 A 还是 树 B，只要初始为空，均为不是子树结构
     * 2. 初始时，如果树 A 的值与树 B 的值相等，则递归匹配
     * 3. 如果树 A 的值与树 B 的值不相等，则树 B 不变，分别在树 A 的左子树和右子树递归匹配
     * 4. 匹配递归：
     *    a. 如果树 B 为空，即表示匹配成功
     *    b. 如果树 A 为空，树 B 不为空；或者树 A  的值和树 B 的值不相等，则表示匹配失败
     *    c. 分别在对树 A 和树 B 的左右子树进行匹配，两者均为 true 才是匹配成功
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean isSubtree = false;
        if (root1 == null || root2 == null)
            return false;
        if (root1.val == root2.val)
            isSubtree = HasSubtreeRecursion(root1, root2);
        if (!isSubtree)
            isSubtree = HasSubtreeRecursion(root1.left, root2);
        if (!isSubtree)
            isSubtree = HasSubtreeRecursion(root1.right, root2);
        return isSubtree;
    }

    public boolean HasSubtreeRecursion(TreeNode root1, TreeNode root2) {
        if (root2 == null)
            return true;
        if (root1 == null && root2 != null)
            return false;
        if (root1.val != root2.val)
            return false;
        boolean left = HasSubtreeRecursion(root1.left, root2.left);
        boolean right = HasSubtreeRecursion(root1.right, root2.right);
        return left & right;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) + "ns");
    }
}
