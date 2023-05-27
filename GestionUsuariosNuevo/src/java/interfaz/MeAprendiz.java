package interfaz;

import java.util.List;
import model.Aprendiz;

public interface MeAprendiz {
    public Aprendiz list(int id);
    public List listadoA();
    public boolean registrar(Aprendiz ap);
    public boolean actualizar(Aprendiz ap);
    public boolean eliminar(int id);
}
