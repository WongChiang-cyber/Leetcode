package LeetCode;

import java.util.Arrays;
import java.util.HashSet;

public class LC888_fairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int sumA = 0,sumB = 0;
        for(int a:A){
            sumA += a;
        }
        HashSet<Integer> set= new HashSet<Integer>();
        for(int b:B){
            sumB += b;
            set.add(b);
        }
        int i = 0,target=0;
        for (; i < A.length; i++) {
            target = A[i]+(sumB-sumA)/2;
            if(set.contains(target))
                break;
        }
        int[] res = {A[i],target};
        return res;
    }

    public static void main(String[] args) {
        LC888_fairCandySwap t = new LC888_fairCandySwap();
        int A[] = {1,1};
        int B[] = {2,2};
        System.out.println(Arrays.toString(t.fairCandySwap(A,B)));

    }
}
