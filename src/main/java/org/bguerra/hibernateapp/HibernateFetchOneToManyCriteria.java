package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;
import org.bguerra.hibernateapp.entity.Cliente;
import org.bguerra.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchOneToManyCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cliente> query = cb.createQuery(Cliente.class);
        Root<Cliente> cliente = query.from(Cliente.class);

        cliente.fetch("direcciones", JoinType.LEFT);
        query.select(cliente).distinct(true);
        cliente.fetch("detalle", JoinType.LEFT);
        List<Cliente> clientes = em.createQuery(query).getResultList();

        clientes.forEach(c -> System.out.println(c.getNombre() + ", detalle: " +
                c.getDetalle() + ", direcciones: " + c.getDirecciones()));

        em.close();
    }
}
