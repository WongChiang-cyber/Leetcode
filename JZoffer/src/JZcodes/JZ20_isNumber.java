package JZcodes;

public class JZ20_isNumber {
    public boolean isNumber(String s) {
        if(s==null || s.trim().length()==0)
            return false;
        s = s.trim();
        int start =0;
        int Epos = -1;
        for (int i = start; i < s.length(); i++) {
            if(s.charAt(i)=='e' || s.charAt(i)=='E'){
                Epos = i;
                break;
            }
        }
        if(Epos == -1)
            return check(s,start,s.length());
        else
            return check(s,start,Epos) && check(s,Epos+1,s.length());
    }

    private boolean check(String str,int start,int end){
        if(start>=end)
            return false;
        if(str.charAt(start)=='+' || str.charAt(start)=='-'){
            start++;
        }
        if(start>=end)
            return false;
        int dotNum = 0;
        int dotPos = -1;
        for (int i = start; i < end; i++) {
            if(str.charAt(i)>='0' && str.charAt(i)<='9') {
            }
            else if(str.charAt(i)=='.'){
                dotNum++;
                dotPos=i;
            }else{
                return false;
            }
        }
        if(dotNum>1)
            return false;
        return true;
    }

    public static void main(String[] args) {
        JZ20_isNumber t = new JZ20_isNumber();
        System.out.println(t.isNumber("0e+"));
    }
}
