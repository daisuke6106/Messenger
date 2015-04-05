package jp.co.dk.messenger.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
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

/**
 * <p>メールの送信を行うメッセンジャークラスです。</p>
 * MessengerProperty.propertiesに定義されている内容を元に本クラスのインスタンスを生成し、メール送信を行います。
 * 
 * @version 1.0
 * @author D.Kanno
 */
public class Mail implements Messenger{
	
	/** SMTP接続先ホスト名 */
	protected String hostname;
	
	/** SMTP接続先ポート番号 */
	protected int port;
	
	/** SMTP接続先認証有無 */
	protected boolean auth;
	
	/** SMTP接続時のSTARTTLS */
	protected boolean starttls_enable;
	
	/** SMTP接続時のデバック有無 */
	protected boolean debug;
	
	/** SMTP接続時のユーザ */
	protected String user;
	
	/** SMTP接続時のパスワード */
	protected String password;
	
	/** メール送信セッション */
	protected Session session;
	
	/** 送信先一覧 */
	protected Map<Message.RecipientType, List<Address>> toAddressList;
	
	/** FROMヘッダ内容 */
	protected Address fromAddress;
	
	/** 送信時のエンコード */
	protected Encode encode;
	
	/**
	 * <p>MessengerProperty.propertiesに定義されている内容を元にインスタンスを生成します。</p>
	 */
	public Mail() throws MessengerInitializeException {
		this.hostname        = MessengerProperty.MAIL_SMTP_HOST.getString();
		if (hostname        == null || hostname.length() == 0) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_HOSTNAME_IS_NOT_SET);
		this.port            = MessengerProperty.MAIL_SMTP_PORT.getInt();
		this.auth            = MessengerProperty.MAIL_SMTP_AUTH.getBoolean();
		this.starttls_enable = MessengerProperty.MAIL_SMTP_STARTTLS_ENABLE.getBoolean();
		this.debug           = MessengerProperty.MAIL_SMTP_DEBUG.getBoolean();
		Properties property = new Properties();
		property.put("mail.smtp.host"           , MessengerProperty.MAIL_SMTP_HOST.getString());
		property.put("mail.smtp.port"           , MessengerProperty.MAIL_SMTP_PORT.getString());
		property.put("mail.smtp.auth"           , MessengerProperty.MAIL_SMTP_AUTH.getString());
		property.put("mail.smtp.starttls.enable", MessengerProperty.MAIL_SMTP_STARTTLS_ENABLE.getString());
		property.put("mail.smtp.debug"          , MessengerProperty.MAIL_SMTP_DEBUG.getString());
		
		if (auth) {
			this.user     = MessengerProperty.MAIL_SMTP_AUTHENTICATION_USER.getString();
			if (user != null && user.equals("")) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_USER_IS_NOT_SET);
			
			this.password = MessengerProperty.MAIL_SMTP_AUTHENTICATION_PASSWORD.getString();
			if (password != null && password.equals("")) throw new MessengerInitializeException(MessengerMessege.ERROR_SMTP_PASSWORD_IS_NOT_SET);
			
			this.session = Session.getInstance(property, new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
	            	return new PasswordAuthentication(user, password);
				}
			});
		} else {
			this.session = Session.getInstance(property);
		}
		this.toAddressList = new HashMap<Message.RecipientType, List<Address>>();
		this.toAddressList.put(Message.RecipientType.TO , this.createAddressList(MessengerProperty.MAIL_SMTP_TO_MAIL_ADDRESS.getList()));
		this.toAddressList.put(Message.RecipientType.CC , this.createAddressList(MessengerProperty.MAIL_SMTP_CC_MAIL_ADDRESS.getList()));
		this.toAddressList.put(Message.RecipientType.BCC, this.createAddressList(MessengerProperty.MAIL_SMTP_BCC_MAIL_ADDRESS.getList()));
		this.fromAddress   = this.createAddress(MessengerProperty.MAIL_SMTP_FROM_MAIL_ADDRESS.getString());
		this.encode        = Encode.getEncode(MessengerProperty.MAIL_SMTP_ENCODING.getString());
	}
	
	@Override
	public void send(jp.co.dk.messenger.Message message) throws MessengerSendException{
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
	
	protected List<Address> createAddressList(List<String> addressList) throws MessengerInitializeException {
		List<Address> addressObjList = new ArrayList<Address>();
		for (String addressStr : addressList) {
			addressObjList.add(this.createAddress(addressStr));
		}
		return addressObjList;
	}
	
	protected Address createAddress(String addressStr) throws MessengerInitializeException {
		try {
			String[] splitedAddress = addressStr.split(":");
			return new InternetAddress(splitedAddress[0], splitedAddress[1]);
		} catch (UnsupportedEncodingException e) {
			throw new MessengerInitializeException(MessengerMessege.ERROR_SEND_MAILADDRESS_IS_FAILE);
		}
	}
}
