class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //leftmaxboundary
        int leftmax[]=new int[n];
        leftmax[0]=height[0];
        for(int i=1;i<n;i++){
            leftmax[i]=Math.max(leftmax[i-1],height[i]);
        }
        //rightmax boundary
        int rightmax[]=new int[n];
        rightmax[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            rightmax[i]=Math.max(rightmax[i+1],height[i]);
        }

     int trapped=0;
     for(int i=0;i<n;i++){
        int waterLevel=Math.min(leftmax[i],rightmax[i]);
        trapped+=waterLevel-height[i];
     }
     return trapped;
    }
}