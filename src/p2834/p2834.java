import java.util.*;
public class p2834{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int m[]=new int[n+1];
        int mod=(int)1e9+0x7;
        int dp[][]=new int [n+1][w+1];
        for(int i=1;i<=n;i++){
            m[i]=sc.nextInt();
        }
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(j<m[i]) dp[i][j]=dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-m[i]];
                    dp[i][j]=dp[i][j]%mod;
                }
            }
        }
        System.out.println(dp[n][w]);
        sc.close();
    }
}