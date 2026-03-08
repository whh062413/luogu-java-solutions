import java.util.*;
public class p2404 {
    static int n;
    static int div[]=new int[9];
    static int flag=1;
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        dfs(n,0);
        System.exit(0);
    }
    public static void dfs(int i,int y){
        if(i==0){
            print(y);
            return ;
        }
        if(i<0){
            return ;
        }
        for(int j=1;j<=n;j++){
            div[flag]=j;
            flag++;
            dfs(i-j,flag);
            flag--;
            div[flag]=0;
        }
    }
    public static void print(int y){
        if(y==2) return ;
        for(int i=1;i<=y-2;i++){
            if(div[i]>div[i+1]) return ;
        }
        for(int i=1;i<=y-1;i++){
            if(i!=(y-1)) System.out.print(div[i]+"+");
            else System.out.print(div[i]);
        }
        System.out.println();
    }
}
