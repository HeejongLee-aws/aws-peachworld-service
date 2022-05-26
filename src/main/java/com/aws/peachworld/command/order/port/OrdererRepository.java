package com.aws.peachworld.command.order.port;

import com.aws.peachworld.command.order.application.NotExistOrdererException;
import com.aws.peachworld.command.order.application.model.valueobjects.Orderer;

import java.util.Optional;

public interface OrdererRepository {
    Optional<Orderer> findByUsername(String username) throws NotExistOrdererException;
}
