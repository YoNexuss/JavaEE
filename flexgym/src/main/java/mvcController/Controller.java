package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcModel.offreService;

import java.io.IOException;
import java.util.List;

import entities.Offre;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @EJB
    private offreService serviceOffre;
       
    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Offre> offres = retrieveOffres();
        request.setAttribute("offres", offres);
        request.getRequestDispatcher("/offreAdmin.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
    }

    private List<Offre> retrieveOffres() {
        return serviceOffre.getAllOffres();
    }
}
