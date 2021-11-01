package com.example.demo.service;

import com.example.demo.entity.Usuario;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class UsuarioRepoCustomImpl implements UsuarioRepoCustom {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Usuario> filterData(Map<String, Object> mapita) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = cb.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);

        List<Predicate> predicates = new ArrayList<>();
        mapita.forEach((field,value) -> {

            switch (field){
                case "id":
                    predicates.add(cb.equal(root.get(field), (Long)value));
                    break;
                case "nombre":
                case "apellido":
                    predicates.add(cb.like(root.get(field), (String)"%"+value+"%" ));
                    break;
                case "cedula":
                    predicates.add(cb.like(root.get(field), (String)value+"%" ));
                    break;

            }
        });
        query.select(root).where(predicates.toArray(new Predicate[0]));


        return entityManager.createQuery(query).getResultList();
    }
}
