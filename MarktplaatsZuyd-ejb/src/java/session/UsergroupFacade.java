/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package session;

import entity.Usergroup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rick
 */
@Stateless
public class UsergroupFacade extends AbstractFacade<Usergroup> {
    @PersistenceContext(unitName = "MarktplaatsZuyd-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsergroupFacade() {
        super(Usergroup.class);
    }
    
}
