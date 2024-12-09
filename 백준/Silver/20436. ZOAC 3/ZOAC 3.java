import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Key {
    char c, hand;
    int x, y;
    public Key(char c, char hand, int x, int y) {
        this.c = c;
        this.hand = hand;
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static Key[] arr = new Key[30];
    public static void make() {
        arr[0] = new Key('q', 'l', 0, 0);
        arr[1] = new Key('w', 'l', 0, 1);
        arr[2] = new Key('e', 'l', 0, 2);
        arr[3] = new Key('r', 'l', 0, 3);
        arr[4] = new Key('t', 'l', 0, 4);
        arr[5] = new Key('y', 'r', 0, 5);
        arr[6] = new Key('u', 'r', 0, 6);
        arr[7] = new Key('i', 'r', 0, 7);
        arr[8] = new Key('o', 'r', 0, 8);
        arr[9] = new Key('p', 'r', 0, 9);

        arr[10] = new Key('a', 'l', 1, 0);
        arr[11] = new Key('s', 'l', 1, 1);
        arr[12] = new Key('d', 'l', 1, 2);
        arr[13] = new Key('f', 'l', 1, 3);
        arr[14] = new Key('g', 'l', 1, 4);
        arr[15] = new Key('h', 'r', 1, 5);
        arr[16] = new Key('j', 'r', 1, 6);
        arr[17] = new Key('k', 'r', 1, 7);
        arr[18] = new Key('l', 'r', 1, 8);

        arr[19] = new Key('X', 'x', 1, 9);

        arr[20] = new Key('z', 'l', 2, 0);
        arr[21] = new Key('x', 'l', 2, 1);
        arr[22] = new Key('c', 'l', 2, 2);
        arr[23] = new Key('v', 'l', 2, 3);
        arr[24] = new Key('b', 'r', 2, 4);
        arr[25] = new Key('n', 'r', 2, 5);
        arr[26] = new Key('m', 'r', 2, 6);

        arr[27] = new Key('X', 'x', 2, 7);
        arr[28] = new Key('X', 'x', 2, 8);
        arr[29] = new Key('X', 'x', 2, 9);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        make();

        StringTokenizer stk = new StringTokenizer(br.readLine());
        char le = stk.nextToken().charAt(0);
        char rt = stk.nextToken().charAt(0);
        
        Key leInfo = null, rtInfo = null;
        
        for(int i = 0; i < arr.length; i ++) {
            if(le == arr[i].c) {
                leInfo = arr[i];
            }
            if(rt == arr[i].c) {
                rtInfo = arr[i];
            }
        }
        
        char[] cArr = br.readLine().toCharArray();
        int cnt = 0;
        for(char c : cArr) {
            Key currKey = null;
            for(int i = 0; i < arr.length; i ++) {
                if(c == arr[i].c) currKey = arr[i];
            }
            
            if(currKey.hand == 'l') {
                cnt += Math.abs(leInfo.x - currKey.x) + Math.abs(leInfo.y - currKey.y);
                cnt ++;
                leInfo = currKey;
            }
            else {
                cnt += Math.abs(rtInfo.x - currKey.x) + Math.abs(rtInfo.y - currKey.y);
                cnt ++;
                rtInfo = currKey;
            }
        }
        bw.write(cnt + "");
        bw.flush();
    }
}