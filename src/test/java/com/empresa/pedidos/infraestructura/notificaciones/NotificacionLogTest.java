package com.empresa.pedidos.infraestructura.notificaciones;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.PedidoId;
import com.empresa.pedidos.dominio.PedidoProcesadoEvent;
import org.junit.jupiter.api.Test;

class NotificacionLogTest {
    @Test
    void notificar_no_falla() {
        Pedido pedido = new Pedido();
        pedido.setId(new PedidoId(1L));
        pedido.setCosto(123.0);

        NotificacionLog notificacion = new NotificacionLog();

        assertDoesNotThrow(() -> notificacion.notificar(new PedidoProcesadoEvent(pedido)));
    }
}
