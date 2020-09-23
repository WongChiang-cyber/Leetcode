import java.util.ArrayList;
import java.util.List;

public class LC93_restoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        ArrayList<String> res = new ArrayList<>();
        if(len<4 || len>12)
            return res;
        for (int i = 1; i <= len-3; i++) {
            String p1 = s.substring(0,i);
            if(Integer.parseInt(p1)>255)
                continue;
            if((Integer.parseInt(p1)<Math.pow(10,i-1))&&i!=1)
                continue;
            for (int j = i+1; j <= len-2 ; j++) {
                String p2 = s.substring(i,j);
                if(Integer.parseInt(p2)>255)
                    continue;
                if((Integer.parseInt(p2)<Math.pow(10,j-i-1))&&j-i!=1)
                    continue;
                for (int k = j+1; k <= len-1 ; k++) {
                    String p3 = s.substring(j,k);
                    if(Integer.parseInt(p3)>255)
                        continue;
                    if(Integer.parseInt(p3)<Math.pow(10,k-j-1)&&k-j!=1)
                        continue;
                    String p4 = s.substring(k,len);
                    if(Integer.parseInt(p4)>255)
                        continue;
                    if(Integer.parseInt(p4)<Math.pow(10,len-k-1)&&len-k!=1)
                        continue;

                    res.add(p1+"."+p2+"."+p3+"."+p4);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "1231231231234";
        LC93_restoreIpAddresses t = new LC93_restoreIpAddresses();
        List<String> res = t.restoreIpAddresses(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
