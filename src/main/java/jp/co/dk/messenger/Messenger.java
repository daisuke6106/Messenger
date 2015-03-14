package jp.co.dk.messenger;

import jp.co.dk.messenger.exception.MessengerSendException;

public interface Messenger {
	
	public void send(Messege message) throws MessengerSendException;
	
}
