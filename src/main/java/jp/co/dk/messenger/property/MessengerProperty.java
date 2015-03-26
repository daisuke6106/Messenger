package jp.co.dk.messenger.property;

import java.io.File;

import jp.co.dk.property.AbstractProperty;
import jp.co.dk.property.exception.PropertyException;

/**
 * メッセンジャーに関するプロパティを定義するクラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerProperty extends AbstractProperty {
	
	/** SMTP接続先ホスト名 */
	public static final MessengerProperty MAIL_SMTP_HOST                    = new MessengerProperty("mail.smtp.host");
	
	/** SMTP接続先ポート番号 */
	public static final MessengerProperty MAIL_SMTP_PORT                    = new MessengerProperty("mail.smtp.port");
	
	/** SMTP接続先認証有無 */
	public static final MessengerProperty MAIL_SMTP_AUTH                    = new MessengerProperty("mail.smtp.auth");

	/** SMTP接続時のSTARTTLS */
	public static final MessengerProperty MAIL_SMTP_STARTTLS_ENABLE         = new MessengerProperty("mail.smtp.starttls.enable");

	/** SMTP接続時のデバック有無 */
	public static final MessengerProperty MAIL_SMTP_DEBUG                   = new MessengerProperty("mail.smtp.debug");

	/** SMTP認証ユーザ */
	public static final MessengerProperty MAIL_SMTP_AUTHENTICATION_USER     = new MessengerProperty("mail.smtp.authentication.user");

	/** SMTP認証パスワード */
	public static final MessengerProperty MAIL_SMTP_AUTHENTICATION_PASSWORD = new MessengerProperty("mail.smtp.authentication.password");

	/** メール送信元アドレス */
	public static final MessengerProperty MAIL_SMTP_FROM_MAIL_ADDRESS       = new MessengerProperty("mail.smtp.from.mail.address");

	/** メール送信元アドレス（TO） */
	public static final MessengerProperty MAIL_SMTP_TO_MAIL_ADDRESS         = new MessengerProperty("mail.smtp.to.mail.address");

	/** メール送信元アドレス（CC） */
	public static final MessengerProperty MAIL_SMTP_CC_MAIL_ADDRESS         = new MessengerProperty("mail.smtp.cc.mail.address");

	/** メール送信元アドレス（BCC） */
	public static final MessengerProperty MAIL_SMTP_BCC_MAIL_ADDRESS        = new MessengerProperty("mail.smtp.bcc.mail.address");

	/** メール送信時エンコーディング */
	public static final MessengerProperty MAIL_SMTP_ENCODING                = new MessengerProperty("mail.smtp.encoding");
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定されたプロパティキーをもとにプロパティ定数クラスを生成します。
	 * 
	 * @param key プロパティキー
	 */
	protected MessengerProperty (String key) throws PropertyException {
		super(new File("MessengerProperty.properties"), key);
	}
	
}
