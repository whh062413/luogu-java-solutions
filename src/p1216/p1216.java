import java.util.*;
public class p1216{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int num[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                num[i][j]=sc.nextInt();
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(j!=0) num[i][j]+=Math.max(num[i-1][j],num[i-1][j-1]);
                else num[i][j]+=num[i-1][j];
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            ans=Math.max(num[n-1][i],ans);
        }
        System.out.println(ans);
        sc.close();
    }
}