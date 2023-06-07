import java.util.HashMap;

public class pm118666 {
    public static void main(String[] args) {
        String[] survey = { "AN", "CF", "MJ", "RT", "NA" };
        int[] choices = { 5, 3, 2, 7, 5 };

        String answer = "";
        HashMap<String, Integer> scoreTable = new HashMap<>();
        String[][] checkTable = { { "R", "T" }, { "C", "F" },
                { "J", "M" }, { "A", "N" } };

        for (String[] i : checkTable) {
            for (String str : i)
                scoreTable.put(str, 0);
        }

        int score = 0;
        for (int i = 0; i < choices.length; i++) {
            score = choices[i];
            boolean state = score > 4;

            if (score == 4)
                continue;

            score = (score > 4) ? score -= 4 : 4 - score;

            String now;

            now = (state) ? survey[i].substring(1, 2) : survey[i].substring(0, 1);
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
        //System.out.println(scoreTable);
        System.out.println(answer);

    }
}
