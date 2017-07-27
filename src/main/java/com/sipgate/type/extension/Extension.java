package com.sipgate.type.extension;

import static java.text.MessageFormat.format;

import com.sipgate.type.user.MasterSipid;
import java.io.Serializable;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class Extension implements Serializable {
	private final MasterSipid masterSipid;
	private final ExtensionType type;
	private final String id;

	public Extension(MasterSipid masterSipid, ExtensionType type, String id) {
		this.masterSipid = masterSipid;
		this.type = type;
		this.id = id;
	}

	public Extension(String masterSipid, ExtensionType type, String id) {
		this.masterSipid = MasterSipid.of(masterSipid);
		this.type = type;
		this.id = id;
	}

	public abstract String getDescription();

	public static Extension build(MasterSipid masterSipid, ExtensionType type, String extensionId) {
		return type.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildA(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.A.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildC(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.C.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildE(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.E.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildF(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.F.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildG(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.G.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildH(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.H.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildI(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.I.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildQ(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.Q.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildR(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.R.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildS(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.S.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildT(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.T.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildV(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.V.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildW(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.W.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildX(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.X.buildExtension(masterSipid, extensionId);
	}

	public static Extension buildY(MasterSipid masterSipid, String extensionId) {
		return ExtensionType.Y.buildExtension(masterSipid, extensionId);
	}

	public static Optional<Extension> parse(String extension) {
		final Matcher matcher = Pattern.compile("(\\d+)(\\D+)(\\d+)").matcher(extension);

		if (!matcher.matches()) {
			return Optional.empty();
		}

		final Optional<ExtensionType> type = ExtensionType.parse(matcher.group(2));

		if (!type.isPresent()) {
			return Optional.empty();
		}

		final String extensionId = matcher.group(3);
		final String masterSipidKey = matcher.group(1);

		final Optional<MasterSipid> masterSipid = MasterSipid.parse(masterSipidKey);

		if (masterSipid.isPresent()) {
			return Optional.of(masterSipid.get().deriveExtension(type.get(), extensionId));
		}

		return Optional.empty();
	}

	public static boolean isA(final String extension, final ExtensionType extensionType) {
		final Optional<Extension> maybeExtension = Extension.parse(extension);
		return maybeExtension.isPresent() && maybeExtension.get().getType().equals(extensionType);
	}

	public ExtensionType getType() {
		return type;
	}

	public MasterSipid getMasterSipid() {
		return masterSipid;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return format("{0}{1}{2}", masterSipid, type.getKey(), id);
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}
}
