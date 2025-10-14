package com.mycompany.techstore.Model.DAO;

import com.mycompany.techstore.Model.Connection.ConnectionDB;
import com.mycompany.techstore.Model.Entity.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProductDAO {

    public List<Product> ObtenerProducto() {
        List<Product> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";

        try (Connection conn = ConnectionDB.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product(
                        rs.getString("nombre"),
                        rs.getString("categoria"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("descripcion")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener productos: " + e.getMessage());
        }

        return lista;
    }

    public void InsertarProducto(Product p) {
        String sql = "INSERT INTO productos (nombre, categoria, precio, cantidad, descripcion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setString(5, p.getDescripcion());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar el producto: " + e.getMessage());
        }
    }

    public void actualizarProducto(Product p, String nombreAntiguo) {
        String sql = "UPDATE productos SET nombre=?, categoria=?, precio=?, cantidad=?, descripcion=? WHERE nombre=?";

        try (Connection conn = ConnectionDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getCategoria());
            ps.setDouble(3, p.getPrecio());
            ps.setInt(4, p.getCantidad());
            ps.setString(5, p.getDescripcion());
            ps.setString(6, nombreAntiguo);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + e.getMessage());
        }
    }
}
