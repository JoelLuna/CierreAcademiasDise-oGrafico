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
import Modelo.ProyectoFacade;
import Entidades.*;
import java.util.List;

/**
 *
 * @author Jesus
 */
@Named(value = "proyectoControlador")
@SessionScoped
public class ProyectoControlador implements Serializable {

    @EJB
    private ProyectoFacade proyectoFacade;
    private Proyecto p = new Proyecto();

    public Proyecto getP() {
        return p;
    }

    public void setP(Proyecto p) {
        this.p = p;
    }

    public ProyectoControlador() {
    }

    public List<Proyecto> findAll() {
        return this.proyectoFacade.findAll();
    }
    
    public String add(){
        this.proyectoFacade.create(this.p);
        return "index";
    }
    
    public void delete(Proyecto p){
        this.proyectoFacade.remove(p);
    }
    
    public String edit(Proyecto p){
        this.p = p;
        return "edit";
    }
    
    public String edit(){
        this.proyectoFacade.edit(this.p);
        this.p = new Proyecto();
        return "index";
    }
    
    public Proyecto proyectoGetOne(int pos){
        System.out.println(this.proyectoFacade.find(pos)+ "v1");
        return this.proyectoFacade.find(pos);
        
    }
    
    public Proyecto proyectoGetOne2(int pos){
        System.out.println(this.proyectoFacade.find(new Proyecto(pos))+ "v2");
        return this.proyectoFacade.find(new Proyecto(pos));
    }
}
