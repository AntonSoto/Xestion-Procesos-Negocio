package es.udc.fic.xpn.example.service;

import es.udc.fic.xpn.example.dao.PedidoDAO;
import es.udc.fic.xpn.example.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService{


    @Autowired
    private PedidoDAO pedidoDAO;
    @Override
    public Pedido create(Pedido pedido) {
        Long id = pedidoDAO.save(pedido);
        pedido.setId(id);
        return pedido;
    }

    @Override
    public Optional<Pedido> find(Long id) {
        return pedidoDAO.find(id);
    }

    @Override
    public List<Pedido> findAll() {
        return pedidoDAO.findAll();
    }

    @Override
    public void update(Pedido pedido) {
        pedidoDAO.update(pedido);
    }


    @Override
    public void delete(Long id) {
        if (! pedidoDAO.find(id).isEmpty())
            pedidoDAO.delete(id);
    }

}
