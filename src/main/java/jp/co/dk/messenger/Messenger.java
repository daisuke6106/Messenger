package jp.co.dk.messenger;

import jp.co.dk.messenger.exception.MessengerSendException;

/**
 * <p>メッセージ送信を行うクラスが実装するインターフェースです。</p>
 * メール、IPメッセンジャーなど、メッセージの送信を実際に行うクラスが実装するべきインターフェースです。<br/>
 * sendメソッドに対してメッセージ本文のインスタンスを渡すことで、メッセージの送信を実際に行います。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public interface Messenger {
	
	/**
	 * <p>メッセージ送信を行います。</p>
	 * 引数にメッセージタイトル、本文を渡すことによって、実際にメッセージの送信を行います。
	 * 
	 * @param message　メッセージタイトル、本文を保持するメッセージ送信内諭インスタンス
	 * @throws MessengerSendException メッセージの送信に失敗した場合
	 */
	public void send(Messege message) throws MessengerSendException;
	
}
