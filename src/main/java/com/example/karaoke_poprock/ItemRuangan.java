package com.example.karaoke_poprock;

import Master.Karyawan;
import Master.Member;
import Master.Menu;
import Master.Ruangan;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemRuangan implements Initializable {
    @FXML
    private AnchorPane itemTransPane;

    @FXML
    private HBox itemTransHBox;

    @FXML
    public Label id_lbl;
    @FXML
    public Label nama_lbl;
    @FXML
    public Label tipe_lbl;
    @FXML
    public Label kapasitas_lbl;
    @FXML
    public Label tarif_lbl;
    @FXML
    public Label status_lbl;

    @FXML
    private Button btnTambah;

    private Ruangan ruangan;
    private DasTransaksi transaksi;
    private Karyawan karyawan;
    private Member member;
    private Menu menu;

    public void setDataTransaksiRuangan(Ruangan ruangan, DasTransaksi transaksi) {
        this.ruangan = ruangan;
        this.transaksi = transaksi;

        id_lbl.setText(String.valueOf(ruangan.getId_ruangan()));
        tipe_lbl.setText(ruangan.getTipe_ruangan());
        kapasitas_lbl.setText(ruangan.getKapasitas_ruangan());
        tarif_lbl.setText(String.valueOf(ruangan.getTarif_ruangan()));
        status_lbl.setText(ruangan.getStatus());

        btnTambah.setOnAction(event -> handleRuangan());
    }

    public void handleRuangan(){
            transaksi.cekRuangan(ruangan);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
