import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger num = BigInteger.ZERO;
            for(int j = 0; j < n; j++) {
                num = num.add(new BigInteger(br.readLine()));
            }
            if(num.equals(BigInteger.ZERO)) {
                sb.append("0").append("\n");
            } else if(num.compareTo(BigInteger.ZERO) > 0) {
                sb.append("+").append("\n");
            } else {
                sb.append("-").append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
