package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Offre;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Stateless
@LocalBean
public class offreService {

    @PersistenceContext(unitName = "flexgym")
    private EntityManager em;

    public offreService() {
        // Constructor logic, if any
    }

    public List<Offre> getAllOffres() {
        TypedQuery<Offre> query = em.createNamedQuery("Offre.findAll", Offre.class);
        return query.getResultList();
    }

    @Transactional
    public void deleteOffreById(int offreId) {
        Offre offre = em.find(Offre.class, offreId);
        if (offre != null) {
            em.remove(offre);
        }
    }

    public Offre getOffreById(int offreId) {
        return em.find(Offre.class, offreId);
    }

    @Transactional
    public Offre modifyOffre(Offre offre) {
        Offre existingOffre = em.find(Offre.class, offre.getOffreId());
        if (existingOffre != null) {
            existingOffre.setOffreNom(offre.getOffreNom());
            existingOffre.setOffreDetail(offre.getOffreDetail());
            existingOffre.setOffrePrix(offre.getOffrePrix());
            // Update other attributes as needed
        }
        return existingOffre;
    }

    @Transactional
    public Offre addOffre(Offre offre) {
        em.persist(offre);
        return offre;
    }
}
