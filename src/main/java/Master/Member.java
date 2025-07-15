package Master;

public class Member {
    private int idMember;
    private String tipeMember;
    private double diskonMember;
    private double hargaMember;

    private Member(){

    }

    public Member(int idMember, String tipeMember, double diskonMember, double hargaMember) {
        this.idMember = idMember;
        this.tipeMember = tipeMember;
        this.diskonMember = diskonMember;
        this.hargaMember = hargaMember;
    }

    public Member(int id, double diskon, double harga) {
        this.idMember = id;
        this.diskonMember = diskon;
        this.hargaMember = harga;
    }

    public int getIdMember() {
        return idMember;
    }

    public void setIdMember(int idMember) {
        this.idMember = idMember;
    }

    public String getTipeMember() {
        return tipeMember;
    }

    public void setTipeMember(String tipeMember) {
        this.tipeMember = tipeMember;
    }

    public double getDiskonMember() {
        return diskonMember;
    }

    public void setDiskonMember(double diskonMember) {
        this.diskonMember = diskonMember;
    }

    public double getHargaMember() {
        return hargaMember;
    }

    public void setHargaMember(double hargaMember) {
        this.hargaMember = hargaMember;
    }
}
