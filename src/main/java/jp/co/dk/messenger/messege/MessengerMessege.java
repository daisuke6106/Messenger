package jp.co.dk.messenger.messege;

import jp.co.dk.message.AbstractMessage;

/**
 * MessengerMessegeは、メッセンジャーの操作にて使用するメッセージを定義する定数クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerMessege extends AbstractMessage{
	
	/** メッセンジャーのインスタンス生成に失敗しました。 */
	public static final MessengerMessege ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE = new MessengerMessege("E001");
	
	/** メッセージの送信に失敗しました。 */
	public static final MessengerMessege ERROR_SEND_MAIL = new MessengerMessege("E002");
	
	/** SMTP接続先ホスト名が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_HOSTNAME_IS_NOT_SET = new MessengerMessege("E101");

	/** SMTP接続先ポート番号が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_PORT_IS_NOT_SET = new MessengerMessege("E102");
	
	/** SMTP接続先認証有無が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_AUTH_IS_NOT_SET = new MessengerMessege("E103");
	
	/** SMTP接続時のSTARTTLSが設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_STARTTLS_IS_NOT_SET = new MessengerMessege("E104");
	
	/** SMTP接続時のデバック有無が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_DEBUG_IS_NOT_SET = new MessengerMessege("E105");
	
	/** SMTP認証ユーザが指定されていません。 */
	public static final MessengerMessege ERROR_SMTP_USER_IS_NOT_SET = new MessengerMessege("E106");
	
	/** SMTP認証パスワードが指定されていません。 */
	public static final MessengerMessege ERROR_SMTP_PASSWORD_IS_NOT_SET = new MessengerMessege("E107");

	/** メール送信先アドレスの指定が不正です。 */
	public static final MessengerMessege ERROR_SEND_MAILADDRESS_IS_FAILE = new MessengerMessege("E108");
	
	/** メール送信時のエンコーディングの指定が不正です。encode=[{0}] */
	public static final MessengerMessege ERROR_SEND_MAIL_ENCODING_IS_FAILE = new MessengerMessege("E109");
	
	protected MessengerMessege(String messageId) {
		super(messageId);
	}

}
