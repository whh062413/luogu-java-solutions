import java.util.*;
public class p2840{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int q[]=new int[n];
        for(int i=0;i<n;i++){
            q[i]=sc.nextInt();
        }
        int dp[]=new int[w+1];
        dp[0]=1;
        for(int i=1;i<=w;i++){
            for(int j=0;j<n;j++){
                if(i-q[j]>=0) dp[i]=(int) ((dp[i]+dp[i-q[j]])%(1e9+0x7));
            }
        }
        System.out.println( (int)(dp[w]%(1e9+0x7)));
        sc.close();
    }
}