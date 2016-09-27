package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class Q extends Extension
{
	Q(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}
}
