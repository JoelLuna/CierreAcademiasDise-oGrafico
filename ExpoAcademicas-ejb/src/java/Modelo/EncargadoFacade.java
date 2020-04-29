/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Entidades.Encargado;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jesus
 */
@Stateless
public class EncargadoFacade extends AbstractFacade<Encargado> {

    @PersistenceContext(unitName = "ExpoAcademicas-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EncargadoFacade() {
        super(Encargado.class);
    }
    
}
