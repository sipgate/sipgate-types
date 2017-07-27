package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.V;

import com.sipgate.type.user.MasterSipid;

public final class V extends Extension {
	static final String DESCRIPTION = "Voicemail-Extension";


	V(MasterSipid masterSipid, String id) {
		super(masterSipid, V, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
