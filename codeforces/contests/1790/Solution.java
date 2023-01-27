import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class Node {
    public int value;
    public List<Integer> lefts = new ArrayList<>();
    public List<Integer> rights = new ArrayList<>();
    public Node left;
    public Node right;
    public Node() {

    }
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String r = right == null ? "null" : String.valueOf(right.value);
        String l = left == null ? "null" : String.valueOf(left.value);
        return String.format("{ value: %s r: %s, l: %s }", value, r, l);
    }
}

public class Solution {
    public static void main(String[] args) {
        solveC();
    }



    public static void solveC() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            Node[] nodes = new Node[n+1];
            System.out.println("--------------- case :" + i + "-------------");
            for (int j = 0; j < n; j++) {
                int previous = 0;
                int tmp = 0;
                // here a permutation without a number
                for (int k = 0; k < n-1; k++) {
                    if (tmp != 0) {
                        previous = tmp;
                    }
                    tmp = in.nextInt();
                    if (nodes[tmp] == null) {
                        nodes[tmp] = new Node(tmp);
                    }
                    // nodes[tmp] = new Node(tmp);
                    // now I have nodes[tmp] and tmp and previous (maybe 0) up to date
                    if (previous != 0) {
                        if (nodes[previous].rights.size() < 3 && nodes[previous].right == null) {
                            nodes[previous].rights.add(tmp);
                        }
                        if (nodes[tmp].lefts.size() < 3 && nodes[tmp].left == null) {
                            nodes[tmp].lefts.add(previous);
                        }
                        if (nodes[previous].rights.size() >= 3) {
                            int rightIndex = nodes[previous].rights.get(0);
                            if (nodes[previous].rights.get(1) == nodes[previous].rights.get(2)) {
                                rightIndex = nodes[previous].rights.get(0);
                            }
                            nodes[previous].right = nodes[rightIndex];
                            nodes[rightIndex].left = nodes[previous];
                        }
                        if (nodes[tmp].lefts.size() >= 3) {
                            int leftIndex = nodes[tmp].lefts.get(0);
                            if (nodes[tmp].lefts.get(1) == nodes[tmp].lefts.get(2)) {
                                leftIndex = nodes[previous].lefts.get(0);
                            }
                            nodes[tmp].left = nodes[leftIndex];
                            nodes[leftIndex].right = nodes[tmp];
                        }
                    }
                }
            }
            for (int j = 1; j < n+1; j++) {
                System.out.println(nodes[j]);
            }
        }
    }


    public static void solveB() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n, s, r;
            n = in.nextInt();
            s = in.nextInt();
            r = in.nextInt();
            int max = s - r;
            // all (n-1) dices should be less than max and their some = r
            int[] dices = new int[n];
            dices[n-1] = max;
            while (r>0) {
                for (int j = 0; j < n-1 && r>0; j++) {
                    if (dices[j] < max) {
                        dices[j]++;
                        r--;
                    }
                }
            }
            for (int j = 0; j < n - 1; j++) {
                System.out.print(dices[j]+ " ");
            }
            System.out.println(max);
        }
    }
    
    public static void solve() {
        String PI = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679821480865132823066470938446095505822317253594081284811174502";
        Scanner in = new Scanner(System.in);
        int  t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int ans = 0;
            String n = in.next();
            boolean stillCorrect = true;
            int delta = 0;
            for (int j = 0; j < n.length() && stillCorrect; j++) {

                if (PI.charAt(j) == '.') {
                    delta = 1;
                }
                if (n.charAt(j) == PI.charAt(j + delta)) {
                    ans++;
                } else {
                    stillCorrect = false;
                }
            }
            System.out.println(ans);
        }
    }
}
