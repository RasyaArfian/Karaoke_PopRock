package com.example.karaoke_poprock;

import Master.*;
import Master.Menu;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DasTransaksi implements Initializable {
    @FXML
    private Label lblHargaMember1;
    @FXML
    private Label lblHargaMember;
    @FXML
    private TextField tfIdTransaksiMember;
    DBconnect connection = new DBconnect();

    // RUANGAN RUANGAN RUANGAN
    // RUANGAN RUANGAN RUANGAN
    String statusRuangan, namaTransaksiR, noHpTransaksiR, namaMember;
    double diskonRuangan, hargaRuangan,totalRuangan,totalPembayaran, totalkembalian, durasiPenyewaan;
    int idkaryawan, idruangan, idmember, idtransaksi;

    // MENU MENU MENU
    // MENU MENU MENU
    String statusMenu, namaMenu, kategoriMenu;
    double hargaMenu, totalKeranjangMenu , totalpembayaranMenu, totalkembalianMenu;
    double tampungHarga;
    int  quantity, idmenu;

    @FXML
    private Pane pnlHomeTransaksi;
    @FXML
    private Pane pnlMemberTransaksi;
    @FXML
    private Pane pnlTransaksi;
    @FXML
    private Pane pnlTransaksiRuangan;
    @FXML
    private Pane pnlTransaksiMenu;
    @FXML
    private Pane pnlTransaksiMember;
    @FXML
    private Pane pnlPembuatanmember;
    @FXML
    private Pane pnlUpMember;

    @FXML
    private Label tglTrans;

    @FXML
    private Label lblNamaKaryawan;

    // VBOX VBOX VBOX
    // VBOX VBOX VBOX
    @FXML
    private Button btnHomeTransaksi;
    @FXML
    private Button btnMemberTransaksi;
    @FXML
    private Button btnTransaksi;
    //VBOX VBOX VBOX
    // VBOX VBOX VBOX

    //TRANSAKSI
    //TRANSAKSI
    @FXML
    private Button btnTrMember;
    @FXML
    private Button btnTrRuangan;
    @FXML
    private Button btnTrMenu;
    //TRANSAKSI
    //TRANSAKSI

    // SUB TRANSAKSI MEMBER
    // SUB TRANSAKSI MEMBER
    @FXML
    private Button btnCreateMember;
    @FXML
    private Button btnUpMember;


    // TRANSAKSI RUANGAN
    // TRANSAKSI RUANGAN
    @FXML
    private DatePicker tglTransaksiRuangan;
    @FXML
    private TextField txtIdTransaksiRuangan;
    @FXML
    private TextField txtIdMember;
    @FXML
    private TextField txtNamaTransaksi;
    @FXML
    private TextField txtNotelpTransaksi;
    @FXML
    private TextField txtDiskonTR;
    @FXML
    private ComboBox<LocalTime> cbJamMulai;
    @FXML
    private ComboBox<LocalTime> cbJamSelesai;
    @FXML
    private Label lblDurasi;
    @FXML
    private TextField txtDurasiPenyewaan;
    @FXML
    private TextField txtPembayaran;
    @FXML
    private Label lblTotalPenyewaan;
    @FXML
    private Label lblTotalKembali;

    @FXML
    private Button btnbyrRuangan, btnbyrMember;
    @FXML
    private Button btnHitungRuangan;
    @FXML
    private Button btnBatalRuangan, btnBatalMember;

    @FXML
    private ListView<Ruangan> dataRuangan;

    // TRANSAKSI RUANGAN
    // TRANSAKSI RUANGAN


    // TRANSAKSI MENU
    // TRANSAKSI MENU

    @FXML private TextField txtIdRuangan;
    @FXML private DatePicker tglMenuTrs;
    @FXML private TextField txtIdTrsMenu;
    @FXML private ListView<Menu> dataMenu;
    @FXML private ListView<keranjangMenu> dataKeranjangMenu;
    @FXML private TextField txtPembayaranMenu;
    @FXML private Label lblKembalian;
    @FXML private Label totalMenu;

    @FXML private Button btnBayarMenu;
    @FXML private Button btnHitungMenu;
    @FXML private Button btnBatalMenu;
    @FXML private Button btnCariRuanganMenu;


    // TRANSAKSI MENU
    // TRANSAKSI MENU

    //, tfNoTelpMember, , ;

    @FXML
    private TextField tfTanggalPembuatan;
    @FXML
    private TextField tfNamaMember;
    @FXML
    private  TextField tfNoTelpMember;
    @FXML
    private TextField tfDiskonTransaksiMember;
    @FXML
    private TextField tfTotalPembayaran;
    @FXML ComboBox<String> cbTipeMember;

    @FXML
    private Label lblTarif;
    @FXML
    private Label lblKembalianMember;

    @FXML
    private Map<String, Member> tipeMemberMap = new HashMap<>();
    swalAlert alert = new swalAlert();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tglTransaksiRuangan.setValue(LocalDate.from(LocalDateTime.now()));
        tglMenuTrs.setValue(LocalDate.from(LocalDateTime.now()));
        loadDataFromDatabaseRuangan();
        loadDataTipeMember();

        if (cbJamSelesai != null && cbJamMulai != null) {
            for (int i = 0; i < 24; i++) {
                cbJamMulai.getItems().add(LocalTime.of(i, 0));
                cbJamSelesai.getItems().add(LocalTime.of(i, 0));
            }
        }else{
            System.err.println("Error");
        }

        if (cbJamSelesai != null && cbJamMulai != null) {
            cbJamMulai.valueProperty().addListener((
                    (observableValue, oldValue, newValue) -> hitungDurasiDanHarga()));
            cbJamSelesai.valueProperty().addListener((
                    (observableValue, oldValue, newValue) -> hitungDurasiDanHarga()));
        }



        cbTipeMember.setOnAction(e -> {
            String selected = cbTipeMember.getValue();
            Member data = tipeMemberMap.get(selected);

            if (data != null) {
                tfDiskonTransaksiMember.setText(String.valueOf(data.getDiskonMember()));
                lblTarif.setText(String.valueOf(data.getHargaMember()));
                Double tarif = data.getHargaMember();
                String bayar = tfTotalPembayaran.getText();
                Double bayar2 = Double.parseDouble(bayar);
                Double kembalian = bayar2 - tarif;
                lblKembalianMember.setText(String.valueOf(kembalian));
            }
        });
        tfTotalPembayaran.setOnAction(e -> {
            String bayar = tfTotalPembayaran.getText();

            if (bayar != null && !bayar.isEmpty()) {
                try {
                    Double bayar2 = Double.parseDouble(bayar);
                    // Assume you already have the tarif value
                    String selected = cbTipeMember.getValue();
                    Member data = tipeMemberMap.get(selected);

                    if (data != null) {
                        Double tarif = data.getHargaMember();
                        Double kembalian = bayar2 - tarif;
                        lblKembalianMember.setText(String.valueOf(kembalian));
                    }
                } catch (NumberFormatException exception) {
                    lblKembalianMember.setText("Bayar tidak valid");
                    System.out.println("Format bayar salah: " + exception.getMessage());
                }
            } else {
                lblKembalianMember.setText("");
            }
        });

    }

    @FXML
    protected void ClickEventMouseEntered(){
        btnHomeTransaksi.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnHomeTransaksi.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnHomeTransaksi.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnHomeTransaksi.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnHomeTransaksi.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnMemberTransaksi.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnMemberTransaksi.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnMemberTransaksi.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnMemberTransaksi.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnMemberTransaksi.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnTransaksi.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnTransaksi.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnTransaksi.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnTransaksi.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnTransaksi.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnTrMenu.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnTrMenu.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277;"));
        btnTrMenu.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnTrMenu.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnTrMenu.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });
        btnTrRuangan.addEventHandler(MouseEvent.MOUSE_ENTERED, ev -> btnTrRuangan.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #413277; "));
        btnTrRuangan.addEventHandler(MouseEvent.MOUSE_EXITED, ev -> {
            if (!btnTrRuangan.getStyle().contains("#FFFFFF; -fx-background-color: #FFFFFF;")) {
                btnTrRuangan.setStyle("-fx-background-color: #413277; -fx-text-fill: #FFFFFF;");
            }
        });

    }

    public void generateIDTransaksiRuangan() {
        try {
            String sql = "SELECT MAX(id_trsruangan) AS nextId FROM transaksi_penyewaanruangan";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();
            if (connection.result.next()) {
                int nextId = connection.result.getInt("nextId");
                txtIdTransaksiRuangan.setText(String.valueOf(nextId + 1));
            } else {
                txtIdTransaksiRuangan.setText("1");
            }
            connection.pstat.close();
            connection.result.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi error saat generate ID: " + ex);
        }
    }

    public void generateIDTransaksiMenu() {
        try {
            String sql = "SELECT MAX(id_trsmenu) AS nextId FROM transaksi_penyewaanruangan";
            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();
            if (connection.result.next()) {
                int nextId = connection.result.getInt("nextId");
                txtIdTransaksiRuangan.setText(String.valueOf(nextId + 1));
            } else {
                txtIdTransaksiRuangan.setText("1");
            }
            connection.pstat.close();
            connection.result.close();
        } catch (SQLException ex) {
            System.out.println("Terjadi error saat generate ID: " + ex);
        }
    }


    @FXML
    protected void btnsearchRuanganTransaksi(){
        try{
            List<Ruangan> vr = new ArrayList<>();
            connection.stat = connection.conn.createStatement();
            String query = "SELECT id_trsruangan,nama_customer FROM transaksi_penyewaanruangan WHERE id_trsruangan = "+ txtIdRuangan.getText();
            connection.result = connection.stat.executeQuery(query);

            if(connection.result.next()){
                int idruangan = connection.result.getInt("id_trsruangan");
                String namaCustomer = connection.result.getString("nama_customer");
                alert.showAlert(Alert.AlertType.INFORMATION,"INFORMATION","Data pada id ruangan "+idruangan +" dengan customer "+ namaCustomer+" ditemukan",false);
            }else{
                alert.showAlert(Alert.AlertType.INFORMATION,"INFORMATION","Data tersebut tidak ada",false);
                txtIdRuangan.setText("");
            }

        }catch (SQLException e){
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR","Data tidak ada",false);
        }
    }


    public double getDurasiFromFunction(DBconnect connection, LocalDateTime jmMulai, LocalDateTime jmSelesai){
    try{
        String sql = "SELECT dbo.fn_hitungDurasiPenyewaan (?, ?) AS durasi";
        connection.pstat = connection.conn.prepareStatement(sql);
        connection.pstat.setTimestamp(1, Timestamp.valueOf(jmMulai));
        connection.pstat.setTimestamp(2, Timestamp.valueOf(jmSelesai));

        ResultSet rs = connection.pstat.executeQuery();
        if (rs.next()) {
            return rs.getDouble("durasi");
        }

        rs.close();
        connection.pstat.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return 0;
    }

    public void hitungDurasiDanHarga() {
        try {
           LocalDate tanggal = tglTransaksiRuangan.getValue();
           LocalTime jamMulai = cbJamMulai.getValue();
           LocalTime jamSelesai = cbJamSelesai.getValue();

           if (jamMulai != null && jamSelesai != null) {
               LocalDateTime mulai = LocalDateTime.of(tanggal, jamMulai);
               LocalDateTime selesai = LocalDateTime.of(tanggal, jamSelesai);

               double durasi = getDurasiFromFunction(connection, mulai, selesai);
               if (durasi <= 0) {
                   alert.showAlert(Alert.AlertType.WARNING,"WARNING","Jam selesai tidak boleh kurang dari jam mulai",false);
                   cbJamMulai.setValue(null);
                   cbJamSelesai.setValue(null);
                   return;
               }else if(durasi == 0){
                   alert.showAlert(Alert.AlertType.WARNING,"WARNING","Jam mulai dan jam selesai tidak boleh sama",false);
                   return;
               }
               else{
                   lblDurasi.setText(String.format("%.2f jam", durasi));
               }

               // Hitung total harga
               double diskon = txtDiskonTR.getText().isEmpty() ? 0 : Double.parseDouble(txtDiskonTR.getText());
               double hargaAwal = durasi * hargaRuangan;
               double totalHarga = hargaAwal - (hargaAwal * diskon / 100);

               lblTotalPenyewaan.setText(String.format("Rp %,.2f", totalHarga));
               totalRuangan = totalHarga;
               durasiPenyewaan = durasi;

           }else if (jamMulai == null || jamSelesai == null) {
               alert.showAlert(Alert.AlertType.WARNING, "WARNING","jam mulai dan selesai tidak boleh kosong",false);
           }
        } catch (NumberFormatException e) {
            lblDurasi.setText("Input tidak valid");
            lblTotalPenyewaan.setText("Rp 0");
        }
    }

    int tmpKary;
    public void setName(int id, String nama) {
            lblNamaKaryawan.setText(nama);
            tmpKary = id;
    }

    @FXML
    private void loadDataFromDatabaseRuangan() {
        statusRuangan = "Aktif";

        try {
            List<Ruangan> viewRn = new ArrayList<>();
            String sql = "SELECT * FROM master_Ruangan";

            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            while (connection.result.next()) {
                viewRn.add(new Ruangan(
                        connection.result.getInt("id_Ruangan"),
                        connection.result.getString("tipe_Ruangan"),
                        connection.result.getString("kapasitas"),
                        connection.result.getInt("tarif_perjam"),
                        connection.result.getString("status")
                ));

                dataRuangan.getItems().setAll(viewRn);
                // connection.result.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void reloadDataRuangan() {
        dataRuangan.setCellFactory(parameter -> new ListCell<Ruangan>() {
            @Override
            protected void updateItem(Ruangan item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("itemRuangan.fxml"));
                        HBox itemBox = fxmlLoader.load();
                        ItemRuangan controller = fxmlLoader.getController();
                        controller.setDataTransaksiRuangan(item, DasTransaksi.this);
                        setGraphic(itemBox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    public void cekRuangan(Ruangan ruangan){
       hargaRuangan = ruangan.getTarif_ruangan();
       statusRuangan = ruangan.getStatus();
       idruangan = ruangan.getId_ruangan();
       dataRuangan.setVisible(false);
    }

    @FXML
    private void loadDataFromDatabaseMenu() {
//        statusRuangan = "Aktif";

        try {
            List<Menu> viewMenu = new ArrayList<>();
            String sql = "SELECT * FROM master_Menu";

            connection.pstat = connection.conn.prepareStatement(sql);
            connection.result = connection.pstat.executeQuery();

            while (connection.result.next()) {
                viewMenu.add(new Menu(
                        connection.result.getInt("ID_Menu"),
                        connection.result.getString("nama_menu"),
                        connection.result.getString("kategori_menu"),
                        connection.result.getInt("harga_MENU"),
                        connection.result.getString("status")
                ));

                dataMenu.getItems().setAll(viewMenu);
                // connection.result.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void reloadDataMenu() {
        dataMenu.setCellFactory(parameter -> new ListCell<Menu>() {
            @Override
            protected void updateItem(Menu mn, boolean empty) {
                super.updateItem(mn, empty);

                if (empty || mn == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("itemMenu.fxml"));
                        HBox itemBox = fxmlLoader.load();
                        ItemMenu controller = fxmlLoader.getController();
                        controller.setDataTransaksiMenu(mn, DasTransaksi.this);
                        setGraphic(itemBox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }



    private ObservableList<keranjangMenu> keranjangItems = FXCollections.observableArrayList();

    public void setQuantityMenu(keranjangMenu keranjangMenu) {
        if (keranjangMenu.getQuantity() <= 1){
            alert.showAlert(Alert.AlertType.CONFIRMATION,"INFORMATION", "Apakah anda yakin ingin menghapus menu ini?",false);
            if(true) {
                dataKeranjangMenu.getItems().remove(keranjangMenu);
                reloadKeranjangMenu();
                updateTotalHarga();
            }else{
                reloadKeranjangMenu();
                updateTotalHarga();
            }
        }else {
            keranjangMenu.setQuantity(keranjangMenu.getQuantity() - 1);
            reloadKeranjangMenu();
            updateTotalHarga();
        }
    }

    public void cekMenu(Menu menu){

        if(menu == null){
            alert.showAlert(Alert.AlertType.INFORMATION,"EMPTY","Data kosong",false);
            return;
        }

        hargaMenu = menu.getHargaMenu();
        statusMenu = menu.getStatus();
        kategoriMenu = menu.getKategoriMenu();
        idmenu = menu.getIdMenu();
        namaMenu = menu.getNamaMenu();

        boolean itemExists = false;
        for (keranjangMenu item : keranjangItems) {
            if (item.getIdMenu() == idmenu) {
                item.setQuantity(item.getQuantity() + 1); // Tambah quantity jika sudah ada
                itemExists = true;
                break;
            }
        }

        if (!itemExists) {
            // Tambahkan item baru jika belum ada
            keranjangItems.add(new keranjangMenu(idmenu, namaMenu, kategoriMenu, hargaMenu, 1));
        }
        //totalMenu.setText(String.valueOf(tampungHarga));
       // loadDataForDatabaseKeranjangMenu(hargaMenu, idmenu, namaMenu, kategoriMenu,quantity);
        reloadKeranjangMenu();
        updateTotalHarga();

    }
    private void updateTotalHarga() {
        totalKeranjangMenu = 0;
        for (keranjangMenu item : keranjangItems) {
            totalKeranjangMenu += item.getHargaMenu() * item.getQuantity();
            quantity += item.getQuantity();
            if(item.getQuantity() > 10){
                alert.showAlert(Alert.AlertType.WARNING,"WARNING","Pesanan tidak boleh lebih dari 10",false);
                item.setQuantity(item.getQuantity() - 1);
                reloadKeranjangMenu();
                updateTotalHarga();
            }
        }
        totalMenu.setText("Rp. " + totalKeranjangMenu); // Langsung set label
    }


//    public void loadDataForDatabaseKeranjangMenu(double hargaMenu, int idmenu, String nmu, String kategorimenu,int quantity) {
//        List<keranjangMenu> cek = new ArrayList<>();
//
//
//
//
////        cek.add(new keranjangMenu(idmenu, nmu, kategorimenu, hargaMenu,quantity));
////
////        dataKeranjangMenu.getItems().setAll(cek);
//    }

    private void reloadKeranjangMenu() {
        dataKeranjangMenu.setItems(keranjangItems);
        dataKeranjangMenu.setCellFactory(parameter -> new ListCell<keranjangMenu>() {
            @Override
            protected void updateItem(keranjangMenu mn, boolean empty) {
                super.updateItem(mn, empty);

                if (empty || mn == null) {
                    setText(null);
                    setGraphic(null);
                }else{
                    try{
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("itemKeranjangMenu.fxml"));
                        HBox itemBox = fxmlLoader.load();
                        ItemKeranjangMenu controller = fxmlLoader.getController();
                        controller.setDataTransaksiKeranjangMenu(mn, DasTransaksi.this);
                        setGraphic(itemBox);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }




//
//    @FXML
//    protected void onClickCariMember()  {
//        try{
//            connection.stat = connection.conn.createStatement();
//            String sql = "SELECT ID_Member FROM master_Member";
//
//
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @FXML
    private void onClickBatal() {

        txtPembayaran.setText("");
        txtIdMember.setText("");
        txtNamaTransaksi.setText("");
        txtNotelpTransaksi.setText("");
        txtDiskonTR.setText("");
        dataRuangan.setVisible(true);
        lblDurasi.setText("");
        loadDataFromDatabaseRuangan();
        reloadDataRuangan();
        cbJamMulai.setValue(null);
        cbJamSelesai.setValue(null);
        lblTotalPenyewaan.setText("");
        lblTotalKembali.setText("");
        tfNamaMember.clear();
        tfNoTelpMember.clear();
        tfDiskonTransaksiMember.clear();
        tfTotalPembayaran.clear();

        // Reset ComboBox selection
        cbTipeMember.getSelectionModel().clearSelection();

        // Reset Labels
        lblTarif.setText("");
        lblKembalianMember.setText("");

        // Reset DatePicker to today
        tglTransaksiRuangan.setValue(LocalDate.now());

    }

    @FXML
    protected void onClickHitung(){
        hitungDurasiDanHarga();
        if (txtPembayaran.getText().isEmpty()){
            alert.showAlert(Alert.AlertType.WARNING,"ERROR","Data pembayaran tidak boleh kosong",false);
            return;
        }
        totalPembayaran = Double.parseDouble(txtPembayaran.getText());

        //totalRuangan = Double.parseDouble(lblTotalPenyewaan.getText());
        if (totalPembayaran < totalRuangan){
            alert.showAlert(Alert.AlertType.INFORMATION,"ERROR","Jumlah pembayaran kurang dari total penyewaan ruangan",false);
            return;
        }else {
            totalkembalian = totalPembayaran - totalRuangan;
        }

        lblTotalKembali.setText(String.format("%.2f", totalkembalian));
    }

    Karyawan kry = new Karyawan();
    Ruangan rng = new Ruangan();

    @FXML
    protected void onClickCariMember(){
        int idmbr = txtIdMember.getText().isEmpty() ? 0 : Integer.parseInt(txtIdMember.getText());
        if (idmbr == 0){
            txtIdMember.setVisible(false);
        }
        idmember = idmbr;
        txtIdMember.setText(String.valueOf(idmember));

        double diskonruang = txtDiskonTR.getText().isEmpty() ? 0 : Double.parseDouble(txtDiskonTR.getText());
        if (diskonruang == 0){
            txtDiskonTR.setVisible(false);
        }
        diskonRuangan = diskonruang;
        txtDiskonTR.setText(String.valueOf(diskonRuangan));
    }


    @FXML
    protected void onClickBayar(){

        if(txtNamaTransaksi.getText().isEmpty() || txtNotelpTransaksi.getText().isEmpty() || idruangan == 0 || cbJamMulai.getValue() == null || cbJamSelesai.getValue() == null){
            alert.showAlert(Alert.AlertType.WARNING,"ERROR","Data harus diisi", false);
            return;
        }

        //txtIdTransaksiRuangan.setVisible(false);
        //idtransaksi = Integer.parseInt(txtIdTransaksiRuangan.getText());
        idkaryawan = tmpKary;

        LocalDate tglTransaksi = tglTransaksiRuangan.getValue();
        LocalDateTime jamMulai = LocalDateTime.of(tglTransaksi, cbJamMulai.getValue());
        LocalDateTime jamSelesai = LocalDateTime.of(tglTransaksi, cbJamSelesai.getValue());
        namaMember = txtNamaTransaksi.getText();
        noHpTransaksiR = txtNotelpTransaksi.getText();
        statusRuangan = "Diproses";

        try{
            String query = "EXEC createTransaksiPenyewaanRuangan ?,?,?,?,?,?,?,?,?,?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setInt(1, idkaryawan);
            connection.pstat.setInt(2, idruangan);
            connection.pstat.setDate(3, Date.valueOf(tglTransaksi));
            connection.pstat.setInt(4, idmember);
            connection.pstat.setString(5, namaMember);
            connection.pstat.setString(6, noHpTransaksiR);
            connection.pstat.setTimestamp(7, Timestamp.valueOf(jamMulai));
            connection.pstat.setTimestamp(8, Timestamp.valueOf(jamSelesai));
            connection.pstat.setDouble(9, diskonRuangan);
            connection.pstat.setString(10, statusRuangan);
            connection.pstat.executeUpdate();

            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION,"SUCCESS", "Data berhasil diisi", false);
        } catch (SQLException e) {
            System.out.println("Terjadi error saat insert data transaksi: " + e);
        }finally {
            loadDataFromDatabaseRuangan();
            reloadDataRuangan();
            onClickBatal();
            txtIdMember.setVisible(true);
            txtDiskonTR.setVisible(true);
        }

    }

//    @FXML
//    protected void onClickBayarRuangan(){
//        txtIdTransaksiRuangan.setVisible(false);
//        idkaryawan = kry.getId_karyawan();
//        idmember = Integer.parseInt(txtIdMember.getText());
//        LocalDate tglTransaksi = tglTransaksiRuangan.getValue();
//        LocalTime jamMulai = cbJamMulai.getValue();
//        LocalTime jamSelesai = cbJamSelesai.getValue();
//        namaMember = txtIdMember.getText();
//        noHpTransaksiR = txtNotelpTransaksi.getText();
//        diskonRuangan = Double.parseDouble(txtDiskonTR.getText());
//
//        try{
//            String query = "EXEC createTransaksiPenyewaanRuangan ?,?,?,?,?,?,?,?,?,?";
//            connection.pstat = connection.conn.prepareStatement(query);
//            connection.pstat.setInt(1, idkaryawan);
//            connection.pstat.setInt(2, idruangan);
//            connection.pstat.setDate(3, Date.valueOf(tglTransaksi));
//            connection.pstat.setInt(4, idmember);
//            connection.pstat.setString(5, namaMember);
//            connection.pstat.setString(6, noHpTransaksiR);
//            connection.pstat.setTime(7, Time.valueOf(jamMulai));
//            connection.pstat.setTime(8, Time.valueOf(jamSelesai));
//            connection.pstat.setDouble(9, diskonRuangan);
//            connection.pstat.setDouble(10, durasiPenyewaan);
//            connection.pstat.setDouble(11, totalRuangan);
//            connection.pstat.setString(12, statusRuangan);
//
////            ResultSet rs = connection.pstat.executeQuery();
////            if (rs.next()){
////
////            }
//
//            connection.pstat.executeUpdate();
//            connection.pstat.close();
//        } catch (SQLException e) {
//            System.out.println("Terjadi error saat insert data Ruangan: " + e);
//        }
//        //showAlert("Succes", "Ruangan berhasil diisi");
//
//    }

private void  loadDataTipeMember() {
    try {
        String query = "SELECT id_member, tipe_member, diskon_member, harga_member FROM master_Member";
        connection.pstat = connection.conn.prepareStatement(query);
        connection.result = connection.pstat.executeQuery();

        while (connection.result.next()){
            int id = connection.result.getInt("id_member");
            String nama = connection.result.getString("tipe_member");
            double diskon = connection.result.getDouble("diskon_member");
            double harga = connection.result.getDouble("harga_member");

            cbTipeMember.getItems().add(nama);
            tipeMemberMap.put(nama, new Member(id, diskon, harga));
        }

       connection.pstat.close();
    } catch (SQLException e) {
        System.out.println("Gagal load data Tipe Member: " + e.getMessage());
    }
}

    @FXML
    protected void onClickBayarMember() {
        // Validate input
        if (tfNamaMember.getText().isEmpty() ||
                 tfNoTelpMember.getText().isEmpty() ||
                tfDiskonTransaksiMember.getText().isEmpty() ||
                cbTipeMember.getValue() == null ||
                tfTotalPembayaran.getText().isEmpty()) {

            alert.showAlert(Alert.AlertType.WARNING, "Peringatan", "Lengkapi semua data terlebih dahulu!", false);
            return;
        }

        // Ambil data dari input
        int id_karyawan = tmpKary;
        String selectedTipe = cbTipeMember.getValue();
        Member selectedMember = tipeMemberMap.get(selectedTipe);

        if (selectedMember == null) {
            alert.showAlert(Alert.AlertType.ERROR, "Error", "Data member tidak ditemukan!", false);
            return;
        }

        int id_member = selectedMember.getIdMember();
        String tipe_member = selectedTipe;
        LocalDate tanggal = LocalDate.now();
        String nama = tfNamaMember.getText();
        String nohp = tfNoTelpMember.getText();
        double diskon = selectedMember.getDiskonMember();
        double totalHarga;

        try {
            totalHarga = Double.parseDouble(tfTotalPembayaran.getText());
        } catch (NumberFormatException e) {
            alert.showAlert(Alert.AlertType.ERROR, "Error", "Format bayar tidak valid!", false);
            return;
        }

        String status = "Diproses";

        // Eksekusi stored procedure
        try {
            String query = "EXEC createTransaksiMember ?,?,?,?,?,?,?,?,?";
            connection.pstat = connection.conn.prepareStatement(query);
            connection.pstat.setInt(1, id_karyawan);
            connection.pstat.setInt(2, id_member);
            connection.pstat.setString(3, tipe_member);
            connection.pstat.setDate(4, Date.valueOf(tanggal));
            connection.pstat.setString(5, nama);
            connection.pstat.setString(6, nohp);
            connection.pstat.setDouble(7, diskon);
            connection.pstat.setDouble(8, totalHarga);
            connection.pstat.setString(9, status);
            connection.pstat.executeUpdate();

            connection.pstat.close();
            alert.showAlert(Alert.AlertType.INFORMATION, "SUCCESS", "Transaksi berhasil disimpan", false);
        } catch (SQLException e) {
            System.out.println("Terjadi error saat insert transaksi member: " + e);
            alert.showAlert(Alert.AlertType.ERROR, "ERROR", "Gagal menyimpan transaksi", false);
        } finally {
            onClickBatal();
        }
    }

    public void handleTransaksiClicks(ActionEvent event) {
        if (event.getSource() == btnTrRuangan) {
            pnlTransaksiRuangan.setStyle("-fx-background-color : #ffffff");
            pnlTransaksiRuangan.toFront();
            loadDataFromDatabaseRuangan();
            reloadDataRuangan();
            //generateIDTransaksiRuangan();
        }
        if (event.getSource() == btnTrMenu) {
            pnlTransaksiMenu.setStyle("-fx-background-color : #ffffff");
            pnlTransaksiMenu.toFront();
            loadDataFromDatabaseMenu();
            reloadDataMenu();

        }
        if (event.getSource() == btnTrMember) {
            pnlTransaksiMember.setStyle("-fx-background-color : #ffffff");
            pnlTransaksiMember.toFront();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String tanggal = LocalDate.now().format(formatter);
            tfTanggalPembuatan.setText(tanggal);
        }
    }



    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnHomeTransaksi) {
            pnlHomeTransaksi.setStyle("-fx-background-color : #ffffff");
            pnlHomeTransaksi.toFront();
        }
        if (actionEvent.getSource() == btnMemberTransaksi) {
            pnlMemberTransaksi.setStyle("-fx-background-color : #ffffff");
            pnlMemberTransaksi.toFront();
        }
        if(actionEvent.getSource() == btnTransaksi ) {
            pnlTransaksi.setStyle("-fx-background-color : #ffffff");
            pnlTransaksi.toFront();
        }
    }



}
