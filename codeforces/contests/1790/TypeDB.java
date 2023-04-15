import java.util.*;


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

class RankedNode extends Node {
    public int rank = 1;

    public RankedNode(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return super.toString() + "[ rank: " + rank + "]";
    }

}

public class Solution {
    public static void main(String[] args) {
        solveCBis();
    }


    /*
    autor: mouhssin
     */
    public static void solveCBis() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println("--------------- case :" + i + "-------------");
            int n = in.nextInt();
            RankedNode[] ranks = new RankedNode[n+1];
            for (int j = 0; j <= n; j++) {
                ranks[j] = new RankedNode(j);
            }
            ranks[0].rank = 0;
            // fill the array with 0
            for (int j = 0; j < n; j++) {
                int previous = in.nextInt();
                // here a permutation without a number
                for (int k = 1; k < n-1; k++) {
                    int tmp = in.nextInt();
                    ranks[tmp].rank = Math.max(ranks[tmp].rank, ranks[previous].rank + 1);
                    previous = tmp;
                }
            }
            Arrays.sort(ranks, new Comparator<RankedNode>() {
                @Override
                public int compare(RankedNode o1, RankedNode o2) {
                    return o1.rank - o2.rank;
                }
            });

            for (int j = 1; j <= n; j++) {
                System.out.println(ranks[j]);
            }

            for (int j = 1; j < n; j++) {
                System.out.print(ranks[j].value + " ");
            }
            System.out.println(ranks[n].value);
        }
    }

    public static void solveC() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            Node[] nodes = new Node[n+1];
            //System.out.println("--------------- case :" + i + "-------------");
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
                                rightIndex = nodes[previous].rights.get(1);
                            }
                            nodes[previous].right = nodes[rightIndex];
                            nodes[rightIndex].left = nodes[previous];
                        }
                        if (nodes[tmp].lefts.size() >= 3) {
                            int leftIndex = nodes[tmp].lefts.get(0);
                            if (nodes[tmp].lefts.get(1) == nodes[tmp].lefts.get(2)) {
                                leftIndex = nodes[tmp].lefts.get(1);
                            }
                            nodes[tmp].left = nodes[leftIndex];
                            nodes[leftIndex].right = nodes[tmp];
                        }
                    }
                }
            }
            if (n > 3) {
                Node leftMostNode = null;
                for (int j = 1; j < n+1; j++) {
                    // System.out.println(nodes[j]);
                    if (nodes[j].left == null) leftMostNode = nodes[j];
                }
                while(leftMostNode.right != null) {
                    System.out.print(leftMostNode.value + " ");
                    leftMostNode = leftMostNode.right;
                }
                System.out.println(leftMostNode.value);
            } else {
                Node middleNode = null;
                for (int j = 1; j < n+1; j++) {
                    if (nodes[j].rights.size() == 1 && nodes[j].lefts.size() == 1) {
                        middleNode = nodes[j];
                        System.out.print(middleNode.lefts.get(0) + " ");
                        System.out.print(middleNode.value + " ");
                        System.out.println(middleNode.rights.get(0));
                    }
                }
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
