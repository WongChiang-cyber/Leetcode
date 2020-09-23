package JZcodes;

import java.util.ArrayList;

public class JZ49_UglyNumber {
    public static int nthUglyNumber(int n) {
        if(n==0)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        int M = 1;
        list.add(M);
        int M2 = 0,M3 = 0,M5 = 0;
        int T2 = 0,T3 = 0,T5 = 0;
        for (int i = 1; i < n; i++) {
            M2 = list.get(T2)*2;
            M3 = list.get(T3)*3;
            M5 = list.get(T5)*5;
            //add M
            if(M2 <= M3 && M2 <= M5){
                M = M2;
                list.add(M);
            }else if(M3 <= M2 && M3 <= M5){
                M = M3;
                list.add(M);
            }else{
                M = M5;
                list.add(M);
            }
            //move T
            if(M == M2) T2++;
            if(M == M3) T3++;
            if(M == M5) T5++;
        }
        //System.out.println(list);
        return M;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(20));
    }
}
