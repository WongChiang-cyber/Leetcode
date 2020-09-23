package JZcodes;

public class JZ58II_reverseLeft {
    public String reverseLeftWords(String s, int n) {
        if(n==0) return s;
        String front = s.substring(0,n);
        String back = s.substring(n,s.length());
        return back.concat(front);
    }
}
