package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class I extends Extension
{
	static final String DESCRIPTION = "Extension for SIM";

	I(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
