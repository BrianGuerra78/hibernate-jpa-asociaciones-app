package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import org.bguerra.hibernateapp.entity.Cliente;
import org.bguerra.hibernateapp.entity.ClienteDetalle;
import org.bguerra.hibernateapp.util.JpaUtil;

public class HibernateAsociacionOneToOneBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("Cata", "Edu");
            cliente.setFormaPago("Paypal");

            ClienteDetalle detalle = new ClienteDetalle(true, 8000L);
            cliente.addDetalle(detalle);
            //detalle.setCliente(cliente);
            em.persist(cliente);

            em.getTransaction().commit();
            System.out.println(cliente);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
