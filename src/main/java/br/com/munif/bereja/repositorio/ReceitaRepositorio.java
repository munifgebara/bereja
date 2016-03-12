/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.munif.bereja.repositorio;

import br.com.munif.bereja.entidades.Receita;
import br.com.munif.util.Persistencia;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.Query;

public class ReceitaRepositorio extends Repositorio<Receita> {
    
    public ReceitaRepositorio() {
        super(Receita.class);
    }
    
    @Override
    public List<Receita> consulta() {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        Query q = em.createQuery(consultaBasica + " order by receita.nome");
        setaParametroTenancy(q);
        return q.getResultList();
    }
    
    public List<Receita> filtra(String s) {
        EntityManager em = Persistencia.getInstancia().getEntityManager();
        Query query = em.createQuery(consultaBasica+ "and receita.nome like :filtro order by receita.nome");
        setaParametroTenancy(query);
        query.setParameter("filtro", s + '%');
        return query.getResultList();
    }
    
}
