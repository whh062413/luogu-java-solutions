import java.util.Scanner;
public class p1024 {
    public static void main(String[] args) {
        Scanner v = new Scanner(System.in);
        double a = v.nextDouble();
        double b = v.nextDouble();
        double c = v.nextDouble();
        double d = v.nextDouble();
        double x = -100;
        int n = 0;
        while (true) {
            if (Math.abs(a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d) <0.01) {
                System.out.printf("%.2f ", x);
                x += 1;
                n ++;
                if (n == 3 || x > 100){
                    break;
                }
            }else {
                x += 0.01;
            }
        }
    }
}
