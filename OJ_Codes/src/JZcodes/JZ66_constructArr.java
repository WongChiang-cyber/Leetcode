package JZcodes;

import java.util.Arrays;

public class JZ66_constructArr {
    public int[] constructArr(int[] a) {
        if(a==null || a.length ==0)
            return new int[]{};
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i-1]*a[i-1];
        }
        int temp = 1;
        for (int i = a.length-2; i >= 0 ; i--) {
            temp = temp * a[i+1];
            b[i] = b[i] * temp;
        }
        return b;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        JZ66_constructArr t = new JZ66_constructArr();
        System.out.println(Arrays.toString(t.constructArr(a)));
    }
}
