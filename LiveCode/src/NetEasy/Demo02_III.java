package NetEasy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Demo02_III {

    static HashMap<Integer,String> map;
    static LinkedList<Integer> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        for (int i = 0; i < num; i++) {
            map = new HashMap<>();
            list = new LinkedList<>();
            int minUpper = 0;
            int opNum =sc.nextInt();
            for (int j = 0; j < opNum; j++) {
                String option =sc.next();
                if(option.equals("open")){
                    int index = 0;
                    if(list.size()>0){
                        index = list.getFirst();
                        list.removeFirst();
                    }else{
                        index = minUpper++;
                    }
                    String name = sc.next();
                    map.put(index,name);
                    System.out.println(index);
                }else if(option.equals("dup")){
                    int fd = sc.nextInt();
                    int index = 0;
                    if(list.size()>0){
                        index = list.getFirst();
                    }else{
                        index = minUpper++;
                        list.removeFirst();
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
                    for (int k = 0; k < list.size(); k++) {
                        if(fd>list.get(k))
                            list.add(k,fd);
                    }
                }else if(option.equals("query")){
                    int fd = sc.nextInt();
                    String name = map.get(fd);
                    System.out.println(name);
                }
            }
        }
    }

}
