package calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.methods;

public class SimpleAdditionTest extends methods {

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

		CalculatorResult = getResultToString();

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
}