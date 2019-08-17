package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utils.ClassUtil;

public class UtilBean implements Serializable {

	private String dir = "ltr";
	private String lang = "fr";

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String activeAR() {
		ClassUtil.arabic();
		return null;
	}

	public String activeFR() {
		ClassUtil.francais();
		return null;
	}

}
