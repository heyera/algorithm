import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class pm92341 {
    public static void main(String[] args) {
        int[] fees = { 120, 0, 60, 591 };
        String[] records = { "16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN" };

        int defTime = fees[0];
        int defFee = fees[1];
        int addTime = fees[2];
        int addFee = fees[3];

        int maxTime = (23 * 60) + 59;

        HashMap<String, Integer> park = new HashMap<>();
        HashMap<String, Integer> parkPay = new HashMap<>();

        for (int i = 0; i < records.length; i++) {
            StringTokenizer totalSt = new StringTokenizer(records[i], " ");

            // 시간저장
            String TimeStr = totalSt.nextToken();
            StringTokenizer timeSt = new StringTokenizer(TimeStr, ":");
            int time = (Integer.parseInt(timeSt.nextToken()) * 60) + Integer.parseInt(timeSt.nextToken());

            // 차번호
            String carNumber = totalSt.nextToken();

            // 입차 출차 상태저장
            String state = totalSt.nextToken();

            if (state.equals("IN")) {
                park.put(carNumber, time);
                continue;
            }

            int inTime = time - park.remove(carNumber);
            // System.out.println(inTime);
            if (parkPay.containsKey(carNumber))
                parkPay.put(carNumber, parkPay.get(carNumber) + inTime);
            else
                parkPay.put(carNumber, inTime);
        }

        // 출차안한 차들 요금 부과
        if (park.size() > 0) {
            for (String i : park.keySet()) {
                int inTime = maxTime - park.remove(i);
                if (parkPay.containsKey(i))
                    parkPay.put(i, parkPay.get(i) + inTime);
                else
                    parkPay.put(i, inTime);
            }
        }

        System.out.println(parkPay);
        String[] carNumbers = new String[parkPay.size()];
        int a = 0;

        for (String i : parkPay.keySet()) {
            carNumbers[a] = i;
            a += 1;
        }

        Arrays.sort(carNumbers);

        int[] answer = new int[parkPay.size()];

        for (int i = 0; i < answer.length; i++) {
            int totalTime = parkPay.get(carNumbers[i]);
            int pay = 0;

            if (totalTime > defTime) {
                totalTime -= defTime;
                pay += defFee;

                if (totalTime % addTime == 0) {
                    pay += (totalTime / addTime) * addFee;
                } else
                    pay += ((totalTime / addTime) + 1) * addFee;

                answer[i] = pay;
                continue;
            }

            answer[i] = defFee;
        }

        // System.out.println(parkPay);
        System.out.println("\ndkanswer");
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
