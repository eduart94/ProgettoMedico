package e.itsadmin.appmedica44;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class Citta {
    private int id;
    private String nome;
    private String paese;


    public Citta(int id, String nome, String paese) {
        this.id = id;
        this.nome = nome;
        this.paese = paese;
    }
    public Citta( String nome, String paese) {

            this.nome = nome;
            this.paese = paese;
    }
    public Citta( ) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }
}
