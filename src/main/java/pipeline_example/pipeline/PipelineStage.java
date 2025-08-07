package pipeline_example.pipeline;

public interface PipelineStage<T> {
    T process(T input);
}
