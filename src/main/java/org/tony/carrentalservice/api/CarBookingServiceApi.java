package org.tony.carrentalservice.api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tony.carrentalservice.bean.R;
import org.tony.carrentalservice.service.CarInfoService;
import org.tony.carrentalservice.service.OrderInfoService;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @ApiOperation(value="获取可租赁汽车列表", notes="notes")
//    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Integer", paramType = "path")
    @GetMapping("/cars")
    public R list(Date startTime, Date endTime) {
        List<String> data = this.carInfoService.selectModelsByConditions(startTime, endTime);
        return R.success(data);
    }

    @ApiOperation(value="下单租赁汽车", notes="notes")
    @PostMapping("/{model}")
    public R book(@PathVariable String model, String username, Date startTime, Date endTime) {
        try {
            this.orderInfoService.book(model, username, startTime, endTime);
            return R.success();
        } catch (Exception e) {
//            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }

    @ApiOperation(value="取消订单", notes="notes")
    @DeleteMapping("/{orderId}")
    public Map<String, Object> cancel(@PathVariable String orderId) {
        return null;
    }

    @ApiOperation(value="归还租赁汽车完成订单", notes="notes")
    @PutMapping("/{orderId}")
    public Map<String, Object> finish(@PathVariable String orderId) {
        return null;
    }
}
