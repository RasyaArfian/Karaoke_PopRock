package Master;

public class keranjangMenu {
    int idMenu;
    String namaMenu;
    String tipeMenu;
    double hargaMenu;
    int quantity;

    public keranjangMenu() {

    }

    public keranjangMenu(int idMenu, String namaMenu, String tipeMenu,double hargaMenu, int quantity) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.tipeMenu = tipeMenu;
        this.hargaMenu = hargaMenu;
        this.quantity = quantity;
    }

    public String getTipeMenu() {
        return tipeMenu;
    }

    public void setTipeMenu(String tipeMenu) {
        this.tipeMenu = tipeMenu;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public double getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(double hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
