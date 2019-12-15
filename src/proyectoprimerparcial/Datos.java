/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprimerparcial;

/**
 *
 * @author FAMILIA
 */
public abstract class Datos {
    
    protected String FechaInicioContrato;
    protected String FechaFinContrato;
    protected String Departamento;
    protected String Area;
    protected String Cargo;

    public Datos(String FechaInicioContrato, String FechaFinContrato, String Departamento, String Area, String Cargo) {
        this.FechaInicioContrato = FechaInicioContrato;
        this.FechaFinContrato = FechaFinContrato;
        this.Departamento = Departamento;
        this.Area = Area;
        this.Cargo = Cargo;
    }

    public Datos(){}
    
    public String getFechaInicioContrato() {
        return FechaInicioContrato;
    }

    public void setFechaInicioContrato(String FechaInicioContrato) {
        this.FechaInicioContrato = FechaInicioContrato;
    }

    public String getFechaFinContrato() {
        return FechaFinContrato;
    }

    public void setFechaFinContrato(String FechaFinContrato) {
        this.FechaFinContrato = FechaFinContrato;
    }

    public String getDepartamento() {
        return Departamento;
    }

    public void setDepartamento(String Departamento) {
        this.Departamento = Departamento;
    }

    public String getArea() {
        return Area;
    }

    public void setArea(String Area) {
        this.Area = Area;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    
    
}


