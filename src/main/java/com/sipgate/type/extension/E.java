package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class E extends Extension
{
	static final String DESCRIPTION = "SIP-Client-Extension";

	E(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
