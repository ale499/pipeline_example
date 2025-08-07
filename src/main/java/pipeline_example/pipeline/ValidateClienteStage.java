package pipeline_example.pipeline;

import pipeline_example.model.Order;

public class ValidateClienteStage implements PipelineStage<Order> {
    @Override
    public Order process(Order input) {
        if (input.getCliente() == null || input.getCliente().isBlank()) {
            throw new RuntimeException("Cliente inválido");
        }
        return input;
    }
}