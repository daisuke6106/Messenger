package jp.co.dk.messenger.mail;

import static org.junit.Assert.*;
import jp.co.dk.messenger.Messege;
import jp.co.dk.messenger.MessengerFoundationTest;

import org.junit.Test;

public class MailTest extends MessengerFoundationTest {

	@Test
	public void constractor() {
		Mail sut = new Mail("smtp.xxxxx.ne.jp", "smtp.host.ne.jp");
		assertThat(sut.smtpServerName, is("smtp.xxxxx.ne.jp"));
		assertThat(sut.smtpHostName  , is("smtp.host.ne.jp"));
	}

}
