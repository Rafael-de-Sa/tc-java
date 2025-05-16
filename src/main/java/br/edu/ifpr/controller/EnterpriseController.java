/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.controller;

import br.edu.ifpr.dao.EnterpriseDAO;
import br.edu.ifpr.model.entity.Enterprise;
import javax.swing.JOptionPane;

/**
 *
 * @author rafael
 */
public class EnterpriseController {
    
    private Enterprise enterprise = new Enterprise();
    private EnterpriseDAO enterpriseDao = new EnterpriseDAO();
    
    public EnterpriseController() {
    }
    
    public void createEnterprise(String tradeName, String registredName, String cnpj, String address, String website, String logo, String phoneNumber, String email, Boolean active) {
        
        enterprise.setTradeName(tradeName);
        enterprise.setRegistredName(registredName);
        enterprise.setCnpj(cnpj);
        enterprise.setAddress(address);
        enterprise.setWebsite(website);
        enterprise.setLogo(logo);
        enterprise.setPhoneNumber(phoneNumber);
        enterprise.setEmail(email);
        enterprise.setActive(active);
        
        if (enterprise.validate()) {
            //TODO: adicionar a enterprise a lista
            enterpriseDao.create(enterprise);
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os dados informados!");
        }
        
    }
    
}
