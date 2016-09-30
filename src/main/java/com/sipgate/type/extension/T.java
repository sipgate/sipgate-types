package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class T extends Extension
{
	static final String DESCRIPTION = "Trunking extension for custom PBXes (10 channels)";


	T(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
