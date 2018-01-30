package e.itsadmin.appmedica44;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class Ambulatorio {
    private int id;
    private int latitudine;
    private int longitudine;


    public Ambulatorio(int id, int latitudine, int longitudine) {
        this.id = id;
        this.latitudine = latitudine;
        this.longitudine = longitudine;

    }
    public Ambulatorio( int latitudine, int longitudine) {

        this.latitudine = latitudine;
        this.longitudine = longitudine;

    }
    public Ambulatorio() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLatitudine() {
        return latitudine;
    }

    public void setLatitudine(int latitudine) {
        this.latitudine = latitudine;
    }

    public int getLongitudine() {
        return longitudine;
    }

    public void setLongitudine(int longitudine) {
        this.longitudine = longitudine;
    }
}