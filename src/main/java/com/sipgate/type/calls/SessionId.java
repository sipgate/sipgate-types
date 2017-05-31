package com.sipgate.type.calls;

import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class SessionId {

	static final byte[] key =
		("feOcden_yetlenJoaccebkelNiecactartum*gensonEicykEcMec=da"
			+ "nofyown8AvonedUgRovNugdegcockiejOt0ocBegrekmgav6leuzsi7"
			+ "Wab5okEygEwQuitUtmymsiavEnsimIcmutIpivGawnOuAtlihontsta"
			+ "DapgewIcByzajnovSibojmor4drefgaHebGeccedavLipgimOchAmWo"
			+ "NifleedIgpictatnecbuevRysbaidNokPeetsyatedmothyejCedPes"
			+ "CecwudpooghacVabyeryamLybOvnedByisokpokmynwinubnuetsilg"
			+ "weadpidgugTeugutmegWimkejUgfapKeHyweskyujCulWuctIlkUcOr"
			+ "AksavyiBlidenshOdbeikijopIcDincikqueracviedNiwacyapJiHo"
			+ "pacnudyiedZytUfAvElAgFadvulPevaijlykEarj0swisicOgdaktof"
			+ "CruguchEgdivAmduwybNoorceurdyeckEfGooHeivifOfdeenJododa"
			+ "RottAtNiWothkefroachacInItVeHikGhawElWiKrardOgCikWozhai"
			+ "TajEexyolnunCizfobrIfeeghodsinyaukTimgalUtyobEkyaylgOj4"
			+ "plytyachujCumicekMarfIgEcyofAfIbfitcashekVajbykMotvevFi"
			+ "FebtyrumObseetDitlinadsIrElyevMiUbdavOpsEcDeHebyavyicBu"
			+ "VekFindOcheituvQuondimougjebMovticwityibOocOgUrbiaHiUls")
			.getBytes(StandardCharsets.ISO_8859_1);

	private final String id;
	private final String owner;
	private final String tos;

	public SessionId(final String id, final String owner, final String tos) {
		this.id = id;
		this.owner = owner;
		this.tos = tos;
	}

	public SessionId(final String encoded) throws DecoderException {
		final String decoded = decode(encoded);
		final String[] split = decoded.split("\\$");
		this.id = split[2];
		this.owner = split[3];
		this.tos = split[1];
	}

	public String getId() {
		return id;
	}

	public String getOwner() {
		return owner;
	}

	public String getTos() {
		return tos;
	}

	public String getEncoded() {
		return encode(this.id, this.owner, this.tos);
	}

	private String encode(final String id, final String owner, final String tos) {
		String combinedId =
			Integer.toHexString(id.length() + owner.length() + tos.length() + 2) + "$" + tos + "$" + id
				+ "$"
				+ owner;

		byte[] plain = combinedId.getBytes(StandardCharsets.ISO_8859_1);
		byte[] encoded = new byte[plain.length];

		for (int i = 0; i < plain.length; i++) {

			encoded[i] = (byte) (plain[i] ^ key[i % key.length]);
		}

		return String.valueOf(Hex.encodeHex(encoded)).toUpperCase();
	}

	private String decode(final String encoded) throws DecoderException {
		byte[] encodedBytes = Hex.decodeHex(encoded.toLowerCase().toCharArray());
		byte[] decodedBytes = new byte[encodedBytes.length];

		for (int i = 0; i < encodedBytes.length; i++) {

			decodedBytes[i] = (byte) (encodedBytes[i] ^ key[i % key.length]);
		}

		return new String(decodedBytes, StandardCharsets.ISO_8859_1);
	}
}
