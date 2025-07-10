package Master;

public class Member {
    private int idMember;
    private String tipeMember;
    private int diskonMember;
    private int hargaMember;

    private Member(){

    }

    public Member(int idMember, String tipeMember, int diskonMember, int hargaMember) {
        this.idMember = idMember;
        this.tipeMember = tipeMember;
        this.diskonMember = diskonMember;
        this.hargaMember = hargaMember;
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

    public int getDiskonMember() {
        return diskonMember;
    }

    public void setDiskonMember(int diskonMember) {
        this.diskonMember = diskonMember;
    }

    public int getHargaMember() {
        return hargaMember;
    }

    public void setHargaMember(int hargaMember) {
        this.hargaMember = hargaMember;
    }
}
