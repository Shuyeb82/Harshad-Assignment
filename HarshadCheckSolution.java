import java.util.Scanner;

public class HarshadCheckSolution {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        int sum = 0, temp = n;

        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }

        if (n % sum == 0)
            System.out.println("Harshad Number");
        else
            System.out.println("Not Harshad Number");

        sc.close();
    }
}