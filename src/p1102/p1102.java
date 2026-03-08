import java.util.Arrays;
import java.util.Scanner;

public class p1102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 排序数组
        Arrays.sort(arr);

        long result = 0;
        for (int num : arr) {
            int target = num + c;
            int left = findLeft(arr, target);
            if (left == -1) continue; // 不存在目标值
            int right = findRight(arr, target);
            result += (right - left + 1);
        }

        System.out.println(result);
    }

    // 查找目标值第一次出现的位置
    private static int findLeft(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid - 1;
                if (arr[mid] == target) {
                    result = mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    // 查找目标值最后一次出现的位置
    private static int findRight(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
                if (arr[mid] == target) {
                    result = mid;
                }
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}