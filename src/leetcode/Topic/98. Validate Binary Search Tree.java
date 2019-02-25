//依据本身性质
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}

//中序遍历法
class Solution2 {
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }
    private boolean helper(TreeNode root, ArrayList<Integer> pre)
    {
        if(root == null)
            return true;
        boolean left = helper(root.left,pre);
        if(pre.get(0)!=null && root.val<=pre.get(0))
            return false;
        pre.set(0,root.val);
        return left && helper(root.right,pre);
    }

}