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
import Modelo.CicloFacade;
import Entidades.*;
import java.util.List;

/**
 *
 * @author Jesus
 */
@Named(value = "cicloControlador")
@SessionScoped
public class CicloControlador implements Serializable {

    @EJB
    private CicloFacade cicloFacade;
    private Ciclo ciclo = new Ciclo();

    public Ciclo getE() {
        return ciclo;
    }

    public void setA(Ciclo ciclo) {
        this.ciclo = ciclo;
    }

    public CicloControlador() {
    }

    public List<Ciclo> findAll() {
        return this.cicloFacade.findAll();
    }

    public String add() {
        this.cicloFacade.create(this.ciclo);
        return "index";
    }

    public void delete(Ciclo ciclo) {
        this.cicloFacade.remove(ciclo);
    }

    public String edit(Ciclo ciclo) {
        this.ciclo = ciclo;
        return "editciclo";
    }

    public String edit() {
        this.cicloFacade.edit(this.ciclo);
        this.ciclo = new Ciclo();
        return "index";
    }

}
