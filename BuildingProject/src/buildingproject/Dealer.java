
package buildingproject;

/**
 *
 * @author RJS
 */
public class Dealer {
    private int id;
    private String dealer_type;
    private String nome;
    private String prenome;
    private String ville;
    private String num_telephone;
    private float payments;
    private float dues;
    private int black_list;
    private String date;
    private String time;
    private String matricule;
    private int received;

    public Dealer(String nome, String prenome, float dues, String matricule, String num_telephone) {
        this.nome = nome;
        this.prenome = prenome;
        this.dues = dues;
        this.matricule = matricule;
        this.num_telephone = num_telephone;
    }
    
    

    public Dealer(String nome, String prenome, String ville, String num_telephone, float payments, float dues, int received,String date,String time) {
        this.nome = nome;
        this.prenome = prenome;
        this.ville = ville;
        this.num_telephone = num_telephone;
        this.payments = payments;
        this.dues = dues;
        this.received = received;
        this.matricule = this.nome.substring(0, 1).toUpperCase()+this.prenome.substring(0, 1)+date.replace("-", "")+time.replace(":", "");
    }

    public Dealer() {
    }

    public int getId() {
        return id;
    }

    public String getDealer_type() {
        return dealer_type;
    }

    public String getNome() {
        return nome;
    }

    public String getPrenome() {
        return prenome;
    }

    public String getVille() {
        return ville;
    }

    public String getNum_telephone() {
        return num_telephone;
    }

    public float getPayments() {
        return payments;
    }

    public float getDues() {
        return dues;
    }

    public int getBlack_list() {
        return black_list;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getMatricule() {
        return matricule;
    }

    public int getReceived() {
        return received;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDealer_type(String dealer_type) {
        this.dealer_type = dealer_type;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPrenome(String prenome) {
        this.prenome = prenome;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setNum_telephone(String num_telephone) {
        this.num_telephone = num_telephone;
    }

    public void setPayments(float payments) {
        this.payments = payments;
    }

    public void setDues(float dues) {
        this.dues = dues;
    }

    public void setBlack_list(int black_list) {
        this.black_list = black_list;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMatriclue(String matricule) {
        this.matricule = matricule;
    }

    public void setReceived(int received) {
        this.received = received;
    }
    
}
