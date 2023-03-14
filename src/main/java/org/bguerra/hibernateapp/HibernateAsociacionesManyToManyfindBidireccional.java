package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import org.bguerra.hibernateapp.entity.Alumno;
import org.bguerra.hibernateapp.entity.Curso;
import org.bguerra.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesManyToManyfindBidireccional {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Alumno alumno1 = em.find(Alumno.class, 1L);
            Alumno alumno2 = em.find(Alumno.class, 2L);

            Curso curso1 = em.find(Curso.class, 1L);//new Curso("Curso Java", "Brian");
            Curso curso2 = em.find(Curso.class, 2L);//new Curso("Curso Hibernate", "Brian");

            alumno1.addCurso(curso1);
            alumno1.addCurso(curso2);

            alumno2.addCurso(curso1);

            em.getTransaction().commit();
            System.out.println(alumno1);
            System.out.println(alumno2);

            em.getTransaction().begin();
            Curso c2 = new Curso("Curso Jav EE 9","Andres");
            c2.setId(2L);
            alumno1.removeCurso(c2);
            em.getTransaction().commit();
            System.out.println(alumno1);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
