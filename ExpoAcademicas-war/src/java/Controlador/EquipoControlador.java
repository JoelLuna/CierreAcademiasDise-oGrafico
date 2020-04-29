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
import Modelo.EquipoFacade;
import Entidades.*;
import java.util.List;

/**
 *
 * @author Jesus
 */
@Named(value = "equipoControlador")
@SessionScoped
public class EquipoControlador implements Serializable {

    @EJB
    private EquipoFacade equipoFacade;
    private Equipo equi = new Equipo();

    public Equipo getE() {
        return equi;
    }

    public void setE(Equipo equi) {
        this.equi = equi;
    }

    public EquipoControlador() {
    }

    public List<Equipo> findAll() {
        return this.equipoFacade.findAll();
    }

    public String add() {
        this.equipoFacade.create(this.equi);
        return "index";
    }

    public void delete(Equipo equi) {
        this.equipoFacade.remove(equi);
    }

    public String edit(Equipo equi) {
        this.equi = equi;
        return "editequi";
    }

    public String edit() {
        this.equipoFacade.edit(this.equi);
        this.equi = new Equipo();
        return "index";
    }

}
