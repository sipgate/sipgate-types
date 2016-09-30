package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class X extends Extension
{
	static final String DESCRIPTION = "Generic External phone extension, e.g. for mobiles";


	X(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
