class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();

        for(int x : students) {
            q.offer(x);
        }

        int i = 0; // sandwich index
        int count = 0;

        while(!q.isEmpty() && count < q.size()) {

            if(q.peek() == sandwiches[i]) {
                q.poll();
                i++;
                count = 0;
            }
            else {
                int front = q.poll();
                q.offer(front);
                count++;
            }
        }


        return q.size();
    }
}