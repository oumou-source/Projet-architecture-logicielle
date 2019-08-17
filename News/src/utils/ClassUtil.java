package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import beans.UtilBean;

public class ClassUtil {

	static Logger logger = Logger.getLogger(ClassUtil.class);

	public final static String ACCUEIL = "ACCUEIL";
	public final static String MANAGER = "MANAGER";
	public final static String LOGIN = "LOGIN";
	public final static String USERS_PAGE = "USERS_PAGE";
	public final static String PARAMETER = "PARAMETER";

	public final static ResourceBundle sql = ResourceBundle.getBundle("sql");
	public final static ResourceBundle conf = ResourceBundle.getBundle("conf");
	public final static ResourceBundle msg = ResourceBundle
			.getBundle("messages_fr");

	public static void showMessage(Severity serverity, String summary,
			String detail, String id) {
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(serverity);
		facesMessage.setSummary(summary);
		facesMessage.setDetail(detail);
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(id, facesMessage);
	}

	public static void francais() {
		UtilBean utilBean = (UtilBean) getSession("utilBean");
		utilBean.setDir("ltr");
		utilBean.setLang("fr");
		ClassUtil.putSession("utilBean", utilBean);
		FacesContext current = FacesContext.getCurrentInstance();
		current.getViewRoot().setLocale(Locale.FRENCH);
		current.renderResponse();
	}

	public static void arabic() {
		UtilBean utilBean = (UtilBean) getSession("utilBean");
		utilBean.setDir("rtl");
		utilBean.setLang("ar");
		ClassUtil.putSession("utilBean", utilBean);
		FacesContext current = FacesContext.getCurrentInstance();
		current.getViewRoot().setLocale(new Locale("ar"));
		current.renderResponse();
	}

	// Get Session
	public static Object getSession(String bean) {
		FacesContext fc = FacesContext.getCurrentInstance();
		Object beanObject = (Object) fc.getExternalContext().getSessionMap()
				.get(bean);
		return beanObject;
	}

	// add Session
	public static void putSession(String bean, Object beanObject) {
		FacesContext fc = FacesContext.getCurrentInstance();
		fc.getExternalContext().getSessionMap().put(bean, beanObject);
	}

	// Get Request
	public static String getRequest(String name) {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String result = request.getParameter(name).toString();
		return null; // result;
	}

	public static String getEncodedPassword(String key) {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}

		return hashString.toString();

	}
	
	public static void showPopUp(String popUpName){
		RequestContext ctx = RequestContext.getCurrentInstance();
		ctx.execute("PF('"+popUpName+"').show()");
	}
	
	public static void closePopUp(String popUpName){
		RequestContext ctx = RequestContext.getCurrentInstance();
		ctx.execute("PF('"+popUpName+"').hide()");
	}

}
