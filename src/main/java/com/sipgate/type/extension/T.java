package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.T;

public final class T extends Extension
{
	static final String DESCRIPTION = "Trunking extension for custom PBXes (10 channels)";


	T(MasterSipid masterSipid, String id)
	{
		super(masterSipid, T, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
