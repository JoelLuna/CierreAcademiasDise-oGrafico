/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import Modelo.AlumnoFacade;
import Entidades.*;
import java.util.List;

/**
 *
 * @author Jesus
 */
@Named(value = "alumnoControlador")
@SessionScoped
public class AlumnoControlador implements Serializable {

    @EJB
    private AlumnoFacade alumnoFacade;
    private Alumno alu = new Alumno();

    public Alumno getA() {
        return alu;
    }

    public void setA(Alumno alu) {
        this.alu = alu;
    }

    public AlumnoControlador() {
    }

    public List<Alumno> findAll() {
        return this.alumnoFacade.findAll();
    }

    public String add() {
        this.alumnoFacade.create(this.alu);
        return "index";
    }

    public void delete(Alumno p) {
        this.alumnoFacade.remove(alu);
    }

    public String edit(Alumno alu) {
        this.alu = alu;
        return "edit";
    }

    public String edit() {
        this.alumnoFacade.edit(this.alu);
        this.alu = new Alumno();
        return "index";
    }

}
