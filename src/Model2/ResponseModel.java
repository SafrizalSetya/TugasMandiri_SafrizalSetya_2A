package Model2;

public class ResponseModel {
    private String massage;
    private String status;
    private String comment;

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public static void main(String[] args) {
        ResponseModel Respon = new ResponseModel();
        Respon.setMassage("data received");
        Respon.setStatus("hallo siswa algo2");
        Respon.setComment("anda sudah terkoneksi ke server mimoapps");
    }

    public void add(ResponseModel responseModel) {
    }
}
