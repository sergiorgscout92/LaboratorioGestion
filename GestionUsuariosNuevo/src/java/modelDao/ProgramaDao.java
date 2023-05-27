/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelDao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Programa;

/**
 *
 * @author APRENDIZ
 */
public class ProgramaDao {
    Conexion cn=new Conexion();
    Programa po =new Programa();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;

    public Programa listadoP(int codpro) {
       String sql = "select * from programa where codprograma="+codpro;
    try{
    con=cn.getConnection();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    po.setCodprograma(rs.getInt("codprograma"));
    po.setNombreprograma(rs.getString("nombrepro"));
    }
    }catch(Exception e){
            
        }
    return po; 
    }

    public List listadopro() {
        ArrayList<Programa> lista = new ArrayList<Programa>();
        String sql ="select * from programa";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Programa pro = new Programa();
                pro.setCodprograma(rs.getInt("codprograma"));
                pro.setNombreprograma(rs.getString("nombrepro"));
                lista.add(pro);
            }
            
        }catch(SQLException ex){
                    
        }
        return lista;
    }

    public boolean Registrarpro(Programa pro) {
        String sql="insert into programa(codprograma,nombrepro)values('"+pro.getCodprograma()+"','"+pro.getNombreprograma()+"')";
                 try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"programa registrado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "error al abrir conexion");
        }
        
        return false;
    }

    public boolean actualizarpro(Programa pro) {
        String sql="update programa set nombrepro='"+po.getNombreprograma()+"' where codprograma ="+po.getCodprograma()+"";
    try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        
    }catch(Exception e){
        
    }
    return false;
    }
   

    public boolean eliminarpro(int codprograma) {
        String sql="delete from programa where codprograma="+codprograma;
    try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
    } catch (Exception e){
    }
    return false;
    }
    }

