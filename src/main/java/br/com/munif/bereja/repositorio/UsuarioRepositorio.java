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
import javax.persistence.Query;

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

    public List<Usuario> filtra(String s) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        Query query = em.createQuery("from Usuario usuario where usuario.nome like :filtro order by usuario.nome");
        query.setParameter("filtro", s + '%');
        query.setMaxResults(4);
        return query.getResultList();
    }

    public Usuario recuperaPorLoginESenha(String usuario, String senha) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        Query query = em.createQuery("from Usuario usuario where usuario.email=:email and usuario.senha=:senha");
        query.setParameter("email", usuario);
        query.setParameter("senha", senha);
        query.setMaxResults(1);
        List<Usuario> resultList = query.getResultList();
        if (resultList.size() == 1) {
            return resultList.get(0);
        }
        return null;
    }

}
