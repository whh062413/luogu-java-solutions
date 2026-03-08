import java.util.*;
public class p1678 {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(); // 学校数量
        int n = sc.nextInt(); // 学生数量
        
        int []a = new int[m]; // 学校分数线
        int []b = new int[n]; // 学生估分
        
        // 读取学校分数线并排序
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        
        // 读取学生估分并计算不满意度之和
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int score = sc.nextInt();
            sum += findMinDiff(a, score);
        }
        
        System.out.println(sum);
    }
    
    // 二分查找最接近的分数线并返回最小差值
    private static long findMinDiff(int[] a, int target) {
        int left = 0, right = a.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (a[mid] == target) {
                return 0; // 找到完全匹配的值
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // 此时left是第一个大于target的位置，right是最后一个小于target的位置
        long minDiff = Integer.MAX_VALUE;
        
        // 检查右边界（最后一个小于target的值）
        if (right >= 0) {
            minDiff = Math.min(minDiff, target - a[right]);
        }
        
        // 检查左边界（第一个大于target的值）
        if (left < a.length) {
            minDiff = Math.min(minDiff, a[left] - target);
        }
        
        return minDiff;
    }
}