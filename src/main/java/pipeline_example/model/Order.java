package pipeline_example.model;

import java.util.List;

public class Order {
    private String cliente;
    private Double total;
    private List<String> productos;

    // Getters y setters
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }

    public List<String> getProductos() { return productos; }
    public void setProductos(List<String> productos) { this.productos = productos; }
}