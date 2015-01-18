package jp.co.dk.messenger.mail;

import jp.co.dk.messenger.Messege;
import jp.co.dk.messenger.Messenger;
import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.messege.MessengerMessege;

public class Mail implements Messenger{
	
	/** SMTPサーバ名 */
	protected String smtpServerName;
	
	/** SMTPホスト名 */
	protected String smtpHostName;
	
	public Mail(String smtpServerName, String smtpHostName) throws MessengerInitializeException {
		if (smtpServerName == null || smtpServerName.equals("")) throw new MessengerInitializeException(MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET);
		if (smtpHostName   == null || smtpHostName.equals(""))   throw new MessengerInitializeException(MessengerMessege.ERROR_HOSTNAME_IS_NOT_SET);
		this.smtpServerName = smtpServerName;
		this.smtpHostName   = smtpHostName;
	}

	@Override
	public void send(Messege message) {
		
	}

}
