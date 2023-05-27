package interfaz;

import java.util.List;
import model.Ficha;


public interface MeFicha {
    public Ficha list(int cod);
    public List listaFichas();
    public boolean registroFicha(Ficha fi);
    public boolean eliminarFicha(int cod);
    public boolean actualizarFicha(Ficha fi);
}
