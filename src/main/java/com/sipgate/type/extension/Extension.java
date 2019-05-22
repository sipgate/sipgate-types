package com.sipgate.type.extension;

import static java.text.MessageFormat.format;
import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import com.sipgate.type.user.MasterSipid;
import java.io.Serializable;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		if (extension == null) {
			return Optional.empty();
		}

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

		return MasterSipid.parse(masterSipidKey)
				.map(masterSipid -> masterSipid.deriveExtension(type.get(), extensionId));
	}

	public static Optional<A> parseA(String extension) {
		return safeCast(A.class).apply(parse(extension));
	}

	public static Optional<C> parseC(String extension) {
		return safeCast(C.class).apply(parse(extension));
	}

	public static Optional<E> parseE(String extension) {
		return safeCast(E.class).apply(parse(extension));
	}

	public static Optional<F> parseF(String extension) {
		return safeCast(F.class).apply(parse(extension));
	}

	public static Optional<G> parseG(String extension) {
		return safeCast(G.class).apply(parse(extension));
	}

	public static Optional<H> parseH(String extension) {
		return safeCast(H.class).apply(parse(extension));
	}

	public static Optional<I> parseI(String extension) {
		return safeCast(I.class).apply(parse(extension));
	}

	public static Optional<P> parseP(String extension) {
		return safeCast(P.class).apply(parse(extension));
	}

	public static Optional<Q> parseQ(String extension) {
		return safeCast(Q.class).apply(parse(extension));
	}

	public static Optional<R> parseR(String extension) {
		return safeCast(R.class).apply(parse(extension));
	}

	public static Optional<T> parseT(String extension) {
		return safeCast(T.class).apply(parse(extension));
	}

	public static Optional<V> parseV(String extension) {
		return safeCast(V.class).apply(parse(extension));
	}

	public static Optional<W> parseW(String extension) {
		return safeCast(W.class).apply(parse(extension));
	}

	public static Optional<X> parseX(String extension) {
		return safeCast(X.class).apply(parse(extension));
	}

	public static Optional<Y> parseY(String extension) {
		return safeCast(Y.class).apply(parse(extension));
	}

	private static <T extends Extension> Function<Optional<Extension>, Optional<T>> safeCast(Class<T> clazz) {
		return (Optional<Extension> maybeExtension) -> maybeExtension
				.filter(e -> clazz.isAssignableFrom(e.getClass()))
				.map(clazz::cast);
	}

	public static boolean isA(final Extension extension, final ExtensionType extensionType) {
		return extension != null && isA(extension.getFullExtensionId(), extensionType);
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

	/**
	 * @deprecated	This method returns the extension number only.
	 * 				Replaced by
	 * 				{@link #getExtensionNumber()}
	 **/
	@Deprecated
	public String getId() {
		return id;
	}

	/**
	 * @return the extension number, e.g: 0
	 */
	public String getExtensionNumber() {
		return id;
	}

	/**
	 * @return the extension type and the extension number, e.g: w0
	 */
	public String getExtensionId() {
		return format("{0}{1}", type.getKey(), id);
	}

	/**
	 * @return the extension type and the extension number, e.g: 1234567w0
	 */
	public String getFullExtensionId() {
		return format("{0}{1}", masterSipid, getExtensionId());
	}

	/**
	 * @return the extension type and the extension number, e.g: 1234567w0
	 */
	@Override
	public String toString() {
		return getFullExtensionId();
	}

	@Override
	public boolean equals(Object obj) {
		return reflectionEquals(this, obj, false);
	}

	@Override
	public int hashCode() {
		return reflectionHashCode(this, false);
	}
}
