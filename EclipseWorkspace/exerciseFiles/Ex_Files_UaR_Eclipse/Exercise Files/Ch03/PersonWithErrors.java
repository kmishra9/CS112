package com.charleskelly.member;

public class PersonWithErrors
{
	private String fName;
	private String mName;
	private String lName;
	private Date	dob;
	////////////////////////////////////////////////////////////////////////////
	public PersonWithErrors()
	{
		super();
	}// public PersonWithErrors()	
	////////////////////////////////////////////////////////////////////////////
	public void evaluateAge() throws Exception
	{
		try
		{
			if (null == this.dob)
			{
				throw new Exception ("dob field is null)
			} else
			{
				GregorianCalendar oldAgeCalendar = 
						new GregorianCalendar(1900,Calendar.JANUARY,1);
				Date oldAgeDate = oldAgeCalendar.getTime();
				if (this.dob.before(oldAgeDate))
				{
					System.out.println("Getting kind of old");
				}
				else
				{
					System.out.println("Still got plenty of time");
				}
			}
			if (dob=0)
				System.out.println ("Oops: I wanted a conditional operator");
		}// try
		catch (Exception e)
		{
			// TODO: handle exception
		}// catch (Exception e)
	}// public void evaluateAge() throws Exception
	////////////////////////////////////////////////////////////////////////////
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
}// public class PersonWithErrors
