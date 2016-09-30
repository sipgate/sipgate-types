package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class Y extends Extension
{
	static final String DESCRIPTION = "y(i) for mobile extensions";


	Y(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
