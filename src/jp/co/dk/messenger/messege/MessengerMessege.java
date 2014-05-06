package jp.co.dk.messenger.messege;

import jp.co.dk.message.AbstractMessage;

/**
 * MessengerMessegeは、メッセンジャーの操作にて使用するメッセージを定義する定数クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerMessege extends AbstractMessage{
	
	/** 必須項目は */
	public static final MessengerMessege ERROR_MAIL_ = new MessengerMessege("E001");
	
	protected MessengerMessege(String messageId) {
		super(messageId);
	}

}
