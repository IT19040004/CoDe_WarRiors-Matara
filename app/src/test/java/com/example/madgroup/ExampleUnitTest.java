package com.example.madgroup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

  private BMIcalculate bmIcalculate;

  @Before
  public void setup(){
    bmIcalculate = new BMIcalculate();

  }

  @Test
  public void testBMIcalculate(){
    float result = bmIcalculate.calcBMI(60.00f,1.600f);
    assertEquals(23.4375f,result,0.0001);
  }
}