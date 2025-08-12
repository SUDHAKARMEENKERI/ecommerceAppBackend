package model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class UserAddress {
    @NotBlank(message = "addressLine1 required")
    @Column
    private String addressLine1;
    @Column
    @NotBlank(message = "addressLine2 required")
    private String getAddressLine2;
    @Column
    @NotBlank(message = "state required")
    private String state;
    @Column
    @NotBlank(message = "district required")
    private String district;
    @Column
    @NotBlank(message = "pinCode required")
    private String pinCode;
    @Column
    @NotBlank(message = "street required")
    private String street;

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getGetAddressLine2() {
        return getAddressLine2;
    }

    public void setGetAddressLine2(String getAddressLine2) {
        this.getAddressLine2 = getAddressLine2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "UserAddress{" +
                "addressLine1='" + addressLine1 + '\'' +
                ", getAddressLine2='" + getAddressLine2 + '\'' +
                ", state='" + state + '\'' +
                ", district='" + district + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
