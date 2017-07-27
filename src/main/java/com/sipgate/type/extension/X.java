package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.X;

import com.sipgate.type.user.MasterSipid;

public final class X extends Extension {
	static final String DESCRIPTION = "Generic External phone extension, e.g. for mobiles";


	X(MasterSipid masterSipid, String id) {
		super(masterSipid, X, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
