import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static String caesarCipher(String s, int k) {
        final int ALPHABET_SIZE = 26;
        
        int n = s.length();
        StringBuilder result = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            char encryptedCh = ch;
            if (Character.isUpperCase(ch)) {
                encryptedCh = (char)('A' + (ch - 'A' + k) % ALPHABET_SIZE);
            }            
            if (Character.isLowerCase(ch)) {
                encryptedCh = (char)('a' + (ch - 'a' + k) % ALPHABET_SIZE);
            }
            result.append(encryptedCh);
        }
        
        return result.toString();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
