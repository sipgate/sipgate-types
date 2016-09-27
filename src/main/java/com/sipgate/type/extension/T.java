package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class T extends Extension
{
	T(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}
}
