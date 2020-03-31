package org.tony.carrentalservice.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tony.carrentalservice.bean.R;
import org.tony.carrentalservice.dto.OrderInfoDTO;
import org.tony.carrentalservice.model.OrderInfo;
import org.tony.carrentalservice.service.CarInfoService;
import org.tony.carrentalservice.service.OrderInfoService;

import java.util.Date;
import java.util.List;

/**
 * @author tony.chenjy
 * @date 2020-03-29
 */
@RequestMapping("/api/carBookingService")
@RestController
public class CarBookingServiceApi {

    @Autowired
    private CarInfoService carInfoService;
    @Autowired
    private OrderInfoService orderInfoService;

    @ApiOperation(value="查询可租赁的汽车品牌")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/cars")
    public R list(@RequestParam Date startTime,
                  @RequestParam Date endTime) {
        List<String> data = this.carInfoService.selectModelsByConditions(startTime, endTime);
        return R.success(data);
    }

    @ApiOperation(value="下单租赁汽车")
    @PostMapping("/{model}")
    public R book(@PathVariable String model,
                  @RequestParam String username,
                  @RequestParam Date startTime,
                  @RequestParam Date endTime) {
        try {
            this.orderInfoService.book(model, username, startTime, endTime);
            return R.success();
        } catch (Exception e) {
//            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @ApiOperation(value="查询符合条件的订单")
    @PostMapping("/orders")
    public R list(String userName, Date startTime, Date endTime, Short status) {
        List<OrderInfo> data = this.orderInfoService.selectByConditions(userName, startTime, endTime, status);
        return R.success(data);
    }

    @ApiOperation(value="取消订单")
    @DeleteMapping("/{orderId}")
    public R cancel(@PathVariable Long orderId) {
        this.orderInfoService.update(orderId, OrderInfoDTO.STATUS_CANCELED);
        return R.success();
    }

    @ApiOperation(value="归还租赁汽车完成订单")
    @PutMapping("/{orderId}")
    public R finish(@PathVariable Long orderId) {
        this.orderInfoService.update(orderId, OrderInfoDTO.STATUS_FINISHED);
        return R.success();
    }

}
