/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entity.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rick
 */
@Stateless
public class AccountFacade extends AbstractFacade<Account> {

    @PersistenceContext(unitName = "MarktplaatsZuyd-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AccountFacade() {
        super(Account.class);
    }

    public Account getAccountByUsername(String username) {
        //EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("UniversityApplicationPU");
        //EntityManager em = emFactory.createEntityManager();
        //em.getTransaction.begin();
        Query query = getEntityManager().createNamedQuery("Account.findByUsername");
        query.setParameter("username", username);
        return (Account)query.getResultList().get(0);
    }
}
