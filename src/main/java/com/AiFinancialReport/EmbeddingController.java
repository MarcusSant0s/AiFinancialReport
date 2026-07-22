    package com.AiFinancialReport;

    import org.springframework.ai.bedrock.titan.BedrockTitanEmbeddingModel;
    import org.springframework.ai.bedrock.titan.BedrockTitanEmbeddingOptions;
    import org.springframework.ai.embedding.EmbeddingModel;
    import org.springframework.ai.embedding.EmbeddingRequest;
    import org.springframework.ai.embedding.EmbeddingResponse;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.bind.annotation.RestController;

    import java.util.List;
    import java.util.Map;

    @RestController
    public class EmbeddingController {

        private final EmbeddingModel embeddingModel;

        @Autowired
        public EmbeddingController( EmbeddingModel embeddingModel){
            this.embeddingModel = embeddingModel;
        }

//    @GetMapping("/ai/embedding")
//        public Map embed(@RequestParam(value = "message", defaultValue = "Tell me a joke") String message){
//        EmbeddingResponse embeddingResponse = this.embeddingModel.embedForResponse(List.of(message));
//        return Map.of("embedding", embeddingResponse);
//    }

        @GetMapping("/ai/embedding")
        public Map<String, EmbeddingResponse> embed(){

            EmbeddingResponse embeddingResponse = embeddingModel.call(
                    new EmbeddingRequest(List.of("Hello World"),
                            BedrockTitanEmbeddingOptions.builder()
                                    .inputType(BedrockTitanEmbeddingModel.InputType.TEXT)
                                    .build()));

            return Map.of("embedding", embeddingResponse);


        }
    }
