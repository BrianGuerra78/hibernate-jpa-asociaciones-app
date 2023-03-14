package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import org.bguerra.hibernateapp.entity.Cliente;
import org.bguerra.hibernateapp.util.JpaUtil;

public class HibernateFetchLazyOneToMany {
    public static void main(String[] args) {
        EntityManager em= JpaUtil.getEntityManager();

        Cliente cliente = em.find(Cliente.class, 1L);
        System.out.println(cliente.getNombre() + ", direcciones: " + cliente.getDirecciones());
        em.close();
    }
}
