package es.udc.fic.xpn.example.dao;

import es.udc.fic.xpn.example.dto.PedidoRowMapper;
import es.udc.fic.xpn.example.dto.ProductRowMapper;
import es.udc.fic.xpn.example.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.time.ZoneId;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

//import static org.apache.catalina.valves.AbstractAccessLogValve.localDate;

@Component
public class PedidoDAOImpl implements PedidoDAO{


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Long save2(Pedido pedido) {
        String sql = "INSERT INTO pedido (dni, nombre, apellido, entradaVip, " +
                "saldoPulsera, email, fechaNacimiento, direccion, confirmado) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?. ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(con -> {
                    PreparedStatement ps = con.prepareStatement(sql, new String[]{"id"});
                    ps.setString(1, pedido.getDni());
                    ps.setString(2, pedido.getNombre());
                    ps.setString(3, pedido.getApellido());
                    ps.setBoolean(4, pedido.getEntradaVip());
                    ps.setFloat(5, pedido.getSaldoPulsera());
                    ps.setString(6, pedido.getEmail());
                    ps.setDate(7, Date.valueOf(pedido.getFechaNacimiento()));
                    ps.setString(8, pedido.getDireccion());
                    ps.setBoolean(9, pedido.getConfirmado());

                    return ps;
                },
                keyHolder);

        return keyHolder.getKey().longValue();
    }

    @Override
    public Long save(Pedido pedido) {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate =
                new NamedParameterJdbcTemplate(jdbcTemplate);

        String sql = "INSERT INTO pedido (dni, nombre, apellido, entradaVip, " +
                "saldoPulsera, email, fechaNacimiento, direccion, confirmado) " +
                "VALUES (:dni, :nombre, :apellido, :entradaVip, " +
                ":saldoPulsera, :email, :fechaNacimiento, :direccion, :confirmado)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        namedParameterJdbcTemplate.update(sql,
                new BeanPropertySqlParameterSource(pedido),
                keyHolder, new String[]{"id"});

        return keyHolder.getKey().longValue();
    }

    @Override
    public Optional<Pedido> find(Long id) {

        String sql = "SELECT id, dni, nombre, apellido, entradaVip, " +
                "saldoPulsera, email, fechaNacimiento, direccion, confirmado " +
                "FROM pedido WHERE id = ?";

        try {
            Pedido pedido = jdbcTemplate.queryForObject(sql, new PedidoRowMapper(), id);
            return Optional.ofNullable(pedido);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Pedido> findAll() {
        String sql = "SELECT id, dni, nombre, apellido, entradaVip, saldoPulsera" +
                "email, fechaNacimiento, direccion, confirmado " +
                "FROM pedido";
        return jdbcTemplate.query(sql, new PedidoRowMapper());
    }

    @Override
    public void update(Pedido pedido) {

        NamedParameterJdbcTemplate namedParameterJdbcTemplate =
                new NamedParameterJdbcTemplate(jdbcTemplate);

        String sql = "UPDATE pedido SET dni = :dni, nombre = :nombre, " +
                "apellido = :apellido, entradaVip = :entradaVip, saldoPulsera = :saldoPulsera," +
                "email = :email, fechaNacimiento = :fechaNacimiento, direccion = :direccion," +
                "confirmado = :confirmado WHERE id = :id;";

        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(pedido));

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM pedido WHERE id = ?";
        jdbcTemplate.update(sql, id);

    }

}
