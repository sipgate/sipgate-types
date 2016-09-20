package com.sipgate.type.number;

import static java.text.MessageFormat.format;

public class E164Number
{
	private String countrycode;
	private String areacode;
	private String number;

	@Override
	public String toString()
	{
		return format("{0}{1}{2}", countrycode, areacode, number);
	}

}
