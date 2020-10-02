package LeetCode;

public class JZ69_mySqrt {

    private int res = 0;

    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long res = 0;
        while(start<=end){
            long mid = (start+end)/2;
            if(mid*mid <= x){
                start = mid+1;
                res = mid;
            }else{
                end = mid-1;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        JZ69_mySqrt t = new JZ69_mySqrt();
        //t.mySqrt(2147395599);
        //t.find(8,0,8);
    }
}
