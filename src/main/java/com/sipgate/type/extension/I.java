package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.I;

public final class I extends Extension
{
	static final String DESCRIPTION = "Extension for SIM";

	I(String masterSipid, String id)
	{
		super(masterSipid, I, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
