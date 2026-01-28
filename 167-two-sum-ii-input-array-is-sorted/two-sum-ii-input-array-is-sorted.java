class Solution {
    public int[] twoSum(int[] numbers, int target) {
      int arr[] = new int[2];
       int  i=0;
       int j=numbers.length-1;
        // while(i<j){
        //     if(numbers[i]+numbers[j]>target){
        //         j--;
        //     }
        //     else if(numbers[i]+numbers[j]<target){
        //         i++;
        //     }
        //     else {
        //         arr[0]=i+1;
        //         arr[1]=j+1;
        //         break;
        //     }
        // }
        // return arr;
        while(i < j) {
    int sum = numbers[i] + numbers[j];
    if(sum > target) {
        j--;
    } else if(sum < target) {
        i++;
    } else {
        return new int[]{i + 1, j + 1};
    }
}
  return new int[]{i + 1, j + 1};

    }
}