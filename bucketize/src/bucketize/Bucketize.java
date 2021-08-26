package bucketize;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bucketize {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter the phrase that you want bucketized:");
		String phrase = scanner.nextLine();
		
		System.out.println("\nPlease enter the size of the buckets:");
		int size = scanner.nextInt();
		
		scanner.close();
		
		List<String> bucketized = bucketize(phrase, size);
		System.out.println("Your bucketed phrase is:");
		bucketized.forEach(s -> System.out.println(s));
	}
	
	public static List<String> bucketize(String input, int bucketSize) {
		input = input.strip();
		String[] splitInput = input.split(" ");
		List<String> buckets = new ArrayList<String>();
		for (int i = 0, bucketIdx = 0; i < splitInput.length; i++) {
			if (splitInput[i].length() > bucketSize) {
				buckets.add("");
			} else if (i == 0) {
				buckets.add(splitInput[i]);
			} else {
				if (buckets.get(bucketIdx).length() != 0 && ((buckets.get(bucketIdx).length() + 1 + splitInput[i].length()) <= bucketSize)) {
					buckets.set(bucketIdx, buckets.get(bucketIdx) + " " + splitInput[i]);
				} else {
					buckets.add(splitInput[i]);
					bucketIdx++;
				}
			}
		}
		return buckets;
	}
}
