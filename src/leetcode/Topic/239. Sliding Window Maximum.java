public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k<=0) return new int[0];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i=0; i<k-1; i++) {
            queue.add(-nums[i]);
        }
        // System.out.println(map);
        int[] max = new int[nums.length-k+1];
        for(int i=0,j=k-1; j<nums.length; i++, j++) {
            queue.add(-nums[j]);
            max[i] = -queue.peek();
            queue.remove(-nums[j-k+1]);
        }
        return max;
    }
}