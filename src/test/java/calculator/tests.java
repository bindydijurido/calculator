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
	public String MathSymbol1;
	public String MathSymbol2;
	public int DoMathematic;
	public int RandomKey1;
	public int RandomKey2;
	public int KeyDivide;
	public int Operation1;
	public int Operation2;
	public boolean TF;

	@Test
	public void AppLaunch() {

		System.out.println("Starting App Launch test");

		Assert.assertNotNull(driver.getContext());

		System.out.println("Test passed");
	}

	@Test
	public void SimpleAdditionFunctionality() {

		System.out.println("Starting Simple Addition Functionality test");

		driver.findElement(getNumber(1)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(6)).click();
		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();

		DoMathematic = 1 + 6;
		expected = Integer.toString(DoMathematic);

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

		DoMathematic = 94 + 94 + 1 + 51;
		expected = Integer.toString(DoMathematic);

		Assert.assertEquals(result, expected);

		System.out.println("Test passed");
	}

	@Test
	public void RandomlyAdditionFunctionality() {

		int sum = 0;

		do {

			RandomKey1 = ThreadLocalRandom.current().nextInt(0, 10);
			RandomKey2 = ThreadLocalRandom.current().nextInt(0, 10);

			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(RandomKey1)).click();
			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(RandomKey2)).click();

			sum = sum + RandomKey1 + RandomKey2;

			System.out.println(RandomKey1 + " + " + RandomKey2 + " / sum: " + sum + ",");
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

			RandomKey1 = ThreadLocalRandom.current().nextInt(0, 10);
			RandomKey2 = ThreadLocalRandom.current().nextInt(0, 10);
			KeyDivide = ThreadLocalRandom.current().nextInt(1, 10);
			Operation1 = ThreadLocalRandom.current().nextInt(1, 4);
			Operation2 = ThreadLocalRandom.current().nextInt(1, 4);

			switch (Operation1) {

			case 1:
				driver.findElement(getPlus()).click();
				sum = sum + RandomKey1;
				MathSymbol1 = " + ";
				break;

			case 2:
				driver.findElement(getMinus()).click();
				sum = sum - RandomKey1;
				MathSymbol1 = " - ";
				break;

			case 3:
				driver.findElement(getTimes()).click();
				sum = sum * RandomKey1;
				MathSymbol1 = " * ";
				break;
			}

			driver.findElement(getNumber(RandomKey1)).click();

			if (sum > 200 || sum < -100 && TF) {

				driver.findElement(getDivide()).click();
				sum = sum / KeyDivide;
				MathSymbol2 = " / ";
			} else {

				switch (Operation2) {

				case 1:
					driver.findElement(getPlus()).click();
					sum = sum + RandomKey2;
					MathSymbol2 = " + ";
					break;

				case 2:
					driver.findElement(getMinus()).click();
					sum = sum - RandomKey2;
					MathSymbol2 = " - ";
					break;

				case 3:
					driver.findElement(getTimes()).click();
					sum = sum * RandomKey2;
					MathSymbol2 = " * ";
					break;
				}
			}

			driver.findElement(getNumber(RandomKey2)).click();

			i++;

			System.out.println(RandomKey1 + MathSymbol2 + RandomKey2 + MathSymbol1 + " / sum: " + sum + ",");
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