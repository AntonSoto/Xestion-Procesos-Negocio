package es.udc.fic.xpn.example.controller;


import es.udc.fic.xpn.example.dto.PedidoDto;
import es.udc.fic.xpn.example.mapper.PedidoMapper;
import es.udc.fic.xpn.example.model.Pedido;
import es.udc.fic.xpn.example.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoDto create(@RequestBody PedidoDto pedidoDto){
        return PedidoMapper.entityToDto(
                pedidoService.create(PedidoMapper.
                        dtoToEntity(pedidoDto)));
    }

    @GetMapping
    public List<PedidoDto> findAll(){
        List<Pedido> pedidos = pedidoService.findAll();

        return pedidos.stream().map(PedidoMapper::entityToDto).
                collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> findById(@PathVariable Long id){
        Optional<Pedido> pedido = pedidoService.find(id);

        if(pedido.isPresent())
            return new ResponseEntity<>(
                    PedidoMapper.entityToDto(pedido.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PedidoDto pedidoDto){
        if(pedidoService.find(pedidoDto.getId()).isPresent()){
            pedidoService.update((PedidoMapper.dtoToEntity(pedidoDto)));
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(pedidoService.find(id).isPresent()){
            pedidoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
