//TreeMap_Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class bj7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tk = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int a = 0; a < tk; a++) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    //treemap에서 중요한 함수 "getOrDefault" (a,b) 키값 a가 있으면 a키값 벨류를, 없으면 b값을 반환함
                }
                if (map.size() == 0) {
                    continue;
                }
                if (str.equals("D")) {
                    int keyNum = num == 1 ? map.lastKey() : map.firstKey();
                    int valNum = map.get(keyNum);
                    if (valNum == 1) {
                        map.remove(keyNum);
                    } else {
                        map.put(keyNum, valNum - 1);
                    }

                }

            }
            if (map.size() == 0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }

        }
        System.out.println(sb);
    }
}
