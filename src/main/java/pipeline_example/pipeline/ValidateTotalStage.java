package pipeline_example.pipeline;

import pipeline_example.model.Order;

public class ValidateTotalStage implements PipelineStage<Order> {
    @Override
    public Order process(Order input) {
        if (input.getTotal() == null || input.getTotal() <= 0) {
            throw new RuntimeException("Total inválido");
        }
        return input;
    }
}
