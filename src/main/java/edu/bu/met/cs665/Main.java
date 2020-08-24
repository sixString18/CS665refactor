
/* Refactor the following code and apply one design pattern to it.

Or in the following:*/

/**I have refactored the code by removing the duplicate code and elevating all 
 * but the doFinalCal method to the parent class.  In essence, the duplicate code is "extracted"
 * and pulled-up into a parent class.  In essense, this is a template.
 */

package edu.bu.met.cs665;

import java.util.ArrayList;
import java.util.List;

// Some not so nice implementation of L1 and L2 norms.   
public class Main {

  public static void main(String[] args) {

    List<Double> data = new ArrayList<Double>();

    // generate some example data to test.
    for (int i = 0; i < 10; i++) {
      data.add(new Double(-2.0));
    }

    // Create different calculators
    L1Norm l1Calulator = new L1Norm();
    L2Norm l2Calulator = new L2Norm();

    System.out.println("Data is: " + data);
    System.out.println("L1 Norm is: " + l1Calulator.doCal(data));
    System.out.println("L2 Norm is: " + l2Calulator.doCal(data));

  }

}

/**
 * Abstract superclass
 */

abstract class LNorm {
  public double doCal(List<Double> a) {
    double tmp = 0;
    // Step-1:
    // First we calculate the abs values
    List<Double> tmpList = doVectorCal(a);
    // Step-2:
    // We sum them up.
    tmp = sum(tmpList);
    // Step-3:
    // Last we compute the power 1 of it
    tmp = doFinalCal(tmp);
    return tmp;
  }

  /**
   * This method calculates the sum.
   * 
   * @param a list of values
   * @return a single number
   */
  public double sum(List<Double> a) {
    // calculate the sum of them
    float sum = 0;
    for (int i = 0; i < a.size(); i++) {
      sum += a.get(0);
    }
    return sum;
  }

  /**
   * This method calculates absolute value.
   * 
   * @param a list of values
   * @return a list of absolute values
   */
  public List<Double> doVectorCal(List<Double> a) {
    // calculate the sum of them
    List<Double> tmp = new ArrayList<Double>();
    for (int i = 0; i < a.size(); i++) {
      tmp.add(Math.abs(a.get(0)));
    }
    return tmp;
  }

  /**
   * This method does nothing.
   * 
   * @param a
   * @return
   */
  abstract public double doFinalCal(double a);
}

/************************************* L1Norm */

class L1Norm extends LNorm {

  /**
   * This method does nothing.
   * 
   * @param a
   * @return
   */
  public double doFinalCal(double a) {
    // Do nothing
    return a;
  }
}

/*********************************************** L2Norm */
////////////////////////////////////////////
///////////////////////////////////////////

/**
 * 
 * A class to calculate L2 Norm.
 */

class L2Norm extends LNorm {

  /**
   * This method Calculates the sqrt value.
   * 
   * @param a double
   * @return a double
   */
  public double doFinalCal(double a) {
    // calculate the sqrt
    return Math.sqrt(a);
  }
}
