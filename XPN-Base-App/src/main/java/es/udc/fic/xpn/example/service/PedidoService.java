package es.udc.fic.xpn.example.service;

import es.udc.fic.xpn.example.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {

    public Pedido create(Pedido pedido);

    public Optional<Pedido> find(Long id);

    public List<Pedido> findAll();

    public void update(Pedido pedido);

    public void delete(Long id);

}
