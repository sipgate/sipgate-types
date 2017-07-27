package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.H;

import com.sipgate.type.user.MasterSipid;

public final class H extends Extension {
	static final String DESCRIPTION = "Enables IVR";

	H(MasterSipid masterSipid, String id) {
		super(masterSipid, H, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
