package jp.co.dk.messenger.mail;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import jp.co.dk.messenger.Messege;
import jp.co.dk.messenger.Messenger;
import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.messege.MessengerMessege;

public class Mail implements Messenger{
	
	/** SMTPサーバ名 */
	protected String smtpServerName;
	
	/** SMTPホスト名 */
	protected String smtpHostName;
	
	/** メール送信セッション */
	protected Session session;
	
	/** 送信先一覧 */
	protected Map<Message.RecipientType, List<Address>> toAddressList;
	
	/** FROMヘッダ内容 */
	protected InternetAddress fromAddress;
	
	/** 送信時のエンコード */
	protected Encode encord;
	
	public Mail(String smtpServerName, String smtpHostName) throws MessengerInitializeException {
		if (smtpServerName == null || smtpServerName.equals("")) throw new MessengerInitializeException(MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET);
		if (smtpHostName   == null || smtpHostName.equals(""))   throw new MessengerInitializeException(MessengerMessege.ERROR_HOSTNAME_IS_NOT_SET);
		this.smtpServerName = smtpServerName;
		this.smtpHostName   = smtpHostName;
	}
	
	protected Mail(Properties configure, final String user, final String password, Map<Message.RecipientType, List<Address>> toAddressList, InternetAddress fromAddress, Encode encord) throws MessengerInitializeException {
		this.session = Session.getInstance(configure, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
            	return new PasswordAuthentication(user, password);
			}
		});
	}
	
	@Override
	public void send(Messege message) {
		try {
			MimeMessage messageObject = new MimeMessage(this.session);
			List<Address> toAddressList  = this.toAddressList.get(Message.RecipientType.TO);
			if (toAddressList != null)  messageObject.setRecipients(Message.RecipientType.TO, toAddressList.toArray(new Address[0]));
			List<Address> ccAddressList  = this.toAddressList.get(Message.RecipientType.CC);
			if (ccAddressList != null)  messageObject.setRecipients(Message.RecipientType.CC, ccAddressList.toArray(new Address[0]));
			List<Address> bccAddressList = this.toAddressList.get(Message.RecipientType.BCC);
			if (bccAddressList != null) messageObject.setRecipients(Message.RecipientType.BCC, bccAddressList.toArray(new Address[0]));
			messageObject.setFrom(this.fromAddress);
			messageObject.setSubject(message.getTitle(), this.encord.getEncodeStr());
			messageObject.setText(message.getText(), this.encord.getEncodeStr());
			Transport.send(messageObject);
		} catch (MessagingException e) {
			
		}
	}

}
