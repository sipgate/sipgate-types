package com.sipgate.type.extension;

import com.sipgate.type.user.MasterSipid;

import static com.sipgate.type.extension.ExtensionType.V;

public final class V extends Extension
{
	static final String DESCRIPTION = "Voicemail-Extension";


	V(MasterSipid masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
