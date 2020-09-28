package JZcodes;

import java.util.ArrayList;

public class JZ38_permutation {

    public String[] permutation(String s) {
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
        boolean[] set = new boolean[26];
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if(set[(int)(c-'a')])
                continue;
            else
                set[(int)(c-'a')]=true;
            path = path + String.valueOf(c);
            String s = sb.substring(0,i)+sb.substring(i+1,sb.length());
            find(s,path,res);
            path = path.substring(0,path.length()-1);
        }
    }

    public static void main(String[] args) {
        JZ38_permutation t = new JZ38_permutation();
        String[] res = t.permutation("aaabbb");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }


}
