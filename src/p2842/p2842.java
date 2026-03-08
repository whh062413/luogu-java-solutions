import java.util.Scanner;

public class p2842 {
    public static void main(String[] args) {
        // 创建Scanner对象读取输入
        Scanner sc = new Scanner(System.in);
        
        // 读取纸币种类n和目标金额w
        int n = sc.nextInt();
        int w = sc.nextInt();
        
        // 读取纸币面额数组
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        
        // 初始化dp数组：dp[j]表示凑出金额j的最少纸币数
        // 用Integer.MAX_VALUE - 1避免后续+1时溢出
        int[] dp = new int[w + 1];
        final int INF = Integer.MAX_VALUE - 1;
        for (int j = 1; j <= w; j++) {
            dp[j] = INF;
        }
        dp[0] = 0; // 凑0元需要0张纸币
        
        // 遍历每种纸币（完全背包：先物品，后金额）
        for (int num : a) {
            // 遍历金额从当前纸币面额到目标金额
            for (int j = num; j <= w; j++) {
                // 状态转移：更新最少张数
                dp[j] = Math.min(dp[j], dp[j - num] + 1);
            }
        }
        
        // 输出结果
        System.out.println(dp[w]);
    }
}