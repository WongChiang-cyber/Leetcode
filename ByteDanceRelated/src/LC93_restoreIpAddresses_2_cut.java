import java.util.ArrayList;
import java.util.List;

public class LC93_restoreIpAddresses_2_cut {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<String>();
        if(len>12)
            return res;
        String[] path = new String[4];
        dfs(s,0,4,res,path);
        return res;
    }

    private void dfs(String s,int begin,int remainParts,List<String> res,String[] path){
        int width = s.length()-begin;
        if(width<remainParts || width>remainParts*3)
            return;
        else if(remainParts==1){
            String substring = s.substring(begin, s.length());
            if(isAvailableIP(substring)){
                path[3] = substring;
                res.add(String.join(".",path));
            }
            return;
        }
        for (int i = begin+1; i <= begin+3; i++) {
            if(i>s.length())
                return;
            if(isAvailableIP(s.substring(begin,i))){
                path[4-remainParts] = s.substring(begin,i);
                dfs(s,i,remainParts-1,res,path);
            }
        }
    }

    private boolean isAvailableIP(String str){
        if(str.length()>3)
            return false;
        if(str.charAt(0)=='0' && str.length()>1)
            return false;
        if(Integer.parseInt(str)>255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "010010";
        LC93_restoreIpAddresses_2_cut t = new LC93_restoreIpAddresses_2_cut();
        List<String> res = t.restoreIpAddresses(s);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
