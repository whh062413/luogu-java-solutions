import java.util.*;
public class p2196{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int w[]=new int [N+1];
        int map[][]=new int[N+1][N+1];
         int dp[]=new int[N+1];
        for(int i=1;i<=N;i++) {w[i]=sc.nextInt();
            dp[i]=w[i];
        }
        for(int i=1;i<=N-1;i++){
            for(int j=i+1;j<=N;j++)
                map[i][j]=sc.nextInt();
        }   
        /*for(int i=1;i<=N-1;i++){
            for(int j=1;j<=N-i;j++)
                System.out.println(map[i][j]+" ");
        }  */
        int[] prev = new int[N+1];
        // 初始化prev为0（无前置节点）
        Arrays.fill(prev,0);
       for(int i=1;i<=N;i++){
            for(int j=i+1;j<=N;j++){
                if (map[i][j]==1) {
                    // 若从i到j能获得更大价值，更新dp[j]并记录前驱
                    if (dp[j]<dp[i]+w[j]) {
                        dp[j]=dp[i]+w[j];
                        prev[j]=i; // 记录j的前驱是i
                    }
                }
            }
       }
       int maxNum=-1;
       int maxIndex=-1;
       for(int i=1;i<=N;i++){
        if(dp[i]>maxNum) maxIndex=i;
        maxNum=Math.max(dp[i],maxNum);
       }
       List<Integer> path=new ArrayList<>();
       int temp=maxIndex;
       while(temp!=0){
        path.add(temp);
        temp=prev[temp];
       }
        Collections.reverse(path);
        for (int i=0;i<path.size(); i++) {
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
       System.out.println(maxNum);
       sc.close();
    }
}