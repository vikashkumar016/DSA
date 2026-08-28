class Solution {
    public int[] resultArray(int[] nums) {
                ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        int last1 = nums[0];
        int last2 = nums[1];

        list1.add(last1);
        list2.add(last2);

        for(int i = 2; i < nums.length; i++) {

            if(last1 > last2) {
                list1.add(nums[i]);
                last1 = nums[i];
            } 
            else {
                list2.add(nums[i]);
                last2 = nums[i];
            }
        }

        for(int i = 0; i < list1.size(); i++) {
            nums[i] = list1.get(i);
        }

        for(int i = list1.size(); i < nums.length; i++) {
            nums[i] = list2.get(i - list1.size());
        }

        return nums;

    }
}