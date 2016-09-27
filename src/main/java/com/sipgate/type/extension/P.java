package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class P extends Extension
{
	P(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}
}
