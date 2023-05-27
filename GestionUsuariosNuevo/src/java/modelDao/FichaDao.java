package modelDao;

import config.Conexion;
import interfaz.MeFicha;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Ficha;
import java.util.ArrayList;
import java.util.List;

public class FichaDao implements MeFicha{
    Conexion cn=new Conexion();
    Connection con;
    ResultSet rs;
    PreparedStatement ps;
    Ficha fi = new Ficha();

    @Override
    public Ficha list(int cod) {
        String sql = "select * from ficha where codaficha="+cod;
    try{
    con=cn.getConnection();
    ps=con.prepareStatement(sql);
    rs=ps.executeQuery();
    while(rs.next()){
    fi.setCodficha(rs.getInt("codficha"));
    fi.setCantapre(rs.getInt("cantapre"));
    fi.setNombrepro(rs.getString("nombrepro"));
    fi.setNombreA(rs.getString("NombreA"));
    }
    }catch(Exception e){
            
        }
    return fi;
    }

    @Override
    public List listaFichas() {
        ArrayList<Ficha> lista = new ArrayList<Ficha>();
        String sql ="select * from ficha";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                fi.setCodficha(rs.getInt("codficha"));
                fi.setCantapre(rs.getInt("cantapre"));
                fi.setNombrepro(rs.getString("nombrepro"));
                fi.setNombreA(rs.getString("NombreA"));
                lista.add(fi);
            }
            
        }catch(Exception e){
                    
        }
        return lista;
    }

    @Override
    public boolean registroFicha(Ficha fi) {
        String sql="insert into ficha (codficha,cantapre,nombrepro,NombreA)values('"+fi.getCodficha()+"','"+fi.getCantapre()+"','"+fi.getNombrepro()+"','"+fi.getNombreA()+"')";
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Ficha registrada");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error, no se guardó la ficha"+ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminarFicha(int cod) {
        String sql="delete from ficha where codficha="+cod;
    try {
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
    } catch (Exception e){
    }
    return false;
    }

    @Override
    public boolean actualizarFicha(Ficha fi) {
        String sql = "INSERT INTO ficha (codficha, cantapre, nombrepro, NombreA) VALUES ('"+fi.getCodficha()+"','"+fi.getCantapre()+"','"+fi.getNombrepro()+"','"+fi.getNombreA()+"')";

        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
           
           
            JOptionPane.showMessageDialog(null, "Ficha registrada correctamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la ficha: " + e.getMessage());
        }
        return false;
    }


    
}