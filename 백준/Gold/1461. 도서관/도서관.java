import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        List<Integer> plusList = new ArrayList<>();
        List<Integer> minusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num > 0) {
                plusList.add(num);
            } else {
                minusList.add(num);
            }
        }

        Collections.sort(plusList, Collections.reverseOrder());
        Collections.sort(minusList);
        //M : 한번에 들 수 있는 책의 개수
        //M이 리스트에 있는 갯수보다 클 경우도 따로 생각해야될듯
        int answer = 0;
        int plusIdx = 0;
        int minusIdx = 0;
        if (plusList.size() > 0 && minusList.size() > 0) {
            if (plusList.get(0) > minusList.get(0) * -1) {
                answer += plusList.get(0);
                plusIdx += M;
            } else if (plusList.get(0) < Math.abs(minusList.get(0))) {
                answer += Math.abs(minusList.get(0));
                minusIdx += M;
            } else {
                if (plusList.size() > minusList.size()) {
                    answer += plusList.get(0);
                    plusIdx += M;
                } else {
                    answer += Math.abs(minusList.get(0));
                    minusIdx += M;
                }
            }
        } else {
            if (plusList.size() == 0) {
                answer += Math.abs(minusList.get(0));
                minusIdx += M;
            } else {
                answer += plusList.get(0);
                plusIdx += M;
            }
        }

        for (int i = plusIdx; i < plusList.size(); i += M) {
            answer += plusList.get(i) * 2;
        }

        for (int i = minusIdx; i < minusList.size(); i += M) {
            answer += Math.abs(minusList.get(i)) * 2;
        }

        System.out.println(answer);
    }
}
