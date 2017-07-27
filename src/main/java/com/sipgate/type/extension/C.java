package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.C;

import com.sipgate.type.user.MasterSipid;

public final class C extends Extension {
	static final String DESCRIPTION = "A conference room";

	C(MasterSipid masterSipid, String id) {
		super(masterSipid, C, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
