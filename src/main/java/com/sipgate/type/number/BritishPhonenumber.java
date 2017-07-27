package com.sipgate.type.number;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;
import java.util.Optional;

public class BritishPhonenumber extends Phonenumber {
	private BritishPhonenumber(PhoneNumber number) {
		super(number);
	}

	static Optional<Phonenumber> parse(String number) {
		try {
			final PhoneNumberUtil utils = PhoneNumberUtil.getInstance();
			final PhoneNumber phonenumber = utils.parse(number, "GB");

			return Optional.of(new BritishPhonenumber(phonenumber));
		} catch (final NumberParseException e) {
			return Optional.empty();
		}
	}
}
