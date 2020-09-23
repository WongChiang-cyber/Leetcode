package JZcodes;

public class JZ62_LastRemain {
    public int lastRemaining(int n, int m) {
        if(n==1)
            return 0;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res+m)%i;
        }
        return res;
    }

    public static void main(String[] args) {
        JZ62_LastRemain T = new JZ62_LastRemain();
        System.out.println(T.lastRemaining(5,3));
    }
}
