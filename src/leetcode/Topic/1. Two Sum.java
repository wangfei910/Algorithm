class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null || nums.length<2)
            return res;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {                      
            if(map.containsKey(target-nums[i]))    //�ж�map���Ƿ�������֮�����
            {
                res[0]=map.get(target-nums[i]);
                res[1]=i;
                return res;
            }
            map.put(nums[i],i); 
        }
        return res;
    }
}