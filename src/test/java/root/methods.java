package root;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;

public class methods extends root {

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

	protected static String NUMBER = "info.woodsmall.calculator:id/btn%s";
	protected static String PERIOD = "info.woodsmall.calculator:id/btnPeriod";
	protected static String EQUAL = "info.woodsmall.calculator:id/btnEqual";
	protected static String PLUS = "info.woodsmall.calculator:id/btnPlus";
	protected static String MINUS = "info.woodsmall.calculator:id/btnMinus";
	protected static String TIMES = "info.woodsmall.calculator:id/btnTimes";
	protected static String DIVIDE = "info.woodsmall.calculator:id/btnDivide";
	protected static String RESULT = "info.woodsmall.calculator:id/txtVal";

	public static By getNumber(int element) {
		return (By) By.id(String.format(NUMBER, Integer.toString(element)));
	}

	public static By getPeriod() {
		return (By) By.id(PERIOD);
	}

	public static By getEqual() {
		return (By) By.id(EQUAL);
	}

	public static By getPlus() {
		return (By) By.id(PLUS);
	}

	public static By getMinus() {
		return (By) By.id(MINUS);
	}

	public static By getTimes() {
		return (By) By.id(TIMES);
	}

	public static By getDivide() {
		return (By) By.id(DIVIDE);
	}

	public static By getResult() {
		return (By) By.id(RESULT);
	}

	public static String getResultToString() {
		return driver.findElement(getResult()).getText().toString();
	}

	public static int getRandomNumber(int element, int element1) {
		return ThreadLocalRandom.current().nextInt(element, element1);
	}
}
