package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.Q;

import com.sipgate.type.user.MasterSipid;

public final class Q extends Extension {
	static final String DESCRIPTION = "Allows customer to enable incoming queue on groups for";


	Q(MasterSipid masterSipid, String id) {
		super(masterSipid, Q, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
