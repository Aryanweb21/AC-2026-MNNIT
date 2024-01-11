import java.util.*;

public class 1st{
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int n = read.nextInt();
        String s = read.next();
        int ans=0;
        for(int i=0;i<n-2;i++)
        {
            /*
                Since we need to find three consecutive 'x' in string, we can clearly say that it will never appear in less
                than 3 elements, so we can start a loop from 0 to n-2 and check if there is any consecutive occurrence of 'x'
                and if 'YES' we can increase the ans by 1.
                ans is holding the number of times we encounter a 'xxx' and need to remove 'x'.
            */
            if(s.charAt(i)=='x' && s.charAt(i+1)=='x' && s.charAt(i+2)=='x')
                ans++;
        }
        System.out.println(ans);
    }
}
