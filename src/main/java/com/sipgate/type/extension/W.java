package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.W;

public final class W extends Extension
{
	W(String masterSipid, String id)
	{
		super(masterSipid, W, id);
	}
}
