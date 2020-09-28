package NetEasy;

import java.util.*;

public class Demo02_II {

    static TreeMap<Integer,String> tree;
    static HashMap<Integer,String> map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num =sc.nextInt();
        for (int i = 0; i < num; i++) {
            tree = new TreeMap<Integer,String>();
            map = new HashMap<>();
            int opNum = sc.nextInt();
            int minUpper = 0;
            for (int j = 0; j < opNum; j++) {
                String option =sc.next();
                if(option.equals("open")){
                    String name = sc.next();
                    //find min unused index
                    int index = 0;
                    if(tree.size()>0){
                        index = tree.firstKey();
                        tree.remove(tree.firstKey());
                    }else{
                        index = minUpper++;
                    }
                    map.put(index,name);
                    System.out.println(index);
                }else if(option.equals("dup")){
                    int fd = sc.nextInt();
                    //find min unused index
                    int index = 0;
                    if(tree.size()>0){
                        index = tree.firstKey();
                        tree.remove(index);
                    }else{
                        index = minUpper++;
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
                    tree.put(fd,"whatever");
                }else if(option.equals("query")){
                    int fd = sc.nextInt();
                    String name = map.get(fd);
                    System.out.println(name);
                }
            }
        }
    }
}

