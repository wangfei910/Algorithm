class KthLargest {
    final PriorityQueue<Integer> q;
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for(int val : nums)
            add(val);
    }
    
    public int add(int val) {
        if(q.size()<k)
            q.offer(val);
        else if(q.peek()<val){
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}
