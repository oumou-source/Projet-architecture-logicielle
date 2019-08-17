package utils;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;


/**
* 
* Ce Listner assure la redirection après l'invaidation de la session
* 
**/

public class MySessionListener implements HttpSessionListener {

	static Logger logger = Logger.getLogger(MySessionListener.class);
	
	public MySessionListener() {
	}

	public void sessionCreated(HttpSessionEvent event) {
		logger.info("La session est créé : "+ event.getSession().getId()+ " a "+ new Date());
	}

	public void sessionDestroyed(HttpSessionEvent event) {
		// get the destroying session...
		HttpSession session = event.getSession();	
		logger.info("Current Session destroyed :"+ session.getId()+ " Logging out user...");	

		// Only if needed
		try {
			prepareLogoutInfoAndLogoutActiveUser(session);
		} catch(Exception e) {
			logger.error("Error while logging out at session destroyed : "+ e.getMessage());
		}
	}

	/**
	* Clean your logout operations.
	*/

	public void prepareLogoutInfoAndLogoutActiveUser(HttpSession httpSession) {
	// Only if needed
	}
}

