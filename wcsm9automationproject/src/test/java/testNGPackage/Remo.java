package testNGPackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Remo {
  @Test
  public void method1() {
	//  System.out.println("method2 from Remo class");
	  Reporter.log("method1 from Remo class", true);
	
  }
  @Test
  public void method2()
  {
	  Reporter.log("method2 from Remo class", true); 
  }
}
