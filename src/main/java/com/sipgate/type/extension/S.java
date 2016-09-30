package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class S extends Extension
{
	static final String DESCRIPTION = "SMS-Extension";


	S(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
