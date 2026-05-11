package com.empresa.pedidos.dominio;

import java.util.Objects;

public class PedidoId {
    private final Long value;

    public PedidoId(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("PedidoId requerido");
        }
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PedidoId pedidoId = (PedidoId) o;
        return Objects.equals(value, pedidoId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
