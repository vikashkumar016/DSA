class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
         List<int[]> people = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            people.add(new int[] {heights[i], i}); // Store the height and index
        }

        // Sort the list by height in descending order
        Collections.sort(people, (a, b) -> b[0] - a[0]);

        // Prepare the result based on the sorted indices
        String[] result = new String[names.length];
        for (int i = 0; i < people.size(); i++) {
            result[i] = names[people.get(i)[1]]; // Add the name corresponding to the index
        }
        
        return result;
    }
}