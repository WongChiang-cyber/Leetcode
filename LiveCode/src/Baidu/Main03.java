package Baidu;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n+1];
        for (int i = 0; i < n + 1; i++) {
            nodes[i] = new Node(i);
        }
        int m = sc.nextInt();
        int[] start = new int[m];
        int[] end = new int[m];
        for (int i = 0; i < m; i++) {
            start[i] = sc.nextInt();
            end[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int s = start[i];
            int e = end[i];
            nodes[s].next = nodes[e];
        }


    }

    public static boolean isChanged(Node[] nodes1,Node[] nodes2){
        for (int i = 0; i < nodes1.length; i++) {
            if(!Node.compare(nodes1[i],nodes2[i]))
                return false;
        }
        return true;
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
    public static boolean compare(Node node1,Node node2){
        if(node1==null && node2==null)
            return true;
        else if(node1 == null || node2==null)
            return false;
        return node1.val==node2.val && node1.next==node2.next;
    }
}
