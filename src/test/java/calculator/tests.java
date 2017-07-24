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
	public int RandomNumber1;
	public int RandomNumber2;
	public int DivideValue;
	public int RandomMath1;
	public int RandomMath2;
	public boolean TorF;

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

		System.out.println("Staring Randomly Addition Functionality test");

		int sum = 0;

		do {

			RandomNumber1 = ThreadLocalRandom.current().nextInt(0, 10);
			RandomNumber2 = ThreadLocalRandom.current().nextInt(0, 10);

			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(RandomNumber1)).click();
			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(RandomNumber2)).click();

			sum = sum + RandomNumber1 + RandomNumber2;

			System.out.println(RandomNumber1 + " + " + RandomNumber2 + " / sum: " + sum + ",");
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
		TorF = random.nextBoolean();

		for (i = 0; i < 250; i++) {

			RandomNumber1 = ThreadLocalRandom.current().nextInt(0, 10);
			RandomNumber2 = ThreadLocalRandom.current().nextInt(0, 10);
			DivideValue = ThreadLocalRandom.current().nextInt(1, 10);

			switch (getOperation()) {

			case 1:
				driver.findElement(getPlus()).click();
				sum = sum + RandomNumber1;
				MathSymbol1 = " + ";
				break;

			case 2:
				driver.findElement(getMinus()).click();
				sum = sum - RandomNumber1;
				MathSymbol1 = " - ";
				break;

			case 3:
				driver.findElement(getTimes()).click();
				sum = sum * RandomNumber1;
				MathSymbol1 = " * ";
				break;
			}

			driver.findElement(getNumber(RandomNumber1)).click();

			if (sum > 200 || sum < -100 && TorF) {

				driver.findElement(getDivide()).click();
				sum = sum / DivideValue;
				MathSymbol2 = " / ";
			} else {

				switch (getOperation()) {

				case 1:
					driver.findElement(getPlus()).click();
					sum = sum + RandomNumber2;
					MathSymbol2 = " + ";
					break;

				case 2:
					driver.findElement(getMinus()).click();
					sum = sum - RandomNumber2;
					MathSymbol2 = " - ";
					break;

				case 3:
					driver.findElement(getTimes()).click();
					sum = sum * RandomNumber2;
					MathSymbol2 = " * ";
					break;
				}
			}

			driver.findElement(getNumber(RandomNumber2)).click();

			i++;

			System.out.println(RandomNumber1 + MathSymbol2 + RandomNumber2 + MathSymbol1 + " / sum: " + sum + ",");
		}

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