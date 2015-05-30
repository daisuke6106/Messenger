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

import org.hamcrest.core.IsNot;
import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(Enclosed.class)
public class MailTest {

	public static class コンストラクタ extends MessengerFoundationTest {
		
		@Test
		public void コンストラクタに対して引数に正常値が設定されている場合フィールドに値が保持されていること() {
			try {
				Mail sut = new Mail();
				assertThat(sut.hostname, is("smtp.gmail.com"));
				assertThat(sut.port, is(587));
				assertThat(sut.auth, is(true));
				assertThat(sut.starttls_enable, is(true));
				assertThat(sut.debug, is(true));
				
				assertThat(sut.user, is("daisuke6106"));
				assertThat(sut.password, is("zaq12wsx"));
				
				assertThat(sut.session, notNullValue());
				
				assertThat(sut.toAddressList, notNullValue());
				
				Address fromAddress = new InternetAddress("from_daisuke6106@gmail.com","送信元アドレス");
				org.assertj.core.api.Assertions.assertThat(sut.fromAddress).isEqualTo(fromAddress);
				
				List<Address> toAddressList = new ArrayList<Address>();
				Address toAddress1 = new InternetAddress("to_daisuke6106@gmail.com","送信先アドレス(TO)");
				toAddressList.add(toAddress1);
				assertThat(sut.toAddressList.get(Message.RecipientType.TO), is(toAddressList));
				
				List<Address> ccAddressList = new ArrayList<Address>();
				Address ccAddress1 = new InternetAddress("cc_daisuke6106@gmail.com","送信先アドレス(CC)");
				ccAddressList.add(ccAddress1);
				assertThat(sut.toAddressList.get(Message.RecipientType.CC), is(ccAddressList)); 
				
				List<Address> bccAddressList = new ArrayList<Address>();
				Address bccAddress1 = new InternetAddress("bcc_daisuke6106@gmail.com","送信先アドレス(BCC)");
				bccAddressList.add(bccAddress1);
				assertThat(sut.toAddressList.get(Message.RecipientType.BCC), is(bccAddressList)); 
				
				assertThat(sut.encode, is(Encode.UTF_8));
			} catch (MessengerInitializeException e) {
				fail(e);
			} catch (UnsupportedEncodingException e) {
				fail(e);
			}
		}
	}
	
//	public static class 正常にインスタンスが生成できた場合 extends MessengerFoundationTest {
//		
//		protected Mail sut;
//		
//		@Before
//		public void init() {
//			this.sut = new Mail() {
//				protected List<jp.co.dk.messenger.Message> messageList = new ArrayList<jp.co.dk.messenger.Message>();
//				@Override
//				public void send(jp.co.dk.messenger.Message message) throws MessengerSendException {
//					this.messageList.add(message);
//				}
//			};
//		}
//	}
}
