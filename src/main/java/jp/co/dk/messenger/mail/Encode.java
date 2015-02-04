package jp.co.dk.messenger.mail;

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
}
