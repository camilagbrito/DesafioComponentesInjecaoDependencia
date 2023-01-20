package com.desafio.comp_injecao_dependencia.services;

import com.desafio.comp_injecao_dependencia.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {
    public double shipment(Order order){
        if(order.getBasic() < 100.0){
            return 20.0;
        } else if( order.getBasic() >= 100.0 && order.getBasic() < 200.0){
            return 12.0;
        } else{
            return 0;
        }
    }
}
