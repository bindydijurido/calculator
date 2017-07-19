package calculator;

import java.util.concurrent.ThreadLocalRandom;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.methods;

public class tests extends methods {

	public String result;
	public String expected;
	public String sumS;
	public int math;
	public int n;
	public int n1;

	@Test
	public void AppLaunch() {

		Assert.assertNotNull(driver.getContext());
	}

	@Test
	public void SimpleAdditionFunctionality() {

		driver.findElement(getNumber(1)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(6)).click();
		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();

		math = 1 + 6;
		expected = Integer.toString(math);

		Assert.assertEquals(result, expected);
	}

	@Test
	public void AdvancedAdditionFunctionality() {

		driver.findElement(getNumber(9)).click(); driver.findElement(getNumber(4)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(9)).click(); driver.findElement(getNumber(4)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(1)).click();
		driver.findElement(getPlus()).click();
		driver.findElement(getNumber(5)).click(); driver.findElement(getNumber(1)).click();
		driver.findElement(getEqual()).click();

		result = driver.findElement(getResult()).getText().toString();

		math = 94 + 94 + 1 + 51;
		expected = Integer.toString(math);

		Assert.assertEquals(result, expected);
	}
	
	@Test
	public void RandomlyAdditionFunctionality() {

		int sum = 0;

		do {

			n = ThreadLocalRandom.current().nextInt(0, 9);
			n1 = ThreadLocalRandom.current().nextInt(0, 9);

			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(n)).click();
			driver.findElement(getPlus()).click();
			driver.findElement(getNumber(n1)).click();

			sum = sum + n + n1;

			System.out.print(sum + " + ");
		}

		while (sum <= 100);
		
		System.out.print("= " + sum);

		driver.findElement(getEqual()).click();
		
		result = driver.findElement(getResult()).getText().toString();
		sumS = Integer.toString(sum);

		Assert.assertEquals(sumS, result);
	}
}