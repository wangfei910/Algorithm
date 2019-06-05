package Algorithm.Offer.T24;

import Algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 *
 * @author: wangfei
 * @date: 2019/4/6 15:45
 */
public class Solution {

    //因为如果放在里面的话每次递归的时候就会重新new一个lists和list,这样会把上一步的结果覆盖,所以必须写在外面.
    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    /**
     * 递归，栈回退
     *
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null)
            return lists;
        if (target >= 0) {
            list.add(root.val);
            target -= root.val;
            if (target == 0 && root.left == null && root.right == null)
                lists.add(new ArrayList<>(list));
            if (root.left != null)
                FindPath(root.left, target);
            if (root.right != null)
                FindPath(root.right, target);
            //递归到叶子节点如果还没有找到路径，就要回退到父节点继续寻找，依次类推
            list.remove(list.size() - 1);
        }
        return lists;
    }
}
