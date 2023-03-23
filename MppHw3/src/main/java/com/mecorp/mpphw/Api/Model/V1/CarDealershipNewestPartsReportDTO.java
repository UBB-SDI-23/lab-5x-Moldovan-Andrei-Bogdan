package com.mecorp.mpphw.Api.Model.V1;

public class CarDealershipNewestPartsReportDTO {
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private Integer yearFounded;
    private String address;
    private Integer partsAppearYearAverage;

    public CarDealershipNewestPartsReportDTO(Integer id, String name, String phoneNumber, String email, Integer yearFounded, String address, Integer partsYearAverage) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.yearFounded = yearFounded;
        this.address = address;
        this.partsAppearYearAverage = partsYearAverage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPartsAppearYearAverage() {
        return partsAppearYearAverage;
    }

    public void setPartsAppearYearAverage(Integer partsYearAverage) {
        this.partsAppearYearAverage = partsYearAverage;
    }
}
