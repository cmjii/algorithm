import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String str[] = new String[a.length()];
		for (int i = 0; i < a.length(); i++) {
			str[i] = String.valueOf(a.charAt(i));
			if (str[i].equals(str[i].toLowerCase())) {
				str[i] = str[i].toUpperCase();
			} else if (str[i].equals(str[i].toUpperCase())) {
				str[i] = str[i].toLowerCase();
			}
		}
		String answer = "";
		for(int i =0; i<str.length; i++) {
			answer += str[i];
		}
		System.out.println(answer);
	}
}

