package Algorithm.Offer.T61;

import Algorithm.common.TreeNode;

/**
 * 序列化二叉树
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * @author: wangfei
 * @date: 2019/5/14 19:45
 */
public class Solution {

    private StringBuffer stringBuffer = new StringBuffer();
    /**
     * 1、序列化：二叉树前序遍历，遇到 Null 补上 #，数字之间用 ! 分割
     * 2、反序列化
     * （1）将序列化后得到的字符串直接分割成字符数组
     * （2）全局变量 index 用于在数组索引
     * （3）如果 index 指向的索引为 #，则返回 NULL，否则按照前序遍历重建二叉树
     * 3、Tips：substring(int beginIndex, int endIndex) 返回字符串的字串
     *
     * @param root
     * @return
     */
    public String Serialize(TreeNode root) {
        preOrder(root);
        return stringBuffer.toString();
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            stringBuffer.append("#").append("!");
        } else {
            stringBuffer.append(root.val).append("!");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private int index = -1;
    public TreeNode Deserialize(String str) {
        return Deserialize(str.split("!"));
    }

    private TreeNode Deserialize(String[] dStr) {
        index++;
        if (dStr[index].equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(dStr[index]));
            node.left = Deserialize(dStr);
            node.right = Deserialize(dStr);
            return node;
        }
    }
}
