package Master;

public class Karyawan {
    private int id_karyawan;
    private String nama_karyawan;
    private String noTelp_karyawan;
    private String username_karyawan;
    private String passwordkaryawan;
    private String role_password;
    private String Status_karyawan;

    public Karyawan() {

    }

    public Karyawan(int id_karyawan, String nama_karyawan, String noTelp_karyawan, String username_karyawan, String passwordkaryawan, String role_password, String status_karyawan) {
        this.id_karyawan = id_karyawan;
        this.nama_karyawan = nama_karyawan;
        this.noTelp_karyawan = noTelp_karyawan;
        this.username_karyawan = username_karyawan;
        this.passwordkaryawan = passwordkaryawan;
        this.role_password = role_password;
        Status_karyawan = status_karyawan;
    }

    public Karyawan(int idKaryawan, String namaKaryawan, String notelpKaryawan, String username, String role) {
        this.id_karyawan = idKaryawan;
        this.nama_karyawan = namaKaryawan;
        this.noTelp_karyawan = notelpKaryawan;
        this.username_karyawan = username;
        this.role_password = role;
    }

    public Karyawan(String user) {
        this.nama_karyawan = user;
    }

    public int getId_karyawan() {
        return id_karyawan;
    }

    public void setId_karyawan(int id_karyawan) {
        this.id_karyawan = id_karyawan;
    }

    public String getNama_karyawan() {
        return nama_karyawan;
    }

    public void setNama_karyawan(String nama_karyawan) {
        this.nama_karyawan = nama_karyawan;
    }

    public String getNoTelp_karyawan() {
        return noTelp_karyawan;
    }

    public void setNoTelp_karyawan(String noTelp_karyawan) {
        this.noTelp_karyawan = noTelp_karyawan;
    }

    public String getUsername_karyawan() {
        return username_karyawan;
    }

    public void setUsername_karyawan(String username_karyawan) {
        this.username_karyawan = username_karyawan;
    }

    public String getPasswordkaryawan() {
        return passwordkaryawan;
    }

    public void setPasswordkaryawan(String passwordkaryawan) {
        this.passwordkaryawan = passwordkaryawan;
    }

    public String getRole_password() {
        return role_password;
    }

    public void setRole_password(String role_password) {
        this.role_password = role_password;
    }

    public String getStatus_karyawan() {
        return Status_karyawan;
    }

    public void setStatus_karyawan(String status_karyawan) {
        Status_karyawan = status_karyawan;
    }
}
