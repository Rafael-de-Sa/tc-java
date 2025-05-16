/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package br.edu.ifpr;

import br.edu.ifpr.dao.EnterpriseDAO;
import br.edu.ifpr.model.entity.Enterprise;

/**
 *
 * @author rafae
 */
public class TCProject {
    
    public static void main(String[] args) {
        EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
        /*
        Enterprise enterprise = new Enterprise("Empresa teste 1", "Empresa Teste Um LTDA", "123412312312", "Rua tal, 420, bairro do piriri,- Umuarama/PR", "sitesitesite.gov", "./assets/logos/logoum.png", "441234565", "sitesitesite@gov.br", true);

        enterpriseDAO.create(enterprise);
         */
        
        Enterprise enterprise = enterpriseDAO.retrieve(1);
        
       /* System.out.println(enterprise.toString());
        
        enterprise.setWebsite("www.sitedaempresa.com");
        
        enterpriseDAO.update(enterprise);
        
        System.out.println(enterprise.toString());*/
        
    }
    
}
