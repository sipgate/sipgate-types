package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.H;

public final class H extends Extension
{
	static final String DESCRIPTION = "Enables IVR";

	H(MasterSipid masterSipid, String id)
	{
		super(masterSipid, H, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
