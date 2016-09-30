package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class F extends Extension
{
	static final String DESCRIPTION = "Webfax-Extension, in+ou";

	F(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
