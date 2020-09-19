package JZcodes;

public class JZ14_CuttingRopeII {
    public int cuttingRope(int n) {
        if(n<4) return n-1;
        long res = 1;
        while(n>4){
            n-=3;
            res=(res*3)%1000000007;
        }
        return (int)((n*res)%1000000007);
    }

    public static void main(String[] args) {
        JZ14_CuttingRopeII t = new JZ14_CuttingRopeII();
        System.out.println(t.cuttingRope(127));
    }
}
