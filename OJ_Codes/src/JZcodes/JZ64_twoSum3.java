package JZcodes;

import java.util.Arrays;

public class JZ64_twoSum3 {
    public double[] twoSum(int n) {
        double pre[]={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for(int i=2;i<=n;i++){
            double tmp[]=new double[5*i+1];
            for(int j=0;j<pre.length;j++)
                for(int x=0;x<6;x++)
                    tmp[j+x]+=pre[j]/6;
            pre=tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        JZ64_twoSum3 sum = new JZ64_twoSum3();
        double[] res = sum.twoSum(2);
        System.out.println(Arrays.toString(res));
    }
}
