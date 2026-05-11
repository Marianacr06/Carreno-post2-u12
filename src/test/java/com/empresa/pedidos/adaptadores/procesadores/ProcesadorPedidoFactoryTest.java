package com.empresa.pedidos.adaptadores.procesadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.empresa.pedidos.dominio.TipoPedido;
import com.empresa.pedidos.dominio.puertos.ProcesadorPedido;
import java.util.List;
import org.junit.jupiter.api.Test;

class ProcesadorPedidoFactoryTest {
    @Test
    void devuelve_procesador_por_tipo() {
        List<ProcesadorPedido> lista = List.of(
            new ProcesadorPedidoEstandar(),
            new ProcesadorPedidoExpress(),
            new ProcesadorPedidoInternacional());

        ProcesadorPedidoFactory factory = new ProcesadorPedidoFactory(lista);

        assertEquals(TipoPedido.EXPRESS, factory.obtener(TipoPedido.EXPRESS).getTipo());
    }

    @Test
    void tipo_desconocido_lanza_excepcion() {
        ProcesadorPedidoFactory factory = new ProcesadorPedidoFactory(List.of());

        assertThrows(IllegalArgumentException.class, () -> factory.obtener(TipoPedido.ESTANDAR));
    }
}
