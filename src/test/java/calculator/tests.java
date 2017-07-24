package calculator;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.methods;

public class tests extends methods {

	Random random = new Random();

	public String result;
	public String expected;
	public String sumS;
	public String math1;
	public String math2;
	public int math;
	public int Key1;
	public int Key2;
	public int KeyDivide;
	public int Operation1;
	public int Operation2;
	public boolean TF;

	@Test
	public void AppLaunch() {

		Assert.assertNotNull(driver.getContext());
	}

	@Test
	public void SimpleAdditionFunctionality() {

		System.out.println("Starting Simple Addition Functionality test");

		driver.findElement(getNumber(1)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(6)).click();
		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();

		math = 1 + 6;
		expected = Integer.toString(math);

		Assert.assertEquals(result, expected);

		System.out.println("Test passed");
	}

	@Test
	public void AdvancedAdditionFunctionality() {

		System.out.println("Starting Advanced Addition Functionality test");

		driver.findElement(getNumber(9)).click();
		driver.findElement(getNumber(4)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(9)).click();
		driver.findElement(getNumber(4)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(1)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(5)).click();
		driver.findElement(getNumber(1)).click();
		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();

		math = 94 + 94 + 1 + 51;
		expected = Integer.toString(math);

		Assert.assertEquals(result, expected);

		System.out.println("Test passed");
	}

	@Test
	public void RandomlyAdditionFunctionality() {

		int sum = 0;

		do {

			Key1 = ThreadLocalRandom.current().nextInt(0, 10);
			Key2 = ThreadLocalRandom.current().nextInt(0, 10);

			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(Key1)).click();
			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(Key2)).click();

			sum = sum + Key1 + Key2;

			System.out.println(Key1 + " + " + Key2 + " / sum: " + sum + ",");
		}

		while (sum <= 500);

		System.out.println("sum: " + sum);

		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();
		sumS = Integer.toString(sum);

		Assert.assertEquals(sumS, result);

		System.out.println("Test passed");
	}

	@Test
	public void RandomlyCalculateThings() {

		System.out.println("Starting Randomly Calculate Things test");

		int i = 0;
		double sum = 0;
		TF = random.nextBoolean();

		do {

			Key1 = ThreadLocalRandom.current().nextInt(0, 10);
			Key2 = ThreadLocalRandom.current().nextInt(0, 10);
			KeyDivide = ThreadLocalRandom.current().nextInt(1, 10);
			Operation1 = ThreadLocalRandom.current().nextInt(1, 4);
			Operation2 = ThreadLocalRandom.current().nextInt(1, 4);

			switch (Operation1) {

			case 1:
				driver.findElement(getPlus()).click();
				sum = sum + Key1;
				math1 = " + ";
				break;

			case 2:
				driver.findElement(getMinus()).click();
				sum = sum - Key1;
				math1 = " - ";
				break;

			case 3:
				driver.findElement(getTimes()).click();
				sum = sum * Key1;
				math1 = " * ";
				break;
			}

			driver.findElement(getNumber(Key1)).click();

			if (sum > 200 || sum < -100 && TF) {

				driver.findElement(getDivide()).click();
				sum = sum / KeyDivide;
				math2 = " / ";
			} else {

				switch (Operation2) {

				case 1:
					driver.findElement(getPlus()).click();
					sum = sum + Key2;
					math2 = " + ";
					break;

				case 2:
					driver.findElement(getMinus()).click();
					sum = sum - Key2;
					math2 = " - ";
					break;

				case 3:
					driver.findElement(getTimes()).click();
					sum = sum * Key2;
					math2 = " * ";
					break;
				}
			}

			driver.findElement(getNumber(Key2)).click();

			i++;

			System.out.println(Key1 + math2 + Key2 + math1 + " / sum: " + sum + ",");
		}

		while (i <= 250);

		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();
		result = result.split("\\.")[0];

		System.out.print("result from calculator: " + result);

		sumS = String.valueOf(sum);
		sumS = result.split("\\.")[0];

		System.out.println(", result from compilator: " + sumS);

		Assert.assertEquals(sumS, result);

		System.out.println("Test passed");
	}
}