package jp.co.dk.messenger;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	/* jp.co.dk.messanger */
	jp.co.dk.messenger.MessegeManagerTest.class, 
	jp.co.dk.messenger.MessengerTest.class, 
	
	/* jp.co.dk.messenger.exception */
	jp.co.dk.messenger.exception.MessengerExceptionTest.class, 
	jp.co.dk.messenger.exception.MessengerFatalExceptionTest.class, 
})
public class AllTest {}
