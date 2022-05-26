package com.aws.peachworld.command.order.application;

import com.aws.peachworld.command.order.application.model.valueobjects.ShippingInformation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrder {

    private String username;
    private List<OrderLineRequest> orderLineRequests;
    private ShippingRequest shippingRequest;
    private PaymentRequest paymentRequest;

    public List<Long> getOrderProductIds() {
        return this.orderLineRequests.stream().map( m -> m.getProductId()).collect(Collectors.toList());
    }

    @Getter
    public static class OrderLineRequest {
        private Long productId;
        private Long price;
        private int quantity;
    }

    @Getter
    public static class ShippingRequest {
        private String city;
        private String telephoneNumber;
        private String receiver;
        private String address1;
        private String address2;

        public ShippingInformation createShippingInformation(){
            return ShippingInformation.builder().address1(this.address1)
                    .address2(this.address2)
                    .city(this.city)
                    .receiver(this.receiver)
                    .telephoneNumber(this.telephoneNumber)
                    .build();
        }
    }

    @Getter
    public static class PaymentRequest {
        private String method;
        private String transactionId;
        private String amount;
    }
}
