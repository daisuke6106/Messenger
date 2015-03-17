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
	
	public static final MessengerProperty MAIL_SMTP_HOST                    = new MessengerProperty("mail.smtp.host");
	public static final MessengerProperty MAIL_SMTP_PORT                    = new MessengerProperty("mail.smtp.port");
	public static final MessengerProperty MAIL_SMTP_AUTH                    = new MessengerProperty("mail.smtp.auth");
	public static final MessengerProperty MAIL_SMTP_STARTTLS_ENABLE         = new MessengerProperty("mail.smtp.starttls.enable");
	public static final MessengerProperty MAIL_SMTP_DEBUG                   = new MessengerProperty("mail.smtp.debug");
	
	public static final MessengerProperty MAIL_SMTP_AUTHENTICATION_USER     = new MessengerProperty("mail.smtp.authentication.user");
	public static final MessengerProperty MAIL_SMTP_AUTHENTICATION_PASSWORD = new MessengerProperty("mail.smtp.authentication.password");
	public static final MessengerProperty MAIL_SMTP_FROM_MAIL_ADDRESS       = new MessengerProperty("mail.smtp.from.mail.address");
	public static final MessengerProperty MAIL_SMTP_TO_MAIL_ADDRESS         = new MessengerProperty("mail.smtp.to.mail.address");
	public static final MessengerProperty MAIL_SMTP_CC_MAIL_ADDRESS         = new MessengerProperty("mail.smtp.cc.mail.address");
	public static final MessengerProperty MAIL_SMTP_BCC_MAIL_ADDRESS        = new MessengerProperty("mail.smtp.bcc.mail.address");
	public static final MessengerProperty MAIL_SMTP_ENCODING                = new MessengerProperty("mail.smtp.bcc.mail.address");
	
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
