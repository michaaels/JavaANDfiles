/*
Curso:      ISI-NO-4-6
Integrantes:
- Montenegro Valeriana Jhon
- Sánchez Rubio Michael
- Sellán Cárdenas Orlando
- Tenempaguay Borja Jenniffer
 */
package proyectoprimerparcial;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
//import proyectoprimerparcial.clasificacion_empresa.Clasificacion_Empresa;
import proyectoprimerparcial.clasificacion_empresa.Departamento;
import proyectoprimerparcial.clasificacion_empresa.Area;
import proyectoprimerparcial.clasificacion_empresa.Cargo;
//import proyectoprimerparcial.clasificacion_empresa.Cargo;

public class ProyectoPrimerParcial {
    HashMap <String,Empleado> emplist = new HashMap<>();
    HashMap<String, Departamento> Dptos_empresa = new HashMap();
    HashMap<String, Area> Areas_empresa = new HashMap();
    HashMap<String, Cargo> Cargos_empresa = new HashMap();
   
    
    public static void main(String[] args){
        Archivos arch=new Archivos();
        arch.LeerArchivo("Departamento",Dptos_empresa);
       /* arch.LeerArchivo("Empleado",emplist);//("NombreArchivo,HashMap lista")
        arch.LeerArchivo("Area",Areas_empresa);
        arch.LeerArchivo("Cargo",Cargos_empresa);*/
           
    ProyectoPrimerParcial m =new ProyectoPrimerParcial();
        m.MENU();
    }
    public static int OpcionesSistema()
    {
        Scanner ingreso= new Scanner(System.in);
        int opcion;
        boolean validar = false;
        do{
            try
            {
                do{
                    System.out.print("\nEscoja una opción");
                    System.out.print("\n1.    Ingreso - busqueda Personal");
                   //System.out.print("\n2.    Entrega - Recepcion claves de acceso ");
                    System.out.print("\n2.    Ingreso de Departamento - area - cargo");
                    System.out.print("\n0.    Salir del Sistema");
                    System.out.print("\nEscoja ---> ");
                    opcion = ingreso.nextInt();  
                }while(opcion<0 || opcion>3);
                validar = false;
            }
            catch(Exception e)
            {
                System.out.println("Ingrese datos numericos");
                opcion = 0;
                validar = true;
            }
        }while(validar == true);   
        return opcion; 
    }
    public static int OpcionesOrganizacionEmpresa()
    {
        Scanner ingreso= new Scanner(System.in);
        int opcion;
        boolean validar = false;
        do{
            try
            {
                do{
                    System.out.print("\nEscoja una opción");
                    System.out.print("\n1.    DEPARTAMENTOS");
                    System.out.print("\n2.    AREAS ");
                    System.out.print("\n3.    CARGOS");
                    System.out.print("\n0.    REGRESAR");
                    System.out.print("\nEscoja ---> ");
                    opcion = ingreso.nextInt();  
                }while(opcion<0 || opcion>3);
                validar = false;
            }
            catch(Exception e)
            {
                opcion = 0;
                validar = true;
            }
        }while(validar == true);   
        return opcion; 
    }
    public static int EdicionOrganizacion(String nom)
    {
        Scanner ingreso= new Scanner(System.in);
        int opcion;
        boolean validar = false;
        do{
            try
            {
                //do{
                    System.out.print("\n" +nom);
                    System.out.print("\nEscoja una opción");
                    System.out.print("\n1.    INGRESAR");
                    System.out.print("\n2.    EDITAR ");
                    System.out.print("\n3.    BUSCAR");
                    System.out.print("\n4.    ELIMINAR ");
                    System.out.print("\n0.    Salir ");
                    System.out.print("\nEscoja ---> ");
                    opcion = ingreso.nextInt();  
                //}while(opcion<0 || opcion>3);
                validar = false;
            }
            catch(Exception e)
            {
                opcion = 0;
                
                validar = true;
            }
        }while(validar == true);   
        return opcion; 
    }
    
