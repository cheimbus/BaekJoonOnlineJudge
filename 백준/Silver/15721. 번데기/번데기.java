import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, val;

    public static int find() {
        int cnt = 2;
        int a = 0;
        int b = 0;
        while (true) {
            for (int i = 0; i < 6; i++) {
                if (i == 4) {
                    for (int j = 0; j < cnt; j++) {
                        a++;
                        if (a == m && val == 0) return (a + b - 1) % n;
                    }
                } else if (i == 5) {
                    for (int j = 0; j < cnt; j++) {
                        b++;
                        if (b == m && val == 1) return (b + a - 1) % n;
                    }
                } else if (i % 2 == 0) {
                    a++;
                    if (a == m && val == 0) return (a + b - 1) % n;
                } else {
                    b++;
                    if (b == m && val == 1) return (b + a - 1) % n;
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        val = Integer.parseInt(br.readLine());

        int ans = find();

        bw.write(ans + "");
        bw.flush();
    }
}
