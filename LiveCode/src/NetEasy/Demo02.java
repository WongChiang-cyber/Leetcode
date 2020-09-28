package NetEasy;

import java.lang.reflect.Array;
import java.util.*;

public class Demo02 {

    static HashMap<Integer,String> map;
    static ArrayList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        for (int i = 0; i < num; i++) {
            map = new HashMap<>();
            int opNum =sc.nextInt();
            for (int j = 0; j < opNum; j++) {
                String option =sc.next();
                if(option.equals("open")){
                    int index = 0;
                    if(map.size()!=0){
                        for (int k = 0; k <= map.size(); k++) {
                            if(!map.containsKey(k)){
                                index = k;
                                break;
                            }
                        }
                    }
                    String name = sc.next();
                    map.put(index,name);
                    System.out.println(index);
                }else if(option.equals("dup")){
                    int fd = sc.nextInt();
                    int index = 0;
                    if(map.size()!=0){
                        for (int k = 0; k <= map.size(); k++) {
                            if(!map.containsKey(k)){
                                index = k;
                                break;
                            }
                        }
                    }
                    String name = map.get(fd);
                    map.put(index,name);
                    System.out.println(index);
                }else if(option.equals("dup2")){
                    int fd = sc.nextInt();
                    int new_fd = sc.nextInt();
                    String name = map.get(fd);
                    map.put(new_fd,name);
                }else if(option.equals("close")){
                    int fd = sc.nextInt();
                    map.remove(fd);
                }else if(option.equals("query")){
                    int fd = sc.nextInt();
                    String name = map.get(fd);
                    System.out.println(name);
                }
            }
        }
    }

}
