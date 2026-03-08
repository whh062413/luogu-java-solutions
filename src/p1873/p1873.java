import java.util.*;
import java.lang.*;
public class p1873 {
    private static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] a = new int[n + 1];
        int maxNum = -1;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if (a[i] > maxNum) maxNum = a[i];
        }
        // Arrays.sort(a,1,n+1);
        System.out.println(divTree(a, 0, maxNum, m));
        System.exit(0);
    }

    public static int divTree(int[] a, int l, int r, int m) {
        int ans = l;
        while (l <= r) {
            int mid = (l + r) / 2;
            //if(countTree(a,mid)==m) return mid;
            if (countTree(a, mid) >= m) {
                ans = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return ans;
    }

    public static long countTree(int[] a, int q) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            if (a[i] > q) sum += a[i] - q;
        }
        return sum;
    }
}