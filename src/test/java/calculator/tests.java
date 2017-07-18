package calculator;

import org.testng.Assert;
import org.testng.annotations.Test;

import root.methods;

public class tests extends methods {

	public String result;
	public String expected;
	public int math;

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
}