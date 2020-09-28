package JZcodes;

import java.util.ArrayList;
import java.util.Arrays;

public class JZ38_permutation2 {

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        ArrayList<String> res = new ArrayList<>();
        find(s,"",res);
        String[] strs = new String[res.size()];
         for (int i = 0; i < strs.length; i++) {
            strs[i] = res.get(i);
        }
        return strs;
    }

    public void find(String sb, String path,ArrayList<String> res){
        if(sb.length()==1){
            res.add((path.concat(sb)).toString());
            return;
        }
        char preChar = '$';
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(c==preChar)
                continue;
            else
                preChar = c;
            path = path + c;
            String s = sb.substring(0,i)+sb.substring(i+1);
            find(s,path,res);
            path = path.substring(0,path.length()-1);
        }
    }

    public static void main(String[] args) {
        JZ38_permutation2 t = new JZ38_permutation2();
        String[] res = t.permutation("aab");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }


}
