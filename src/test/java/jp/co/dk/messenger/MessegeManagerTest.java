package jp.co.dk.messenger;

import static jp.co.dk.messenger.messege.MessengerMessege.ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE;
import static org.junit.Assert.*;

import java.util.ArrayList;

import jp.co.dk.messenger.MessegeManager;
import jp.co.dk.messenger.mail.Mail;
import jp.co.dk.messenger.property.MessengerProperty;
import jp.co.dk.property.Property;
import jp.co.dk.messenger.exception.MessengerInitializeException;
import jp.co.dk.messenger.exception.MessengerSendException;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class MessegeManagerTest {

	public static class コンストラクタ extends MessengerFoundationTest {
		@Test
		public void プロパティのメッセンジャークラス一覧に何も設定されていなかった場合正常にインスタンスが生成されること() {
			try {
				MessegeManager sut = new MessegeManager(){
					@Override
					protected java.util.List<String> getMessengerClass() {
						java.util.List<String> propertyList = new ArrayList<String>();
						return propertyList;
					}
				};
				assertNotNull(sut.messangerList);
				assertThat(sut.messangerList.size(), is(0));
			} catch (MessengerInitializeException e){
				fail(e);
			}
		}
		
		@Test
		public void プロパティのメッセンジャークラス一覧に不正なクラスが設定されていた場合例外が発生すること() {
			try {
				MessegeManager sut = new MessegeManager(){
					@Override
					protected java.util.List<String> getMessengerClass() {
						java.util.List<String> propertyList = new ArrayList<String>();
						propertyList.add("DummyClass");
						return propertyList;
					}
				};
				fail();
			} catch (MessengerInitializeException e){
				assertEquals(e.getMessageObj(), ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE);
			}
		}
		
		@Test
		public void プロパティのメッセンジャークラス一覧にメッセンジャーインターフェースを実装していないクラスが設定されていた場合例外が発生すること() {
			try {
				MessegeManager sut = new MessegeManager(){
					@Override
					protected java.util.List<String> getMessengerClass() {
						java.util.List<String> propertyList = new ArrayList<String>();
						propertyList.add("DummyMessenger01");
						return propertyList;
					}
				};
				fail();
			} catch (MessengerInitializeException e){
				assertEquals(e.getMessageObj(), ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE);
			}
		}
		
		@Test
		public void プロパティのメッセンジャークラス一覧にメッセンジャーインターフェースを実装しているがデフォルトコンストラクタが存在しないクラスが設定されていた場合例外が発生すること() {
			try {
				MessegeManager sut = new MessegeManager(){
					@Override
					protected java.util.List<String> getMessengerClass() {
						java.util.List<String> propertyList = new ArrayList<String>();
						propertyList.add("DummyMessenger02");
						return propertyList;
					}
				};
				fail();
			} catch (MessengerInitializeException e){
				assertEquals(e.getMessageObj(), ERROR_CAN_NOT_CREATE_MESSENGER_INSTANCE);
			}
		}
	}

}

class DummyMessenger01 {
	
}

class DummyMessenger02 implements Messenger{
	
	DummyMessenger02(String arg) {}
	
	@Override
	public void send(Messege message) throws MessengerSendException {}
	
}