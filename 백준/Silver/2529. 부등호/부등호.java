import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;

public class Main {
    private static int size;
    private static boolean[] used = new boolean[10];
    private static String[] signs;
    private static long max = Long.MIN_VALUE;
    private static long min = Long.MAX_VALUE;
    private static String maxStr = "";
    private static String minStr = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        size = k + 1;
        signs = br.readLine().split(" ");
        select(0, 0, 0, "");
        System.out.println(maxStr);
        System.out.println(minStr);
    }
    private static boolean validate(int a, int b, int idx) {
        if (a < b && signs[idx].equals(">")) {
            return false;
        }
        if (a > b && signs[idx].equals("<")) {
            return false;
        }
        return true;
    }

    private static void select(int idx, int cnt, int lastNum, String num) {
        if (cnt == size) {
            long tmp = Long.parseLong(num);
            if (tmp > max) {
                max = tmp;
                maxStr = num;
            }
            if (tmp < min) {
                min = tmp;
                minStr = num;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                if (cnt == 0) {
                    used[i] = true;
                    select(idx, cnt + 1, i, num + i);
                } else {
                    if (validate(lastNum, i, idx)) {
                        used[i] = true;
                        select(idx + 1, cnt + 1, i, num + i);
                    }
                }
                used[i] = false;
            }
        }
    }
}
