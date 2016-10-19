package com.sipgate.type.user;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static java.text.MessageFormat.format;

/**
 * Convenience class bundling {@link MasterSipid} and {@link Domain}
 * as a lot of old daemons couple these values extremely strong.
 */
public class User
{
	private final MasterSipid masterSipid;
	private final Domain domain;

	public static User of(MasterSipid masterSipid, Domain domain)
	{
		return new User(masterSipid, domain);
	}

	public static User of(String masterSipid, String domain)
	{
		return new User(MasterSipid.of(masterSipid), Domain.parse(domain));
	}

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

	@Override
	public boolean equals(Object obj)
	{
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	@Override
	public int hashCode()
	{
		return HashCodeBuilder.reflectionHashCode(this, false);
	}
}
