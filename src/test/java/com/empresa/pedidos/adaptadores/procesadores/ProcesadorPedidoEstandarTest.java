package com.empresa.pedidos.adaptadores.procesadores;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.empresa.pedidos.dominio.Pedido;
import com.empresa.pedidos.dominio.TipoPedido;
import org.junit.jupiter.api.Test;

class ProcesadorPedidoEstandarTest {
    @Test
    void calcula_costo_estandar() {
        Pedido pedido = new Pedido();
        pedido.setTipo(TipoPedido.ESTANDAR);
        pedido.setSubtotal(100.0);

        ProcesadorPedidoEstandar procesador = new ProcesadorPedidoEstandar();
        procesador.procesar(pedido);

        assertEquals(110.0, pedido.getCosto(), 0.001);
    }
}
