package com.aws.peachworld.command.order.port;

import com.aws.peachworld.command.order.application.NotExistOrdererException;
import com.aws.peachworld.command.order.application.model.valueobjects.Orderer;

public interface OrdererRepository {
    Orderer findByUsername(String username) throws NotExistOrdererException;
}
