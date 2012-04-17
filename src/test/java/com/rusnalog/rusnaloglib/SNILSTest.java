package com.rusnalog.rusnaloglib;

import static org.junit.Assert.*;

import org.junit.Test;

import com.rusnalog.rusnaloglib.SNILS;


public class SNILSTest {

	@Test
	public void testCheckValid() {
		// TODO: Найти правильные INN
		SNILS tsnils1 = new SNILS( "768-456-123 02" );
		assertTrue( SNILS.checkValid(tsnils1) );
		
		SNILS tsnils2 = new SNILS( "268-416-123 01" );
		assertTrue( SNILS.checkValid(tsnils2) );
	}

	@Test
	public void testGenerate() {
		String snils_string = SNILS.Generate();
		assertTrue( SNILS.IsValidSNILSString(snils_string) );
	}

	@Test
	public void testComputeControlNumber() {
		assertEquals( SNILS.ComputeControlNumber( 547436786 ), 2 );
	}

	@Test
	public void testIsValidSNILSString() {
		String snils_string = "268-416-123 01";
		assertTrue( SNILS.IsValidSNILSString(snils_string) );
	}

}
