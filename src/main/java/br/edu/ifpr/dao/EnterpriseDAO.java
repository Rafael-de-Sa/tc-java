/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.dao;

import br.edu.ifpr.model.entity.Enterprise;
import br.edu.ifpr.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class EnterpriseDAO implements Dao<Integer, Enterprise> {

    @Override
    public void create(Enterprise entity) {
        String sql = "INSERT INTO enterprises (tradeName, registredName, cnpj, address, website, logo, phoneNumber, email, active) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {

            pstmt.setString(1, entity.getTradeName());
            pstmt.setString(2, entity.getRegistredName());
            pstmt.setString(3, entity.getCnpj());
            pstmt.setString(4, entity.getAddress());
            pstmt.setString(5, entity.getWebsite());
            pstmt.setString(6, entity.getLogo());
            pstmt.setString(7, entity.getPhoneNumber());
            pstmt.setString(8, entity.getEmail());
            pstmt.setBoolean(9, entity.isActive());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                int id = rs.getInt(1);
                entity.setEnterprise_id(id);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Enterprise retrieve(Integer id) {
        String sql = "SELECT * FROM enterprises WHERE enterprise_id = ?";

        Enterprise enterprise = null;

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                enterprise = new Enterprise();
                enterprise.setEnterprise_id(rs.getInt("enterprise_id"));
                enterprise.setTradeName(rs.getString("tradeName"));
                enterprise.setRegistredName(rs.getString("registredName"));
                enterprise.setCnpj(rs.getString("cnpj"));
                enterprise.setAddress(rs.getString("address"));
                enterprise.setWebsite(rs.getString("website"));
                enterprise.setLogo(rs.getString("logo"));
                enterprise.setPhoneNumber(rs.getString("phoneNumber"));
                enterprise.setEmail(rs.getString("email"));
                enterprise.setActive(rs.getBoolean("active"));

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return enterprise;
    }

    @Override
    public void update(Enterprise entity) {
        String sql = "UPDATE enterprises SET tradeName = ?, registredName = ?, cnpj = ?, address = ?, website = ?, logo = ?, phoneNumber = ?, email = ?, active = ?"
                + "WHERE enterprise_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setString(1, entity.getTradeName());
            pstmt.setString(2, entity.getRegistredName());
            pstmt.setString(3, entity.getCnpj());
            pstmt.setString(4, entity.getAddress());
            pstmt.setString(5, entity.getWebsite());
            pstmt.setString(6, entity.getLogo());
            pstmt.setString(7, entity.getPhoneNumber());
            pstmt.setString(8, entity.getEmail());
            pstmt.setBoolean(9, entity.isActive());
            pstmt.setInt(10, entity.getEnterprise_id());

            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM enterprises"
                + "WHERE enterprise_id = ?";

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Enterprise> findAll() {
        String sql = "SELECT * FROM enterprises";

        List<Enterprise> enterprises = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql);) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Enterprise enterprise = new Enterprise();
                enterprise.setEnterprise_id(rs.getInt("enterprise_id"));
                enterprise.setTradeName(rs.getString("tradeName"));
                enterprise.setRegistredName(rs.getString("registredName"));
                enterprise.setCnpj(rs.getString("cnpj"));
                enterprise.setAddress(rs.getString("address"));
                enterprise.setWebsite(rs.getString("website"));
                enterprise.setLogo(rs.getString("logo"));
                enterprise.setPhoneNumber(rs.getString("phoneNumber"));
                enterprise.setEmail(rs.getString("email"));
                enterprise.setActive(rs.getBoolean("active"));

                enterprises.add(enterprise);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return enterprises;
    }

}
