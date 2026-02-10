class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i]; 
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

     
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 3) {
                result.add(entry.getKey()); 
            }
        }

        return result;
    }
}