package jp.co.dk.messenger.mail;

import jp.co.dk.message.MessageInterface;
import jp.co.dk.messenger.MessengerFoundationTest;
import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.messege.MessengerMessege;

import org.junit.Test;

public class MailTest extends MessengerFoundationTest {

	@Test
	public void constractor() {
		// コンストラクタに対して引数に正常値が設定されている場合、
		// フィールドに値が保持されていること
		try {
			Mail sut = new Mail("smtp.xxxxx.ne.jp", "smtp.host.ne.jp");
			assertThat(sut.smtpServerName, is("smtp.xxxxx.ne.jp"));
			assertThat(sut.smtpHostName  , is("smtp.host.ne.jp"));
		} catch (MessengerInitializeException e) {
			fail(e);
		}
		
		
		// コンストラクタに対して必要な値が設定されいない場合、
		// 例外が発生すること。
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
