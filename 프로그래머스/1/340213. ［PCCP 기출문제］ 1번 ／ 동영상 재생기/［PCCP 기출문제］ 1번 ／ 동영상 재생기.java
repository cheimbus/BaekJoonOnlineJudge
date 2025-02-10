import java.util.*;
class Solution {
    public boolean check(int a, int b, int x) {
        return a <= x && x <= b;
    }
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int ip = 0;
        String[] sArr = pos.split(":");
        ip += Integer.parseInt(sArr[0]) * 60;
        ip += Integer.parseInt(sArr[1]);
        
        String[] osArr = op_start.split(":");
        String[] oeArr = op_end.split(":");
        int os = 0;
        os += Integer.parseInt(osArr[0]) * 60;
        os += Integer.parseInt(osArr[1]);
        
        int oe = 0;
        oe += Integer.parseInt(oeArr[0]) * 60;
        oe += Integer.parseInt(oeArr[1]);
        
        String[] vlArr = video_len.split(":");
        int vl = 0;
        vl += Integer.parseInt(vlArr[0]) * 60;
        vl += Integer.parseInt(vlArr[1]);
        
        if(check(os, oe, ip)) ip = oe;
        
        for(int i = 0; i < commands.length; i ++) {
            if(commands[i].equals("next")) {
                ip += 10;
                if(ip >= vl) ip = vl;
                if(check(os, oe, ip)) ip = oe;
            }
            else {
                ip -= 10;
                if(ip <= 0) ip = 0;
                if(check(os, oe, ip)) ip = oe;
            }
        }
        StringBuilder sb = new StringBuilder();    
        String m = ip / 60 + "";
        ip %= 60;
        
        if(m.equals("0")) sb.append("00" + ":");
        else if(m.length() == 1) sb.append("0" + m + ":");
        else sb.append(m + ":");
           
        String s = ip + "";
        if(s.equals("0")) sb.append("00");
        else if(s.length() == 1) sb.append("0" + s);
        else sb.append(s);
    
        return sb.toString();
    }
}