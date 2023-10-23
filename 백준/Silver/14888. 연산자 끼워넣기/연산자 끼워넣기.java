import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[] numbers;
    private static int[] operators;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        find(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void find(int index, int result) {
        if (index == N - 1) {
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] != 0) {
                int tmp = result;
                if (i == 0) {
                    result += numbers[index + 1];
                    operators[i]--;
                }
                else if (i == 1) {
                    result -= numbers[index + 1];
                    operators[i]--;
                }

                else if (i == 2) {
                    result *= numbers[index + 1];
                    operators[i]--;

                }
                else {
                    result /= numbers[index + 1];
                    operators[i]--;
                }

                find(index + 1, result);
                operators[i]++;
                result = tmp;
            }
        }
    }
}

