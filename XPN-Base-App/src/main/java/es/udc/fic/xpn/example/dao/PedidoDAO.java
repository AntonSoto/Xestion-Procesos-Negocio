package es.udc.fic.xpn.example.dao;

import es.udc.fic.xpn.example.model.Pedido;
import es.udc.fic.xpn.example.model.Product;

import java.util.List;
import java.util.Optional;

public interface PedidoDAO {

    public Long save(Pedido pedido);

    public Optional<Pedido> find(Long id);

    public List<Pedido> findAll();

    public void update(Pedido pedido);

    public void delete(Long id);

}
