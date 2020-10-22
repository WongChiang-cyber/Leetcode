package QNER;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main02 {

    public static int find(String[] s1,String[] s2){
        int n = s1.length;
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; i++) {
            map.put(s1[i],i);
        }
        int[] nums = new int[s1.length];
        for (int i = 0; i < s2.length; i++) {
            int index = map.get(s2[i]);
            nums[i] = index;
        }
        //System.out.println(Arrays.toString(nums));
        //dp
        int[] dp = new int[n];
        int[] max = new int[n];
        //base case
        dp[0] = 1;
        max[0] = nums[0];
        //start dp
        for (int i = 1; i < n; i++) {
            int cur_num = nums[i];
            int max_len = 0;
            for (int j = 0; j < i; j++) {
                if(max[j]<cur_num && dp[j]>max_len){
                    max_len = dp[j];
                }
            }
            max[i] = cur_num;
            dp[i] = max_len+1;
        }
        System.out.println(Arrays.toString(dp));
        Arrays.sort(dp);
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s1 = new String[n];
        String[] s2 = new String[n];
        for (int i = 0; i < n; i++) {
            s1[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            s2[i] = sc.next();
        }
        System.out.println(find(s1,s2));
    }
}

