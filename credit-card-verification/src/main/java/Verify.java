import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Verify {
	public static void main(String[] args) {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Please enter a credit card number: ");
			String input = scanner.nextLine();
			if (input.equalsIgnoreCase("exit")) break;
			String[] split = input.split("");
			List<Integer> nums = new ArrayList<Integer>(input.length());
			for (String s : split) nums.add(Integer.parseInt(s));
			
			int last = nums.remove(nums.size() - 1);
			Collections.reverse(nums);
			int sum = 0;
			for (int i = 0; i < nums.size(); i++) {
				if (i % 2 == 1) {
					int doubled = nums.get(i) * 2;
					if (doubled >= 10) {
						int ones = doubled % 10;
						int tens = doubled / 10;
						nums.set(i, ones + tens);
					} else nums.set(i, doubled);
				}
				
				sum += nums.get(i);
			}
			
			int lastOfSum = 10 - (sum % 10);
			System.out.println(lastOfSum == last);
		}
	}
}
