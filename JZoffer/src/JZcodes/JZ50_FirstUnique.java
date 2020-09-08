package JZcodes;

import java.util.HashMap;

public class JZ50_FirstUnique {
    public char firstUniqChar(String s) {
        HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
        for(int i = 0;i<s.length();i++){
            int character = (int)s.charAt(i);
            if(hashmap.containsKey(character)){
                int value = hashmap.get(character);
                hashmap.put(character,value+1);
            }else{
                hashmap.put(character,1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int character = (int)s.charAt(i);
            if(hashmap.containsKey(character)){
                int value = hashmap.get(character);
                if(value==1)
                    return (char)character;
            }
        }
        return ' ';

    }
}
