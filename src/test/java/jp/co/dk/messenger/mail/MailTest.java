package jp.co.dk.messenger.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;

import jp.co.dk.message.MessageInterface;
import jp.co.dk.messenger.MessengerFoundationTest;
import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.exception.MessengerSendException;
import jp.co.dk.messenger.messege.MessengerMessege;
import jp.co.dk.messenger.property.MessengerProperty;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MailTest {

	public static class コンストラクタ extends MessengerFoundationTest {
		
		@Test
		public void コンストラクタに対して引数に正常値が設定されている場合フィールドに値が保持されていること() {
			try {
				Mail sut = new Mail("smtp.xxxxx.ne.jp", "smtp.host.ne.jp");
				assertThat(sut.smtpServerName, is("smtp.xxxxx.ne.jp"));
				assertThat(sut.smtpHostName  , is("smtp.host.ne.jp"));
			} catch (MessengerInitializeException e) {
				fail(e);
			}
		}
		
		@Test
		public void コンストラクタに対して必要な値が設定されいない場合例外が発生すること() {
			try {
				new Mail(null, null);
				fail();
			} catch (MessengerInitializeException e) {
				assertThat(e.getMessageObj(), is((MessageInterface)MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET));
			}
			
			try {
				new Mail(null, "smtp.host.ne.jp");
				fail();
			} catch (MessengerInitializeException e) {
				assertThat(e.getMessageObj(), is((MessageInterface)MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET));
			}
			
			try {
				new Mail("smtp.xxxxx.ne.jp", null);
				fail();
			} catch (MessengerInitializeException e) {
				assertThat(e.getMessageObj(), is((MessageInterface)MessengerMessege.ERROR_HOSTNAME_IS_NOT_SET));
			}
			
			try {
				new Mail("", "");
				fail();
			} catch (MessengerInitializeException e) {
				assertThat(e.getMessageObj(), is((MessageInterface)MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET));
			}
			
			try {
				new Mail("", "smtp.host.ne.jp");
				fail();
			} catch (MessengerInitializeException e) {
				assertThat(e.getMessageObj(), is((MessageInterface)MessengerMessege.ERROR_SERVERNAME_IS_NOT_SET));
			}
			
			try {
				new Mail("smtp.xxxxx.ne.jp", "");
				fail();
			} catch (MessengerInitializeException e) {
				assertThat(e.getMessageObj(), is((MessageInterface)MessengerMessege.ERROR_HOSTNAME_IS_NOT_SET));
			}
		}	
	}
	
	public static class 引数に各種値を渡しインスタンスを生成 extends MessengerFoundationTest {
		@Test
		public void send() throws UnsupportedEncodingException, MessengerSendException {
			Map<Message.RecipientType, List<Address>> toAddressList = new HashMap<Message.RecipientType, List<Address>>();
			List<Address> addressList = new ArrayList<Address>();
			addressList.add(new InternetAddress("daisuke6106@gmail.com", "自分宛！！"));
			toAddressList.put(Message.RecipientType.TO, addressList);
			Mail mail = new Mail("smtp.gmail.com", 587, true, true, true, "daisuke6106", "Dk_4294967296", toAddressList, new InternetAddress("daisuke6106@gmail.com", "自分宛！！"), Encode.UTF_8);
			
			mail.send(new jp.co.dk.messenger.Messege() {
				@Override
				public String getTitle() {
					return "テスト用メール送信タイトル";
				}
				@Override
				public String getText() {
					return "本文!!めっさ長い本文ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー";
				}
			});
		}
	}
	
	public static class プロパティファイルを元にインスタンスを生成 extends MessengerFoundationTest {
		@Test
		public void send() throws UnsupportedEncodingException, MessengerSendException {
			// Gmailの場合
			Mail mailer = new Mail(new MessengerProperty());
			mail.send(new jp.co.dk.messenger.Messege() {

				@Override
				public String getTitle() {
					return "テスト用メール送信タイトル";
				}

				@Override
				public String getText() {
					// TODO Auto-generated method stub
					return "本文!!めっさ長い本文ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー";
				}
				
			});
		}
	}
}
