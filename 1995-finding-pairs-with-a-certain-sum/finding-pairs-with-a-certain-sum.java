class FindSumPairs {
      int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> map;

    public FindSumPairs(int[] nums1, int[] nums2) {
           this.nums1 = nums1;
            this.nums2 = nums2;
            map=new HashMap<>();
    for(int i=0;i<nums2.length;i++){
        map.put(nums2[i],map.getOrDefault(nums2[i],0)+1);
    }

    }
    
    public void add(int index, int val) {
       int old = nums2[index];

    map.put(old, map.get(old) - 1);

    nums2[index] += val;

    int updated = nums2[index];

    map.put(updated, map.getOrDefault(updated, 0) + 1);
    }
    
    public int count(int tot) {
         int count = 0;
        for(int i=0;i<nums1.length;i++){
            int needed=tot-nums1[i];
            if(map.containsKey(needed)){
               count+= map.get(needed);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */