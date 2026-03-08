import java.util.Scanner;

public class p2249 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        // 动态分配数组（1-based 索引，避免下标越界）
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int q = sc.nextInt();
            int res = findFirst(a, q, 1, n); // 找第一个出现的位置
            sb.append(res).append(" ");
        }

        // 去除末尾多余空格
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.println(sb.toString());
    }

    /**
     * 迭代版二分查找：找目标值**第一次出现**的位置（1-based 索引）
     * @param a  非降序数组
     * @param q  目标值
     * @param l  左边界（初始为 1）
     * @param r  右边界（初始为 n）
     * @return   第一次出现的索引，或 -1（未找到）
     */
    public static int findFirst(int[] a, int q, int l, int r) {
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2; // 防止 l + r 溢出
            if (a[mid] == q) {
                res = mid; // 记录当前位置，继续向左找更早的出现
                r = mid - 1;
            } else if (a[mid] > q) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}