class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle=minutes*6;
        double hourAngle=0;
        if(hour==12){
            hourAngle=(hour%12)*30+(minutes*0.5);
        }
        else {
            hourAngle=(hour*30)+(minutes*0.5);
        }
        double diff=Math.abs(minuteAngle-hourAngle);
        double diff2=360-diff;
        return Math.min(diff,diff2);
    }
}