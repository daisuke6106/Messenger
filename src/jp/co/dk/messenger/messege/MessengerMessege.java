package jp.co.dk.messenger.messege;

import jp.co.dk.message.AbstractMessage;

/**
 * MessengerMessegeは、メッセンジャーの操作にて使用するメッセージを定義する定数クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerMessege extends AbstractMessage{
	
	/** SMTPサーバ名が設定されていません。 */
	public static final MessengerMessege ERROR_SERVERNAME_IS_NOT_SET = new MessengerMessege("E001");
	
	/** SMTPホスト名が設定されていません。 */
	public static final MessengerMessege ERROR_HOSTNAME_IS_NOT_SET = new MessengerMessege("E002");
	
	protected MessengerMessege(String messageId) {
		super(messageId);
	}

}
