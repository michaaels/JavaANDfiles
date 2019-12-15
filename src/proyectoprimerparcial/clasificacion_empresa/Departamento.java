package proyectoprimerparcial.clasificacion_empresa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Departamento extends Clasificacion_Empresa implements Serializable{
    HashMap<String, Area> areas_dep = new HashMap();
    
    //Constructores
    public Departamento() {
    }
    public Departamento(String Codigo, String Nombre) {
        super(Codigo, Nombre);
    }
    
    //Get Set Sobrecarga
    public HashMap<String, Area> getAreas_dep() {
        return areas_dep;
    }
    public void setAreas_dep(HashMap<String, Area> areas_dep) {
        this.areas_dep = areas_dep;
    }
    public void setAreas_dep(Area a) {
       areas_dep.put(a.getCodigo(), a);
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
    @Override
    public void Buscar(HashMap n){
        Scanner ingreso= new Scanner(System.in);
        String busq_dep;
        this.MostrarColeccion(n);
        System.out.print("\n\n Ingrese departamento a Buscar: ");
        busq_dep = ingreso.nextLine();
        super.setNombre(busq_dep);
        if(ExisteNoexiste(n)== true)
            System.out.println("\n ****Departamento existente****");
        else
            System.out.println("\n ****Departamento inexistente****");
    }
    
    public Departamento BuscarDep(HashMap n) {
        Departamento s;
        Scanner ingreso= new Scanner(System.in);
        HashMap<String, Departamento> m = n;
        String busq_dep;
        boolean value = false;
        do{
            this.MostrarColeccion(n);
            System.out.print("\n\n Ingrese departamento o codigo a buscar: ");
            busq_dep = ingreso.nextLine();
            super.setCodigo(busq_dep);
            super.setNombre(busq_dep);
            if((m.get(busq_dep)!=null) || (ExisteNoexiste(m)== true)){
                value = true;
            } 
            else{
                System.out.print("\n*** Dato no encontrado, ingrese nuevamente ***");
            }  
        }while(value != true);
        s = m.get(busq_dep);
        return s;
    }
    @Override
    public boolean ExisteNoexiste(HashMap n){
        HashMap<String, Departamento> m;
        m = n;
        boolean exist_noexist = false;
        //m.get(super.Codigo);
        //if(m.get(super.Codigo) != null)
        //    exist_noexist = true;
        for (Map.Entry<String, Departamento> col_dpto : m.entrySet()) {
            if(col_dpto.getValue().getNombre().equals(super.Nombre))
                exist_noexist = true;
        }
        return exist_noexist;
    }
    @Override
    public void MostrarColeccion(HashMap n){
        HashMap<String, Departamento> m = n;
        /*for (Map.Entry<String, Departamento> col_dpto : m.entrySet()) {
        System.out.println("clave=" + col_dpto.getKey() + ", valor=" + col_dpto.getValue());
        }*/
        m.entrySet().forEach((col_dpto) -> {
            //col_dpto.getValue().toString();
            System.out.println(col_dpto.getKey() + " )\t " + col_dpto.getValue().getNombre());
        });
    }
    @Override
    public void Editar(HashMap n)
    {
        HashMap<String, Departamento> m;
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
        HashMap<String, Departamento> m;
        m = n;
        if(m.get(super.Codigo) != null)
        {
            m.remove(super.Codigo, m.get(super.Codigo));
        }
        else
        {
            System.out.println("Departamento no existe, no se puede eliminar");
        }
    }
    @Override
    public int ContarNumColeccion(HashMap n){
        int c=1;
        HashMap<String, Departamento> m = n;
        for (Map.Entry<String, Departamento> col_dpto : m.entrySet()) {
            c++;
        }
        return c;
    }
    
    //        HashMap<String, Departamento> Dptos_empresa = new HashMap();


    //INTERFAZ

    /*public void getBuscar(HashMap n){
        HashMap<String, Departamento> m;
        m = n;
        boolean exist_noexist = false;
        m.get(super.Codigo);
        if(m.get(super.Codigo) != null)
            exist_noexist = false;
        
       
    }
    
    
    public HashMap AgregarColeccion(HashMap n){
        if(n == null){ // Este if-else omitir
            n.put(this.Codigo, getClass());
        }
        else{
            //Validar si el departamento existe 
            if(this.ExisteNoexiste(n) == true)
                System.out.println("Departamento ya registrado");
            else
                n.put(this.Codigo, getClass());
        }
        return n;
    }
    
    public HashMap AgregarAreasDep(HashMap n, Area a){
        Departamento dep;
        HashMap<String, Departamento> m;
        m = n;
        boolean exist_noexist = ExisteNoexiste(m);
        for(Map.Entry<String, Departamento> col_dpto : m.entrySet()) {
            if(col_dpto.getKey().equals(super.getCodigo()))
            {
                dep = col_dpto.getValue();
                dep.setAreas_dep(a); //Aqui validar
            }
        }
        return n;
    }
    @Override
    public void Buscar_Mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String toString(){
        return "";
        
    }
*/
  
}
