import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class minConcatStrNum {
    public String solution(String[] strArray){
        ArrayList<String> list = new ArrayList<>(Arrays.asList(strArray));
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(Integer.parseInt(o1 + o2), Integer.parseInt(o2 + o1));
            }
        });
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        minConcatStrNum t = new minConcatStrNum();
        String[] strs = {"321","32","3"};
        System.out.println(t.solution(strs));
    }
}
