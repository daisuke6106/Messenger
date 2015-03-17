package jp.co.dk.messenger.mail;

import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.messege.MessengerMessege;

public enum Encode {
	
	ISO_2022_JP("ISO-2022-JP"),
	
	UTF_8("UTF-8"),
	
	SHIFT_JIS("Shift_Jis"),
	
	;
	
	private String encodeStr;
	
	private Encode(String encodeStr) {
		this.encodeStr = encodeStr;
	}
	
	String getEncodeStr() {
		return this.encodeStr;
	}
	
	static Encode getEncode(String encode) throws MessengerInitializeException{
		for (Encode encodeObj : Encode.values()) {
			if (encodeObj.encodeStr.equals(encode)) return encodeObj;
		}
		throw new MessengerInitializeException(MessengerMessege.ERROR_SEND_MAIL_ENCODING_IS_FAILE, encode);
	}
}
