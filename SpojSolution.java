import java.io.*;
import java.util.*;

public class SpojSolution {

    static final int MAX = 1000000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        boolean[] generated = new boolean[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum <= MAX) {
                generated[sum] = true;
            }
        }

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] prefix = new int[MAX + 1];

        for (int i = 1; i <= MAX; i++) {
            prefix[i] = prefix[i - 1];

            if (!generated[i] && isPrime[i]) {
                prefix[i]++;
            }
        }

        
        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            String[] parts = br.readLine().split(" ");
            int A = Integer.parseInt(parts[0]);
            int B = Integer.parseInt(parts[1]);

            int result = prefix[B] - (A > 0 ? prefix[A - 1] : 0);
            output.append(result).append("\n");
        }

        System.out.print(output);
    }
}