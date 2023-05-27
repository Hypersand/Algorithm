
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //민겸수
    //10^n -> n+1개의 m
    //5*10^n -> n개의 m , 1개의 k
    //민겸수는 한 개 이상의 민겸 숫자를 이어붙여 만든다.
    //하나의 민겸수가 십진수로 변환되었을때 가질 수 있는 최댓값과 최솟값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mk = br.readLine();

        String[] mkArr = mk.split("");

        StringBuilder max = new StringBuilder();
        StringBuilder min = new StringBuilder();

        StringBuilder group = new StringBuilder();

        for (int i = 0; i < mkArr.length; i++) {

            if (mkArr[i].equals("M")) {
                group.append("M");
                continue;
            }

            if (group.toString().equals("")) {
                max.append("5");
                continue;
            }

            max.append("5");

            for (int j = 0; j < group.length(); j++) {
                max.append("0");
            }

            group = new StringBuilder();
        }

        if (!group.equals("")) {
            for (int i = 0; i < group.length(); i++) {
                max.append("1");
            }
        }

        group = new StringBuilder();

        for (int i = 0; i < mkArr.length; i++) {

            if (mkArr[i].equals("M")) {
                group.append("M");
                continue;
            }


            for (int j = 0; j < group.length(); j++) {
                if (j == 0) {
                    min.append("1");
                    continue;
                }

                min.append("0");
            }

            group = new StringBuilder();

            min.append("5");
        }

        for (int j = 0; j < group.length(); j++) {
            if (j == 0) {
                min.append("1");
                continue;
            }

            min.append("0");
        }


        System.out.println(max);
        System.out.println(min);

    }
}
