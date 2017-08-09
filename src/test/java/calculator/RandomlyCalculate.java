package calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.methods;

public class RandomlyCalculate extends methods {

	@Test
	public void RandomlyCalculateThings() {

		System.out.println("Starting Randomly Calculate Things test");

		double sum = 0;
		TorF = false;

		for (int i = 0; i < 350; i++) {

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

			CalculatorResult = CalculatorResult.split("\\.")[0];

			CompilatorResult = CompilatorResult.split("\\.")[0];

			Assert.assertEquals(CompilatorResult, CalculatorResult);
		}

		// CalculatorResult = CalculatorResult.split("\\.")[0];
		//
		// CompilatorResult = CompilatorResult.split("\\.")[0];
		//
		// Assert.assertEquals(CompilatorResult, CalculatorResult);

		System.out.println("Test passed");
	}
}
