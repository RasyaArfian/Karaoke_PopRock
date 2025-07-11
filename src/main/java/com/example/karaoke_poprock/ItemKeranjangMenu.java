package com.example.karaoke_poprock;

import Master.Karyawan;
import Master.Member;
import Master.keranjangMenu;
import Master.Menu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class ItemKeranjangMenu implements Initializable {
    @FXML
    private AnchorPane itemTransPane;

    @FXML
    private HBox itemTransHBox;

    @FXML
    public Label lblpilihmeu;
    @FXML
    public Label lblnamamenu;
    @FXML
    public Label lblkategorimenu;
    @FXML
    public Label lblquantitymenu;

    @FXML
    private Button btnKurang;

    private keranjangMenu keranjangMenu;
    private Menu menu;
    private DasTransaksi trns;
    private Karyawan karyawan;
    private Member member;

    public void setDataTransaksiKeranjangMenu(keranjangMenu keranjangMenu, DasTransaksi transaksi) {
        this.keranjangMenu = keranjangMenu;
        this.trns = transaksi;

        lblpilihmeu.setText(String.valueOf(keranjangMenu.getIdMenu()));
        lblnamamenu.setText(keranjangMenu.getNamaMenu());
        lblkategorimenu.setText(keranjangMenu.getTipeMenu());
        lblquantitymenu.setText(keranjangMenu.getQuantity()+"x");

        btnKurang.setOnAction(event -> setKurang());
    }

public void setKurang(){
    trns.setQuantityMenu(keranjangMenu);
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
