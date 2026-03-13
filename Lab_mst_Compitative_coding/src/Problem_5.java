public class Problem_5 {
    public static int singleNumber(int []nums){
        int ones=0;
        int two=0;
        for(int i:nums){
            ones=(ones^i)& ~two;
            two=(two^i)&~ones;
        }return ones;
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println("unique number in the array:"+singleNumber(nums));
    }
}
