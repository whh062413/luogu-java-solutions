import java.lang.*;
import java.util.*;
public class p2440 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 原木数量
        int k = sc.nextInt(); // 需要的小段数量
        
        int[] woods = new int[n];
        int maxWood = 0;
        
        // 读取原木长度并找出最大值
        for (int i = 0; i < n; i++) {
            woods[i] = sc.nextInt();
            maxWood = Math.max(maxWood, woods[i]);
        }
        
        // 二分查找最大可能的长度 l
        int left=1;
        int right=maxWood;
        int ans=0;
        
        while(left<=right) {
            int mid=left+(right-left)/2;
            if (canCut(woods, mid, k)){
                ans = mid;
                left = mid + 1; // 尝试更大的长度
            } else {
                right = mid - 1; // 尝试更小的长度
            }
        }
        
        System.out.println(ans);
    }
    
    // 检查是否能切出至少 k 段长度为 len 的小段
    private static boolean canCut(int[] woods, int len, int k){
        long count = 0;
        for (int wood : woods) {
            count += wood / len; // 每根原木能切出的段数
        }
        return count >= k;
    }
}