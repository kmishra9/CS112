package com.charleskelly.holder;

import java.security.Key;

import javax.xml.bind.annotation.XmlElement;

import com.charleskelly.key.otp.OneTimeKey;

/**
 * Holder record for a key, alias, index
 * 
 * @author charlie
 *
 */


//@Entity
public class KeyHolder
{
//	@Id
//	@GeneratedValue
	private Long id;
	
//	@XmlElement
	private String 		alias;
//	@XmlElement
	private String		designator;
//	@XmlElement
	private long		index;
//	private Key			key;
//	@XmlElement
	private OneTimeKey	oneTimeKey;
	////////////////////////////////////////////////////////////////////////////
	public KeyHolder()
	{
		
	}// public KeyHolder()
	////////////////////////////////////////////////////////////////////////////
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getAlias()
	{
		return alias;
	}
	public void setAlias(String alias)
	{
		this.alias = alias;
	}
	public long getIndex()
	{
		return index;
	}
	public void setIndex(long index)
	{
		this.index = index;
	}
	
	public OneTimeKey getOneTimeKey()
	{
		return oneTimeKey;
	}
	public void setOneTimeKey(OneTimeKey oneTimeKey)
	{
		this.oneTimeKey = oneTimeKey;
	}
	public String getDesignator()
	{
		return designator;
	}
	public void setDesignator(String designator)
	{
		this.designator = designator;
	}
	@Override
	public String toString()
	{
		return "KeyHolder [alias=" + alias + ", index=" + index + "]";
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (int) (index ^ (index >>> 32));
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
		KeyHolder other = (KeyHolder) obj;
		if (alias == null)
		{
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (index != other.index)
			return false;
		return true;
	}
	
	
}// public class KeyHolder
