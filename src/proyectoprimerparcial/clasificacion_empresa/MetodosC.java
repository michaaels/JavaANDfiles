
package proyectoprimerparcial.clasificacion_empresa;

import java.util.HashMap;

public interface MetodosC {
    public void Ingreso(HashMap n, String i);
    public void Buscar(HashMap n);
    public void Editar(HashMap n);
    public void Eliminar(HashMap n);
    public void MostrarColeccion(HashMap n);
    public boolean ExisteNoexiste(HashMap n);
    public int ContarNumColeccion(HashMap n);
}

