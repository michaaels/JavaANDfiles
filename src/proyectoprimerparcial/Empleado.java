
package proyectoprimerparcial;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import proyectoprimerparcial.clasificacion_empresa.Area;
import proyectoprimerparcial.clasificacion_empresa.Cargo;
import proyectoprimerparcial.clasificacion_empresa.Departamento;

public class  Empleado extends Datos implements M_Empleados,Serializable{
    //cedula, nombres, apellidos, domicilio 
    protected String Cedula;
    protected String Nombre;
    protected String Apellido;
    protected String Apellido2;
    protected int EdadActual;
    protected String Direccion;
    protected String EstadoCivil;
    protected String CodigoEmpleado;
    protected String JornadaLaboral;
    protected String Discapacidad;

    public Empleado(String Cedula, String Nombre, String Apellido, String Apellido2, int EdadActual, String Direccion, String EstadoCivil, String CodigoEmpleado, String JornadaLaboral, String Discapacidad, String FechaInicioContrato, String FechaFinContrato, String Departamento, String Area, String Cargo) {
        super(FechaInicioContrato, FechaFinContrato, Departamento, Area, Cargo);
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Apellido2 = Apellido2;
        this.EdadActual = EdadActual;
        this.Direccion = Direccion;
        this.EstadoCivil = EstadoCivil;
        this.CodigoEmpleado = CodigoEmpleado;
        this.JornadaLaboral = JornadaLaboral;
        this.Discapacidad = Discapacidad;
    }

   

     public Empleado(){
     super();
     }
    
    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    
    
    public int getEdadActual() {
        return EdadActual;
    }

    public void setEdadActual(int EdadActual) {
        this.EdadActual = EdadActual;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

    public String getCodigoEmpleado() {
        return CodigoEmpleado;
    }

    public void setCodigoEmpleado(String CodigoEmpleado) {
        this.CodigoEmpleado = CodigoEmpleado;
    }

    public String getJornadaLaboral() {
        return JornadaLaboral;
    }

    public void setJornadaLaboral(String JornadaLaboral) {
        this.JornadaLaboral = JornadaLaboral;
    }

    public String getDiscapacidad() {
        return Discapacidad;
    }

    public void setDiscapacidad(String Discapacidad) {
        this.Discapacidad = Discapacidad;
    }
    
    
    
   public boolean Ingreso(HashMap emp,HashMap depa,HashMap area,HashMap carg){

       Scanner obj =new Scanner(System.in);
       boolean v;

       System.out.println("DATOS DEL EMPLEADO");
       System.out.println("Cedula: \t");
       this.Cedula=obj.nextLine();
       if (!emp.containsKey(this.Cedula)) {
            v=true;
            System.out.println("Nombre: \t");
            this.Nombre=obj.nextLine();
            System.out.println("Apellido Materno: \t");
            this.Apellido=obj.nextLine();
            System.out.println("Apellido Paterno: \t");
            this.Apellido2=obj.nextLine();
            System.out.println("Direccion: \t");
            this.Direccion=obj.nextLine();
            System.out.println("Estado civil: ");
            this.EstadoCivil=obj.nextLine();
            System.out.println("Codigo empleado: ");
            this.CodigoEmpleado=obj.nextLine();
            System.out.println("Estado civil: ");
            this.EstadoCivil=obj.nextLine();
            System.out.println("Fecha inicio contrato: ");
            super.FechaInicioContrato=obj.nextLine();
            System.out.println("Fechafin contrato: ");
            super.FechaFinContrato=obj.nextLine();
            System.out.println("Jornada laboral: ");
            this.JornadaLaboral=obj.nextLine();
            System.out.println("Discapacidad: ");
            this.Discapacidad=obj.nextLine();
            
            //ProyectoPrimerParcial m =new ProyectoPrimerParcial();
            Departamento dep = new Departamento();
            dep=dep.BuscarDep(depa);
            //System.out.println("Escoja un Departamento: ");
            super.setDepartamento(dep.getNombre());
            
            Area ar = new Area();
            ar=ar.BuscarArea(area);
            //System.out.println("Area: ");
            super.setArea(ar.getNombre());
            
            Cargo cr = new Cargo();
            cr=cr.BuscarCargo(carg);
            //System.out.println("Cargo: ");
            super.setCargo(cr.getNombre());
       
        }else{
            System.out.println("El empleado ya se encuentra registrado");
            v=false;
        }
       
       return v;
   }

   @Override
    public String BuscarEmpleado(HashMap emplist,String cod) {
        Empleado e;
        boolean v=true;
        Map<String, Empleado> mapemp = emplist;//Convertir de hashmap a map para buscar
        
        for(Map.Entry<String, Empleado> EmpFind : mapemp.entrySet()) {
            System.out.println(EmpFind.getValue().Nombre);
            if(EmpFind.getValue().CodigoEmpleado.equals(cod)){
                e=EmpFind.getValue();
                System.out.println(e);
                break;
            }else{
                v=false;
            }
            
            if(v=false)
                System.out.println("No se encontro el empleado");
          
        }
        
    return null;

    }

    @Override
    public String FechaActual() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String GenerarLogin() {
        return this.Nombre.charAt(0)+this.Apellido+this.Apellido2.charAt(0);
    }
   /*         
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (this.Cedula== other.Cedula) {
            return false;
        }
        return true;
    }*/


    
    
    @Override
    public String toString(){
        return "Cedula:"+ this.Cedula
      +"Cedula: "+ this.Nombre+"Apellido: \t"+this.Apellido+" "+this.Apellido2+"Direccon: \t"+
            this.Direccion+"Estado civil: "+this.EstadoCivil+"Codigo empleado: "+this.CodigoEmpleado+"Estado civil: "+
            this.EstadoCivil+"Fecha inicio contrato: "+
            super.FechaInicioContrato+"Fechafin contrato: "+
            super.FechaFinContrato+"Jornada laboral: "+
            this.JornadaLaboral+"Discapacidad: "+
            this.Discapacidad+"Departamento: "+
            super.Departamento+"Area: "+
            super.Area+"Cargo: "+
            super.Cargo;
    }
}
