package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class Q extends Extension
{
	static final String DESCRIPTION = "Allows customer to enable incoming queue on groups for";


	Q(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
