package jp.co.dk.messenger.messege;

import jp.co.dk.message.AbstractMessage;

/**
 * MessengerMessegeは、メッセンジャーの操作にて使用するメッセージを定義する定数クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerMessege extends AbstractMessage{

	/** SMTP接続先ホスト名が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_HOSTNAME_IS_NOT_SET = new MessengerMessege("E002");

	/** SMTP接続先ポート番号が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_PORT_IS_NOT_SET = new MessengerMessege("E002");
	
	/** SMTP接続先ホストに対しての認証。 */
	public static final MessengerMessege ERROR_SMTP_PORT_IS_NOT_SET = new MessengerMessege("E002");
	
	/** SMTP接続先ポート番号が設定されていません。 */
	public static final MessengerMessege ERROR_SMTP_PORT_IS_NOT_SET = new MessengerMessege("E002");
	
	/** SMTP認証ユーザが指定されていません。 */
	public static final MessengerMessege ERROR_SMTP_USER_IS_NOT_SET = new MessengerMessege("E003");
	
	/** SMTP認証パスワードが指定されていません。 */
	public static final MessengerMessege ERROR_SMTP_PASSWORD_IS_NOT_SET = new MessengerMessege("E003");
	
	
	
	
	/** SMTPサーバ名が設定されていません。 */
	public static final MessengerMessege ERROR_SERVERNAME_IS_NOT_SET = new MessengerMessege("E001");
	
	/** メッセージの送信に失敗しました。 */
	public static final MessengerMessege ERROR_SEND_MAIL = new MessengerMessege("E003");
	
	protected MessengerMessege(String messageId) {
		super(messageId);
	}

}
