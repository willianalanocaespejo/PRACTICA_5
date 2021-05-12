package com.emergentes.controlador;

import com.emergentes.dao.BlogDAO;
import com.emergentes.dao.BlogDAOimpl;
import com.emergentes.modelo.Blog;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            BlogDAO dao = new BlogDAOimpl();
            //para recibir el id
            int id;
            //para gestionar registros
            Blog blg = new Blog();
            
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            
            switch(action){
                case "add":
                    //nuevo registro
                    request.setAttribute("blg", blg);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);                                        
                    break;
                    
                case "edit":
                    //para editar
                    id = Integer.parseInt(request.getParameter("id"));
                    blg = dao.getById(id);
                    request.setAttribute("blg", blg);
                    request.getRequestDispatcher("frmblog.jsp").forward(request, response);                    
                    break;
                case "delete":
                    //para eliminar
                        id = Integer.parseInt(request.getParameter("id"));
                        dao.delete(id);
                        //request.getRequestDispatcher("Inicio").forward(request, response);
                        response.sendRedirect("Inicio");
                    
                    
                    break;
                default:
                    // listar los registros
                    List<Blog> blog = dao.getAll();
                    request.setAttribute("blog", blog);
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;
            }
            
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }
        
      
    }

    
    
    
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        BlogDAO dao = new BlogDAOimpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String fecha = request.getParameter("fecha");
        String titulo = request.getParameter("titulo");        
        String contenido = request.getParameter("contenido");
        
        Blog blg = new Blog();
        
        blg.setId(id);
        blg.setFecha(fecha);
        blg.setTitulo(titulo);
        blg.setContenido(contenido);
        
        if (id == 0){
            //nuevo  registro
            try{
                dao.insert(blg);
            response.sendRedirect("Inicio");
            }catch(Exception e){
                System.out.println("Error"+e.getMessage());
            }
        }else{
            //actualizacion de un registro
               try{
                dao.update(blg);
                response.sendRedirect("Inicio");
            }catch(Exception e){
                System.out.println("Error"+e.getMessage());
            }
            
        }
      
    }

   

}
