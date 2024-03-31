package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Abonnement;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class AbonnementService
 */
@Stateless
@LocalBean
public class abonnementService {

    @PersistenceContext(unitName = "flexgym")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public abonnementService() {
        // TODO Auto-generated constructor stub
    }

    public List<Abonnement> getAllAbonnements() {
        List<Abonnement> abonnements = new ArrayList<>();
        TypedQuery<Abonnement> query = em.createNamedQuery("Abonnement.findAll", Abonnement.class);
        abonnements = query.getResultList();
        return abonnements;
    }

    public List<Abonnement> deleteAbonnementById(int abonnementId) {
        List<Abonnement> abonnements = new ArrayList<>();
        Abonnement abonnement = em.find(Abonnement.class, abonnementId);
        if (abonnement != null) {
            em.remove(abonnement);
        }
        TypedQuery<Abonnement> query = em.createNamedQuery("Abonnement.findAll", Abonnement.class);
        abonnements = query.getResultList();
        return abonnements;
    }

    public Abonnement getAbonnementById(int abonnementId) {
        return em.find(Abonnement.class, abonnementId);
    }

    public Abonnement modifyAbonnement(Abonnement abonnement) {
        Abonnement existingAbonnement = em.find(Abonnement.class, abonnement.getAbonnementId());
        if (existingAbonnement != null) {
            existingAbonnement.setAbonnementEtat(abonnement.getAbonnementEtat());
            existingAbonnement.setDebutDate(abonnement.getDebutDate());
            existingAbonnement.setFinDate(abonnement.getFinDate());
            // Update other attributes as needed
            em.persist(existingAbonnement);
        }
        return existingAbonnement;
    }

    public Abonnement addAbonnement(Abonnement abonnement) {
        em.persist(abonnement);
        return abonnement;
    }
}
