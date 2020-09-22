public class LC415_TwoStringAdd {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int preAdd = 0;
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        while(i>=0 || j>=0 || preAdd==1){
            int a,b ;
            if(i>=0) a = nums1[i]-'0';
            else a = 0;
            if(j>=0) b = nums2[j]-'0';
            else b = 0;
            sb.insert(0,(char)((a+b+preAdd)%10+'0'));
            if(a+b+preAdd>=10)
                preAdd = 1;
            else
                preAdd = 0;
            i--;
            j--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC415_TwoStringAdd t = new LC415_TwoStringAdd();
        System.out.println(t.addStrings("99999999999999999","1"));
    }
}
