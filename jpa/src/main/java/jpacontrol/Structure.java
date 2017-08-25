/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpacontrol;

import entity.Customer;
import entity.DiscountFixed;
import entity.DiscountQuantity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
    import javax.persistence.Persistence;

/**
 *
 * @author MartinLodahl
 */
public class Structure {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaPU");

        EntityManager em = emf.createEntityManager();
        Customer cus = new Customer();
        cus.addDiscountType(new DiscountFixed());
        cus.addDiscountType(new DiscountQuantity());
        em.getTransaction().begin();
        em.persist(cus);
        em.getTransaction().commit();
        em.close();
        
    }
}
