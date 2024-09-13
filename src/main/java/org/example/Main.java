package org.example;


import org.example.Entidades.*;
import org.example.audit.Revision;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("example-unit");
        EntityManager em = emf.createEntityManager();
        System.out.println("-------------------------------------------------");

        try{
            // Persistir
            em.getTransaction().begin();


             Categoria categoria1 = Categoria.builder()
                    .denominacion("Gondola Dulce")
                    .build();
            Categoria categoria2 = Categoria.builder()
                    .denominacion("Herramientas")
                    .build();

            Articulo articulo1 = Articulo.builder()
                    .cantidad(12)
                    .denominacion("Dulce de leche")
                    .precio(50)
                    .build();
            Articulo articulo2 = Articulo.builder()
                    .cantidad(7)
                    .denominacion("Martillo")
                    .precio(75)
                    .build();

            articulo1.getCategoria().add(categoria1);
            articulo2.getCategoria().add(categoria2);

            Domicilio domi = Domicilio.builder()
                    .nombreCalle("Perito Moreno")
                    .numero(200)
                    .build();
            Cliente cliente1 = Cliente.builder()
                    .dni(203342)
                    .nombre("Juan Ignacio")
                    .apellido("Rodriguez")
                    .domicilio(domi)
                    .build();

            Factura factura1 = Factura.builder()
                    .numero(1212)
                    .fecha("9/9/2024")
                    .total(3000)
                    .build();
            DetalleFactura detalle1 = DetalleFactura.builder()
                    .cantidad(213)
                    .subtotal(2222)
                    .factura(factura1)
                    .articulo(articulo1)
                    .build();

            Factura factura2 = Factura.builder()
                    .numero(1111)
                    .fecha("2/9/2024")
                    .total(4500)
                    .build();
            DetalleFactura detalle2 = DetalleFactura.builder()
                    .cantidad(222)
                    .subtotal(1800)
                    .factura(factura2)
                    .articulo(articulo2)
                    .build();
            factura1.getDetalleFactura().add(detalle1);
            factura2.getDetalleFactura().add(detalle2);

            em.persist(factura1);
             em.getTransaction().commit();

            //------------------------------------------------
            // Actualizar domicilio al cliente
            em.getTransaction().begin();

            Domicilio domi2 = Domicilio.builder()
                    .nombreCalle("Juab B bustos")
                    .numero(233)
                    .build();
            cliente1.setDomicilio(domi2);
            em.merge(cliente1);

            Revision revision = new Revision();
            em.persist(revision);
            em.flush();
           em.getTransaction().commit();
            //------------------------------------------------

            //Eliminar
           /*
            em.getTransaction().begin();

            Factura factura3 = em.find(Factura.class,3L);
            em.remove(factura3);

            em.flush();
            em.getTransaction().commit();
            */

        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e.getMessage());

        }
        em.close();
        emf.close();
    }
}