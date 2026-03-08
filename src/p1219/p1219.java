import java.util.*;
public class p1219{
    static int[] a,b,c,d;
    static int count=0;
    static int n;
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        a=new int[n+1];b=new int[n+1];c = new int[2*n+2]; // 主对角线i+j最大为2n
        d = new int[2*n+2]; // 副对角线i-j+n最大为2n-1，加2确保安全
        queen(1);
        System.out.println(count);
        System.exit(0);
    }
    public static void queen(int i){
        if(i>n){
            print();
            return ;
        }
        else{
            for(int j=1;j<=n;j++){
                if(b[j]==0&&c[i+j]==0&&d[i-j+n]==0){
                    a[i]=j;
                    b[j]=1;c[i+j]=1;d[i-j+n]=1;
                    queen(i+1);
                    b[j]=0;
                    c[i+j]=0;
                    d[i-j+n]=0;
                }
            }
        }
    }
    public static void print(){
        if(count<=2){
            for(int k=1;k<=n;k++){
                System.out.print(a[k]+" ");
            }
            System.out.println();
        }
        count++;
    }
}