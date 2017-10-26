package calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.Methods;

public class RandomCalculation extends Methods {

	public String firstSymbol;
	public String secondSymbol;

	@Test
	public void randomCalculate() {

		double sum = 0;
		log("I am starting randomly 'Calculate Things'");
		for (int mathAction = 0; mathAction < 350; mathAction++) {
			int firstNr = getRandomNr(0, 10);
			int secondNr = getRandomNr(0, 10);
			int divideNr = getRandomNr(1, 10);

			switch (getRandomNr(1, 4)) {
			case 1:
				driver.findElement(getPlus()).click();
				sum = sum + firstNr;
				firstSymbol = " + ";
				break;

			case 2:
				driver.findElement(getMinus()).click();
				sum = sum - firstNr;
				firstSymbol = " - ";
				break;

			case 3:
				driver.findElement(getTimes()).click();
				sum = sum * firstNr;
				firstSymbol = " * ";
				break;
			}

			driver.findElement(getNumber(firstNr)).click();
			driver.findElement(getEqual()).click();

			if (sum > 26 || sum < -26) {
				driver.findElement(getDivide()).click();
				sum = sum / divideNr;
				secondSymbol = " / ";
				driver.findElement(getNumber(divideNr)).click();
			} else {
				switch (getRandomNr(1, 4)) {
				case 1:
					driver.findElement(getPlus()).click();
					sum = sum + secondNr;
					secondSymbol = " + ";
					break;

				case 2:
					driver.findElement(getMinus()).click();
					sum = sum - secondNr;
					secondSymbol = " - ";
					break;

				case 3:
					driver.findElement(getTimes()).click();
					sum = sum * secondNr;
					secondSymbol = " * ";
					break;
				}

				driver.findElement(getNumber(secondNr)).click();
			}

			String compilatorResult = String.valueOf(sum);
			driver.findElement(getEqual()).click();
			String calculatorResult = getResultToString();

			boolean sOUT = false;
			if (sOUT == false) {
				log("#" + mathAction + " / 0" + firstSymbol + firstNr + secondSymbol + secondNr +
						" / compilator: " + compilatorResult + " / calculator: " + calculatorResult);

				sOUT = true;
			} else {
				log("#" + mathAction + " /" + firstSymbol + firstNr + secondSymbol + secondNr +
						" / compilator: " + compilatorResult + " / calculator: " + calculatorResult);
			}

			Assert.assertEquals(compilatorResult.split("\\.")[0], calculatorResult.split("\\.")[0]);
		}
		log("Test passed");
	}
}
