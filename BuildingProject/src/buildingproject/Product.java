
package buildingproject;

/**
 *
 * @author ANIS INFO
 */
public class Product {
    private int id;
    private String code;
    private String disignation;
    private float prix_unitaire;
    private String unite_de_mesure;
    private int disponibility;
    private String type;
    private float qte;
    private float sum;

    public Product() {
    }

    public Product(String code, String disignation, float prix_unitaire, String unite_de_mesure, int disponibility) {
        this.code = code;
        this.disignation = disignation;
        this.prix_unitaire = prix_unitaire;
        this.unite_de_mesure = unite_de_mesure;
        this.disponibility = disponibility;
        this.qte = 1;
        this.sum = this.qte * this.prix_unitaire;
    }
    
    

    public Product(String code, String disignation, float prix_unitaire, String unite_de_mesure, int disponibility, String type, float qte) {
        
        this.code = code;
        this.disignation = disignation;
        this.prix_unitaire = prix_unitaire;
        this.unite_de_mesure = unite_de_mesure;
        this.disponibility = disponibility;
        this.type = type;
        this.qte = qte;
        this.sum = this.qte * this.prix_unitaire;
    }

    public Product(String code, String disignation, float prix_unitaire, String unite_de_mesure, int disponibility, float qte) {
        this.code = code;
        this.disignation = disignation;
        this.prix_unitaire = prix_unitaire;
        this.unite_de_mesure = unite_de_mesure;
        this.disponibility = disponibility;
        this.qte = qte;
        this.sum = sum;
        this.sum = this.qte * this.prix_unitaire;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDisignation() {
        return disignation;
    }

    public float getPrix_unitaire() {
        return prix_unitaire;
    }

    public String getUnite_de_mesure() {
        return unite_de_mesure;
    }

    public int getDisponibility() {
        return disponibility;
    }

    public String getType() {
        return type;
    }

    public float getQte() {
        return qte;
    }

    public float getSum() {
        return sum;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDisignation(String disignation) {
        this.disignation = disignation;
    }

    public void setPrix_unitaire(float prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public void setUnite_de_mesure(String unite_de_mesure) {
        this.unite_de_mesure = unite_de_mesure;
    }

    public void setDisponibility(int disponibility) {
        this.disponibility = disponibility;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQte(float qte) {
        this.qte = qte;
        this.sum = this.prix_unitaire * this.qte;
    }

    public void setSum(float sum) {
        this.sum = this.qte * this.prix_unitaire;
    }
    
    
    
    
}
