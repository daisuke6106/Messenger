package jp.co.dk.messenger;

import java.util.ArrayList;
import java.util.List;

import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.exception.MessengerSendException;
import jp.co.dk.messenger.property.MessengerProperty;
import jp.co.dk.property.Property;

import static jp.co.dk.messenger.messege.MessengerMessege.*;

/**
 * <p>メッセンジャークラスを管理するメッセンジャー管理クラスです。</p>
 * MessengerMessege.propertiesに設定されているメッセンジャークラスを基にメッセンジャークラスを生成し、メッセージ送信を行います。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessegeManager implements Messenger {
	
	/** メッセンジャークラス一覧 */
	protected List<Messenger> messangerList = new ArrayList<Messenger>();
	
	/**
	 * MessengerMessege.propertiesに設定されているメッセンジャークラスを基に、メッセンジャークラスを生成し、メッセンジャー管理クラスを生成します。
	 * @throws MessengerInitializeException メッセンジャークラスの生成に失敗した場合
	 */
	public MessegeManager() throws MessengerInitializeException {
		try {
			java.util.List<String> messengerClasses = this.getMessengerClass();
			for (String messengerClass : messengerClasses) {
				Class messengerClassObj = Class.forName(messengerClass);
				Messenger messengerInstance = (Messenger) messengerClassObj.newInstance();
				messangerList.add(messengerInstance);
			}
		} catch (ClassNotFoundException e) {
			throw new MessengerInitializeException(ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE, e);
		} catch (ReflectiveOperationException e) {
			throw new MessengerInitializeException(ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE, e);
		}
	}
	
	/**
	 * MessengerMessege.propertiesに設定されているメッセンジャークラス一覧を取得します。
	 * @return メッセンジャークラス一覧
	 */
	protected java.util.List<String> getMessengerClass() {
		java.util.List<String> messengerClass = new ArrayList<String>();
		for (Property messengerClassProperty : MessengerProperty.MESSENGER_CLASS.getPropertyList()) {
			messengerClass.add(messengerClassProperty.getString());
		}
		return messengerClass;
	}
	
	
	@Override
	public void send(Messege message) throws MessengerSendException {
		for (Messenger messenger : messangerList) messenger.send(message);
	}
}
