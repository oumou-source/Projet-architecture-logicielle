
package serviceweb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for user complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="user">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="etat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="groupe" type="{http://serviceWeb/}groupe" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nomPrenom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="supprime" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "user", propOrder = {
    "connected",
    "etat",
    "groupe",
    "id",
    "login",
    "nomPrenom",
    "password",
    "supprime"
})
public class User {

    protected boolean connected;
    protected int etat;
    protected Groupe groupe;
    protected Integer id;
    protected String login;
    protected String nomPrenom;
    protected String password;
    protected int supprime;

    /**
     * Gets the value of the connected property.
     * 
     */
    public boolean isConnected() {
        return connected;
    }

    /**
     * Sets the value of the connected property.
     * 
     */
    public void setConnected(boolean value) {
        this.connected = value;
    }

    /**
     * Gets the value of the etat property.
     * 
     */
    public int getEtat() {
        return etat;
    }

    /**
     * Sets the value of the etat property.
     * 
     */
    public void setEtat(int value) {
        this.etat = value;
    }

    /**
     * Gets the value of the groupe property.
     * 
     * @return
     *     possible object is
     *     {@link Groupe }
     *     
     */
    public Groupe getGroupe() {
        return groupe;
    }

    /**
     * Sets the value of the groupe property.
     * 
     * @param value
     *     allowed object is
     *     {@link Groupe }
     *     
     */
    public void setGroupe(Groupe value) {
        this.groupe = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the nomPrenom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomPrenom() {
        return nomPrenom;
    }

    /**
     * Sets the value of the nomPrenom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomPrenom(String value) {
        this.nomPrenom = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the supprime property.
     * 
     */
    public int getSupprime() {
        return supprime;
    }

    /**
     * Sets the value of the supprime property.
     * 
     */
    public void setSupprime(int value) {
        this.supprime = value;
    }

}
