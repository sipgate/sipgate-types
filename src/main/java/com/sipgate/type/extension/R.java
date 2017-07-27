package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.R;

import com.sipgate.type.user.MasterSipid;

public final class R extends Extension {
	static final String DESCRIPTION =
			"Groupcall-Announcement-extension for sipgate.de only. Technically the same as callthrough, but with d";


	R(MasterSipid masterSipid, String id) {
		super(masterSipid, R, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
