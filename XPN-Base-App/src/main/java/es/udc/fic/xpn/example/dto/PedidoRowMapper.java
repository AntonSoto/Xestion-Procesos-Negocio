package es.udc.fic.xpn.example.dto;

import es.udc.fic.xpn.example.model.Pedido;
import es.udc.fic.xpn.example.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class PedidoRowMapper implements RowMapper<Pedido> {

    public Pedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Pedido p = new Pedido();
        p.setId(rs.getLong("id"));
        p.setDni(rs.getString("dni"));
        p.setNombre(rs.getString("name"));
        p.setApellido(rs.getString("apellido"));
        p.setEntradaVip(rs.getBoolean("entradaVip"));
        p.setSaldoPulsera(rs.getFloat("saldo_pulsera"));
        p.setEmail(rs.getString("email"));
        p.setFechaNacimiento(rs.getDate("fecha_nacimiento").toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        p.setDireccion(rs.getString("direccion"));
        p.setConfirmado(rs.getBoolean("confirmado"));

        return p;
    }

}
