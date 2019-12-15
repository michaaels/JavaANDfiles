
package proyectoprimerparcial.clasificacion_empresa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Area extends Clasificacion_Empresa implements Serializable {
    HashMap<String, Cargo> cargos_area = new HashMap();
    
    public Area() {
    }

    public Area(String Codigo, String Nombre) {
        super(Codigo, Nombre);
    }

    public HashMap<String, Cargo> getCargos_area() {
        return cargos_area;
    }

    public void setCargos_area(HashMap<String, Cargo> cargos_area) {
        this.cargos_area = cargos_area;
    }

   

    
    @Override
    public void Ingreso(HashMap n, String i){
        do{
            super.IngresoDatos(i);
            if(ExisteNoexiste(n)== true)
                System.out.println(i +" existente, ingrese nuevamente, por favor");
            else
                super.setCodigo("00"+this.ContarNumColeccion(n)+"");
        }while(ExisteNoexiste(n) == true);
    }
    
    public void Buscar(HashMap n){
        Scanner ingreso= new Scanner(System.in);
        String busq;
        this.MostrarColeccion(n);
        System.out.print("\n\n Ingrese area a Buscar: ");
        busq = ingreso.nextLine();
        super.setNombre(busq);
        if(ExisteNoexiste(n)== true)
            System.out.println("\n ****Area existente****");
        else
            System.out.println("\n ****Area inexistente****");
    }
    public Area BuscarArea(HashMap n){//dep.get
        Area s;
        Scanner ingreso= new Scanner(System.in);
        HashMap<String, Area> m = n;
        String busq;
        boolean value = false;
        do{
            this.MostrarColeccion(n);
            System.out.print("\n\n Ingrese area o codigo a buscar: ");
            busq = ingreso.nextLine();
            super.setCodigo(busq);
            super.setNombre(busq);
            if((m.get(busq)!=null) || (ExisteNoexiste(m)== true)){
                value = true;
            } 
            else{
                System.out.print("\n*** Dato no encontrado, ingrese nuevamente ***");
            }  
        }while(value != true);
        s = m.get(busq);
        return s;
    }
    @Override
    public boolean ExisteNoexiste(HashMap n){
        HashMap<String, Area> m;
        m = n;
        boolean exist_noexist = false;
        //m.get(super.Codigo);
        //if(m.get(super.Codigo) != null)
        //    exist_noexist = true;
        for (Map.Entry<String, Area> col_area : m.entrySet()) {
            if(col_area.getValue().getNombre().equals(super.Nombre))
                exist_noexist = true;
        }
        return exist_noexist;
    }
    @Override
    public void MostrarColeccion(HashMap n){
        HashMap<String, Area> m = n;
        /*for (Map.Entry<String, Departamento> col_dpto : m.entrySet()) {
        System.out.println("clave=" + col_dpto.getKey() + ", valor=" + col_dpto.getValue());
        }*/
        m.entrySet().forEach((col_area) -> {
            //col_dpto.getValue().toString();
            System.out.println(col_area.getKey() + " )\t " + col_area.getValue().getNombre());
        });
    }
    @Override
    public void Editar(HashMap n)
    {
        HashMap<String, Area> m;
        m = n;
        if(m.get(super.Codigo) != null)
        {
            m.put(Codigo, this);
        }
        else
        {
            System.out.println("Departamento no existe, no se puede editar");
        }
    }
    @Override
    public void Eliminar(HashMap n)
    {
        HashMap<String, Area> m;
        m = n;
        if(m.get(super.Codigo) != null)
        {
            m.remove(super.Codigo, m.get(super.Codigo));
        }
        else
        {
            System.out.println("Area no existe, no se puede eliminar");
        }
    }
    @Override
    public int ContarNumColeccion(HashMap n){
        int c=1;
        HashMap<String, Area> m = n;
        for (Map.Entry<String, Area> col_dpto : m.entrySet()) {
            c++;
        }
        return c;
    }
    
    
}
