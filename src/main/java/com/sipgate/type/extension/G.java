package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class G extends Extension
{
	static final String DESCRIPTION = "Callgroup-Extension";

	G(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
