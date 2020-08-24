package edu.bu.met.cs665;

import static org.junit.Assert.*;

import org.junit.Test;

// TestBeverageMaker.java

/**
 * This program is the JUnit test class
 * 
 * @author Ray Clark
 * @course MET CS 665
 * @date 8-17-20
 * 
 */

public class TestBeverageMaker {

  @Test
  public void testCreateCoffeeDrink() {
    
    // test for an Americano coffee drink & related values - using factory
    try {
      Beverage b = BeverageFactory.makeBeverage("Americano");
      assertEquals(b.makeDrink(), "We made a hot Americano drink!");

      // test to check for price of an Americano
      assertTrue(b.getPrice() == 4.00);

      // add condiments and compute total price 
      b.addCondiment(CondimentFactory.makeCondiment("Milk", 1));
      b.addCondiment(CondimentFactory.makeCondiment("Sugar", 2));
      assertTrue(b.computePrice() == 6.00);
    } catch (Exception e) {
      fail("Unexpected Exception");
    }
  }
  
  @Test
  public void testCreateTeaDrink() {
  
    // test for a Black Tea drink and related values - using factory
    try {
      Beverage b = BeverageFactory.makeBeverage("Black Tea");
      assertEquals(b.makeDrink(), "We made a hot Black Tea drink!");

      // test to check for price of an Americano
      assertTrue(b.getPrice() == 2.75);

      // add condiments and compute total price 
      b.addCondiment(CondimentFactory.makeCondiment("Milk", 2));
      b.addCondiment(CondimentFactory.makeCondiment("Sugar", 1));
      assertTrue(b.computePrice() == 5.25);
    } catch (Exception e) {
      fail("Unexpected Exception");
    }
  }

  @Test
  public void testCondimentPrices() {
    try {
      // test of price of 1 condiment
      Condiment c1 = CondimentFactory.makeCondiment("Milk", 1);
      assertTrue(c1.getPrice() == 1.00);

      // test of total price of 2 condiment units
      Condiment c2 = CondimentFactory.makeCondiment("Sugar", 2);
      assertTrue(c2.getPrice() == 1.00);

    } catch (Exception e) {
      fail("Unexpected Exception");
    }
  }

  // to test the max units exception
  @Test
  public void testCondimentUnitsException() {
    try {
      Condiment c = CondimentFactory.makeCondiment("Sugar", 4);
      fail("Expected Exception!");
    } catch (Exception e) {
      assertTrue(true);
    }
  }
} //end of TestBeverageMaker class


