package WeBank;

import java.util.Arrays;
import java.util.Scanner;

public class Main02 {

    public static int find(String input){
        int state = 0;
        int res = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (state){
                case 0:
                    switch (c){
                        case 'P':
                            state = 2;
                            res += 200;
                            break;
                        case 'G':
                            state = 1;
                            res += 100;
                            break;
                        case 'M':
                            state = -1;
                            break;
                    }
                    break;
                case 1:
                    switch (c){
                        case 'P':
                            state = 2;
                            res+=200;
                            break;
                        case 'G':
                            state = 1;
                            res += 100;
                            break;
                        case 'M':
                            state = 0;
                            break;
                    }
                    break;
                case 2:
                    switch (c){
                        case 'P':
                            state = 3;
                            res += 200;
                            break;
                        case 'G':
                            state = 1;
                            res += 100;
                            break;
                        case 'M':
                            state = 0;
                            break;
                    }
                    break;
                case 3:
                    switch (c){
                        case 'P':
                            state = 4;
                            res += 200;
                            break;
                        case 'G':
                            state = 1;
                            res += 100;
                            break;
                        case 'M':
                            state = 0;
                            break;
                    }
                    break;
                case 4:
                    switch (c){
                        case 'P':
                            res += 250;
                            state = 4;
                            break;
                        case 'G':
                            res += 100;
                            state = 1;
                            break;
                        case 'M':
                            state = 0;
                            break;
                    }
                    break;
                case -1:
                    switch (c){
                        case 'P':
                            res += 200;
                            state = 2;
                            break;
                        case 'G':
                            res += 100;
                            state = 1;
                            break;
                        case 'M':
                            state = -2;
                            break;
                    }
                    break;
                case -2:
                    return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(find(input));
    }
}
