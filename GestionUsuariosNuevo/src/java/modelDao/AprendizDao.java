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
import model.Aprendiz;

/**
 *
 * @author APRENDIZ
 */
public class AprendizDao {
    Conexion cn=new Conexion();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    Aprendiz ap =new Aprendiz();

    
    public Aprendiz list(int ide) {
        String sql = "select * from aprendiz where id="+ide;
    try{
    con=cn.getConnection();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    ap.setId(rs.getInt("id"));
    ap.setDocumentoa(rs.getInt("Docu"));
    ap.setNombrea(rs.getString("NombreA"));
    ap.setApellidoa(rs.getString("ApellidoA"));
    ap.setCorreoa(rs.getString("EmailA"));
    ap.setTelefonoa(rs.getInt("Telefono"));
    }
    }catch(Exception e){
            
        }
    return ap;
    }
    public List listadoA() {
        ArrayList<Aprendiz> lista = new ArrayList<Aprendiz>();
        String sql ="select * from aprendiz";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Aprendiz usu = new Aprendiz();
                usu.setId(rs.getInt("id"));
                usu.setDocumentoa(rs.getInt("Docu"));
                usu.setNombrea(rs.getString("NombreA"));
                usu.setApellidoa(rs.getString("ApellidoA"));
                usu.setCorreoa(rs.getString("EmailA"));
                usu.setTelefonoa(rs.getInt("Telefono"));
                lista.add(usu);
            }
            
        }catch(Exception e){
                    
        }
        return lista;
    }

    public boolean registrar(Aprendiz ap) {
        String sql="insert into aprendiz(Docu,NombreA,ApellidoA,EmailA,Telefono)values('"+ap.getDocumentoa()+"','"+ap.getNombrea()+"','"+ap.getApellidoa()+"','"+ap.getCorreoa()+"','"+ap.getTelefonoa()+"')";
                 try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"aprendiz registrado");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "error no se guarda aprendiz");
        }
        
        return false;
  
    }

    public boolean actualizar(Aprendiz ap) {
        String sql="update Aprendiz set Docu='"+ap.getDocumentoa()+"',Nombrea='"+ap.getNombrea()+"',Apellidoa='"+ap.getApellidoa()+"',EmailA='"+ap.getCorreoa()+"',Telefono='"+ap.getTelefonoa()+"'where id ="+ap.getId()+"";
    try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        
    }catch(Exception e){
        
    }
        return false;
    }

    public boolean eliminar(int id) {
    String sql="delete from Aprendiz where id="+id;
    try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
    } catch (Exception e){
    }
    return false;
    }

   
}
