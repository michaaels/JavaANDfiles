/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprimerparcial;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import proyectoprimerparcial.clasificacion_empresa.*;


public class Archivos implements Serializable{
            //ficheros    
        File archivo;
        ObjectOutputStream oos;
        ObjectInputStream ois;
        FileOutputStream fos;
        static String EnlaceArchivo="C:/Users/InternetPC/Desktop/ProyectoPrimerParcial/";

        
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
                System.out.println(other.Nombre+"Ha sido el protected lapirix");
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
        
    public static HashMap LeerArchivo(String NomArchivo,HashMap c) throws FileNotFoundException, IOException, ClassNotFoundException{
       String enlace=EnlaceArchivo+NomArchivo+".txt";
       File archivo = new File(enlace);
        ObjectInputStream ois =new ObjectInputStream(new FileInputStream(archivo));
        HashMap<String,Empleado> otrolistE= new HashMap<>();
        HashMap<String,Departamento> otrolistD= new HashMap<>();
        HashMap<String,Area> otrolistA= new HashMap<>();
        HashMap<String,Cargo> otrolistC= new HashMap<>();
        
        int ubi=0;//saber cual es 
        
        Object aux = ois.readObject();
           
        // Mientras haya objetos
        while (aux!=null)
        {
             if(aux instanceof Empleado){
                
                aux = ois.readObject();
                final Empleado other = (Empleado) aux;
                otrolistE.put(other.CodigoEmpleado,other);
                ubi=1;

            }
            if(aux instanceof Departamento){
                
                aux = ois.readObject();
                final Departamento other = (Departamento) aux;
                otrolistD.put(other.getCodigo(),other);
                ubi=2;
                
            }
            
            if(aux instanceof Area){
                
                aux = ois.readObject();
                final Area other = (Area) aux;
                otrolistA.put(other.getCodigo(),other);
                ubi=3;
                
            }
            
            if(aux instanceof Cargo){
               
                aux = ois.readObject();
                final Cargo other = (Cargo) aux;
                otrolistC.put(other.getCodigo(),other);
                ubi=4;   
            }

        }
        ois.close();
        
        if(ubi==1)
            return otrolistE;
        if(ubi==2)
            return otrolistD;
        if(ubi==3)
            return otrolistA;
        if(ubi==4)
            return otrolistC;
        
        
            return null;
    }
    
}


       