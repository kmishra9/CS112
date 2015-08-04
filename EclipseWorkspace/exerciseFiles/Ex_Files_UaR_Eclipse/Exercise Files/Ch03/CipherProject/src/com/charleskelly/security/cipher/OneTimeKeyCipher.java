package com.charleskelly.security.cipher;

import com.charleskelly.key.otp.OneTimeKey;

public class OneTimeKeyCipher
{
	public static final int ENCRYPT_MODE = 1;
	public static final int DECRYPT_MODE = 2;
	
	private int 		mode;
	private OneTimeKey	oneTimeKey;
	////////////////////////////////////////////////////////////////////////////
	private OneTimeKeyCipher ()
	{
		// inhibit instantiation
		// follow convention from Java Cryptographic Extension (JCE) framework
		// use getInstance() method
		
	}// private OneTimeKeyCipher ()
	////////////////////////////////////////////////////////////////////////////
	public static OneTimeKeyCipher getInstance()
	{
		return new OneTimeKeyCipher();
	}// public static OneTimeKeyCipher getInstance()
	////////////////////////////////////////////////////////////////////////////
	public void init (int opMode, OneTimeKey oneTimeKey) throws Exception
	{
		try
		{
			if (null == oneTimeKey)
				throw new Exception ("oneTimeKey parameter is null");
			this.oneTimeKey = oneTimeKey;
			
			switch (opMode)
			{
				case ENCRYPT_MODE :
				{
					this.mode = ENCRYPT_MODE;
					break;
				}// case ENCRYPT_MODE :
				
				case DECRYPT_MODE :
				{
					this.mode = DECRYPT_MODE;
					break;
				}// case DECRYPT_MODE :
				
				default:
				{
					throw new Exception ("invalid opMode: " + opMode);
				}// default:
			}// switch (opMode)
		}// try
		catch (Exception e)
		{
			throw new Exception(e); // trap for debugging
		}// catch (Exception e)
	}// public void init (int opMode, OneTimeKey oneTimeKey) throws Exception
	////////////////////////////////////////////////////////////////////////////
	public byte[] doFinal (byte[] inputBytes) throws Exception
	{
		try
		{
			int messageLength = inputBytes.length;
			byte[] cipherBytes = this.oneTimeKey.getKeyBytes();
			if (messageLength > cipherBytes.length)
				throw new Exception ("message length greater than cipher length");
			
			byte[] outputBytes = new byte[messageLength];
			
			switch (this.mode)
			{
				case ENCRYPT_MODE :
				{
					for (int i=0; i<messageLength; i++)
					{
						outputBytes[i] = (byte) (inputBytes[i] - cipherBytes[i]);
					}// for (int i=0; i<messageLength; i++)
					break;
				}// case ENCRYPT_MODE :
				
				case DECRYPT_MODE :
				{
					for (int i=0; i<messageLength; i++)
					{
						outputBytes[i] = (byte) (inputBytes[i] + cipherBytes[i]);
					}// for (int i=0; i<messageLength; i++)
					break;
				}// case DECRYPT_MODE :
				
				default:
				{
					throw new Exception ("invalid opMode: " + this.mode);
				}// default:
			}// switch (this.mode)
			
			return outputBytes;
		}// try
		catch (Exception e)
		{
			throw new Exception(e); // trap for debugging
		}// catch (Exception e)
	}// public byte[] doFinal (byte[] inputBytes) throws Exception
	////////////////////////////////////////////////////////////////////////////
}// public class OneTimeKeyCipher

