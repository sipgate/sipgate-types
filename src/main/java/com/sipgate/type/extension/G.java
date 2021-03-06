package com.sipgate.type.extension;

import static com.sipgate.type.extension.ExtensionType.G;

import com.sipgate.type.user.MasterSipid;

public final class G extends Extension {
	static final String DESCRIPTION = "Callgroup-Extension";

	G(MasterSipid masterSipid, String id) {
		super(masterSipid, G, id);
	}

	@Override
	public String getDescription() {
		return DESCRIPTION;
	}
}
