package jp.co.dk.messenger.exception;

import java.util.List;

import jp.co.dk.message.MessageInterface;

/**
 * DocumentExceptionは、メッセンジャーへの操作にて例外が発生したことを通知する例外クラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerSendException extends MessengerException{
	
	/**
	 * シリアルバージョンID
	 */
	private static final long serialVersionUID = -6377631970699270851L;

	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージで例外を生成します。
	 * 
	 * @param msg メッセージ定数インスタンス
	 * @since 1.0
	 */
	public MessengerSendException(MessageInterface msg){
		super(msg);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージで例外を生成します。
	 * 
	 * @param msg メッセージ定数インスタンス
	 * @param str メッセージ埋め込み文字列
	 * @since 1.0
	 */
	public MessengerSendException(MessageInterface msg, String str){
		super(msg, str);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージ、例外で例外を生成します。
	 * 
	 * @param msg メッセージ定数インスタンス
	 * @param throwable 例外インスタンス
	 * @since 1.0
	 */
	public MessengerSendException(MessageInterface msg, Throwable throwable){
		super(msg, throwable);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージ、埋め込み文字列、例外で例外を生成します。
	 * 
	 * @param msg メッセージ定数インスタンス
	 * @param str メッセージ埋め込み文字列
	 * @param throwable 例外インスタンス
	 * @since 1.0
	 */
	public MessengerSendException(MessageInterface msg, String str, Throwable throwable){
		super(msg, str, throwable);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージ、埋め込み文字列一覧、例外で例外を生成します。
	 * 
	 * @param msg メッセージ定数インスタンス
	 * @param list メッセージ埋め込み文字列一覧
	 * @param throwable 例外インスタンス
	 * @since 1.0
	 */
	public MessengerSendException(MessageInterface msg, List<String> list, Throwable throwable){
		super(msg, list, throwable);
	}
	
	/**
	 * コンストラクタ<p>
	 * 
	 * 指定のメッセージ、埋め込み文字列一覧、例外で例外を生成します。
	 * 
	 * @param msg メッセージ定数インスタンス
	 * @param embeddedStrList メッセージ埋め込み文字列一覧
	 * @param throwable 例外インスタンス
	 * @since 1.0
	 */
	public MessengerSendException(MessageInterface msg, String[] str, Throwable throwable){
		super(msg, str, throwable);
	}
}
