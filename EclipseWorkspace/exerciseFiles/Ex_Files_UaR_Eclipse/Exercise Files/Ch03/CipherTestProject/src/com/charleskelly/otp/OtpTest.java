package com.charleskelly.otp;

import static org.junit.Assert.*;s
import org.junit.Test;

public class OtpTest
{

	private static final String TEST_MESSAGE = "The quick red fox";
	
	private static int keyLength = 64;
	/**
	 * This key contains the sequence 0,1,2,3...
	 */
	private static byte[] sillyKey = new byte[keyLength];
	////////////////////////////////////////////////////////////////////////////
	@Test
	public void testPad()
	{
		try
		{
			for (byte i = 0; i<keyLength; i ++)
				sillyKey[i] = i;
			
			byte[] messageBytes = TEST_MESSAGE.getBytes();
			int messageBytesLength = messageBytes.length;
			byte[] encryptedBytes = new byte[messageBytesLength];
			
			for (byte i = 0; i<messageBytesLength; i ++)
				encryptedBytes[i] = (byte) (messageBytes[i] - sillyKey[i]);
			
			byte[] decryptedBytes = new byte[messageBytesLength];
			for (byte i = 0; i<messageBytesLength; i ++)
				decryptedBytes[i] = (byte) (encryptedBytes[i] + sillyKey[i]);
			
			String decryptedString = new String (decryptedBytes);
//			System.out.println (decryptedString);
			boolean equalStringFlag = decryptedString.equals(TEST_MESSAGE);
			assertTrue (equalStringFlag);
		}// try
		catch (Exception e)
		{
			fail("Exception encountered during test: " + e.toString() );
		}// catch (Exception e)
	}// public void testPad()
	////////////////////////////////////////////////////////////////////////////

    
}// public class OtpTest
