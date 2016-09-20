package com.sipgate.type.user;

import static java.text.MessageFormat.format;

/**
 * Convenience class bundling {@link MasterSipid} and {@link Domain}
 * as a lot of old daemons couple these values extremely strong.
 */
public class User
{
	private final MasterSipid masterSipid;
	private final Domain domain;

	public User(MasterSipid masterSipid, Domain domain)
	{
		this.masterSipid = masterSipid;
		this.domain = domain;
	}

	public MasterSipid getMasterSipid()
	{
		return masterSipid;
	}

	public Domain getDomain()
	{
		return domain;
	}

	@Override
	public String toString()
	{
		return format("{0} ({1})", masterSipid, domain);
	}
}
