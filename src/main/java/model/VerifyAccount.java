package model;

public class VerifyAccount {

    private String email;
    private String phone;
    private String verifyCode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "VerifyAccount{" +
                "email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
