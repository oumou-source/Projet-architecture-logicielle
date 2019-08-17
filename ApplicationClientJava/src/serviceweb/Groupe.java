
package serviceweb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for groupe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="groupe">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="etat" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="listPersonnels" type="{http://serviceWeb/}user" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listeFonctionnalite" type="{http://serviceWeb/}fonctionnalite" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="nom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "groupe", propOrder = {
    "description",
    "etat",
    "id",
    "listPersonnels",
    "listeFonctionnalite",
    "nom",
    "supprime"
})
public class Groupe {

    protected String description;
    protected int etat;
    protected Integer id;
    @XmlElement(nillable = true)
    protected List<User> listPersonnels;
    @XmlElement(nillable = true)
    protected List<Fonctionnalite> listeFonctionnalite;
    protected String nom;
    protected int supprime;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
     * Gets the value of the listPersonnels property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listPersonnels property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListPersonnels().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link User }
     * 
     * 
     */
    public List<User> getListPersonnels() {
        if (listPersonnels == null) {
            listPersonnels = new ArrayList<User>();
        }
        return this.listPersonnels;
    }

    /**
     * Gets the value of the listeFonctionnalite property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listeFonctionnalite property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListeFonctionnalite().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fonctionnalite }
     * 
     * 
     */
    public List<Fonctionnalite> getListeFonctionnalite() {
        if (listeFonctionnalite == null) {
            listeFonctionnalite = new ArrayList<Fonctionnalite>();
        }
        return this.listeFonctionnalite;
    }

    /**
     * Gets the value of the nom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNom() {
        return nom;
    }

    /**
     * Sets the value of the nom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNom(String value) {
        this.nom = value;
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
