package Transaksi;

import java.time.LocalDateTime;

public class TransaksiRuangan {
    private int IDtransaksiRuangan;
    private int IDkaryawan;
    private int IDmemberRuangan;
    private int IDruangan;
    private String namaTransaksiRuangan;
    private String notelpTransaksiRuangan;
    private LocalDateTime tglTransaksiRuangan;
    private LocalDateTime jamMulai;
    private LocalDateTime jamSelesai;
    private double durasi;
    private double diskon;
    private double totalharga;
    private String statusTransaksi;

    public TransaksiRuangan(int IDkaryawan, int IDruangan, LocalDateTime tglTransaksiRuangan, int IDmemberRuangan, String namaTransaksiRuangan, String notelpTransaksiRuangan, LocalDateTime jamMulai, LocalDateTime jamSelesai, double diskon, String statusTransaksi) {
        this.IDkaryawan = IDkaryawan;
        this.IDruangan = IDruangan;
        this.tglTransaksiRuangan = tglTransaksiRuangan;
        this.IDmemberRuangan = IDmemberRuangan;
        this.namaTransaksiRuangan = namaTransaksiRuangan;
        this.notelpTransaksiRuangan = notelpTransaksiRuangan;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.diskon = diskon;
        this.statusTransaksi = statusTransaksi;
    }

    public int getIDtransaksiRuangan() {
        return IDtransaksiRuangan;
    }

    public void setIDtransaksiRuangan(int IDtransaksiRuangan) {
        this.IDtransaksiRuangan = IDtransaksiRuangan;
    }

    public int getIDkaryawan() {
        return IDkaryawan;
    }

    public void setIDkaryawan(int IDkaryawan) {
        this.IDkaryawan = IDkaryawan;
    }

    public int getIDmemberRuangan() {
        return IDmemberRuangan;
    }

    public void setIDmemberRuangan(int IDmemberRuangan) {
        this.IDmemberRuangan = IDmemberRuangan;
    }

    public int getIDruangan() {
        return IDruangan;
    }

    public void setIDruangan(int IDruangan) {
        this.IDruangan = IDruangan;
    }

    public String getNamaTransaksiRuangan() {
        return namaTransaksiRuangan;
    }

    public void setNamaTransaksiRuangan(String namaTransaksiRuangan) {
        this.namaTransaksiRuangan = namaTransaksiRuangan;
    }

    public String getNotelpTransaksiRuangan() {
        return notelpTransaksiRuangan;
    }

    public void setNotelpTransaksiRuangan(String notelpTransaksiRuangan) {
        this.notelpTransaksiRuangan = notelpTransaksiRuangan;
    }

    public LocalDateTime getTglTransaksiRuangan() {
        return tglTransaksiRuangan;
    }

    public void setTglTransaksiRuangan(LocalDateTime tglTransaksiRuangan) {
        this.tglTransaksiRuangan = tglTransaksiRuangan;
    }

    public LocalDateTime getJamMulai() {
        return jamMulai;
    }

    public void setJamMulai(LocalDateTime jamMulai) {
        this.jamMulai = jamMulai;
    }

    public LocalDateTime getJamSelesai() {
        return jamSelesai;
    }

    public void setJamSelesai(LocalDateTime jamSelesai) {
        this.jamSelesai = jamSelesai;
    }

    public double getDurasi() {
        return durasi;
    }

    public void setDurasi(double durasi) {
        this.durasi = durasi;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
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
