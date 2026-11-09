class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {

        int n = s1.length();
        int start = -1;

        List<List<String>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                if (start == -1) {
                    start = i;
                }

            } else if (start != -1) {

                List<String> segment = new ArrayList<>();

                segment.add(s1.substring(start, i));
                segment.add(s2.substring(start, i));

                list.add(segment);

                start = -1;
            }
        }

        // Handle remaining segment
        if (start != -1) {

            List<String> segment = new ArrayList<>();

            segment.add(s1.substring(start, n));
            segment.add(s2.substring(start, n));

            list.add(segment);
        }

        return list;
    }
}