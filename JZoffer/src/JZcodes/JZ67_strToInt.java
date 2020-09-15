package JZcodes;

public class JZ67_strToInt {

    final static int MAX_INT = Integer.MAX_VALUE;
    final static int MIN_INT = Integer.MIN_VALUE;

    public int strToInt(String str) {
        //trim space
        int start = 0;
        str = str.trim();
        char[] arr = str.toCharArray();
        if(str==null || str.length()==0 || arr.length==0)
            return 0;
        //judge sign
        int sign = 1;
        if(arr[0]=='-'){
            sign = -1;
            start++;
        }
        else if(arr[0] == '+'){
            sign = 1;
            start++;
        }
        //calculate
        long res = 0;
        for (int i = start; i < arr.length; i++) {
            if(arr[i]>='0'&&arr[i]<='9') {
                if(res > MAX_INT/10)
                    return sign==-1?MIN_INT:MAX_INT;
                res = res*10+(str.charAt(i)-'0');
            }else
                break;
        }
        if(sign==-1)
            res*=-1;
        if(res>MAX_INT)
            return MAX_INT;
        else if(res<MIN_INT)
            return MIN_INT;
        return (int)res;
    }

    public static void main(String[] args) {
        String str = " ";
        JZ67_strToInt T = new JZ67_strToInt();
        System.out.println(T.strToInt(str));
    }
}
