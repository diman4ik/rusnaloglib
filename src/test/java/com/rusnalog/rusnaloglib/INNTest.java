package com.rusnalog.rusnaloglib;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rusnalog.rusnaloglib.INN;


public class INNTest {

	@Test
	public void testCheckValid() {
		INN inn2 = new INN("7841304521");
		assertTrue( INN.checkValid( inn2 ) );
		
		INN inn3 = new INN("742203501226");
		assertTrue( INN.checkValid( inn3 ) );
		
		INN inn4 = new INN("7707083893");
		assertTrue( INN.checkValid( inn4 ) );
	}
	
	@Test
	public void testIsValidINNStr() {
		String inn = "7707083893";
		assertTrue( INN.isValidInnStr( inn ) );
	}
	
	@Test
	public void testGenerateFIS() {
		String region_id = "21";
		String inspec_id = "14";
		String result = INN.generateFis( region_id, inspec_id );
		
		assertTrue( INN.isValidInnStr( result ) );
	}
	
	@Test
	public void testGenerateUrid() {
		String region_id = "21";
		String inspec_id = "15";
		String result = INN.generateUrid( region_id, inspec_id );
		
		assertTrue( INN.isValidInnStr( result ) );
	}

	@Test
	public void test10Digit() {
		String inn = "7707083893";
		assertEquals( INN.compute10Digit( inn ), 3 );
	}

	@Test
	public void test11Digit() {
		String inn = "742203501226";
		assertEquals( INN.compute11Digit( inn ), 2 );
	}

	@Test
	public void test12Digit() {
		String inn = "742203501226";
		assertEquals( INN.compute12Digit( inn ), 6 );
	}
}
