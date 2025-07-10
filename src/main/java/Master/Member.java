package Master;

public class Member {
    private int idMember;
    private String tipeMember;
    private Double diskonMember;
    private Double hargaMember;

    private Member(){

    }

    public Member(int idMember, String tipeMember, Double diskonMember, Double hargaMember) {
        this.idMember = idMember;
        this.tipeMember = tipeMember;
        this.diskonMember = diskonMember;
        this.hargaMember = hargaMember;
    }

    public Member(int idMember, Double diskonMember, Double hargaMember) {
        this.idMember = idMember;
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

    public Double getDiskonMember() {
        return diskonMember;
    }

    public void setDiskonMember(Double diskonMember) {
        this.diskonMember = diskonMember;
    }

    public Double getHargaMember() {
        return hargaMember;
    }

    public void setHargaMember(Double hargaMember) {
        this.hargaMember = hargaMember;
    }
}
