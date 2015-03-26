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
				Mail sut = new Mail();
			} catch (MessengerInitializeException e) {
				fail(e);
			}
		}
	}
}
