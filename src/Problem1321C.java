import java.util.Scanner;

public class Problem1321C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        int count = 0;

        for (char ch = 'z'; ch > 'a'; ch--){
            for (int i = 0; i < s.length(); i++){
                if (s.length() == 1) {
                    break;
                }
                if (s.charAt(i) != ch){
                    continue;
                }

                if (i == 0){
                    if (s.charAt(i + 1) == ch - 1){
                        count++;
                        s = s.substring(0, i) + s.substring(i + 1);
                        i--;
                    }
                } else if (i == s.length() - 1){
                    if (s.charAt(i - 1) == ch - 1){
                        count++;
                        s = s.substring(0, i) + s.substring(i + 1);
                        i -= 2;
                    }
                } else {
                    if (s.charAt(i + 1) == ch - 1 || s.charAt(i - 1) == ch - 1){
                        count++;
                        s = s.substring(0, i) + s.substring(i + 1);
                        i -= 2;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
