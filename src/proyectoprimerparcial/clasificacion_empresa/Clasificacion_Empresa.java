package proyectoprimerparcial.clasificacion_empresa;

import java.util.HashMap;
import java.util.Scanner;

public abstract class Clasificacion_Empresa implements MetodosC{
    public String Codigo;
    public String Nombre;

    public Clasificacion_Empresa() {
    }

    public Clasificacion_Empresa(String Codigo, String Nombre) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    //public abstract int Busqueda();
    public void IngresoDatos(String i)
    {
        
        String nom;
        Scanner ingreso = new Scanner(System.in);
        do{
            System.out.println("Ingrese Nombre del "+i);
             nom = ingreso.nextLine();
            if("".equals(nom))
                System.out.println("***Parámetro no autorizado, ingrese bien departamento a agregar***");
            else
                setNombre(nom);
        }while("".equals(nom));
        
    }
    
    @Override
    public void Buscar(HashMap n){}
    @Override
    public String toString(){
        return this.getCodigo() +" )\t"+ this.getNombre()+"\n";
    }
}
