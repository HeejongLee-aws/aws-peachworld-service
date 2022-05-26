package com.aws.peachworld.view.application;

import com.aws.peachworld.boot.CacheNameType;
import com.aws.peachworld.view.application.readmodel.OrderHistory;
import com.aws.peachworld.view.port.OrderHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class OrderHistoryQueryService {

    private OrderHistoryRepository orderHistoryRepository;

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Cacheable(cacheNames = CacheNameType.TTS_1, key = "'order_history_user_id' + #userId")
    public List<OrderHistory> findByUsername(final String userId){
        return this.orderHistoryRepository.findByUsername(userId);
    }

    @Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
    @Cacheable(cacheNames = CacheNameType.TTS_1, key = "'order_history_order_no' + #orderNo")
    public OrderHistory findByOrderNo(final Long orderNo){
        return this.orderHistoryRepository.findByOrderNo(orderNo);
    }
}
