import java.util.Arrays;

public class aggresive_cows {
    static boolean isPossible(int []stall,int cow,int mid){

        int cows=1,lastStallPos=stall[0];
        for(int i=1;i<stall.length;i++){
            if((stall[i]-lastStallPos)>=mid){
                cows++;
                lastStallPos=stall[i];
            }
            if(cows==cow){
                return true;
            }
        }
        return false;

    }
    static int cows(int[] stall, int c, int n) {
        Arrays.sort(stall);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : stall) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int st = 1;
        int end = max - min;
        int ans = 0;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (isPossible(stall,c,mid)){
                ans = mid;
                st = mid + 1;
            }
            else{
                end = mid - 1;
            }
        } return ans;
    }

    public static void main(String[] args) {
        int[]stalls={1,2,8,4,9};
        System.out.println(cows(stalls,3,stalls.length));
    }
}


