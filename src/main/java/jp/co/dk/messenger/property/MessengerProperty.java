package jp.co.dk.messenger.property;

import java.io.File;

import jp.co.dk.property.AbstractProperty;
import jp.co.dk.property.exception.PropertyException;

/**
 * クローラに関するプロパティを定義するクラスです。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class MessengerProperty extends AbstractProperty {
	
	public static MessengerProperty SLEEP_TIME = new MessengerProperty("sleep.time");
	
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
