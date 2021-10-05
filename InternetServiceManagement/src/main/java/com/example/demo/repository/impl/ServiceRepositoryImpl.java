package com.example.demo.repository.impl;

import com.example.demo.entity.Service;
import com.example.demo.service.ServiceService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ServiceRepositoryImpl implements ServiceService {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Service> findAllService() {
        TypedQuery<Service> query=entityManager.createQuery("select s from Service s",Service.class);
        return query.getResultList();
    }

    @Override
    public Service findServiceById(String serviceId) {
        TypedQuery<Service> query=entityManager.createQuery("select s from Service s where s.serviceId=:serviceId",
                Service.class);
        query.setParameter("serviceId", serviceId);
        try {
            return query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }

    @Override
    public Service deleteService(String serviceId) {
        Service service = findServiceById(serviceId);
        if (service != null){
            entityManager.remove(service);
        }
        return service;
    }
}
