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

import jp.co.dk.messenger.Messenger;
import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.exception.MessengerSendException;
import jp.co.dk.messenger.messege.MessengerMessege;
import jp.co.dk.messenger.property.MessengerProperty;

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
	protected Encode encode;
	
	public Mail(String smtpServerName, String smtpHostName) throws MessengerInitializeException {
		if (smtpServerName == null || smtpServerName.equals("")) throw new MessengerInitializeException(MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET);
		if (smtpHostName   == null || smtpHostName.equals(""))   throw new MessengerInitializeException(MessengerMessege.ERROR_HOSTNAME_IS_NOT_SET);
		this.smtpServerName = smtpServerName;
		this.smtpHostName   = smtpHostName;
	}
	
	protected Mail(String host, int port, boolean debug, boolean starttls_enable, boolean auth, 
			final String user, final String password, Map<Message.RecipientType, List<Address>> toAddressList, InternetAddress fromAddress, Encode encode) {
			Properties property = new Properties();
			property.put("mail.smtp.host", host);
			property.put("mail.smtp.port", port);
			property.put("mail.smtp.auth", auth);
			property.put("mail.smtp.starttls.enable", starttls_enable);
			property.put("mail.smtp.debug", debug);
			this.session = Session.getInstance(property, new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
	            	return new PasswordAuthentication(user, password);
				}
			});
			this.toAddressList = toAddressList;
			this.fromAddress   = fromAddress;
			this.encode        = encode;
			
	}
	
	public Mail() throws MessengerInitializeException {
		
		String hostname        = MessengerProperty.MAIL_SMTP_HOST.getString();
		String port            = MessengerProperty.MAIL_SMTP_PORT.getString();
		String auth            = MessengerProperty.MAIL_SMTP_AUTH.getString();
		String starttls_enable = MessengerProperty.MAIL_SMTP_STARTTLS_ENABLE.getString();
		String debug           = MessengerProperty.MAIL_SMTP_DEBUG.getString();
		if (hostname        == null || hostname.length()        == 0) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_HOSTNAME_IS_NOT_SET);
		if (port            == null || port.length()            == 0) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_PORT_IS_NOT_SET);
		if (auth            == null || auth.length()            == 0) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_HOSTNAME_IS_NOT_SET);
		if (starttls_enable == null || starttls_enable.length() == 0) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_HOSTNAME_IS_NOT_SET);
		if (debug           == null || debug.length()           == 0) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_HOSTNAME_IS_NOT_SET);
		

		Properties property = new Properties();
		property.put("mail.smtp.host"           , MessengerProperty.MAIL_SMTP_HOST.getShort());
		property.put("mail.smtp.port"           , MessengerProperty.MAIL_SMTP_PORT.getShort());
		property.put("mail.smtp.auth"           , MessengerProperty.MAIL_SMTP_AUTH.getShort());
		property.put("mail.smtp.starttls.enable", MessengerProperty.MAIL_SMTP_STARTTLS_ENABLE.getShort());
		property.put("mail.smtp.debug"          , MessengerProperty.MAIL_SMTP_DEBUG.getShort());
		String user     = MessengerProperty.MAIL_SMTP_AUTHENTICATION_USER.getString();
		String password = MessengerProperty.MAIL_SMTP_AUTHENTICATION_PASSWORD.getString();
		if (user != null && user.equals("")) throw new MessengerInitializeException();
		
	}
	
	protected Mail(Properties configure, final String user, final String password, Map<Message.RecipientType, List<Address>> toAddressList, InternetAddress fromAddress, Encode encord) throws MessengerInitializeException {
		this.session = Session.getInstance(configure, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
            	return new PasswordAuthentication(user, password);
			}
		});
		this.toAddressList = toAddressList;
		this.fromAddress   = fromAddress;
		this.encode        = encode;
	}
	
	@Override
	public void send(jp.co.dk.messenger.Messege message) throws MessengerSendException{
		try {
			MimeMessage messageObject = new MimeMessage(this.session);
			List<Address> toAddressList  = this.toAddressList.get(Message.RecipientType.TO);
			if (toAddressList != null)  messageObject.setRecipients(Message.RecipientType.TO, toAddressList.toArray(new Address[0]));
			List<Address> ccAddressList  = this.toAddressList.get(Message.RecipientType.CC);
			if (ccAddressList != null)  messageObject.setRecipients(Message.RecipientType.CC, ccAddressList.toArray(new Address[0]));
			List<Address> bccAddressList = this.toAddressList.get(Message.RecipientType.BCC);
			if (bccAddressList != null) messageObject.setRecipients(Message.RecipientType.BCC, bccAddressList.toArray(new Address[0]));
			messageObject.setFrom(this.fromAddress);
			messageObject.setSubject(message.getTitle(), this.encode.getEncodeStr());
			messageObject.setText(message.getText(), this.encode.getEncodeStr());
			Transport.send(messageObject);
		} catch (MessagingException e) {
			throw new MessengerSendException(MessengerMessege.ERROR_SEND_MAIL, e);
		}
	}
}
