package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class V extends Extension
{
	static final String DESCRIPTION = "Voicemail-Extension";


	V(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription()
	{
		return DESCRIPTION;
	}
}
