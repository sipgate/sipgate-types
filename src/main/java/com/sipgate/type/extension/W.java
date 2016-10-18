package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.W;

public final class W extends Extension
{
	static final String DESCRIPTION = "Webuser-Extension, can be admin or not";


	W(MasterSipid masterSipid, String id)
	{
		super(masterSipid, W, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
