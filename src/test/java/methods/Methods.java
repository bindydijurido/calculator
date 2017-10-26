package methods;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.Root;

public class Methods extends Root {
	
	public static final WebElement let(By locator) {
		WebElement Element = Root.driver.findElement(locator);
		return Element;
	}

	public static By getNumber(int element) {
		return (By) By.id(String.format("info.woodsmall.calculator:id/btn%s", Integer.toString(element)));
	}

	public static By getPeriod() {
		return (By) By.id("info.woodsmall.calculator:id/btnPeriod");
	}

	public static By getEqual() {
		return (By) By.id("info.woodsmall.calculator:id/btnEqual");
	}

	public static By getPlus() {
		return (By) By.id("info.woodsmall.calculator:id/btnPlus");
	}

	public static By getMinus() {
		return (By) By.id("info.woodsmall.calculator:id/btnMinus");
	}

	public static By getTimes() {
		return (By) By.id("info.woodsmall.calculator:id/btnTimes");
	}

	public static By getDivide() {
		return (By) By.id("info.woodsmall.calculator:id/btnDivide");
	}

	public static By getResult() {
		return (By) By.id("info.woodsmall.calculator:id/txtVal");
	}

	public static String getParseResult() {
		return (let(getResult()).getText().toString());
	}
	
	public static String getParseSum(double sum) {
		return (String.valueOf(sum));
	}

	public static int getRandomNr(int element, int element1) {
		return ThreadLocalRandom.current().nextInt(element, element1);
	}

	public void log(String element) {
		System.out.println(element);
	}
}