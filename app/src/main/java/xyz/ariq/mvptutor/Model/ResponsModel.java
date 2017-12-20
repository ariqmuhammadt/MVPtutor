package xyz.ariq.mvptutor.Model;

/**
 * Created by AriqMT on 20/12/2017.
 */

public class ResponsModel {
    String pesan;
    int kode;

    public ResponsModel(String pesan, int kode) {
        this.pesan = pesan;
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public int getKode() {
        return kode;
    }

        public void setKode(int kode) {
        this.kode = kode;
    }

}
