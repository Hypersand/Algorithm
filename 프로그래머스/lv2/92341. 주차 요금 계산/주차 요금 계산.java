import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Car> list = new ArrayList<>();
        
        for (int i = 0; i<records.length; i++) {
            String[] carInfo = records[i].split(" ");
            int carNumber = Integer.parseInt(carInfo[1]);
            if(map.containsKey(carNumber)) {
                if(carInfo[2].equals("OUT")) {
                    int cost = calculateCost(map.get(carNumber), carInfo[0]);
                    if(map2.containsKey(carNumber)) {
                        map2.put(carNumber, map2.get(carNumber) + cost);
                    }
                    else {
                        map2.put(carNumber, cost);
                    }
                    
                    map.remove(carNumber);
                }
            }
            
            else {
                map.put(carNumber, carInfo[0]);  
            }   
        }
        
        for (Integer carNumber : map.keySet()) {
            int cost = calculateCost(map.get(carNumber), "23:59");
            if(map2.containsKey(carNumber)) {
                map2.put(carNumber, map2.get(carNumber) + cost);
            }
            else {
                map2.put(carNumber, cost);
            }
        }
        
        for (Integer carNumber : map2.keySet()) {
            System.out.println(map2.get(carNumber));
            int fee = calculateFee(fees, map2.get(carNumber));
            list.add(new Car(carNumber, fee));
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for (int i = 0; i<list.size(); i++) {
            answer[i] = list.get(i).fee;
        }
        
        return answer;
    }
    
    public int calculateCost(String inTime, String outTime) {
        String[] inTimesStr = inTime.split(":");
        String[] outTimesStr = outTime.split(":");
        int[] inTimes = new int[2];
        int[] outTimes = new int[2];
        inTimes[0] = Integer.parseInt(inTimesStr[0]);
        inTimes[1] = Integer.parseInt(inTimesStr[1]);
        outTimes[0] = Integer.parseInt(outTimesStr[0]);
        outTimes[1] = Integer.parseInt(outTimesStr[1]);
        
        return (outTimes[0] * 60 + outTimes[1]) - 
            (inTimes[0] * 60 + inTimes[1]);    
    }
    
    public int calculateFee(int[] fees, int cost) {
        
        if(cost<=fees[0]) {
            return fees[1];
        }
        
        if(((cost-fees[0])%(double)fees[2]) == 0) {
            return fees[1] + ((cost-fees[0])/fees[2]) * fees[3];  
        }
        
        return fees[1] + (((cost-fees[0])/fees[2]) * fees[3]) + fees[3];
    }
}

class Car implements Comparable<Car> {
    public int number;
    public int fee;
    
    public Car(int number, int fee) {
        this.number = number;
        this.fee = fee;
    }
    
    public int compareTo(Car car) {
        return this.number - car.number;
    }
}