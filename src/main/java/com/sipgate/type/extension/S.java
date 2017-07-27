package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.S;

import com.sipgate.type.user.MasterSipid;

public final class S extends Extension {
	static final String DESCRIPTION = "SMS-Extension";


	S(MasterSipid masterSipid, String id) {
		super(masterSipid, S, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
