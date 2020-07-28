import java.time.LocalTime;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class WPM {
	
	static String[] WORDS = {"quick", "brown", "fox", "jumped", "over", "the", "lazy",
			"dog", "envelope", "quack", "arizona", "chameleon"};
	
	static String[] input = new String[10];

	public static void main(String[] args) throws InterruptedException {
				
		System.out.println("3");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("2");
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("1");
		TimeUnit.SECONDS.sleep(1);
		
		Random rand = new Random();
		
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i<10; i++) {
			input[i] = (WORDS[rand.nextInt(9)]);
		}
		for (String value : input) {
			builder.append(value + " ");
		}
		String inputString = builder.toString();
		System.out.print(inputString);
		System.out.println();
		
		double start = LocalTime.now().toNanoOfDay();
		
		try (Scanner scan = new Scanner(System.in)) {
			String typedWords = scan.nextLine();
			
			String[] inputarr = typedWords.split("\\W+");
			
			
			double end = LocalTime.now().toNanoOfDay();
			double elapsedTime = end - start;
			double seconds = elapsedTime/ 1000000000.0;
			int numChars = typedWords.length();
			int wpm = (int) (((((double) numChars / 5) / seconds) * 60) - CheckWords(input, inputarr));
			
			System.out.println("Your wpm is " + wpm + "!");
		}
	}
	
	public static int CheckWords(String[] TestWords, String[] UserWords){
		int errors = 0;
		for(int i = 0; i<TestWords.length; i++) {
			if (TestWords[i] != UserWords[i]){
				errors++;
			}
		}
		System.out.println("You had " + errors + " errors");
		System.out.println("You entered " + Arrays.toString(UserWords));
		System.out.println("The practice words were " + Arrays.toString(TestWords));
		return errors;
	}


}
