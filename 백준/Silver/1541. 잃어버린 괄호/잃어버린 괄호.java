
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        List<Number> list = new ArrayList<>();
        int a = 0;
        boolean isTrue = true;
        String s = "";

        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("-")) {
                list.add(new Number(Integer.parseInt(s), isTrue));
                isTrue = false;
                s = "";
            }
            else if (str[i].equals("+")) {
                list.add(new Number(Integer.parseInt(s), isTrue));
                isTrue = true;
                s = "";
            }
            else {
                s += str[i];
                if (i == str.length - 1) {
                    list.add(new Number(Integer.parseInt(s), isTrue));
                }
            }
        }


        int sum = list.get(0).num;
        int k = 1;

        for (int i = 1; i<list.size(); i+=k) {
            if (!list.get(i).sign) {
                k = 1;
                int tmp = list.get(i).num;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(j).sign) {
                        k++;
                        tmp += list.get(j).num;
                    }
                    else {
                        break;
                    }
                }
                sum -= tmp;
            }
            else {
                sum += list.get(i).num;
            }
        }

        System.out.println(sum);

    }

    private static class Number {
        int num;
        boolean sign; // false : minus  true : plus

        public Number(int num, boolean sign) {
            this.num = num;
            this.sign = sign;
        }
    }
}
