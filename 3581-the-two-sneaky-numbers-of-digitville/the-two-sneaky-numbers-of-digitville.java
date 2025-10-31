class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        // Set<Integer>seen = new HashSet<>();
        // int[] res= new int[2];
        // int idx=0;

        // for(int num:nums){
        //     if(seen.contains(num)){
        //         res[idx++]=num;
        //     }
        //     else {
        //         seen.add(num);
        //     }
        // }
        // return res;
           Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] res = new int[2];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 2) {
                res[idx++] = entry.getKey();
            }
        }

        return res;
    }
}