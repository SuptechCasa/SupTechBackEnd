package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Etudiant;
import service.EtudiantService;

@WebServlet("/etudiants")
public class EtudiantController extends HttpServlet{
	EtudiantService etudiantService;
	@Override
	public void init() throws ServletException {
		etudiantService=new EtudiantService();
			}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		List<Etudiant> etudiants= this.etudiantService.getAllEtudiants();
		ObjectMapper mapper=new ObjectMapper();
		String jsonEtudiant=mapper.writeValueAsString(etudiants);
		resp.getWriter().write(jsonEtudiant);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Access-Control-Allow-Origin", "*");
		String jsonEtudiant="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonEtudiant+=line.trim();
		}
		ObjectMapper mapper=new ObjectMapper();
		Etudiant etudiant=mapper.readValue(jsonEtudiant, Etudiant.class);
		Etudiant etud=this.etudiantService.addEtudiant(etudiant);
		if (etud!=null) {		
		PrintWriter response=resp.getWriter();
		response.write(jsonEtudiant);
		}
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setHeader("Access-Control-Allow-Origin", "*"); // Autoriser les requêtes depuis n'importe quelle origine
        String jsonEtudiant="";
		String line;
		while((line=req.getReader().readLine()) != null) {
			jsonEtudiant+=line.trim();
		}
		System.out.println(jsonEtudiant);
		ObjectMapper mapper=new ObjectMapper();
		Etudiant etudiant=mapper.readValue(jsonEtudiant, Etudiant.class);
		etudiantService.deleteEtudiant(etudiant);
	}
}
