class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
         HashMap<Integer, Integer> losses = new HashMap<>();

        for (int i = 0; i < matches.length; i++) {
            int w = matches[i][0];
            int l = matches[i][1];

            losses.putIfAbsent(w, 0);
            losses.put(l, losses.getOrDefault(l, 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : losses.keySet()) {
            int count = losses.get(player);

            if (count == 0) {
                zeroLoss.add(player);
            } else if (count == 1) {
                oneLoss.add(player);
            }
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);

        List<List<Integer>> result = new ArrayList<>();
        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}