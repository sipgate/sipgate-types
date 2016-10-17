package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.F;

public final class F extends Extension
{
	static final String DESCRIPTION = "Webfax-Extension, in+out";

	F(MasterSipid masterSipid, String id)
	{
		super(masterSipid, F, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
