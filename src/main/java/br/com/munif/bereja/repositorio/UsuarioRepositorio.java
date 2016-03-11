/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Usuario;
import br.com.munif.util.Persistencia;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author munif
 */
public class UsuarioRepositorio extends Repositorio<Usuario> {

    public UsuarioRepositorio() {
        super(Usuario.class);
    }

    @Override
    public List<Usuario> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        return em.createQuery("from Usuario usu order by usu.nome").getResultList();
    }

}
