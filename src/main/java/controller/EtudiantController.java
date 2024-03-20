package controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Etudiant;
import service.ServiceEtudiant;

@WebServlet("/etudiants")
public class EtudiantController extends HttpServlet{
	ServiceEtudiant serviceEtudiant;
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Etudiant> etudiants= this.serviceEtudiant.getAllEtudiants();
		ObjectMapper mapper=new ObjectMapper();
		String jsonEtudiant=mapper.writeValueAsString(etudiants);
		resp.getWriter().write(jsonEtudiant);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jsonEtudiant="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonEtudiant+=line.trim();
		}
		ObjectMapper mapper=new ObjectMapper();
		Etudiant etudiant=mapper.readValue(jsonEtudiant, Etudiant.class);
		this.serviceEtudiant.addEtudiant(etudiant);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	public void init() throws ServletException {
		this.serviceEtudiant=new ServiceEtudiant();
		this.serviceEtudiant.addEtudiant(new Etudiant(1L, "Hassan", 23));
		this.serviceEtudiant.addEtudiant(new Etudiant(2L, "Sara", 24));
		this.serviceEtudiant.addEtudiant(new Etudiant(3L, "Meriem", 23));

	}

}
