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

public class Item implements Initializable {
    @FXML
    private AnchorPane itemPane;

    @FXML
    private HBox itemHBox;

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
    public Label harga_lbl;

    @FXML
    private Button btnEdit;

    @FXML
    private Button btnHapus;

    private Ruangan ruangan;
    private DasHome dashome;
    private Karyawan karyawan;
    private Member member;
    private Menu menu;

    public void setData(Ruangan ruangan, DasHome dashome) {
        this.ruangan = ruangan;
        this.dashome = dashome;

        id_lbl.setText(String.valueOf(ruangan.getId_ruangan()));
        nama_lbl.setText(ruangan.getNama_ruangan());
        tipe_lbl.setText(ruangan.getTipe_ruangan());
        kapasitas_lbl.setText(ruangan.getKapasitas_ruangan());
        harga_lbl.setText("Rp.");
        tarif_lbl.setText(String.valueOf(ruangan.getTarif_ruangan()));

        btnEdit.setOnAction(event -> handleUpdate());
        btnHapus.setOnAction(event -> handleHapus());
    }

    public void setDataKar(Karyawan karyawan, DasHome dashome) {
        this.karyawan = karyawan;
        this.dashome = dashome;

        id_lbl.setText(String.valueOf(karyawan.getId_karyawan()));
        nama_lbl.setText(karyawan.getNama_karyawan());
        tipe_lbl.setText(karyawan.getNoTelp_karyawan());
        kapasitas_lbl.setText(karyawan.getUsername_karyawan());
        tarif_lbl.setText(karyawan.getRole_password());

        btnEdit.setOnAction(event -> handlleUpdatekaryawan());
        btnHapus.setOnAction(event -> handleHapusKaryawan());
    }

    public void setDataMember(Member member, DasHome dashome) {
        this.member = member;
        this.dashome = dashome;

        id_lbl.setText(String.valueOf(member.getIdMember()));
        nama_lbl.setText(member.getTipeMember());
        tipe_lbl.setText(String.valueOf(member.getDiskonMember()+" %"));
        kapasitas_lbl.setText(String.valueOf("Rp. "+member.getHargaMember()));
        tarif_lbl.setText("");

         btnEdit.setOnAction(event -> handleUpdateMember());
        btnHapus.setOnAction(event -> handleHapusMember());
    }

    public void setDataMenu(Menu menu, DasHome dashome){
        this.menu = menu;
        this.dashome = dashome;

        id_lbl.setText(String.valueOf(menu.getIdMenu()));
        nama_lbl.setText(menu.getNamaMenu());
        tipe_lbl.setText(menu.getKategoriMenu());
        kapasitas_lbl.setText(String.valueOf("Rp. "+menu.getHargaMenu())  );
        tarif_lbl.setText("");

        btnEdit.setOnAction(event -> handleUpdateMenu());
        btnHapus.setOnAction(event -> handleHapusMenu());
    }



    private void handleUpdate() {
        dashome.popUpdateRuangan(ruangan);
    }
    private void handlleUpdatekaryawan() {
        dashome.popUpdateKaryawan(karyawan);
    }
    private void handleUpdateMember(){
        dashome.popUpdateMember(member);
    }
    private void handleUpdateMenu(){
        dashome.popUpdateMenu(menu);
    }


    private void handleHapus() {
        dashome.hapusRuangan(ruangan);
    }
    private void handleHapusKaryawan(){
        dashome.hapusKaryawan(karyawan);
    }
    private void handleHapusMember(){
        dashome.hapusMember(member);
    }
    private void handleHapusMenu(){
        dashome.hapusMenu(menu);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
