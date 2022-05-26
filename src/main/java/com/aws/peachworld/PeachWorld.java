package com.aws.peachworld;

import com.aws.peachworld.view.application.UpdateOrderHistory;
import com.aws.peachworld.view.application.readmodel.OrderHistory;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.List;

@EnableCaching
@SpringBootApplication
public class PeachWorld {
    public static void main(String[] args) {
        SpringApplication.run(PeachWorld.class, args);
    }

    @Slf4j
    @Component
    @RequiredArgsConstructor
    public static class StartupInitializer {
        private final UpdateOrderHistory updateOrderHistory;

        @EventListener(ContextRefreshedEvent.class)
        public void contextRefreshedEvent() {
            createSampleOrderHistory();
        }

        void createSampleOrderHistory() {
                List<OrderHistory> orderHistories = Lists.newArrayList(
                        OrderHistory.builder()
                                .paymentMethod("CARD")
                                .orderNo(1L)
                                .userId("aws")
                                .amount(100L)
                                .userName("IU")
                                .build(),
                        OrderHistory.builder()
                                .paymentMethod("CARD")
                                .orderNo(2L)
                                .userId("lgu+")
                                .amount(100L)
                                .userName("BlackPink")
                                .build(),
                        OrderHistory.builder()
                                .paymentMethod("CARD")
                                .orderNo(3L)
                                .userId("megazone")
                                .amount(100L)
                                .userName("APink")
                                .build());
            orderHistories.forEach(updateOrderHistory::save);
        }
    }
}
