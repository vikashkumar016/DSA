class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> result = new ArrayList<>();
        int remainder = 0; // this stores the number % 5

        for (int bit : nums) {
            remainder = (remainder * 2 + bit) % 5;

            if (remainder == 0)
                result.add(true);
            else
                result.add(false);
        }

        return result;
    }
}