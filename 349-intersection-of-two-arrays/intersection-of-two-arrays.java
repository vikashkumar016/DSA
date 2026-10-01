class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
      HashSet<Integer>set1=new HashSet<>();
      HashSet<Integer>intersectSet= new HashSet<>();
      for(int i:nums1){
        set1.add(i);
      }
      for (int num : nums2) {
        if (set1.contains(num)) {
            intersectSet.add(num);
        }
    }
        int[] arr = new int[intersectSet.size()];
    int t = 0;
    for (Integer k : intersectSet) {
        arr[t++] = k;
    }
    
    return arr;

    }
}