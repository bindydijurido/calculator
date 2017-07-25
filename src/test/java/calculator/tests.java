package calculator;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.methods;

public class tests extends methods {

	Random random = new Random();

	public String CalculatorResult;
	public String CompilatorResult;
	public String MathSymbol1;
	public String MathSymbol2;
	public int DoMathematic;
	public int RandomNumber1;
	public int RandomNumber2;
	public int RandomDivideNumber;
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

		CalculatorResult = driver.findElement(getResult()).getText().toString();

		DoMathematic = 1 + 6;
		CompilatorResult = Integer.toString(DoMathematic);

		Assert.assertEquals(CalculatorResult, CompilatorResult);

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

		CalculatorResult = getResultToString();

		DoMathematic = 94 + 94 + 1 + 51;
		CompilatorResult = Integer.toString(DoMathematic);

		Assert.assertEquals(CalculatorResult, CompilatorResult);

		System.out.println("Test passed");
	}

	@Test
	public void RandomlyAdditionFunctionality() {

		System.out.println("Staring Randomly Addition Functionality test");

		int sum = 0;

		do {

			RandomNumber1 = getRandomNumber(0, 10);
			RandomNumber2 = getRandomNumber(0, 10);

			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(RandomNumber1)).click();
			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(RandomNumber2)).click();

			sum = sum + RandomNumber1 + RandomNumber2;

			System.out.println(RandomNumber1 + " + " + RandomNumber2 + " / sum: " + sum + ",");
		} while (sum <= 250);

		System.out.println("sum: " + sum);

		driver.findElement(getEqual()).click();

		CalculatorResult = getResultToString();
		CompilatorResult = String.valueOf(sum);

		Assert.assertEquals(CompilatorResult, CalculatorResult);

		System.out.println("Test passed");
	}

	@Test
	public void RandomlyCalculateThings() {

		System.out.println("Starting Randomly Calculate Things test");

		double sum = 0;
		TorF = false;

		for (int i = 0; i < 35; i++) {

			RandomNumber1 = getRandomNumber(0, 10);
			RandomNumber2 = getRandomNumber(0, 10);
			RandomDivideNumber = getRandomNumber(1, 10);

			switch (getRandomNumber(1, 4)) {

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

			driver.findElement(getEqual()).click();

			if (sum > 26 || sum < -26) {

				driver.findElement(getDivide()).click();
				sum = sum / RandomDivideNumber;
				MathSymbol2 = " / ";

				driver.findElement(getNumber(RandomDivideNumber)).click();
			} else {

				switch (getRandomNumber(1, 4)) {

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

				driver.findElement(getNumber(RandomNumber2)).click();
			}

			CompilatorResult = String.valueOf(sum);

			driver.findElement(getEqual()).click();

			CalculatorResult = getResultToString();

			if (TorF == false) {

				System.out.println("#" + i + " / 0" + MathSymbol1 + RandomNumber1 + MathSymbol2 + RandomNumber2
						+ " / compilator: " + CompilatorResult + " / calculator: " + CalculatorResult);

				TorF = true;

			} else {

				System.out.println("#" + i + " /" + MathSymbol1 + RandomNumber1 + MathSymbol2 + RandomNumber2
						+ " / compilator: " + CompilatorResult + " / calculator: " + CalculatorResult);
			}
		}

		CalculatorResult = CalculatorResult.split("\\.")[0];

		CompilatorResult = CompilatorResult.split("\\.")[0];

		Assert.assertEquals(CompilatorResult, CalculatorResult);

		System.out.println("Test passed");
	}
}
