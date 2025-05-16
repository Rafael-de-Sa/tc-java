/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model.entity;

/**
 *
 * @author rafae
 */
public class Enterprise {

    private Integer enterprise_id;
    private String tradeName;
    private String registredName;
    private String cnpj;
    private String address;
    private String website;
    private String logo;
    private String phoneNumber;
    private String email;
    private Boolean active;

    public Enterprise() {
    }

    public Enterprise(String tradeName, String registredName, String cnpj, String address, String website, String logo, String phoneNumber, String email, Boolean active) {
        this.tradeName = tradeName;
        this.registredName = registredName;
        this.cnpj = cnpj;
        this.address = address;
        this.website = website;
        this.logo = logo;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.active = active;
    }

    public int getEnterprise_id() {
        return enterprise_id;
    }

    public void setEnterprise_id(int enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getRegistredName() {
        return registredName;
    }

    public void setRegistredName(String registredName) {
        this.registredName = registredName;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Enterprise{" + "enterprise_id=" + enterprise_id + ", tradeName=" + tradeName + ", registredName=" + registredName + ", cnpj=" + cnpj + ", address=" + address + ", website=" + website + ", logo=" + logo + ", phoneNumber=" + phoneNumber + ", email=" + email + ", active=" + active + '}';
    }

    public boolean validate() {
        return tradeName != null
                && registredName != null
                && cnpj != null
                && address != null
                && logo != null
                && phoneNumber != null
                && email != null
                && email.contains("@")
                && active != null;
    }

}
