class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            int totalWeight = 0;
            String str = words[i];

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                totalWeight += weights[ch - 'a'];
            }

            int mod = totalWeight % 26;
            char mapped = (char) ('z' - mod);

            sb.append(mapped);
        }

        return sb.toString();
    }
}