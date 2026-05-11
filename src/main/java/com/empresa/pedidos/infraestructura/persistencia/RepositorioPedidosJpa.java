package com.empresa.pedidos.infraestructura.persistencia;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.PedidoId;
import com.empresa.pedidos.dominio.puertos.RepositorioPedidos;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPedidosJpa implements RepositorioPedidos {
    private final Map<PedidoId, Pedido> almacenamiento = new ConcurrentHashMap<>();
    private final AtomicLong secuencia = new AtomicLong(1);

    @Override
    public Pedido guardar(Pedido pedido) {
        if (pedido.getId() == null) {
            pedido.setId(new PedidoId(secuencia.getAndIncrement()));
        }
        almacenamiento.put(pedido.getId(), pedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> buscarPorId(PedidoId id) {
        return Optional.ofNullable(almacenamiento.get(id));
    }
}
