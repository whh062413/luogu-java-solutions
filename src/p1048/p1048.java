import java.util.*;
public class p1048{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int m=sc.nextInt();
        int w[]=new int[m];
        int v[]=new int[m];
        for(int i=0;i<m;i++){
            w[i]=sc.nextInt();
            v[i]=sc.nextInt();
        }
        int dp[]=new int[t+1];
        dp[0]=0;
        for(int i=0;i<m;i++){
            for(int j=t;j>=w[i];j--)
            dp[j]=Math.max(dp[j],dp[j-w[i]]+v[i]);
        }
        System.out.print(dp[t]);
        sc.close();
    }
}