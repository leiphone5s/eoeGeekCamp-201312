package se1.day04;

import java.util.HashMap;
import java.util.Set;

public class Test02 {
	public static void main(String[] args) {
		String text = "father and mother,we are family.";
		text += "grand father and grand mother we are family";
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			Integer count = counts.get(c);
			count = count == null ? 1 : count + 1;
			counts.put(c, count);

		}
		System.out.println("字符\t出现次数\t百分比");
		Set<Character> keys = counts.keySet();
		for (Character key : keys) {
			int value = counts.get(key);
			double percent = 1.0 * value * 100 / text.length();
			System.out.println(key + "\t" + counts.get(key) + "\t"
					+ pround(percent, 2));
		}
	}

	static double pround(double value, int index) {
		double pow10 = Math.pow(10, index);
		double result = value * pow10;
		result = Math.round(result);
		result = result * 1.0 / pow10;
		return result;
	}
}
