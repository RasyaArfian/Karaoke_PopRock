package Transaksi;

import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TransaksiMember {
    private int IDtransaksiMember;
    private int IDmember;
    private String tipeMember;
    private String namaCustomer;
    private String notelpTransaksiRuangan;
    private Double DiskonTR;
    private LocalDateTime tglTransaksiMember;
    private double totalharga;
    private String statusTransaksi;

    public TransaksiMember() {
    }

    public TransaksiMember(int IDtransaksiMember, int IDmember, String tipeMember, String namaCustomer, String notelpTransaksiRuangan, Double diskonTR, LocalDateTime tglTransaksiMember, double totalharga, String statusTransaksi) {
        this.IDtransaksiMember = IDtransaksiMember;
        this.IDmember = IDmember;
        this.tipeMember = tipeMember;
        this.namaCustomer = namaCustomer;
        this.notelpTransaksiRuangan = notelpTransaksiRuangan;
        DiskonTR = diskonTR;
        this.tglTransaksiMember = tglTransaksiMember;
        this.totalharga = totalharga;
        this.statusTransaksi = statusTransaksi;
    }

    public TransaksiMember(int IDmember, String tipeMember, String namaCustomer, String notelpTransaksiRuangan, Double diskonTR, LocalDateTime tglTransaksiMember, double totalharga, String statusTransaksi) {
        this.IDmember = IDmember;
        this.tipeMember = tipeMember;
        this.namaCustomer = namaCustomer;
        this.notelpTransaksiRuangan = notelpTransaksiRuangan;
        DiskonTR = diskonTR;
        this.tglTransaksiMember = tglTransaksiMember;
        this.totalharga = totalharga;
        this.statusTransaksi = statusTransaksi;
    }

    public int getIDtransaksiMember() {
        return IDtransaksiMember;
    }

    public void setIDtransaksiMember(int IDtransaksiMember) {
        this.IDtransaksiMember = IDtransaksiMember;
    }

    public int getIDmember() {
        return IDmember;
    }

    public void setIDmember(int IDmember) {
        this.IDmember = IDmember;
    }

    public String getTipeMember() {
        return tipeMember;
    }

    public void setTipeMember(String tipeMember) {
        this.tipeMember = tipeMember;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNotelpTransaksiRuangan() {
        return notelpTransaksiRuangan;
    }

    public void setNotelpTransaksiRuangan(String notelpTransaksiRuangan) {
        this.notelpTransaksiRuangan = notelpTransaksiRuangan;
    }

    public Double getDiskonTR() {
        return DiskonTR;
    }

    public void setDiskonTR(Double diskonTR) {
        DiskonTR = diskonTR;
    }

    public LocalDateTime getTglTransaksiMember() {
        return tglTransaksiMember;
    }

    public void setTglTransaksiMember(LocalDateTime tglTransaksiMember) {
        this.tglTransaksiMember = tglTransaksiMember;
    }

    public double getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(double totalharga) {
        this.totalharga = totalharga;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }


}
