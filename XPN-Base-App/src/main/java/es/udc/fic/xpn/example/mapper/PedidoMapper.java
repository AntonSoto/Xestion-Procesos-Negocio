package es.udc.fic.xpn.example.mapper;

import es.udc.fic.xpn.example.dto.PedidoDto;
import es.udc.fic.xpn.example.model.Pedido;

public class PedidoMapper {

    public static PedidoDto entityToDto(Pedido pedido){

        PedidoDto pedidoDto = new PedidoDto();

        pedidoDto.setId(pedido.getId());
        pedidoDto.setDni(pedido.getDni());
        pedidoDto.setNombre(pedido.getNombre());
        pedidoDto.setApellido(pedido.getApellido());
        pedidoDto.setEntradaVip(pedido.getEntradaVip());
        pedidoDto.setSaldoPulsera(pedido.getSaldoPulsera());
        pedidoDto.setEmail(pedido.getEmail());
        pedidoDto.setFechaNacimiento(pedido.getFechaNacimiento());
        pedidoDto.setDireccion(pedido.getDireccion());
        pedidoDto.setConfirmado(pedido.getConfirmado());

        return pedidoDto;
    }

    public static Pedido dtoToEntity(PedidoDto pedidoDto){

        Pedido pedido = new Pedido();

        pedido.setId(pedidoDto.getId());
        pedido.setDni(pedidoDto.getDni());
        pedido.setNombre(pedidoDto.getNombre());
        pedido.setApellido(pedidoDto.getApellido());
        pedido.setEntradaVip(pedidoDto.getEntradaVip());
        pedido.setSaldoPulsera(pedidoDto.getSaldoPulsera());
        pedido.setEmail(pedidoDto.getEmail());
        pedido.setFechaNacimiento(pedidoDto.getFechaNacimiento());
        pedido.setDireccion(pedidoDto.getDireccion());
        pedido.setConfirmado(pedidoDto.getConfirmado());

        return pedido;
    }

}
