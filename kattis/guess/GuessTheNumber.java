import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b;
        a=0;
        b=1001;
        String l="lower",h="higher",c="correct";
        int x=(a+b)/2;
        int tries=1;
        String ans;
        System.out.println(x);
        ans = in.next();
        while(!ans.equals(c)) {
            if (ans.equals(l)) {
                b=x;
                x=(a+b)/2;
            }
            else {
                a=x;
                x=(a+b)/2;
            }
            //tries++;
            System.out.println(x);
            ans=in.next();
        }
    }
}
