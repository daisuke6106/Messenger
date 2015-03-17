package jp.co.dk.messenger.mail;

import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.messege.MessengerMessege;

/**
 * <p>メール送信にて使用するエンコードを定義する定数クラス</p>
 * 
 * @author dk
 * @version 1.0
 */
public enum Encode {
	
	/** ISO-2022-JP */
	ISO_2022_JP("ISO-2022-JP"),
	
	/** UTF-8 */
	UTF_8("UTF-8"),
	
	/** Shift_Jis */
	SHIFT_JIS("Shift_Jis"),
	
	;
	
	/** 文字コードを表す文字列 */
	private String encodeStr;
	
	/**
	 * <p>コンストラクタ</p>
	 * 文字コードを表す文字列を元にエンコードのインスタンスを生成します。
	 * 
	 * @param encodeStr 文字コードを表す文字列
	 */
	private Encode(String encodeStr) {
		this.encodeStr = encodeStr;
	}
	
	/**
	 * 文字コードを表す文字列を返却する。
	 * 
	 * @return 文字コードを表す文字列
	 */
	String getEncodeStr() {
		return this.encodeStr;
	}
	
	/**
	 * <p>指定の文字列を元に該当するエンコードのインスタンスを返却する。</p>
	 * 合致するエンコードのインスタンスが見つからなかった場合、MessengerInitializeExceptionを送出する。
	 * 
	 * @param encode 文字コードを表す文字列
	 * @return エンコードのインスタンス
	 * @throws MessengerInitializeException 合致するエンコードのインスタンスが見つからなかった場合
	 */
	static Encode getEncode(String encode) throws MessengerInitializeException{
		for (Encode encodeObj : Encode.values()) {
			if (encodeObj.encodeStr.equals(encode)) return encodeObj;
		}
		throw new MessengerInitializeException(MessengerMessege.ERROR_SEND_MAIL_ENCODING_IS_FAILE, encode);
	}
}
