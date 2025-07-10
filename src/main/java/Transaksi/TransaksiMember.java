package Transaksi;

import javafx.fxml.Initializable;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class TransaksiMember implements Initializable {
    private int IDtransaksiRuangan;
    private int IDmemberRuangan;
    private int IDruangan;
    private String namaTransaksiRuangan;
    private String notelpTransaksiRuangan;
    private int DiskonTR;
    private LocalDateTime tglTransaksiRuangan;
    private LocalDateTime jamMulai;
    private LocalDateTime jamSelesai;
    private double durasi;
    private double diskon;
    private double totalharga;
    private String statusTransaksi;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
