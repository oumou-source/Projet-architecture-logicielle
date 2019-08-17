package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;


import models.Fonctionnalite;
import models.Groupe;
import models.User;

import org.apache.catalina.startup.SetAllPropertiesRule;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.primefaces.model.DualListModel;

import services.IGenericService;
import services.IUserServise;
import utils.ClassUtil;

@ManagedBean(name = "userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean ajouterGroupe = false;
	private boolean zoneGroupe = false;
	private boolean ajouterPersonnel = false;
	private boolean zoneUsers = false;

	private boolean fGesArticles = false;
	private boolean fGesCategories = false;
	private boolean fGesGroupes = false;
	private boolean fGesUsers = false;
	
	private boolean fGestion = false;
	
	private boolean fSupprimer = false;
	private boolean fModifier = false;
	private boolean supperAdmin ;


	static Logger logger = Logger.getLogger(UserBean.class);

	@ManagedProperty(value = "#{userService}")
	private IUserServise userServise;

	@ManagedProperty(value = "#{genericService}")
	private IGenericService genericService;

	private User user = new User();
	private List<User> users = new ArrayList<User>();
	private Groupe groupe = new Groupe();
	private User newUser = new User();
	
	private DualListModel<String> fonnctionnalites;
	private List<Groupe> listGroupe = new ArrayList<Groupe>();

	private List<SelectItem> listItemGroupe = new ArrayList<SelectItem>();
	private List<SelectItem> listFonction = new ArrayList<SelectItem>();
	private String lastPassword;
	private static String ville;

	@PostConstruct
	public void init() {
		// user = new User();
		updateListe();
	}

	/**
	 * Mettre à jours les listes des utilid=sateurs, groupes et fonctionnalités
	 */
	private void updateListe() {
		List<String> source = new ArrayList<String>();
		List<String> target = new ArrayList<String>();

		List<Object> list = genericService.getAllObject(Fonctionnalite.class);

		for (Object ob : list)
			source.add(((Fonctionnalite) ob).getDescription());

		fonnctionnalites = new DualListModel<String>(source, target);

		displayGroupes();
		displayUsers();

		logger.info("Liste initialisée");
	}

	public String login() {
		logger.info("Try to login");
		String summary = "";
		String detail = "";
		try {
			allFonctionnaltesFalse();

			user.setPassword(ClassUtil.getEncodedPassword(user.getPassword()));
			user = userServise.connect(user);

			if (user != null && StringUtils.isNotEmpty(user.getNomPrenom())) {
				user.setConnected(true);
				if (user.getGroupe().getNom().trim().toUpperCase().equals("SUPER ADMINISTRATEUR")) {
					supperAdmin = true;
					allFonctionnaltesTrue();
				} else {
					logger.info("User Groupe ID " + user.getGroupe().getId() + " SIZE "
							+ user.getGroupe().getListeFonctionnalite().size());

					List<Object> list = genericService.getAllObject(Fonctionnalite.class);
					List<Fonctionnalite> fonctionnalites = new ArrayList<Fonctionnalite>();

					for (Object ob : list)
						fonctionnalites.add((Fonctionnalite) ob);
					Groupe g = (Groupe) genericService.getObject(Groupe.class, user.getGroupe().getId());
					for (Fonctionnalite f : g.getListeFonctionnalite()) {
						
					  logger.info("User Fonctionnalité " + f.getNom());
					  if (f.getNom().equals("fGestion"))
							setfGestion(true);
						if (f.getNom().equals("fGesArticles"))
							setfGesArticles(true);
						if (f.getNom().equals("fGesCategories"))
							setfGesCategories(true);
						if (f.getNom().equals("fGesGroupes"))
							setfGesGroupes(true);
						if (f.getNom().equals("fGesUsers"))
							setfGesUsers(true);
						if (f.getNom().equals("fSupprimer"))
							setfSupprimer(true);
						if (f.getNom().equals("fModifier"))
							setfSupprimer(true);
					}
				}
				logger.info(user.getNomPrenom() + " CONNECTED");
			} else {
				// Envoyer un message de validation au client
				summary = ClassUtil.msg.getString("validation.authent");
				ClassUtil.showMessage(FacesMessage.SEVERITY_ERROR, summary, null, null);
				// On initialise pour la prochaine authentification
				user = new User();
				return null;
			}
			logger.info("Try to redirect to index page");
			return ClassUtil.ACCUEIL;
		} catch (Exception e) {
			e.printStackTrace();
			ClassUtil.showMessage(FacesMessage.SEVERITY_INFO, summary, detail, null);
			return null;
		}
	}

	public String logout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
		user.setConnected(false);
		return ClassUtil.LOGIN;
	}

	public String addGroupe() {
		groupe = new Groupe();
		allFalse();
		setAjouterGroupe(true);
		return ClassUtil.USERS_PAGE;
	}

	public String listeGroupes() {
		allFalse();
		setZoneGroupe(true);
		return ClassUtil.USERS_PAGE;
	}

	public String listUsers() {
		updateListe();
		if (listItemGroupe.isEmpty()) {
			listItemGroupe = genericService.listItemGeneric(Groupe.class, 6);
		}
		if (listFonction.isEmpty()) {
			listFonction = genericService.listItemGeneric(Fonctionnalite.class, 5);
		}

		allFalse();
		setZoneUsers(true);
		return ClassUtil.USERS_PAGE;
	}

	public String addUser() {
		updateListe();
		newUser = new User();

		if (listItemGroupe.isEmpty()) {
			listItemGroupe = genericService.listItemGeneric(Groupe.class, 6);
		}
		if (listFonction.isEmpty()) {
			listFonction = genericService.listItemGeneric(Fonctionnalite.class, 5);
		}

		allFalse();
		setAjouterPersonnel(true);
		return ClassUtil.USERS_PAGE;
	}

	public String editUser(int idUser) {
		newUser = (User) genericService.getObject(User.class, idUser);
		lastPassword = newUser.getPassword();
		listItemGroupe = genericService.listItemGeneric(Groupe.class, 6);
		allFalse();
		setAjouterPersonnel(true);
		return ClassUtil.USERS_PAGE;
	}

	public String saveUser() {
		if (newUser.getId() == null && (newUser.getPassword() == null || newUser.getPassword().equals(""))) {
			ClassUtil.showMessage(FacesMessage.SEVERITY_FATAL, "Erreur ! Mot de passe vide", null, null);
			return null;
		}

		if (newUser.getId() == null && userServise.find(newUser.getLogin()) != null) {
			ClassUtil.showMessage(FacesMessage.SEVERITY_FATAL, "Nom d'utilisateur existe déjas !", null, null);
			return null;
		}

		if (newUser.getPassword() == null || newUser.getPassword().trim().equals("")) {
			newUser.setPassword(lastPassword);
		} else {
			newUser.setPassword(ClassUtil.getEncodedPassword(newUser.getPassword()));
		}
		genericService.saveOrUpdateObject(newUser);
		ClassUtil.showMessage(FacesMessage.SEVERITY_INFO, ClassUtil.msg.getString("data_saved"), null, null);
		newUser = new User();
		updateListe();

		allFalse();
		if (isfGesUsers()) {
			setZoneUsers(true);
			return ClassUtil.USERS_PAGE;
		} else {
			return ClassUtil.ACCUEIL;
		}

	}

	public String saveGroupe() {

		List<Object> list = genericService.getAllObject(Fonctionnalite.class);
		List<Fonctionnalite> listeFoncts = new ArrayList<Fonctionnalite>();

		for (String st : fonnctionnalites.getTarget()) {
			for (Object f : list) {
				if (st.equals(((Fonctionnalite) f).getDescription())) {
					listeFoncts.add(((Fonctionnalite) f));
				}
			}
		}

		if (groupe.getId() != null && groupe.getEtat() == 1) {
			for (User user : groupe.getListPersonnels()) {
				user.setEtat(1);
				genericService.updateObject(user);
			}
		}
		groupe.setListeFonctionnalite(listeFoncts);
		genericService.saveOrUpdateObject(groupe);

		groupe = new Groupe();
		displayGroupes();
		ClassUtil.showMessage(FacesMessage.SEVERITY_INFO, ClassUtil.msg.getString("data_saved"), null, null);
		allFalse();
		setZoneGroupe(true);
		updateListe();
		fonnctionnalites.setTarget(new ArrayList<String>());
		return ClassUtil.USERS_PAGE;
	}

	public String editGroupe(int idGroupe) {
		List<String> source = new ArrayList<String>();
		List<String> target = new ArrayList<String>();

		groupe = (Groupe) genericService.getObject(Groupe.class, idGroupe);

		if (groupe.getNom().trim().toUpperCase().equals("SUPER ADMINISTRATEUR")) {
			ClassUtil.showMessage(FacesMessage.SEVERITY_ERROR,
					"Le groupe Super Administrateur ne peut pas être modifié", null, null);
			groupe = new Groupe();
			return null;
		}

		List<Object> objetFonctionnalites = getGenericService().getAllObject(Fonctionnalite.class);
		List<Fonctionnalite> listeFoncts = new ArrayList<Fonctionnalite>();

		for (Object ob : objetFonctionnalites) {
			listeFoncts.add((Fonctionnalite) ob);
		}

		for (Fonctionnalite f : listeFoncts) {
			boolean exist = false;
			for (Fonctionnalite f2 : groupe.getListeFonctionnalite()) {
				if (f.getId() == f2.getId()) {
					exist = true;
					break;
				}
			}

			if (!exist)
				source.add(f.getDescription());

		}

		for (Fonctionnalite f : groupe.getListeFonctionnalite())
			target.add(f.getDescription());

		fonnctionnalites = new DualListModel<String>(source, target);
		allFalse();
		setAjouterGroupe(true);
		return ClassUtil.USERS_PAGE;
	}

	public String displayUsers() {
		List<Object> objects = genericService.getAllObject(User.class);
		users = new ArrayList<User>();
		newUser = new User();
		for (Object o : objects) {
			if (((User) o).getSupprime() == 0)
				users.add((User) o);
		}
		return ClassUtil.USERS_PAGE;
	}

	public String displayGroupes() {
		List<Object> objects = genericService.getAllObject(Groupe.class);
		listGroupe = new ArrayList<Groupe>();
		groupe = new Groupe();
		for (Object o : objects) {
			listGroupe.add((Groupe) o);
		}
		return ClassUtil.USERS_PAGE;
	}

	public void deletUtilisateur(int idUser) {
		newUser = (User) genericService.getObject(User.class, idUser);
		newUser.setSupprime(1);
		genericService.saveOrUpdateObject(newUser);

		ClassUtil.showMessage(FacesMessage.SEVERITY_INFO, "L'utilisateur est Supprimé", null, null);

		int i = 0;
		for (User us : users) {
			if (us.getId() == newUser.getId()) {
				break;
			}
			i++;
		}
		users.remove(i);
	}

	public String deletGroupe(int idGroupe) {
		groupe = (Groupe) genericService.getObject(Groupe.class, idGroupe);
		if (groupe.getNom().trim().toUpperCase().equals("SUPER ADMINISTRATEUR")) {
			ClassUtil.showMessage(FacesMessage.SEVERITY_ERROR,
					"Le groupe Super Administrateur ne peut pas être modifié", null, null);
			groupe = new Groupe();
			return null;
		}
		groupe.setSupprime(1);
		genericService.saveOrUpdateObject(groupe);

		ClassUtil.showMessage(FacesMessage.SEVERITY_INFO, "Le Groupe est Supprimé", null, null);

		int i = 0;
		for (Groupe gr : listGroupe) {
			if (gr.getId() == groupe.getId()) {
				break;
			}
			i++;
		}
		listGroupe.remove(i);
		return ClassUtil.USERS_PAGE;

	}

	private void allFalse() {
		setAjouterGroupe(false);
		setAjouterPersonnel(false);
		setZoneGroupe(false);
		setZoneUsers(false);
	}

	private void allFonctionnaltesFalse() {
		setfGesArticles(false);
		setfGesCategories(false);
		setfGesGroupes(false);
		setfGesUsers(false);
		setfSupprimer(false);
		setfModifier(false);
		supperAdmin = false;

	}

	private void allFonctionnaltesTrue() {
		setfGesArticles(true);
		setfGesCategories(true);
		setfGesGroupes(true);
		setfGesUsers(true);
		setfGestion(true);
		setfSupprimer(true);
		setfModifier(true);


	}

	public static String getConnectedUserVille() {
		return ville;
	}


	public boolean isAjouterGroupe() {
		return ajouterGroupe;
	}

	public void setAjouterGroupe(boolean ajouterGroupe) {
		this.ajouterGroupe = ajouterGroupe;
	}

	public boolean isAjouterPersonnel() {
		return ajouterPersonnel;
	}

	public void setAjouterPersonnel(boolean ajouterPersonnel) {
		this.ajouterPersonnel = ajouterPersonnel;
	}

	public IUserServise getUserServise() {
		return userServise;
	}

	public void setUserServise(IUserServise userServise) {
		this.userServise = userServise;
	}

	public IGenericService getGenericService() {
		return genericService;
	}

	public void setGenericService(IGenericService genericService) {
		this.genericService = genericService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Groupe getGroupe() {
		return groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	public User getNewUser() {
		return newUser;
	}

	public void setNewUser(User newUser) {
		this.newUser = newUser;
	}

	public DualListModel<String> getFonnctionnalites() {
		return fonnctionnalites;
	}

	public void setFonnctionnalites(DualListModel<String> fonnctionnalites) {
		this.fonnctionnalites = fonnctionnalites;
	}

	public List<Groupe> getListGroupe() {
		return listGroupe;
	}

	public void setListGroupe(List<Groupe> listGroupe) {
		this.listGroupe = listGroupe;
	}

	public List<SelectItem> getListItemGroupe() {
		return listItemGroupe;
	}

	public void setListItemGroupe(List<SelectItem> listItemGroupe) {
		this.listItemGroupe = listItemGroupe;
	}

	public List<SelectItem> getListFonction() {
		return listFonction;
	}

	public void setListFonction(List<SelectItem> listFonction) {
		this.listFonction = listFonction;
	}

	public boolean isfGesGroupes() {
		return fGesGroupes;
	}

	public void setfGesGroupes(boolean fGesGroupes) {
		this.fGesGroupes = fGesGroupes;
	}

	public boolean isfGesUsers() {
		return fGesUsers;
	}

	public void setfGesUsers(boolean fGesUsers) {
		this.fGesUsers = fGesUsers;
	}

	

	public boolean isZoneGroupe() {
		return zoneGroupe;
	}

	public void setZoneGroupe(boolean zoneGroupe) {
		this.zoneGroupe = zoneGroupe;
	}

	public boolean isZoneUsers() {
		return zoneUsers;
	}

	public void setZoneUsers(boolean zoneUsers) {
		this.zoneUsers = zoneUsers;
	}

	

	public boolean isfGestion() {
		return fGestion;
	}

	public void setfGestion(boolean fGestion) {
		this.fGestion = fGestion;
	}

		public boolean isfSupprimer() {
		return fSupprimer;
	}

	public boolean isfGesArticles() {
			return fGesArticles;
		}

		public void setfGesArticles(boolean fGesArticles) {
			this.fGesArticles = fGesArticles;
		}

		

	public boolean isfGesCategories() {
			return fGesCategories;
		}

		public void setfGesCategories(boolean fGesCategories) {
			this.fGesCategories = fGesCategories;
		}

	public void setfSupprimer(boolean fSupprimer) {
		this.fSupprimer = fSupprimer;
	}

	public boolean isfModifier() {
		return fModifier;
	}

	public void setfModifier(boolean fModifier) {
		this.fModifier = fModifier;
	}

	public boolean isSupperAdmin() {
		return supperAdmin;
	}

	public void setSupperAdmin(boolean isSupperAdmin) {
		this.supperAdmin = isSupperAdmin;
	}

	
}
