package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

public final class A extends Extension
{
	A(String masterSipid, String id)
	{
		super(masterSipid, V, id);
	}
}
