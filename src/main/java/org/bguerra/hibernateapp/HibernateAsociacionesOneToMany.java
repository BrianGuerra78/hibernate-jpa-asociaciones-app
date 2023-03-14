package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import org.bguerra.hibernateapp.entity.Cliente;
import org.bguerra.hibernateapp.entity.Direccion;
import org.bguerra.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesOneToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Cliente cliente = new Cliente("cata", "Edu");
            cliente.setFormaPago("MercadoPago");

            Direccion d1 = new Direccion("El vergel", 123);
            Direccion d2 = new Direccion("Vasco de gama", 456);

            cliente.getDirecciones().add(d1);
            cliente.getDirecciones().add(d2);
            em.persist(cliente);


            em.getTransaction().commit();

            System.out.println(cliente);

            em.getTransaction().begin();
            cliente = em.find(Cliente.class,cliente.getId());
            cliente.getDirecciones().remove(d1);
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
