class Solution {
    public int firstUniqChar(String s) {
      HashMap<Character, Integer> map = new HashMap<>();

        // Frequency count
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {

            int index = queue.peek();
            char ch = s.charAt(index);

            if (map.get(ch) == 1) {
                return index;
            }

            queue.poll();
        }

        return -1;
    }
}