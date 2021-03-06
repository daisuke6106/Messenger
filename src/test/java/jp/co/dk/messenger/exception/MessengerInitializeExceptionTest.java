package jp.co.dk.messenger.exception;

import static jp.co.dk.messenger.exception.DummyMessege.M0001;
import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import jp.co.dk.message.MessageInterface;
import jp.co.dk.messenger.MessengerFoundationTest;


public class MessengerInitializeExceptionTest extends MessengerFoundationTest {
	
	@Test
	public void test() {
		// メッセージオブジェクトのみ指定して実行した場合
		// 埋め込み文字列、throwクラスは取得できないこと
		MessengerInitializeException sut1 = new MessengerInitializeException(M0001);
		assertThat(sut1.getMessageObj(), is((MessageInterface)M0001));
		assertThat(sut1.getEmbeddedStrList().size(), is(0));
		assertThat(sut1.getThrowable(), nullValue());
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスは取得できないこと
		MessengerInitializeException sut2 = new MessengerInitializeException(M0001, "http://www.google.com");
		assertThat(sut2.getMessageObj(), is((MessageInterface)M0001));
		assertThat(sut2.getEmbeddedStrList().size(), is(1));
		assertThat(sut2.getEmbeddedStrList().get(0), is("http://www.google.com"));
		assertThat(sut2.getThrowable(), nullValue());
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 埋め込み文字列が取得できないこと
		// throwクラスは取得できること
		MessengerInitializeException sut3 = new MessengerInitializeException(M0001, new NullPointerException());
		assertThat(sut3.getMessageObj(), is((MessageInterface)M0001));
		assertThat(sut3.getEmbeddedStrList().size(), is(0));
		assertThat(sut3.getThrowable(), instanceOf(NullPointerException.class));
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスが取得できること
		MessengerInitializeException sut4 = new MessengerInitializeException(M0001, "http://www.google.com", new NullPointerException());
		assertThat(sut4.getMessageObj(), is((MessageInterface)M0001));
		assertThat(sut4.getEmbeddedStrList().size(), is(1));
		assertThat(sut4.getEmbeddedStrList().get(0), is("http://www.google.com"));
		assertThat(sut4.getThrowable(), instanceOf(NullPointerException.class));
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスが取得できること
		List<String> strList = new ArrayList<String>();
		strList.add("http://www.google.com");
		MessengerInitializeException sut5 = new MessengerInitializeException(M0001, strList, new NullPointerException());
		assertThat(sut5.getMessageObj(), is((MessageInterface)M0001));
		assertThat(sut5.getEmbeddedStrList().size(), is(1));
		assertThat(sut5.getEmbeddedStrList().get(0), is("http://www.google.com"));
		assertThat(sut5.getThrowable(), instanceOf(NullPointerException.class));
		
		
		// メッセージオブジェクト、単一文字のみ指定して実行した場合
		// 指定の埋め込み文字列が取得できること
		// throwクラスが取得できること
		String[] strArray = {"http://www.google.com"};
		MessengerInitializeException sut6 = new MessengerInitializeException(M0001, strArray, new NullPointerException());
		assertThat(sut6.getMessageObj(), is((MessageInterface)M0001));
		assertThat(sut6.getEmbeddedStrList().size(), is(1));
		assertThat(sut6.getEmbeddedStrList().get(0), is("http://www.google.com"));
		assertThat(sut6.getThrowable(), instanceOf(NullPointerException.class));
	}

}
