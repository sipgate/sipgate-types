package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.C;

public final class C extends Extension
{
	static final String DESCRIPTION = "A conference room";

	C(String masterSipid, String id)
	{
		super(masterSipid, C, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
