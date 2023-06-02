import java.util.HashMap;

public class pm118666 {
    public static void main(String[] args) {
        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 4,4,4,4,4 };

        String answer = "";
        HashMap<String, Integer> scoreTable = new HashMap<>();
        scoreTable.put("R", 0);
        scoreTable.put("T", 0);
        scoreTable.put("C", 0);
        scoreTable.put("F", 0);
        scoreTable.put("J", 0);
        scoreTable.put("M", 0);
        scoreTable.put("A", 0);
        scoreTable.put("N", 0);

        String[][] checkTable = { { "R", "T" }, { "C", "F" }, { "J", "M" }, { "A", "N" } };

        int score = 0;
        for (int i = 0; i < choices.length; i++) {
            score = choices[i];
            boolean state = false;
            if (score == 4)
                continue;

            if (score > 4) {
                state = true;
                score -= 4;
            } else
                score = 4 - score;

            String now;
            if (state) {
                now = survey[i].substring(1, 2);
                scoreTable.put(now, scoreTable.get(now) + score);
                continue;
            }
            now = survey[i].substring(0, 1);
            scoreTable.put(now, scoreTable.get(now) + score);
        }
        for (int i = 0; i < 4; i++) {
            int a = scoreTable.get(checkTable[i][0]);
            int b = scoreTable.get(checkTable[i][1]);
            if (a >= b) {
                answer = answer + checkTable[i][0];
                continue;
            }
            answer = answer + checkTable[i][1];
        }

        System.out.println(answer);


    }
}
