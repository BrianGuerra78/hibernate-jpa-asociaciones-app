package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.*;
import org.bguerra.hibernateapp.entity.Cliente;
import org.bguerra.hibernateapp.entity.Factura;
import org.bguerra.hibernateapp.util.JpaUtil;

import java.util.List;

public class HibernateFetchManyToOneCriteria {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Factura> query = cb.createQuery(Factura.class);
        Root<Factura> factura = query.from(Factura.class);
        //Fetch<Factura, Cliente> cliente = factura.fetch("cliente", JoinType.LEFT);
        Join<Factura, Cliente> cliente = (Join) factura.fetch("cliente", JoinType.LEFT);
        cliente.fetch("detalle", JoinType.LEFT);

        query.select(factura).where(cb.equal(cliente.get("id"), 1L));
        List<Factura> facturas = em.createQuery(query).getResultList();
        facturas.forEach(f -> System.out.println(f.getDescription() + ", cliente: " + f.getCliente().getNombre()));
        em.close();
    }
}
