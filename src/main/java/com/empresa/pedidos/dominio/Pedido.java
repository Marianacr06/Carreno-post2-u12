package com.empresa.pedidos.dominio;

public class Pedido {
    private PedidoId id;
    private double subtotal;
    private double costo;
    private TipoPedido tipo;
    private EstadoPedido estado = EstadoPedido.NUEVO;

    public PedidoId getId() {
        return id;
    }

    public void setId(PedidoId id) {
        this.id = id;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public void setTipo(TipoPedido tipo) {
        this.tipo = tipo;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
