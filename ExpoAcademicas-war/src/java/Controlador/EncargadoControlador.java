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
import Modelo.EncargadoFacade;
import Entidades.*;
import java.util.List;

/**
 *
 * @author Jesus
 */
@Named(value = "encargadoControlador")
@SessionScoped
public class EncargadoControlador implements Serializable {

    @EJB
    private EncargadoFacade encargadoFacade;
    private Encargado enc = new Encargado();

    public Encargado getE() {
        return enc;
    }

    public void setA(Encargado enc) {
        this.enc = enc;
    }

    public EncargadoControlador() {
    }

    public List<Encargado> findAll() {
        return this.encargadoFacade.findAll();
    }

    public String add() {
        this.encargadoFacade.create(this.enc);
        return "index";
    }

    public void delete(Encargado p) {
        this.encargadoFacade.remove(enc);
    }

    public String edit(Encargado enc) {
        this.enc = enc;
        return "editenc";
    }

    public String edit() {
        this.encargadoFacade.edit(this.enc);
        this.enc = new Encargado();
        return "index";
    }

}
