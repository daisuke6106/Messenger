package jp.co.dk.messenger.mail;

import javax.mail.Session;

import jp.co.dk.messenger.Messege;
import jp.co.dk.messenger.Messenger;

public class Mail implements Messenger{
	
	/** SMTPサーバ名 */
	protected String smtpServerName;
	
	/** SMTPホスト名 */
	protected String smtpHostName;
	
	public Mail(String smtpServerName, String smtpHostName) {
		
	}

	@Override
	public void send(Messege message) {
		
	}

}
