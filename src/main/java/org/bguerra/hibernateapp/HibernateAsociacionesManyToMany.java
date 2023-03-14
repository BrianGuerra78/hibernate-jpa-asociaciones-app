package org.bguerra.hibernateapp;

import jakarta.persistence.EntityManager;
import org.bguerra.hibernateapp.entity.Alumno;
import org.bguerra.hibernateapp.entity.Curso;
import org.bguerra.hibernateapp.util.JpaUtil;

public class HibernateAsociacionesManyToMany {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Alumno alumno1 = new Alumno("Cata", "Edu");
            Alumno alumno2 = new Alumno("Jano", "Fernan");

            Curso curso1 = new Curso("Curso Java", "Brian");
            Curso curso2 = new Curso("Curso Hibernate", "Brian");

            alumno1.getCursos().add(curso1);
            alumno1.getCursos().add(curso2);

            alumno2.getCursos().add(curso1);

            em.persist(alumno1);
            em.persist(alumno2);

            em.getTransaction().commit();
            System.out.println(alumno1);
            System.out.println(alumno2);

            em.getTransaction().begin();
            Curso c2 = em.find(Curso.class, 3L);
            alumno1.getCursos().remove(c2);
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
