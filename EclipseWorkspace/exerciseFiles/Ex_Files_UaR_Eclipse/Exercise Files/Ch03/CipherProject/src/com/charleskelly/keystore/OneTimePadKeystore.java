package com.charleskelly.keystore;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.charleskelly.holder.KeyHolder;
import com.charleskelly.key.otp.OneTimeKey;

@XmlRootElement
public class OneTimePadKeystore
{
	@XmlElement
	private List <KeyHolder> keyHolderList;
	@XmlElement
	private int		numberOfKeys;
	@XmlElement
	private int		keySize;
	@XmlElement
	private int		nextSequentialKey;
	////////////////////////////////////////////////////////////////////////////
	private OneTimePadKeystore()
	{
		// used for JAXB persistence
	}// private OneTimePadKeystore()
		////////////////////////////////////////////////////////////////////////
	public OneTimePadKeystore (int numberOfKeys, int keySize)
	{
		
		this.numberOfKeys = numberOfKeys;
		
		this.keySize = keySize;
		
		keyHolderList = new ArrayList<KeyHolder>(numberOfKeys);
		
		for (int i=0; i<keySize; i++)
		{
			KeyHolder keyHolder = new KeyHolder();
			keyHolder.setIndex(i);
			OneTimeKey oneTimeKey = new OneTimeKey(this.keySize);
			keyHolder.setOneTimeKey(oneTimeKey);
			this.keyHolderList.add(keyHolder);
		}// for (int i=0; i<keySize; i++)
	}// public OneTimePadKeystore (int numberOfKeys, int keySize)
	////////////////////////////////////////////////////////////////////////////
	public KeyHolder getNextKeyInSequence() throws Exception
	{
		KeyHolder keyHolder = null;
		try
		{
			if (this.nextSequentialKey >= this.keyHolderList.size())
				throw new Exception ("no more keys available in this pad");
			
			keyHolder = this.keyHolderList.get(nextSequentialKey);
			this.nextSequentialKey ++;
			
			return keyHolder;
		}// try
		catch (Exception e)
		{
			throw new Exception(e); // trap for debugging
		}// catch (Exception e)
	}// public KeyHolder getNextKeyInSequence() throws Exception
	////////////////////////////////////////////////////////////////////////////
	public List<KeyHolder> getKeyHolderList()
	{
		return keyHolderList;
	}
	public int getNumberOfKeys()
	{
		return numberOfKeys;
	}
	public int getKeySize()
	{
		return keySize;
	}
	////////////////////////////////////////////////////////////////////////////
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + keySize;
		result = prime * result + nextSequentialKey;
		result = prime * result + numberOfKeys;
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OneTimePadKeystore other = (OneTimePadKeystore) obj;
		if (keySize != other.keySize)
			return false;
		if (nextSequentialKey != other.nextSequentialKey)
			return false;
		if (numberOfKeys != other.numberOfKeys)
			return false;
		return true;
	}
	////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString()
	{
		return "OneTimePadKeystore [numberOfKeys=" + numberOfKeys
				+ ", keySize=" + keySize + ", nextSequentialKey="
				+ nextSequentialKey + "]";
	}
	
}// public class OneTimePadKeystore