    //EDIT
    public static void IngresoDepsAreasCargos() 
    {
        HashMap<String, Departamento> Dptos_empresa = new HashMap();
        
        ProyectoPrimerParcial m =new ProyectoPrimerParcial();
        
        String nom;
        int op;
        do{
            op= OpcionesOrganizacionEmpresa();
            switch(op){
                case 1:
                    nom = "DEPARTAMENTOS";
                    Dptos_empresa = m.EdicionDepartamentos(nom);
                    break;
                case 2:
                    nom = "AREAS";
                    Dptos_empresa = m.EdicionAreas(nom);
                    break;
                case 3:
                    nom = "CARGOS";
                    Dptos_empresa = m.EdicionCargos(nom);
                    break;
            }
        }while(op!=0);
    }
    //HERE
    public HashMap EdicionDepartamentos(String nom)
    {
        Scanner ingreso= new Scanner(System.in);
        Archivos arch = new Archivos();
        HashMap<String, Departamento> Dptos_empresa = new HashMap();
        Departamento depss= new Departamento();
        String edit_dep, edit_depn;
        int op;
        do{
            
            op= EdicionOrganizacion(nom);
            switch(op){
                case 1:
                {
                    System.out.println("INGRESAR");
                    //Ingreso de departamento
                    depss.MostrarColeccion(Dptos_empresa);
                    depss.Ingreso(Dptos_empresa, "departamento");
                    Dptos_empresa.put(depss.getCodigo(), depss);
                    try{
                    arch.EscribirArchivo(depss, "Departamento");
                    }catch(IOException e){
                        System.out.println(e+" 179");
                    }
                    break;
                }
                case 2:
                {
                    depss.Buscar(Dptos_empresa);
                    System.out.println("EDITAR DEPARTAMENTO");
                    break;
                }
                case 3:
                {
                    System.out.println("BUSCAR DEPARTAMENTO");
                    do{
                        System.out.println("Ingrese codigo de departamento a editar: ");
                        edit_dep = ingreso.nextLine();
                        depss.setCodigo(edit_dep);
                        if(Dptos_empresa.get(edit_dep) != null)
                        {
                            System.out.println("Departamento editable: ");
                            edit_depn = ingreso.nextLine();
                            depss.setNombre(edit_depn);
                            depss.Editar(Dptos_empresa);
                        }
                        else
                        {
                            System.out.println("Departamento no existe, no se puede modificar");
                            System.out.println("Revisar linea 207 el while mal");
                            break;
                        }
                    }while(Dptos_empresa.get(edit_dep) == null);
                    break;
                }
                case 4:
                {
                    System.out.println("ELIMINAR DEPARTAMENTO");
                    do{
                        depss.MostrarColeccion(Dptos_empresa);
                        System.out.println("Ingrese codigo de departamento: ");
                        edit_dep = ingreso.nextLine();
                        depss.setCodigo(edit_dep);

                        if(Dptos_empresa.get(edit_dep) != null)
                            depss.Eliminar(Dptos_empresa);
                        else
                            System.out.println("Departamento no existe, no se puede eliminar");

                        depss.MostrarColeccion(Dptos_empresa);
                        depss = new Departamento();
                    }while(Dptos_empresa.get(edit_dep) != null);
                    break;
                    
                }
                case 0:
                    break;
            }
            depss = new Departamento();
        }while(op!=0);
        return Dptos_empresa;
    }
    public  HashMap EdicionAreas(String nom)
    {
        Scanner ingreso= new Scanner(System.in);
        Archivos arch = new Archivos();
        HashMap<String, Departamento> Dptos_empresa = new HashMap();
        HashMap<String, Area> Areas_empresa = new HashMap();
        Departamento depss= new Departamento();
        Area a = new Area();
        String edit_dep, edit_depn;
        int op;
        //dep
        depss = depss.BuscarDep(Dptos_empresa);
        Areas_empresa = depss.getAreas_dep();
        do{
            
            op = EdicionOrganizacion(nom);
            switch(op){
                case 1:
                {
                    System.out.println("INGRESAR");
                    //Ingreso de departamento
                    a.MostrarColeccion(Areas_empresa);
                    a.Ingreso(Areas_empresa, "area");
                    Areas_empresa.put(a.getCodigo(), a);
                    try{
                    arch.EscribirArchivo(Areas_empresa, "Area");
                    }catch(IOException e){
                        System.out.println(e+" 264");
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("EDITAR AREA");
                    a.Buscar(Areas_empresa);
                    break;
                }
                case 3:
                {
                    System.out.println("BUSCAR AREA");
                    do{
                        System.out.print("Ingrese codigo de area a editar: \t");
                        edit_dep = ingreso.nextLine();
                        a.setCodigo(edit_dep);
                        if(Areas_empresa.get(edit_dep) != null)
                        {
                            System.out.print("Area modificadora: \t");
                            edit_depn = ingreso.nextLine();
                            a.setNombre(edit_depn);
                            a.Editar(Areas_empresa);
                        }
                        else
                        {
                            System.out.println("Area no existe, no se puede modificar");
                        }
                    }while(Areas_empresa.get(edit_dep) == null);
                    break;
                }
                case 4:
                {
                    System.out.println("\nELIMINAR AREA");
                    do{
                        a.MostrarColeccion(Areas_empresa);
                        System.out.print("Ingrese codigo de area: \t");
                        edit_dep = ingreso.nextLine();
                        a.setCodigo(edit_dep);

                        if(Areas_empresa.get(edit_dep) != null)
                        {
                            System.out.println("Datos eliminados");
                            a.MostrarColeccion(Areas_empresa);
                            a.Eliminar(Areas_empresa);
                        }
                        else
                            System.out.println("Area no existe, no se puede eliminar");                        
                    }while(Areas_empresa.get(edit_dep) != null);
                    break;
                }
                case 0:
                    break;

            }
            
            a = new Area();
        }while(op!=0);
        depss.setAreas_dep(Areas_empresa);
        depss.Editar(Dptos_empresa);
        return Dptos_empresa;
    }
    public  HashMap EdicionCargos(String nom)
    {
        Scanner ingreso= new Scanner(System.in);
        Archivos arch = new Archivos();
        String edit_dep, edit_depn;
        int op;
       
        Departamento depss= new Departamento();
        Area a = new Area();
        Cargo c = new Cargo();
        depss = depss.BuscarDep(Dptos_empresa);
        Areas_empresa = depss.getAreas_dep();
        a = a.BuscarArea(Areas_empresa);
        Cargos_empresa = a.getCargos_area();
        do{
            
            op = EdicionOrganizacion(nom);
            switch(op){
                case 1:
                {
                    System.out.println("INGRESAR");
                    //Ingreso de departamento
                    c.MostrarColeccion(Areas_empresa);
                    c.Ingreso(Cargos_empresa, "cargo");
                    Cargos_empresa.put(c.getCodigo(), c);
                    try{
                    arch.EscribirArchivo(c, "Cargo");
                    }catch(IOException e){
                        System.out.println(e+" 355");
                    }
                    break;
                }
                case 2:
                {
                    System.out.println("EDITAR CARGOS");
                    c.Buscar(Cargos_empresa);
                    break;
                }
                case 3:
                {
                    System.out.println("BUSCAR CARGOS");
                    do{
                        System.out.print("Ingrese codigo de area a editar: \t");
                        edit_dep = ingreso.nextLine();
                        c.setCodigo(edit_dep);
                        if(Cargos_empresa.get(edit_dep) != null)
                        {
                            System.out.print("Area modificadora: \t");
                            edit_depn = ingreso.nextLine();
                            c.setNombre(edit_depn);
                            c.Editar(Cargos_empresa);
                        }
                        else
                        {
                            System.out.println("Area no existe, no se puede modificar");
                        }
                    }while(Cargos_empresa.get(edit_dep) == null);
                    break;
                }
                case 4:
                {
                    System.out.println("\nELIMINAR AREA");
                    do{
                        c.MostrarColeccion(Areas_empresa);
                        System.out.print("Ingrese codigo de area: \t");
                        edit_dep = ingreso.nextLine();
                        c.setCodigo(edit_dep);

                        if(Cargos_empresa.get(edit_dep) != null)
                        {
                            System.out.println("Datos eliminados");
                            c.MostrarColeccion(Cargos_empresa);
                            c.Eliminar(Cargos_empresa);
                        }
                        else
                            System.out.println("Area no existe, no se puede eliminar");                        
                    }while(Cargos_empresa.get(edit_dep) != null);
                    break;
                }
                case 0:
                    break;

            }
            c = new Cargo();
        }while(op!=0);
        a.setCargos_area(Cargos_empresa);
        a.Editar(Areas_empresa);
        depss.setAreas_dep(Areas_empresa);
        depss.Editar(Dptos_empresa);
        
        return Dptos_empresa;
    }
    
    
    
    private void MENU()
    {
       
        Scanner ingreso= new Scanner(System.in);
        
        
        int opciones;
        opciones = OpcionesSistema();
        
        switch(opciones)
        {
            case 1:
                  MenuEmpleados();
                break;
            case 2:
                IngresoDepsAreasCargos();
                break;
            //case 3:
                    
                //break;
            case 0:
                break;
            default: 
                System.out.println("Porfavor ingrese una opcion del menu");
                
        }
           
           
           
       }
    
        private void MenuEmpleados(){
        Scanner ingreso= new Scanner(System.in);
         Archivos arch = new Archivos();
        boolean v;
        Empleado emp = null;
        String cod="";
        
        int opciones;
        do{
            System.out.println("\n1.Ingresar Empleados \n2.Buscar Codigo Empleado \n0. Salir \nEscoja ---> ");

            
            opciones = ingreso.nextInt();

            switch(opciones)
            {
                case 1:

                        do{
                        emp = new Empleado();
                        v=emp.Ingreso(emplist,Dptos_empresa,Areas_empresa,Cargos_empresa);
                        if(v==true){
                            emplist.put(emp.Cedula, emp);
                            try{
                            arch.EscribirArchivo(emp,"Empleado");
                            }catch(IOException e){
                                System.out.println(e+" 465");
                            }
                            System.out.println("Desea ingresar otro empleado? S/N");
                             cod=ingreso.nextLine();
                            
                             if(cod.toUpperCase().equals("S")){
                                 v=false;
                                 System.out.println(cod.toUpperCase());
                             }   
                         }
                        }while(v == false);

                    break;
                case 2:
                    System.out.println("\nIngrese el codigo a buscar: ");
                        cod=ingreso.nextLine();
                        emp.BuscarEmpleado(emplist, cod);
                    break;
                //case 3:

                    //break;
                case 0:
                    break;
                default: 
                    System.out.println("Porfavor ingrese una opcion del menu");
            }
        }while(opciones <0 || opciones >2);
   
}
    
   
           
         
    
}
