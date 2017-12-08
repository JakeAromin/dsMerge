package co.nz.tsg.utils;

import java.util.Date;

public class Payment {

    private String id;
    private String date;
    private String ref;

    public Payment(String id, String date, String ref) {
        this.id = id;
        this.date = date;
        this.ref = ref;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

}
