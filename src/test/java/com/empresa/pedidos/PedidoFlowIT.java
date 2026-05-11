package com.empresa.pedidos;

import static org.assertj.core.api.Assertions.assertThat;

import com.empresa.pedidos.adaptadores.facade.FachadaPedidos;
import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.PedidoProcesadoEvent;
import com.empresa.pedidos.dominio.TipoPedido;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

@SpringBootTest
@RecordApplicationEvents
class PedidoFlowIT {
    @Autowired
    private FachadaPedidos fachada;

    @Autowired
    private ApplicationEvents events;

    @Test
    void crearPedido_publica_evento() {
        Pedido pedido = new Pedido();
        pedido.setTipo(TipoPedido.ESTANDAR);
        pedido.setSubtotal(100.0);

        fachada.crearPedido(pedido);

        long count = events.stream(PedidoProcesadoEvent.class).count();
        assertThat(count).isGreaterThan(0);
    }
}
