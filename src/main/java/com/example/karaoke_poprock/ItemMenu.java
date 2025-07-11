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

public class ItemMenu implements Initializable {
    @FXML
    private AnchorPane itemTransPane;

    @FXML
    private HBox itemTransHBox;

    @FXML
    public Label lblidMenu;
    @FXML
    public Label lblNamaMenu;
    @FXML
    public Label lblTipeMenu;
    @FXML
    public Label lblHargaMenu;
    @FXML
    public Label status_lbl;

    @FXML
    private Button btnTambah;

    private Menu menu;
    private DasTransaksi trns;
    private Karyawan karyawan;
    private Member member;

    public void setDataTransaksiMenu(Menu menu, DasTransaksi transaksi) {
        this.menu = menu;
        this.trns = transaksi;

        lblidMenu.setText(String.valueOf(menu.getIdMenu()));
        lblNamaMenu.setText(menu.getNamaMenu());
        lblTipeMenu.setText(menu.getKategoriMenu());
        lblHargaMenu.setText(String.valueOf(menu.getHargaMenu()));
        //status_lbl.setText(ruangan.getStatus());

        btnTambah.setOnAction(event -> handleRuangan());
    }

    public void handleRuangan(){
        trns.cekMenu(menu);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
