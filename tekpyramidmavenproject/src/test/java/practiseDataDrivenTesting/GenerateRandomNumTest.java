package practiseDataDrivenTesting;

import java.util.Random;

public class GenerateRandomNumTest {

	public static void main(String[] args) {
		Random rnd = new Random();
		int random=rnd.nextInt(1000);
		System.out.println(random);

	}

}
