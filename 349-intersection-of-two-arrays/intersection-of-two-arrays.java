class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         
        //   int j=0;
        // int i=0;
        // int idx=0;
        // while(i<nums1.length && j<nums2.length){
        //     if(nums1[i]<nums2[j]){
        //         i++;
        //     }
        //     else if(nums1[i]>nums2[j]){
        //         j++;
        //     }
        //     else {
        //        list[idx]=nums1[i];
        //        idx++;
        //         i++;
        //         j++;
        //     }
        // }
        // return list;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        
        for (int n : nums1) {
            set1.add(n);
        }
        
        for (int n : nums2) {
            if (set1.contains(n)) {
                resultSet.add(n);
            }
        }
        
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int n : resultSet) {
            result[i++] = n;
        }
        
        return result;


    }
}