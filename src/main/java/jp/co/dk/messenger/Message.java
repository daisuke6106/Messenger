package jp.co.dk.messenger;

/**
 * <p>メッセンジャーに対してのメッセージ送信内容を決定するクラスが実装するべきメッセージ送信可能インターフェースです。</p>
 * メッセージ内容を送信する際には、本インターフェースを実装し、getTitle、getTextにてそれぞれタイトルと、本文を実装し、メッセンジャークラスに対して、渡すことでメッセージ送信処理を実施することができます。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public interface Message {
	
	/**
	 * <p>メッセージのタイトルを返却します。</p> 
	 * メッセンジャーに対するメッセージのタイトルを生成して返却します。
	 * @return タイトル
	 */
	public String getTitle();
	
	/**
	 * <p>メッセージの本文を返却します。</p> 
	 * メッセンジャーに対するメッセージの本文を生成して返却します。
	 * @return 本文
	 */
	public String getText();
	
}
