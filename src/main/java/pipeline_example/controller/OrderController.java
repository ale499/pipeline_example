package pipeline_example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pipeline_example.model.Order;
import pipeline_example.pipeline.Pipeline;
import pipeline_example.pipeline.ValidateClienteStage;
import pipeline_example.pipeline.ValidateProductosStage;
import pipeline_example.pipeline.ValidateTotalStage;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @PostMapping("/validate")
    public ResponseEntity<String> validateOrder(@RequestBody Order order) {
        Pipeline<Order> pipeline = new Pipeline<Order>()
                .addStage(new ValidateClienteStage())
                .addStage(new ValidateTotalStage())
                .addStage(new ValidateProductosStage());

        try {
            pipeline.execute(order);
            return ResponseEntity.ok("Pedido válido");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}