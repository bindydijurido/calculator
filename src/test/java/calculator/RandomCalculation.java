package calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import methods.Methods;

public class RandomCalculation extends Methods {

	public static int SUM = 0;

	@Test
	public void randomCalculate() {

		log("I am starting randomly 'Calculate Things'");
		for (int mathAction = 0; mathAction < 10; mathAction++) {
			int firstNr = getRandomNr(0, 10);
			int secondNr = getRandomNr(0, 10);
			int divideNr = getRandomNr(1, 10);

			switch (getRandomNr(1, 4)) {
			case 1:
				actions.Math.doSomeMath(firstNr, "plus", getPlus());
				break;

			case 2:
				actions.Math.doSomeMath(firstNr, "minus", getMinus());
				break;

			case 3:
				actions.Math.doSomeMath(firstNr, "times", getTimes());
				break;
			}

			let(getNumber(firstNr)).click();
			let(getEqual()).click();

			if (SUM > 26 || SUM < -26) {
				actions.Math.doSomeMath(divideNr, "divide", getDivide());
				let(getNumber(divideNr)).click();
			} else {
				switch (getRandomNr(1, 4)) {
				case 1:
					actions.Math.doSomeMath(secondNr, "plus", getPlus());
					break;

				case 2:
					actions.Math.doSomeMath(secondNr, "minus", getMinus());
					break;

				case 3:
					actions.Math.doSomeMath(secondNr, "times", getTimes());
					break;
				}

				let(getNumber(secondNr)).click();
			}

			String compilatorResult = getParseSum(SUM);
			let(getEqual()).click();
			String calculatorResult = getParseResult();

			log("#" + mathAction + " // compilator: " + compilatorResult
					+ " / calculator: " + calculatorResult);

			Assert.assertEquals(compilatorResult.split("\\.")[0], calculatorResult.split("\\.")[0]);
		}
		log("Test passed");
	}
}
