package calculator;

import org.testng.annotations.Test;
import org.testng.Assert;

import root.root;

public class tests extends root {

	@Test
	public void AppLaunch() {

		Assert.assertNotNull(driver.getContext());

	}
}