package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class E extends Extension
{
	E(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}
}
