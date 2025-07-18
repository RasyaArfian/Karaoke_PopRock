package Master;

public class Menu {
    private int idMenu;
    private String namaMenu;
    private String kategoriMenu;
    private int hargaMenu;
    private String status;

    public Menu(){

    }


    public Menu(int idMenu, String namaMenu, String kategoriMenu, int hargaMenu) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.kategoriMenu = kategoriMenu;
        this.hargaMenu = hargaMenu;
    }

    public Menu(int idMenu, String namaMenu, String kategoriMenu, int hargaMenu, String status) {
        this.idMenu = idMenu;
        this.namaMenu = namaMenu;
        this.kategoriMenu = kategoriMenu;
        this.hargaMenu = hargaMenu;
        this.status = status;
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

    public String getKategoriMenu() {
        return kategoriMenu;
    }

    public void setKategoriMenu(String kategoriMenu) {
        this.kategoriMenu = kategoriMenu;
    }

    public int getHargaMenu() {
        return hargaMenu;
    }

    public void setHargaMenu(int hargaMenu) {
        this.hargaMenu = hargaMenu;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
