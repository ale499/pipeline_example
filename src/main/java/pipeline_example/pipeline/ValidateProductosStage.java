package pipeline_example.pipeline;

import pipeline_example.model.Order;

public class ValidateProductosStage implements PipelineStage<Order> {
    @Override
    public Order process(Order input) {
        if (input.getProductos() == null || input.getProductos().isEmpty()) {
            throw new RuntimeException("Debe contener al menos un producto");
        }
        return input;
    }
}