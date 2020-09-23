package JZcodes;

public class JZ16_MyPow {
    public double myPow(double x, int n) {
        double res = 1;
        long pow = n;
        if(pow<0){
            x = 1.0/x;
            pow = -pow;
        }

        while(pow>0){
            if((pow & 1)==1){
                res = res * x;
                pow--;
            }else{
                x = x * x;
                pow = pow>>1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JZ16_MyPow t = new JZ16_MyPow();
        System.out.println(t.myPow(2.0, -2147483648));
    }
}
