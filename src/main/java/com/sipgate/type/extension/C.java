package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class C extends Extension
{
	C(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}
}
