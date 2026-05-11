package com.empresa.pedidos.adaptadores.facade;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.empresa.pedidos.adaptadores.procesadores.ProcesadorPedidoEstandar;
import com.empresa.pedidos.adaptadores.procesadores.ProcesadorPedidoFactory;
import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.PedidoProcesadoEvent;
import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.RepositorioPedidos;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

@ExtendWith(MockitoExtension.class)
class FachadaPedidosTest {
    @Mock
    private RepositorioPedidos repositorio;

    @Mock
    private ApplicationEventPublisher publisher;

    @Test
    void crearPedido_publica_evento() {
        ProcesadorPedidoFactory factory = new ProcesadorPedidoFactory(
            List.of(new ProcesadorPedidoEstandar()));
        FachadaPedidos fachada = new FachadaPedidos(factory, repositorio, publisher);

        Pedido pedido = new Pedido();
        pedido.setTipo(TipoPedido.ESTANDAR);
        pedido.setSubtotal(100.0);

        when(repositorio.guardar(pedido)).thenReturn(pedido);

        fachada.crearPedido(pedido);

        verify(publisher).publishEvent(any(PedidoProcesadoEvent.class));
    }
}
