package e.itsadmin.appmedica44;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by itsadmin on 29/01/2018.
 */

public class SlotCalendar {
    private int id;
    private Date data;
    private String ora;

    public SlotCalendar(){

    }
    public SlotCalendar(int id, Date data, String ora){
        this.id= id;
        this.data= data;

        this.ora= ora;

    }
    public SlotCalendar( Date data, String ora){

        this.data= data;
        this.ora= ora;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }


}
