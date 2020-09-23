package JZcodes;

import java.util.LinkedList;

public class JZ14_CuttingRopeII_quick_pow {
    public int cuttingRope(int n) {
        if(n<4) return n-1;
        int x = n/3;
        int y = n%3;
        if(y==0){
            y = 1;
        }else if(y==1){
            x = x - 1;
            y = 4;
        }//y==2 do nothing
        return quickPow(3,x,y);
    }

    private int quickPow(long base,long pow,int y){
        long res = 1;
        while(pow>0){
            if((pow & 1)==1){//为奇数
                res = (res * base)%1000000007;
                pow--;
            }else{
                base = (base * base)%1000000007;
                pow = pow>>1;
            }
        }
        return (int)((res*y)%1000000007);
    }

    public static void main(String[] args) {
        JZ14_CuttingRopeII_quick_pow t = new JZ14_CuttingRopeII_quick_pow();
        System.out.println(t.cuttingRope(127));
    }
}
