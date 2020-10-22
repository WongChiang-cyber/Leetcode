package WeBank;

import java.util.*;

public class Main04 {

    HashSet<Integer> visited = new HashSet<>();
    int num = 0;
    int res = 0;

    public void find(ArrayList<Integer> nums, int m){
        if(nums.size()==1){
            int mut = m*10+nums.get(0);
            if(mut%num==0){
                res++;
            }
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            int next_m = nums.get(i);


        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Main04 m = new Main04();
        m.num = sc.nextInt();
        int[] nums = new int[str.length()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = str.charAt(i)-'0';
        }
    }
}
