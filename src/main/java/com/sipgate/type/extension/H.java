package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class H extends Extension
{
	static final String DESCRIPTION = "Enables IVR";

	H(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
