
package com.emergentes.dao;
import com.emergentes.modelo.Blog;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOimpl extends ConexionBD implements BlogDAO {

    @Override
    public void insert(Blog blog) throws Exception {
        try {
            this.conectar();
            String sql = "insert into posts (fecha,titulo,contenido) values (?,?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            //Ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Blog blog) throws Exception {
        try {
            this.conectar();
            String sql = "update posts set fecha=?, titulo=?, contenido=? where id =?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, blog.getFecha());
            ps.setString(2, blog.getTitulo());
            ps.setString(3, blog.getContenido());
            ps.setInt(4, blog.getId());
            //Ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            String sql = "delete from posts where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            //Ejecutar la consulta
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;

        } finally {
            this.desconectar();
        }
    }

    @Override
    public Blog getById(int id) throws Exception {
        Blog blg = new Blog();

        try {
            this.conectar();
            String sql = "select * from posts where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                blg.setId(rs.getInt("id"));
                blg.setFecha(rs.getString("fecha"));
                blg.setTitulo(rs.getString("titulo"));
                blg.setContenido(rs.getString("contenido"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return blg;
    }

    @Override
    public List<Blog> getAll() throws Exception {
        List<Blog> lista = null;

        try {
            this.conectar();
            String sql = "select * from posts order by id desc";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Blog>();

            while (rs.next()) {
                Blog blg = new Blog();

                blg.setId(rs.getInt("id"));
                blg.setFecha(rs.getString("fecha"));
                blg.setTitulo(rs.getString("titulo"));
                blg.setContenido(rs.getString("contenido"));
                //adicionar a la coleccion
                lista.add(blg);

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
