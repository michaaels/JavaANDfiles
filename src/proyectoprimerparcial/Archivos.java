/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprimerparcial;


import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import proyectoprimerparcial.clasificacion_empresa.*;


public class Archivos implements Serializable{
            //ficheros    
        File archivo;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        FileOutputStream fos;
        static String EnlaceArchivo="";

        
    public void EscribirArchivo(Object obj,String NomArchivo) throws FileNotFoundException, IOException{
        String enlace=EnlaceArchivo+NomArchivo+".txt";
        
        archivo = new File(enlace);
        fos=new FileOutputStream(archivo);
        oos = new ObjectOutputStream(fos);
         BufferedWriter bw;
         
        /*if(archivo.exists())
          bw = new BufferedWriter(new FileWriter(archivo));
        else
          bw = new BufferedWriter(new FileWriter(archivo));*/
        
        try {
            if(obj instanceof Empleado){
                final Empleado other = (Empleado) obj;
                oos.writeObject(other);
            }
            if(obj instanceof Departamento){
                final Departamento other = (Departamento) obj;
                
                oos.writeObject(other);
            }
            
            if(obj instanceof Area){
                final Area other = (Area) obj;
                oos.writeObject(other);
            }
            
            if(obj instanceof Cargo){
                final Cargo other = (Cargo) obj;
                oos.writeObject(other);
            }
             
             oos.flush();
             oos.close();
             System.out.println("Datos guardados correctamente...");

         } catch (IOException ioe) {
             System.out.println(ioe);
             System.out.println("Error: Fallo en la escritura en el fichero. ");
         }
       
    }
        
    public void LeerArchivo(String NomArchivo,HashMap c){
       String enlace=EnlaceArchivo+NomArchivo+".txt";
       archivo = new File(enlace);
       
        HashMap<String,Empleado> otrolistE= new HashMap<>();
        HashMap<String,Departamento> otrolistD= new HashMap<>();
        HashMap<String,Area> otrolistA= new HashMap<>();
        HashMap<String,Cargo> otrolistC= new HashMap<>();
        
        int ubi=0;//saber cual es 
        try{ 
        ObjectInputStream ois =new ObjectInputStream(new FileInputStream(archivo));
        Object aux = ois.readObject();
          
        // Mientras haya objetos
        while (aux!=null)
        {
            
             if(aux instanceof Empleado){
                
                aux = ois.readObject();
                final Empleado other = (Empleado) aux;
                otrolistE.put(other.CodigoEmpleado,other);
                ubi=1;
                 System.out.println(ubi);

            }
            if(aux instanceof Departamento){
                
                aux = ois.readObject();
                
                Departamento other = (Departamento) aux;
                System.out.println(other.Nombre+"el nombre es si vale");
                //otrolistD.put(other.getCodigo(),other);
                ubi=2;
                System.out.println(ubi);
            }
            
            if(aux instanceof Area){
                
                aux = ois.readObject();
                final Area other = (Area) aux;
                otrolistA.put(other.getCodigo(),other);
                ubi=3;
                System.out.println(ubi);
            }
            
            if(aux instanceof Cargo){
               
                aux = ois.readObject();
                final Cargo other = (Cargo) aux;
                otrolistC.put(other.getCodigo(),other);
                ubi=4;   
                System.out.println(ubi);
            }
            System.out.println("Salio :/");
        }
        ois.close();
     }catch(FileNotFoundException a ){
         System.out.println("No se encontro el archivo");
     }catch(IOException b){
            b.printStackTrace();
            System.out.println("Constructs an EOFException with null as its error detail message.");
     }catch(ClassNotFoundException e){
         System.out.println("La clase no se encuentra");
     }
        
      /*  
        if(ubi==1)
            return otrolistE;
        if(ubi==2)
            return otrolistD;
        if(ubi==3)
            return otrolistA;
        if(ubi==4)
            return otrolistC;
        
        
            return null;*/
    }
    
}


       