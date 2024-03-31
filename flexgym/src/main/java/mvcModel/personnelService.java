package mvcModel;

import java.util.ArrayList;
import java.util.List;

import entities.Personnel;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class PersonnelService
 */
@Stateless
@LocalBean
public class personnelService {

    @PersistenceContext(unitName = "flexgym")
    private EntityManager em;

    /**
     * Default constructor.
     */
    public personnelService() {
        // TODO Auto-generated constructor stub
    }

    public List<Personnel> getAllPersonnel() {
        List<Personnel> personnelList = new ArrayList<>();
        TypedQuery<Personnel> query = em.createNamedQuery("Personnel.findAll", Personnel.class);
        personnelList = query.getResultList();
        return personnelList;
    }

    public List<Personnel> deletePersonnelById(int personnelId) {
        List<Personnel> personnelList = new ArrayList<>();
        Personnel personnel = em.find(Personnel.class, personnelId);
        if (personnel != null) {
            em.remove(personnel);
        }
        TypedQuery<Personnel> query = em.createNamedQuery("Personnel.findAll", Personnel.class);
        personnelList = query.getResultList();
        return personnelList;
    }

    public Personnel getPersonnelById(int personnelId) {
        return em.find(Personnel.class, personnelId);
    }

    public Personnel modifyPersonnel(Personnel personnel) {
        Personnel existingPersonnel = em.find(Personnel.class, personnel.getPersonnelId());
        if (existingPersonnel != null) {
            existingPersonnel.setPersonnelNom(personnel.getPersonnelNom());
            existingPersonnel.setPersonnelPrenom(personnel.getPersonnelPrenom());
            existingPersonnel.setPersonnelEmail(personnel.getPersonnelEmail());
            existingPersonnel.setPersonnelPass(personnel.getPersonnelPass());
            existingPersonnel.setPersonnelRole(personnel.getPersonnelRole());
            // Update other attributes as needed
            em.persist(existingPersonnel);
        }
        return existingPersonnel;
    }

    public Personnel addPersonnel(Personnel personnel) {
        em.persist(personnel);
        return personnel;
    }
}