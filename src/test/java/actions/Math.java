package actions;

import org.openqa.selenium.By;

import calculator.RandomCalculation;
import methods.Methods;

public class Math extends Methods {

	public static void doSomeMath(int number, String math, By method) {

		let(method).click();

		if (math == "plus") {
			RandomCalculation.SUM = RandomCalculation.SUM + number;
		}
		if (math == "minus") {
			RandomCalculation.SUM = RandomCalculation.SUM - number;
		}
		if (math == "times") {
			RandomCalculation.SUM = RandomCalculation.SUM * number;
		}
		if (math == "divide") {
			RandomCalculation.SUM = RandomCalculation.SUM / number;
		}
	}
}