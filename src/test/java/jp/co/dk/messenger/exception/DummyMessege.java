package jp.co.dk.messenger.exception;

import jp.co.dk.message.AbstractMessage;

public class DummyMessege extends AbstractMessage {

	public static DummyMessege M0001 = new DummyMessege("M0001");
	
	public static DummyMessege M0002 = new DummyMessege("M0002");

	public static DummyMessege M0003 = new DummyMessege("M0003");

	protected DummyMessege(String messageId) {
		super("DummyMessage.properties", messageId);
	}

}
