class Solution {
    public int[] scoreValidator(String[] events) {
         int score = 0;
        int count = 0;

        for (int i = 0; i < events.length; i++) {

            String event = events[i];

            if (event.equals("WD") || event.equals("NB")) {
                score += 1;
            }

            else if (event.equals("W")) {
                count++;

                if (count == 10) {
                    break;
                }
            }

            else {
                score += Integer.parseInt(event);
            }
        }

        return new int[]{score, count};
    }
}