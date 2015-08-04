/**
 * Copyright (c) 2005 - 2012, Charles Kelly; All rights reserved
*/
package com.charleskelly.security.randomsource;

import java.io.File;
import java.io.FileInputStream;
import java.security.SecureRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * A single source for acquiring a random number generator.  
 * 
 * @author Charlie Kelly
 */
@SuppressWarnings("resource")
public class SecureRandomSource
{
	static Logger logger = LoggerFactory.getLogger(SecureRandomSource.class);
		////////////////////////////////////////////////////////////////////////
	private static SecureRandom secureRandom = new SecureRandom ();    
    static
    { 
        try
        {
            if (new File ("/dev/urandom").exists ()) // Does device micro random exist.
            {            
                byte[] salt = new byte[8192]; // salt.
                new FileInputStream ("/dev/urandom").read (salt); // Read salt.
                secureRandom.setSeed (salt); // Set salt.
            }// if (new File ("/dev/urandom").exists ()) 
        }// try
        catch (Exception e)
        {
        	logger.error(e.toString() );
        }// catch (Exception e)
    }// private static SecureRandom secureRandom = new SecureRandom (); 
    ////////////////////////////////////////////////////////////////////////////
    private SecureRandomSource() 
    {
    	// inhibit instantiation
    }// private SecureRandomSource() 
    ////////////////////////////////////////////////////////////////////////////
    /**
     * This version returns same <code>SecureRandom</code> to all requestors;
     * future version(s) might use different strategy
     */
    public static SecureRandom getSecureRandom()
	{
    	return secureRandom;
    }// public SecureRandom getSecureRandom()
    ////////////////////////////////////////////////////////////////////////////
}// public class SecureRandomSource
