package com.example.karaoke_poprock;

import Master.*;
import Master.Menu;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DasHome implements Initializable {

    DBconnect connection = new DBconnect();

    //RUANGAN
    String namaR, tipeR, kapasitasR, statusR;
    int tarifR, idRuangan;
    //RUANGAN

    //KARYAWAN
    String namaKar, noTelpkar, userKar, passKar, roleKar;
    int idKar;
    //KARYAWAN

    //MEMBER
    String tipeMember;
    int diskonMember, hargaMember, idMember;

    //MENU
    String namaMenu, tipeMenu;
    int hargaMenu, idMenu;


    @FXML
    private Label dataRuangan;
    @FXML
    private Label dataMember;
    @FXML
    private Label dataMenu;



    @FXML
    private Label namaLbl;

    //CRUD untuk ruangan
    //CRUD untuk ruangan
    @FXML
    private TextField txtIdR;
    @FXML
    private TextField txtNamaR;
    @FXML
    private ComboBox txtTipeR;
    @FXML
    private TextField txtKapasitas;
    @FXML
    private TextField txtTarifR;
    @FXML
    private Button btnKembaliR;
    @FXML
    private Button btnTambahR;

    @FXML
    private Button btnUpdate;
    @FXML
    private TextField txtidRuanganUpdate;
    @FXML
    private TextField txtnamaUpdate;
    @FXML
    private ComboBox txttipeUpate;
    @FXML
    private TextField txtKapasitasUpdate;
    @FXML
    private TextField txtTarifUpdate;
    @FXML
    private Button btnKembaliUpdate;
    //CRUD untuk ruangan
    //CRUD untuk ruangan

    //CRUD UNTUK KARYAWAN
    //CRUD UNTUK KARYAWAN
    @FXML
    private TextField txtIdkaryawan;
    @FXML
    private TextField txtnamaKaryawan;
    @FXML
    private TextField txtNotelpkaryawan;
    @FXML
    private TextField txtUsernameKaryawan;
    @FXML
    private TextField txtPasswordKaryawaan;
    @FXML
    private ComboBox txtRoleKaryawan;

    @FXML
    private Button btnTambahKaryawan;

    @FXML
    private Button btnPilihTambahKaryawan;

    @FXML
    private Button btnKembaliKaryawan;

    @FXML
    private TextField txtUpdateIdkaryawan;
    @FXML
    private TextField txtUpdatenamaKaryawan;
    @FXML
    private TextField txtUpdateNotelpkaryawan;
    @FXML
    private TextField txtUpdateUsernameKaryawan;
    @FXML
    private TextField txtUpdatePasswordKaryawaan;
    @FXML
    private ComboBox txtUpdateRoleKaryawan;

    @FXML
    private Button btnUpdateKaryawan;
    //CRUD UNTUK KARYAWAN
    //CRUD UNTUK KARYAWAN

    //CRUD UNTUK MEMBER
    //CRUD UNTUK MEMBER
    @FXML
    private TextField txtIdMember;

    @FXML
    private TextField txtTipeMember;

    @FXML
    private TextField txtDiskonMember;

    @FXML
    private TextField txtHargaMember;

    @FXML
    private Button btnTambahMember;

    @FXML
    private Button btnKembaliMember;

    @FXML
    private Button btnPilihTambahMember;

    @FXML
    private TextField txtIUpdatedMember;

    @FXML
    private TextField txtUpdateTipeMember;

    @FXML
    private TextField txtUpdateDiskonMember;

    @FXML
    private TextField txtUpdateHargaMember;

    @FXML
    private Button btnKembaliUpdateMember;
    @FXML
    private Button btnKembaliMenu;
    @FXML
    private Button btnKembaliUpdateMenu;
    @FXML
    private Button btnKembaliUpdateKaryawan;



    @FXML
    private Button btnUpdateMember;
    //CRUD UNTUK MEMBER
    //CRUD UNTUK MEMBER

    //CRUD UNTUK MENU
    //CRUD UNTUK MENU

    @FXML
    private TextField txtIdMenu;

    @FXML
    private TextField txtNamaMenu;

    @FXML
    private ComboBox txtTipeMenu;

    @FXML
    private TextField txtHargaMenu;

    @FXML
    private Button btnKembaliMenuu;

    @FXML
    private Button btntambahMenu;

    @FXML
    private Button btnPilihTambahMenu;

    @FXML
    private TextField txtUpdateIdMenu;

    @FXML
    private TextField txtUpdateNamaMenu;

    @FXML
    private ComboBox txtUpdateTipeMenu;

    @FXML
    private TextField txtUpdateHargaMenu;

    @FXML
    private Button btnUpdateMenu;

    @FXML
    private Button btnkembaliUpdateMenu;


    //CRUD UNTUK MENU
    //CRUD UNTUK MENU

    @FXML
    private VBox dtRuangan = null;

    @FXML
    private VBox dtMember = null;


    //RUANGAN RUANGAN RUANGAN
    //RUANGAN RUANGAN RUANGAN
    @FXML
    private Pane pnlHome;
    @FXML
    private Pane pnlRuangan;
    @FXML
    private Pane pnltambahRuangan;
    @FXML
    private Pane pnlUpdateRuangan;
    @FXML
    private Pane pnlUpdateKaryawan;
    @FXML
    private Pane pnlUpdateMember;
    @FXML
    private Pane pnlUpdateMenu;

    @FXML
    private Button btnHome;
    @FXML
    private Button btnRuangan;
    @FXML
    private Button createRuangan;
    @FXML
    private ListView<Ruangan> viewRuangan;

    //KARYAWAN KARYAWAN KARYAWAN
    //KARYAWAN KARYAWAN KARYAWAN
    @FXML
    private Pane pnlKaryawan;
    @FXML
    private Pane pnlTambahKaryawan;

    @FXML
    private Button createkaryawan;

    @FXML
    private Button btnKaryawan;
    @FXML
    private ListView<Karyawan> viewKaryawan;

    //MEMBER MEMBER MEMBER
    //MEMBER MEMBER MEMBER
    @FXML
    private Pane pnlMember;

    @FXML
    private Pane pnlTambahMember;

    @FXML
    private Button createMember;

    @FXML
    private Button btnMember;

    @FXML
    private ListView<Member> viewMember;

    //MENU MENU MENU
    //MENU MENU MENU
    @FXML
    private Pane pnlMenu;

    @FXML
    private Pane pnlTambahMenu;

    @FXML
    private Button createMenu;

    @FXML
    private Button btnMenu;

    @FXML
    private ListView<Menu> viewMenu;

    //SEARCH SEARCH SEARCH
    //SEARCH SEARCH SEARCH
    @FXML
    private TextField txtsearchRuangan;
    @FXML
    private TextField txtsearchMenu;
    @FXML
    private TextField txtsearchKaryawan;
    // SEARCH SEARCH SEARCH
    // SEARCH SEARCH SEARCH


    DasLogin lgn = new DasLogin();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ComboTipeRuangan();
        ComboTipeUpdate();
        comboRoleKaryawan();
        comboUpdateRoleKaryawan();
        comboTipeMenu();
        comboUpdateTipeMenu();

        loadDataFromDatabase();
        loadDataFromDatabaseKaryawan();
        loadDataFromDatabaseMember();
        loadDataFromDatabaseMenu();

    }

    public void setName(String user){
        namaLbl.setText(user);
    }


    @FXML
    protected void ClickEventMouseEntered(){
        btnHome.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnHome.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnHome.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnHome.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnHome.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnRuangan.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnRuangan.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnRuangan.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnRuangan.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnRuangan.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnMember.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnMember.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnMember.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnMember.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnMember.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnMenu.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnMenu.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnMenu.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnMenu.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnMenu.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnKaryawan.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnKaryawan.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnKaryawan.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnKaryawan.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnKaryawan.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnExit.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnExit.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnExit.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnExit.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnExit.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
    }

    @FXML
    protected void hitungdataRuangan() {
        try{
            String sql = "SELECT COUNT(*) AS total FROM master_Ruangan";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            if (connection.result.next()) {
                int totalRuangan = connection.result.getInt("total");
                dataRuangan.setText(String.valueOf(totalRuangan));
            }else{
                dataRuangan.setText("0");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    protected void hitungdataMenu() {
        try{
            String sql = "SELECT COUNT(*) AS total FROM master_Menu";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            if (connection.result.next()) {
                int totalmenu = connection.result.getInt("total");
                dataMenu.setText(String.valueOf(totalmenu));
            }else{
                dataMenu.setText("0");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //GENERATE SELERUH ID YANG ADA DI MASTER
    public void generateIDRuangan() {
        try {
            String sql = "SELECT MAX(id_Ruangan) AS nextId FROM master_Ruangan";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();
            if (connection.result.next()) {
                int nextId = connection.result.getInt("nextId");
                txtIdR.setText(String.valueOf(nextId + 1));
            } else {
                txtIdR.setText("1");
            }
            connection.pstat.close();
            connection.result.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi error saat generate ID: " + ex);
        }
    }
    public void generateIDKaryawan() {
        try {
            String sql = "SELECT MAX(id_karyawan) AS nextId FROM master_karyawan";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();
            if (connection.result.next()) {
                int nextId = connection.result.getInt("nextId");
                txtIdkaryawan.setText(String.valueOf(nextId+1));
            } else {
                txtIdkaryawan.setText("1");
            }
            connection.pstat.close();
            connection.result.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi error saat generate ID: " + ex);
        }
    }

    public void generateIDMember() {
        try {
            String sql = "SELECT MAX(ID_Member) AS nextId FROM master_Member";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();
            if (connection.result.next()) {
                int nextId = connection.result.getInt("nextId");
                txtIdMember.setText(String.valueOf(nextId+1));
            } else {
                txtIdMember.setText("1");
            }
            connection.pstat.close();
            connection.result.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi error saat generate ID: " + ex);
        }
    }

    public void generateIDMenu() {
        try {
            String sql = "SELECT MAX(ID_Menu) AS nextId FROM master_Menu";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();
            if (connection.result.next()) {
                int nextId = connection.result.getInt("nextId");
                txtIdMenu.setText(String.valueOf(nextId+1));
            } else {
                txtIdMenu.setText("1");
            }
            connection.pstat.close();
            connection.result.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi error saat generate ID: " + ex);
        }
    }
    //GENERATE SELERUH ID YANG ADA DI MASTER




    @FXML
    private void loadDataFromDatabase() {
        statusR = "Aktif";

        try {
          List<Ruangan> ruanganList = new ArrayList<>();
          String sql = "SELECT * FROM master_Ruangan WHERE status = '" + statusR + "'";

            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

          while (connection.result.next()) {
              ruanganList.add(new Ruangan(
                      connection.result.getInt("id_Ruangan"),
                      connection.result.getString("nama_Ruangan"),
                      connection.result.getString("tipe_Ruangan"),
                      connection.result.getString("kapasitas"),
                      connection.result.getInt("tarif_perjam")
              ));

              viewRuangan.getItems().setAll(ruanganList);
             // connection.result.close();
          }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadDataFromDatabaseKaryawan() {
        statusR = "Aktif";

        try {
            List<Karyawan> viewKry = new ArrayList<>();
            String sql = "SELECT * FROM master_karyawan WHERE status = '" + statusR + "'";

            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            while (connection.result.next()) {
                viewKry.add(new Karyawan(
                        connection.result.getInt("id_karyawan"),
                        connection.result.getString("nama_karyawan"),
                        connection.result.getString("notelp_karyawan"),
                        connection.result.getString("username"),
                        connection.result.getString("role")
                ));

                viewKaryawan.getItems().setAll(viewKry);
               // connection.result.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadDataFromDatabaseMember() {
        statusR = "Aktif";

        try {
            List<Member> viewMbr = new ArrayList<>();
            String sql = "SELECT * FROM master_Member";

            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            while (connection.result.next()) {
                viewMbr.add(new Member(
                        connection.result.getInt("ID_Member"),
                        connection.result.getString("tipe_Member"),
                        connection.result.getDouble("diskon_Member"),
                        connection.result.getDouble("harga_Member")
                ));

                viewMember.getItems().setAll(viewMbr);
                // connection.result.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void loadDataFromDatabaseMenu() {
        statusR = "Aktif";

        try {
            List<Menu> viewMn = new ArrayList<>();
            String sql = "SELECT * FROM master_Menu";

            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            while (connection.result.next()) {
                viewMn.add(new Menu(
                        connection.result.getInt("ID_Menu"),
                        connection.result.getString("nama_menu"),
                        connection.result.getString("kategori_menu"),
                        connection.result.getInt("harga_MENU")
                ));

                viewMenu.getItems().setAll(viewMn);
                // connection.result.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void reload() {
            viewRuangan.setCellFactory(parameter -> new ListCell<Ruangan>() {
                @Override
                protected void updateItem(Ruangan item, boolean empty) {
                    super.updateItem(item, empty);

                    if (empty || item == null) {
                        setText(null);
                        setGraphic(null);
                    }else{
                        try{
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("item.fxml"));
                            HBox itemBox = fxmlLoader.load();
                            Item controller = fxmlLoader.getController();
                            controller.setData(item, DasHome.this);
                            setGraphic(itemBox);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            });
    }

    private void reloadKaryawan() {
        viewKaryawan.setCellFactory(parameter -> new ListCell<Karyawan>() {
            @Override
            protected void updateItem(Karyawan kry, boolean empty) {
                super.updateItem(kry, empty);

                if (empty || kry == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("item.fxml"));
                        HBox itemBox = fxmlLoader.load();
                        Item controller = fxmlLoader.getController();
                        controller.setDataKar(kry, DasHome.this);
                        setGraphic(itemBox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private void reloadMember() {
        viewMember.setCellFactory(parameter -> new ListCell<Member>() {
            @Override
            protected void updateItem(Member mbr, boolean empty) {
                super.updateItem(mbr, empty);

                if (empty || mbr == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("item.fxml"));
                        HBox itemBox = fxmlLoader.load();
                        Item controller = fxmlLoader.getController();
                        controller.setDataMember(mbr, DasHome.this);
                        setGraphic(itemBox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private void reloadMenu() {
        viewMenu.setCellFactory(parameter -> new ListCell<Menu>() {
            @Override
            protected void updateItem(Menu mn, boolean empty) {
                super.updateItem(mn, empty);

                if (empty || mn == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("item.fxml"));
                        HBox itemBox = fxmlLoader.load();
                        Item controller = fxmlLoader.getController();
                        controller.setDataMenu(mn, DasHome.this);
                        setGraphic(itemBox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }



    public void ComboTipeRuangan(){
        txtTipeR.getItems().addAll(
                "Reguler",
                "Premium",
                "Luxury"
        );
    }

    public void ComboTipeUpdate(){
        txttipeUpate.getItems().addAll(
                "Reguler",
                "Premium",
                "Luxury"
        );
    }

    public void comboRoleKaryawan(){
        txtRoleKaryawan.getItems().addAll(
                "Admin",
                "Manager",
                "Kasir"
        );
    }

    public void comboUpdateRoleKaryawan(){
        txtUpdateRoleKaryawan.getItems().addAll(
                "Admin",
                "Manager",
                "Kasir"
        );
    }

    public void comboTipeMenu(){
        txtTipeMenu.getItems().addAll(
                "Makanan",
                "Minuman"
        );
    }

    public void comboUpdateTipeMenu(){
        txtUpdateTipeMenu.getItems().addAll(
                "Makanan",
                "Minuman"
        );
    }

    swalAlert alert = new swalAlert();


    @FXML
    protected void searchRuangan(){
        try{
            List<Ruangan> vr = new ArrayList<>();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM master_Ruangan WHERE id_Ruangan LIKE '%"+txtsearchRuangan.getText()+"%'";
             connection.result = connection.stat.executeQuery(query);

             while(connection.result.next()){
                 vr.add(new Ruangan(
                         connection.result.getInt("id_Ruangan"),
                         connection.result.getString("nama_Ruangan"),
                         connection.result.getString("tipe_Ruangan"),
                         connection.result.getString("kapasitas"),
                         connection.result.getInt("tarif_perjam")
                 ));
                 viewRuangan.getItems().setAll(vr);
             }

        }catch (SQLException e){
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR","Data tidak ada",false);
        }finally {
            reload();
        }
    }

    @FXML
    protected void searchMenu(){
        try{
            List<Menu> vm = new ArrayList<>();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM master_Menu WHERE ID_Menu LIKE '%"+txtsearchMenu.getText()+"%'";
            connection.result = connection.stat.executeQuery(query);

            while(connection.result.next()){
                vm.add(new Menu(
                        connection.result.getInt("ID_Menu"),
                        connection.result.getString("nama_menu"),
                        connection.result.getString("kategori_menu"),
                        connection.result.getInt("harga_MENU")
                ));
                viewMenu.getItems().setAll(vm);
            }

        }catch (SQLException e){
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR","Data tidak ada",false);
        }finally {
            reloadMenu();
        }
    }

    @FXML
    protected void searchKaryawan(){
        try{
            List<Karyawan> vk = new ArrayList<>();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT * FROM master_karyawan WHERE id_karyawan LIKE '%"+txtsearchKaryawan.getText()+"%'";
            connection.result = connection.stat.executeQuery(query);

            while(connection.result.next()){
                vk.add(new Karyawan(
                        connection.result.getInt("id_karyawan"),
                        connection.result.getString("nama_karyawan"),
                        connection.result.getString("notelp_karyawan"),
                        connection.result.getString("username"),
                        connection.result.getString("role")
                ));
                viewKaryawan.getItems().setAll(vk);
            }

        }catch (SQLException e){
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR","Data tidak ada",false);
        }finally {
            reloadKaryawan();
        }
    }

    @FXML
    protected void onClicktambah() {

        // Validasi field kosong
        if(txtNamaR.getText().isEmpty() || txtKapasitas.getText().isEmpty() ||
                txtTarifR.getText().isEmpty() || txtTipeR.getValue() == null) {
            alert.showAlert(Alert.AlertType.WARNING, "ERROR","Data tidak lengkap", false);
            return;
        }
        idRuangan = Integer.parseInt(txtIdR.getText());
        namaR = txtNamaR.getText();

        String cek = (String) txtTipeR.getValue();
        if (cek == null || !(cek.equals("Reguler") || cek.equals("Premium") || cek.equals("Luxury"))) {
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR", "Data tidak sesuai", false);
            txtTipeR.setValue(null);
            return;
        }
        tipeR = cek;
        kapasitasR =txtKapasitas.getText();

        // Validasi tarif harus angka positif
        try {
            tarifR = Integer.parseInt(txtTarifR.getText());
            if(tarifR <= 0) {
                //showAlert("Error", "Tarif harus lebih besar dari 0");
                alert.showAlert(Alert.AlertType.WARNING, "ERROR","Tarif tidak boleh kurang dari 0", false);
                txtTarifR.clear();
                return;
            }
        } catch (NumberFormatException e) {
            alert.showAlert(Alert.AlertType.WARNING, "ERROR", "Data harus berupa angka",false);
            return;
        }

        try{
            String query = "EXEC sp_createRuangan @nama_Ruangan = ?,@tipe_Ruangan = ?,@kapasitas = ?,@tarif_perjam = ?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, namaR);
            connection.pstat.setString(2, tipeR);
            connection.pstat.setString(3, kapasitasR);
            connection.pstat.setInt(4, tarifR);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION,"SUCCES", "Data berhasil diisi", true);
        } catch (SQLException e) {
            System.out.println("Terjadi error saat insert data Ruangan: " + e);
        } catch (NumberFormatException e){
            showAlert("Error", "Tarif harus berupa angka");
        }finally {
            loadDataFromDatabase();
            reload();
            pnlRuangan.toFront();
        }

    }

    public void popUpdateRuangan(Ruangan ruangan){
        pnlUpdateRuangan.toFront();
        txtidRuanganUpdate.setText(String.valueOf(ruangan.getId_ruangan()));
        txtnamaUpdate.setText(ruangan.getNama_ruangan());
        txttipeUpate.setValue(ruangan.getTipe_ruangan());
        txtKapasitasUpdate.setText(ruangan.getKapasitas_ruangan());
        txtTarifUpdate.setText(String.valueOf(ruangan.getTarif_ruangan()));
    }


    @FXML
    protected void onClickupdateRuangan() {
        //validasi field kosong
        if (txtidRuanganUpdate.getText().isEmpty() || txtnamaUpdate.getText().isEmpty() || txttipeUpate.getValue() == null || txtKapasitasUpdate.getText().isEmpty() || txtTarifUpdate.getText().isEmpty()) {
            alert.showAlert(Alert.AlertType.WARNING, "ERROR", "Data tidak lengkap", false);
            return;
        }

        idRuangan = Integer.parseInt(txtidRuanganUpdate.getText());
        namaR = txtnamaUpdate.getText();

        String cek = (String) txttipeUpate.getValue();
        if (cek == null || !(cek.equals("Reguler") || cek.equals("Premium") || cek.equals("Luxury"))) {
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR", "Data tidak sesuai", false);
            txttipeUpate.setValue(null);
            return;
        }
        tipeR = cek;

        kapasitasR = txtKapasitasUpdate.getText();
        try {
            tarifR = Integer.parseInt(txtTarifUpdate.getText());
            if(tarifR <= 0) {
                alert.showAlert(Alert.AlertType.WARNING, "ERROR","Tarif tidak boleh kurang dari 0", false);
                txtTarifUpdate.clear();
                return;
            }
        } catch (NumberFormatException e) {
            //showAlert("Error", "Tarif harus berupa angka");
            alert.showAlert(Alert.AlertType.WARNING, "ERROR", "Data harus berupa angka",false);
            return;
        }


        try {
            String query = "UPDATE master_Ruangan SET nama_Ruangan=?, tipe_Ruangan=?, kapasitas=?, tarif_perjam=? " +
                    "WHERE id_Ruangan=?";

            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, namaR);
            connection.pstat.setString(2, tipeR);
            connection.pstat.setString(3, kapasitasR);
            connection.pstat.setInt(4,tarifR);
            connection.pstat.setInt(5, idRuangan);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION, "SUCCES", "Data ruangan berhasil diupdate", true);
        } catch (SQLException e) {
            showAlert(String.valueOf(Alert.AlertType.ERROR), "Database Error gagal mengupdate data");

        }finally {
            loadDataFromDatabase();
            reload();
            pnlRuangan.toFront();
        }

    }


    public void hapusRuangan(Ruangan ruangan) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Konfirmasi Hapus");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Yakin ingin menghapus ruangan " + ruangan.getNama_ruangan() + "?");

        if (confirmation.showAndWait().get() == ButtonType.OK) {
            idRuangan = ruangan.getId_ruangan();
            statusR = "Tidak Aktif";

            try {
                String query = "UPDATE master_Ruangan SET status = ? WHERE id_Ruangan=?";

                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, statusR);
                connection.pstat.setInt(2, idRuangan);

                int affectedRows = connection.pstat.executeUpdate();

                if (affectedRows > 0) {
                    showAlert("Success", "Data ruangan berhasil dihapus");
                    reload();
                }
                connection.pstat.close();
            } catch (SQLException e) {
                showAlert("Database Error", "Gagal menghapus data: " + e.getMessage());
            }finally {
                loadDataFromDatabase();
                reload();
            }

        }
    }

    @FXML
    protected void onClicktambahKaryawan() {
        // Validasi field kosong
        if(txtnamaKaryawan.getText().isEmpty() || txtNotelpkaryawan.getText().isEmpty() ||
                txtUsernameKaryawan.getText().isEmpty() || txtPasswordKaryawaan.getText().isEmpty() ||
                txtRoleKaryawan.getValue() == null) {
            showAlert("Error", "Seluruh Data Wajib diisi");
            alert.showAlert(Alert.AlertType.ERROR,"ERROR","Seluruh data wajib diisi", false);
            return;
        }

        txtIdkaryawan.setVisible(false);
        idKar = Integer.parseInt(txtIdkaryawan.getText());

        if (!txtnamaKaryawan.getText().matches("[a-zA-Z\\s]*")){
            alert.showAlert(Alert.AlertType.ERROR, "ERROR", "Nama harus berupa huruf", false);
            txtnamaKaryawan.clear();
            return;

        }
        namaKar = txtnamaKaryawan.getText();

        // Validasi format nomor telepon
        if(!txtNotelpkaryawan.getText().matches("[0-9]+")) {
            showAlert("Error", "Nomor telepon hanya boleh mengandung angka");
            return;
        }
        noTelpkar = txtNotelpkaryawan.getText();

        // Validasi panjang username dan password
        if(txtUsernameKaryawan.getText().length() < 5) {
            showAlert("Error", "Username minimal 5 karakter");
            return;
        }
        userKar = txtUsernameKaryawan.getText();

        if(txtPasswordKaryawaan.getText().length() < 6) {
            showAlert("Error", "Password minimal 6 karakter");
            return;
        }
        passKar = txtPasswordKaryawaan.getText();

        String cek = (String) txtRoleKaryawan.getValue();
        if (cek == null || !(cek.equals("Admin") || cek.equals("Kasir") || cek.equals("Manager"))) {
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR", "Data tidak sesuai", false);
            txtRoleKaryawan.setValue(null);
            return;
        }
        roleKar = cek;

        try{
            String query = "EXEC sp_createKaryawan @nama_karyawan = ?,@notelp_karyawan = ?,@username = ?,@password = ?, @role = ?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, namaKar);
            connection.pstat.setString(2, noTelpkar);
            connection.pstat.setString(3, userKar);
            connection.pstat.setString(4, passKar);
            connection.pstat.setString(5, roleKar);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION, "SUCCES", "Data karyawan berhasil", true);
        } catch (SQLException e) {
            System.out.println("Terjadi error saat insert data Karyawan: " + e);
        }finally {
            loadDataFromDatabaseKaryawan();
            reloadKaryawan();
            pnlKaryawan.toFront();
        }

    }

    public void popUpdateKaryawan(Karyawan karyawan){
        pnlUpdateKaryawan.toFront();
        txtUpdateIdkaryawan.setText(String.valueOf(karyawan.getId_karyawan()));
        txtUpdatenamaKaryawan.setText(karyawan.getNama_karyawan());
        txtUpdateNotelpkaryawan.setText(karyawan.getNoTelp_karyawan());
        txtUpdateUsernameKaryawan.setText(karyawan.getUsername_karyawan());
        txtPasswordKaryawaan.setText(karyawan.getPasswordkaryawan());
        txtUpdateRoleKaryawan.setValue(karyawan.getRole_password());
    }


    @FXML
    protected void onClickupdateKaryawan() {
        if(txtUpdatenamaKaryawan.getText().isEmpty() || txtUpdateNotelpkaryawan.getText().isEmpty() ||
                txtUpdateUsernameKaryawan.getText().isEmpty() || txtUpdatePasswordKaryawaan.getText().isEmpty() ||
                txtUpdateRoleKaryawan.getValue() == null) {
           // showAlert("Error", "Seluruh Data Wajib diisi");
            alert.showAlert(Alert.AlertType.ERROR,"ERROR","Seluruh data wajib diisi", false);
            return;
        }

        txtUpdateIdkaryawan.setVisible(false);
        idKar = Integer.parseInt(txtUpdateIdkaryawan.getText());

        if (!txtUpdatenamaKaryawan.getText().matches("[a-zA-Z\\s]*")){
            alert.showAlert(Alert.AlertType.ERROR, "ERROR", "Nama harus berupa huruf", false);
            txtUpdatenamaKaryawan.clear();
            return;

        }
        namaKar = txtUpdatenamaKaryawan.getText();

        // Validasi format nomor telepon
        if(!txtUpdateNotelpkaryawan.getText().matches("[0-9]+")) {
            showAlert("Error", "Nomor telepon hanya boleh mengandung angka");
            return;
        }
        noTelpkar = txtUpdateNotelpkaryawan.getText();

        // Validasi panjang username dan password
        if(txtUpdateUsernameKaryawan.getText().length() < 5) {
            showAlert("Error", "Username minimal 5 karakter");
            return;
        }
        userKar = txtUpdateUsernameKaryawan.getText();

        if(txtUpdatePasswordKaryawaan.getText().length() < 6) {
            showAlert("Error", "Password minimal 6 karakter");
            return;
        }
        passKar = txtUpdatePasswordKaryawaan.getText();

        String cek = (String) txtUpdateRoleKaryawan.getValue();
        if (cek == null || !(cek.equals("Admin") || cek.equals("Kasir") || cek.equals("Manager"))) {
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR", "Data tidak sesuai", false);
            txtUpdateRoleKaryawan.setValue(null);
            return;
        }
        roleKar = cek;

        try {
            String query = "EXEC sp_updateKaryawan ?,?,?,?,?,?";

            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setInt(1, idKar);
            connection.pstat.setString(2, namaKar);
            connection.pstat.setString(3, noTelpkar);
            connection.pstat.setString(4,userKar);
            connection.pstat.setString(5, passKar);
            connection.pstat.setString(6, roleKar);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION,"SUCCES", "Data berasil diupdate", true);
        } catch (SQLException e) {
            showAlert(String.valueOf(Alert.AlertType.ERROR), "Database Error gagal mengupdate data");
        }finally {
            loadDataFromDatabaseKaryawan();
            reloadKaryawan();
            pnlKaryawan.toFront();
        }

    }


    public void hapusKaryawan(Karyawan kry) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Konfirmasi Hapus");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Yakin ingin menghapus ruangan " + kry.getNama_karyawan() + "?");

        if (confirmation.showAndWait().get() == ButtonType.OK) {
            idKar = kry.getId_karyawan();
            statusR = "Tidak Aktif";
            try {
                String query = "UPDATE master_karyawan SET status = ? WHERE id_Karyawan=?";

                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, statusR);
                connection.pstat.setInt(2, idKar);

                int affectedRows = connection.pstat.executeUpdate();

                if (affectedRows > 0) {
                    showAlert("Success", "Data karyawan berhasil dihapus");
                    reload();
                }
                connection.pstat.close();
            } catch (SQLException e) {
                showAlert("Database Error", "Gagal menghapus data: " + e.getMessage());
            }
            loadDataFromDatabaseKaryawan();
            reloadKaryawan();
        }
    }


    @FXML
    protected void onClicktambahMember() {
        // Validasi field kosong
        if(txtTipeMember.getText().isEmpty() || txtDiskonMember.getText().isEmpty() ||
                txtHargaMember.getText().isEmpty()) {
          alert.showAlert(Alert.AlertType.WARNING,"Error", "Seluruh data wajib diisi", false);
            return;
        }

        txtIdMember.setVisible(false);
        tipeMember = txtTipeMember.getText();

        // Validasi diskon antara 0-100
        try {
            diskonMember = Integer.parseInt(txtDiskonMember.getText());
            if(diskonMember < 0 || diskonMember > 100) {
                alert.showAlert(Alert.AlertType.WARNING,"ERROR", "Diskon harus antara 0-100", false);
                return;
            }
        } catch (NumberFormatException e) {
            alert.showAlert(Alert.AlertType.WARNING,"ERROR", "Diskon harus berupa angka", false);
            return;
        }

        // Validasi harga positif
        try {
            hargaMember = Integer.parseInt(txtHargaMember.getText());
            if(hargaMember <= 0) {
                alert.showAlert(Alert.AlertType.WARNING,"ERROR","Data harus lebih besar dari 0",false);
                return;
            }
        } catch (NumberFormatException e) {
            alert.showAlert(Alert.AlertType.WARNING,"ERROR","Data harus berupa angka",false);
            return;
        }
        try{
            String query = "EXEC sp_createMember @tipe_Member = ?,@diskon_Member = ?,@harga_Member = ?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, tipeMember);
            connection.pstat.setInt(2, diskonMember);
            connection.pstat.setInt(3, hargaMember);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            showAlert("Succes", "Member berhasil diisi");
        } catch (SQLException e) {
            System.out.println("Terjadi error saat insert data Member: " + e);
        }finally {
            loadDataFromDatabaseMember();
            reloadMember();
            pnlMember.toFront();
        }


    }

    public void popUpdateMember(Member mbr){
        pnlUpdateMember.toFront();
        txtIUpdatedMember.setText(String.valueOf(mbr.getIdMember()));
        txtUpdateTipeMember.setText(mbr.getTipeMember());
        txtUpdateDiskonMember.setText(String.valueOf(mbr.getDiskonMember()));
        txtUpdateHargaMember.setText(String.valueOf(mbr.getHargaMember()));
    }


    @FXML
    protected void onClickupdateMember() {
        //validasi field kosong
        if(txtUpdateTipeMember.getText().isEmpty() || txtUpdateTipeMember.getText().isEmpty() ||
                txtUpdateHargaMember.getText().isEmpty()) {
            alert.showAlert(Alert.AlertType.WARNING,"Error", "Seluruh data wajib diisi", false);
            return;
        }


        idMember = Integer.parseInt(txtIUpdatedMember.getText());
        tipeMember = txtUpdateTipeMember.getText();
        try {
            diskonMember = Integer.parseInt(txtUpdateDiskonMember.getText());
            if(diskonMember < 0 || diskonMember > 100) {
                alert.showAlert(Alert.AlertType.WARNING,"ERROR", "Diskon harus antara 0-100", false);
                return;
            }
        } catch (NumberFormatException e) {
            alert.showAlert(Alert.AlertType.WARNING,"ERROR", "Diskon harus berupa angka", false);
            return;
        }

        // Validasi harga positif
        try {
            hargaMember = Integer.parseInt(txtUpdateHargaMember.getText());
            if(hargaMember <= 0) {
                alert.showAlert(Alert.AlertType.WARNING,"ERROR","Data harus lebih besar dari 0",false);
                return;
            }
        } catch (NumberFormatException e) {
            alert.showAlert(Alert.AlertType.WARNING,"ERROR","Data harus berupa angka",false);
            return;
        }

        try {
            String query = "EXEC sp_updateMember ?,?,?,?";

            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setInt(1, idMember);
            connection.pstat.setString(2, tipeMember);
            connection.pstat.setInt(3, diskonMember);
            connection.pstat.setInt(4, hargaMember);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION,"SUCCES","Data berhasil diupdate",true);
        } catch (SQLException e) {
            showAlert(String.valueOf(Alert.AlertType.ERROR), "Database Error gagal mengupdate data");
        }finally {
            loadDataFromDatabaseMember();
            reloadMember();
            pnlMember.toFront();
        }

    }


    public void hapusMember(Member mbr) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Konfirmasi Hapus");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Yakin ingin menghapus ruangan " + mbr.getIdMember() + "?");

        if (confirmation.showAndWait().get() == ButtonType.OK) {

            idMember = mbr.getIdMember();
            statusR = "Tidak Aktif";


            try {
                String query = "UPDATE master_Member SET status = ? WHERE ID_Member=?";

                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, statusR);
                connection.pstat.setInt(2, idMember);

                int affectedRows = connection.pstat.executeUpdate();

                if (affectedRows > 0) {
                    showAlert("Success", "Data member berhasil dihapus");
                    reload();
                }
                connection.pstat.close();
            } catch (SQLException e) {
                showAlert("Database Error", "Gagal menghapus data: " + e.getMessage());
            }
            loadDataFromDatabaseMember();
            reloadMember();
        }
    }


    @FXML
    protected void onClicktambahMenu() {
        // Validasi field kosong
        if(txtNamaMenu.getText().isEmpty() || txtTipeMenu.getValue() == null ||
                txtHargaMenu.getText().isEmpty()) {
            showAlert("Error", "Seluruh Data Wajib diisi");
            alert.showAlert(Alert.AlertType.WARNING,"ERROR","Seluruh data wajib diisi",false);
            return;
        }

        txtIdMenu.setVisible(false);
        namaMenu = txtNamaMenu.getText();

        String cek = (String) txtTipeMenu.getValue();
        if (cek == null || !(cek.equals("Makanan") || cek.equals("Minuman") )) {
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR", "Data tidak sesuai", false);
            txtTipeMenu.setValue(null);
            return;
        }
        tipeMenu = cek;

        // Validasi harga positif
        try {
            hargaMenu = Integer.parseInt(txtHargaMenu.getText());
            if(hargaMenu <= 0) {
                alert.showAlert(Alert.AlertType.WARNING,"ERROR","Harga harus lebih dari 0", false);
                return;
            }
        } catch (NumberFormatException e) {
            showAlert("Error", "Harga harus berupa angka");
            alert.showAlert(Alert.AlertType.WARNING,"ERROR","Harga harus berupa angka", false);
            return;
        }

        try{
            String query = "EXEC sp_createMenu @nama_menu = ?,@kategori_menu = ?,@harga_menu = ?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setString(1, namaMenu);
            connection.pstat.setString(2, tipeMenu);
            connection.pstat.setInt(3, hargaMenu);

            connection.pstat.executeUpdate();
            connection.pstat.close();
            showAlert("Succes", "Menu berhasil diisi");
        } catch (SQLException e) {
            System.out.println("Terjadi error saat insert data Menu: " + e);
        }finally {
            loadDataFromDatabaseMenu();
            reloadMenu();
            pnlMenu.toFront();
        }


    }
    public void popUpdateMenu(Menu mn){
        pnlUpdateMenu.toFront();
        txtUpdateIdMenu.setText(String.valueOf(mn.getIdMenu()));
        txtUpdateNamaMenu.setText(mn.getNamaMenu());
        txtUpdateTipeMenu.setValue(mn.getKategoriMenu());
        txtUpdateHargaMenu.setText(String.valueOf(mn.getHargaMenu()));
        }


    @FXML
    protected void onClickupdateMenu() {

        if(txtUpdateNamaMenu.getText().isEmpty() || txtUpdateHargaMenu.getText().isEmpty() ||
                txtUpdateTipeMenu.getValue() ==  null) {
            alert.showAlert(Alert.AlertType.WARNING,"Error", "Seluruh data wajib diisi", false);
            return;
        }

        idMenu = Integer.parseInt(txtUpdateIdMenu.getText());
        namaMenu = txtUpdateNamaMenu.getText();

        String cek = (String) txtUpdateTipeMenu.getValue();
        if (cek == null || !(cek.equals("Makanan") || cek.equals("Minuman") )) {
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR", "Data tidak sesuai", false);
            txtUpdateTipeMenu.setValue(null);
            return;
        }
        tipeMenu = cek;

        hargaMenu = Integer.parseInt(txtUpdateHargaMenu.getText());


        try {
            String query = "EXEC sp_updateMeNU ?,?,?,?";

            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setInt(1, idMenu);
            connection.pstat.setString(2, namaMenu);
            connection.pstat.setString(3, tipeMenu);
            connection.pstat.setInt(4, hargaMenu);
  
            connection.pstat.executeUpdate();
            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION,"SUCCES", "Dara berhasil diupdate",false);
        } catch (SQLException e) {
            showAlert(String.valueOf(Alert.AlertType.ERROR), "Database Error gagal mengupdate data");
        }finally {
            loadDataFromDatabaseMenu();
            reloadMenu();
            pnlMenu.toFront();
        }

    }


    public void hapusMenu(Menu mn) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Konfirmasi Hapus");
        confirmation.setHeaderText(null);
        confirmation.setContentText("Yakin ingin menghapus ruangan " + mn.getIdMenu() + "?");

        if (confirmation.showAndWait().get() == ButtonType.OK) {

            idMenu = mn.getIdMenu();
            statusR = "Tidak Aktif";


            try {
                String query = "UPDATE master_Menu SET status = ? WHERE ID_Menu=?";

                connection.pstat = connection.conn.prepareStatement(query);
                connection.pstat.setString(1, statusR);
                connection.pstat.setInt(2, idMenu);

                int affectedRows = connection.pstat.executeUpdate();

                if (affectedRows > 0) {
                    showAlert("Success", "Data menu berhasil dihapus");
                    reload();
                }
                connection.pstat.close();
            } catch (SQLException e) {
                showAlert("Database Error", "Gagal menghapus data: " + e.getMessage());
            }
            loadDataFromDatabaseMenu();
            reloadMenu();
        }
    }




    @FXML
    public void onClickBtnTambah(ActionEvent event) {
        if(event.getSource() == createRuangan) {
            pnltambahRuangan.setStyle("-fx-background-color : #ffffff");
            pnltambahRuangan.toFront();
            generateIDRuangan();
        }
        if(event.getSource() == createkaryawan) {
            pnlTambahKaryawan.setStyle("-fx-background-color : #ffffff");
            pnlTambahKaryawan.toFront();
            generateIDKaryawan();
        }
        if (event.getSource() == createMember){
            pnlTambahMember.setStyle("-fx-background-color : #ffffff");
            pnlTambahMember.toFront();
            txtTipeMember.setText("");
            txtDiskonMember.setText("");
            txtHargaMember.setText("");
            generateIDMember();
        }
        if(event.getSource() == createMenu){
            pnlTambahMenu.setStyle("-fx-background-color : #ffffff");
            pnlTambahMenu.toFront();
            generateIDMenu();
        }
    }





    public void handleClicksKembali(ActionEvent event) {
        if (event.getSource() == btnKembaliR) {
            pnlRuangan.setStyle("-fx-background-color : #ffffff");
            pnlRuangan.toFront();
        }
        if (event.getSource() == btnKembaliUpdate) {
            pnlRuangan.setStyle("-fx-background-color : #ffffff");
            pnlRuangan.toFront();
        }
        if(event.getSource() ==btnKembaliKaryawan) {
            pnlKaryawan.setStyle("-fx-background-color : #ffffff");
            pnlKaryawan.toFront();
        }
        if (event.getSource() == btnKembaliUpdateKaryawan){
            pnlKaryawan.setStyle("-fx-background-color : #ffffff");
            pnlKaryawan.toFront();
        }
        if (event.getSource() == btnKembaliMember) {
            pnlMember.setStyle("-fx-background-color : #ffffff");
            pnlMember.toFront();
        }
        if (event.getSource() == btnKembaliUpdateMember){
            pnlMember.setStyle("-fx-background-color : #ffffff");
            pnlMember.toFront();
        }
        if (event.getSource() == btnKembaliMenu) {
            pnlMenu.setStyle("-fx-background-color : #ffffff");
            pnlMenu.toFront();
        }
        if (event.getSource() == btnKembaliUpdateMenu){
            pnlMenu.setStyle("-fx-background-color : #ffffff");
            pnlMenu.toFront();
        }
    }
    Karyawan usr = new Karyawan();

    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnHome) {
            pnlHome.setStyle("-fx-background-color : #ffffff");
            pnlHome.toFront();
            hitungdataRuangan();
            hitungdataMenu();
        }
        if (actionEvent.getSource() == btnRuangan) {
            pnlRuangan.setStyle("-fx-background-color : #ffffff");
            pnlRuangan.toFront();
            reload();
        }
        if(actionEvent.getSource() == btnKaryawan) {
            pnlKaryawan.setStyle("-fx-background-color : #ffffff");
            pnlKaryawan.toFront();
            reloadKaryawan();
        }
        if (actionEvent.getSource() == btnMember) {
            pnlMember.setStyle("-fx-background-color : #ffffff");
            pnlMember.toFront();
            reloadMember();
        }
        if (actionEvent.getSource() == btnMenu) {
            pnlMenu.setStyle("-fx-background-color : #ffffff");
            pnlMenu.toFront();
            reloadMenu();

        }
    }

    @FXML
    private Button btnExit;

    @FXML
    protected void OnClickExit() throws IOException {
        FXMLLoader loader = null;

        loader = new FXMLLoader(getClass().getResource("DasLogin.fxml"));
        Parent root = loader.load();

        //Mendapatkan stage dari salah satu node di scene saat ini
        Stage stage = (Stage) namaLbl.getScene().getWindow();

        // Set scene baru
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Login Page");
        stage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}
