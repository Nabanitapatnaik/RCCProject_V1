package com.RCC.TestData;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTestCase extends BaseClass{
  @Test
  public void test1() {
	  Assert.assertEquals("True", "True");
  }
  @Test
  public void test2() {
	  Assert.assertEquals("True", "False");
  }
  
}
