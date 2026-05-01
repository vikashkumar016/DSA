class Solution {
    public int finalValueAfterOperations(String[] operations) {
          int x=0;
        for(int i =0;i<operations.length;i++){

            String op = operations[i];
            switch(op){
                case "X++":
                    x++;
                    break;
                case "X--":
                    x--;
                    break;
                case "++X":
                    ++x;
                    break;
                case "--X":
                    --x;
                    break;            
                    
            }
        }
        return x;
    }
}