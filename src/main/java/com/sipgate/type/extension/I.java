package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.I;

import com.sipgate.type.user.MasterSipid;

public final class I extends Extension {
	static final String DESCRIPTION = "Extension for SIM";

	I(MasterSipid masterSipid, String id) {
		super(masterSipid, I, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
