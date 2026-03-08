import java.lang.*;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.*;
public class p2392{
    static int s[][]=new int[5][];
    static int sn[]=new int[5];
    static int count=0;
    static int left,right;
    static int minNum=Integer.MAX_VALUE;
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        for(int i=1;i<=4;i++){
            sn[i]=sc.nextInt();
            s[i] = new int[sn[i]+1];
        }
        for(int i=1;i<=4;i++)
        for(int j=1;j<=sn[i];j++){
            s[i][j]=sc.nextInt();
        }
        for(int i=1;i<=4;i++){
            minNum=Integer.MAX_VALUE;
            left=right=0;
            dp(i,1);
            count+=minNum;
        }
        System.out.println(count);
        System.exit(0);
    }
    
    public static void dp(int x,int y){
        if(y>sn[x]){
            minNum=min(minNum,max(left,right));
            return ;
        }
        left+=s[x][y];
        dp(x,y+1);
        left-=s[x][y];
        right+=s[x][y];
	    dp(x,y+1);
	    right-=s[x][y];
    }
}