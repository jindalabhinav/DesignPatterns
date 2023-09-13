package Structural.Adaptor;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
// DTO
public class PaymentRequest {
    private Long id;
    private String name;
    private String email;
    private Double amount;
}
