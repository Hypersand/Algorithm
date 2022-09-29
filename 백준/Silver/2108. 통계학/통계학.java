

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        double N = Integer.parseInt(br.readLine());
        double sum = 0;
        for (int i = 0; i<N; i++) {
            int count = 0;
            arr.add(Integer.parseInt(br.readLine()));
            if(map.containsKey(arr.get(i))) {
                int a = map.get(arr.get(i));
                map.put(arr.get(i),++a);
            }
            else {
                map.put(arr.get(i), count);
            }
            sum += arr.get(i);
        }
        System.out.println(Math.round(sum/N));
        Collections.sort(arr);
        System.out.println(arr.get((int) (N/2)));
        //최빈값
        if(arr.size() == 1) {
            System.out.println(arr.get(0));
        }
        else {
            List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
            entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o1.getValue() == o2.getValue()) {
                        return o1.getKey() - o2.getKey();
                    }
                    return o2.getValue() - o1.getValue();
                }
            });


            if(entryList.get(0).getValue()>entryList.get(1).getValue()) {
                System.out.println(entryList.get(0).getKey());
            }
            else {
                System.out.println(entryList.get(1).getKey());
            }
        }

        if(arr.size()>1) {
            System.out.println(arr.get((int) (N-1))-arr.get(0));
        }
        else {
            System.out.println(0);
        }
    }
}
