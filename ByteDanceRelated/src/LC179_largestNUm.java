import java.util.Arrays;
import java.util.Comparator;

public class LC179_largestNUm {
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0)
            return "";
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numStrs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -Long.compare(Long.parseLong(o1+o2),Long.parseLong(o2+o1));
            }
        });
        if(numStrs[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC179_largestNUm t = new LC179_largestNUm();
        int[] nums = {0,0};
        System.out.println(t.largestNumber(nums));
    }
}
