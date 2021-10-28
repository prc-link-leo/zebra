package com.dbses.restful;

import com.dbses.api.OrderService;
import com.dbses.application.service.OrderAppService;
import com.dbses.dto.OrderDTO;
import com.dbses.request.CancelOrderRequest;
import com.dbses.request.ModifyOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 订单服务实现
 *
 * @author infra
 */
@Slf4j
@RestController
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderAppService orderAppService;

    @Override
    public OrderDTO getById(@PathVariable String orderId) {
        return orderAppService.getOrderDetails(orderId);
    }

    @Override
    public void cancel(@PathVariable String orderId, @RequestBody CancelOrderRequest request) {
        log.info("取消订单");
    }

    @Override
    public List<OrderDTO> listByIds(@RequestParam("orderIds") String orderIds) {
        return orderAppService.listByIds(orderIds);
    }

    @Override
    public List<OrderDTO> listByPage(@RequestParam("page") Integer page, @RequestParam("size") Integer size) {
        return orderAppService.listByPage(page, size);
    }

    @Override
    public void updateById(@PathVariable Integer orderId, @RequestBody ModifyOrderRequest request) {
        orderAppService.updateById(orderId, request);
    }

}
