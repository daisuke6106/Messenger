package jp.co.dk.messenger;

import static org.junit.Assert.*;
import jp.co.dk.messenger.MessegeManager;

import org.junit.Test;

public class MessegeManagerTest {

	@Test
	public void constractor() {
		MessegeManager sut = new MessegeManager();
		assertNotNull(sut.messangerList);
	}

}
