package org.tony.carrentalservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tony.carrentalservice.service.CarInfoService;
import org.tony.carrentalservice.service.OrderInfoService;

import java.util.Date;
import java.util.HashMap;
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

    @GetMapping("/cars")
    public Map<String, Object> list(Date startTime, Date endTime) {
        Map<String, Object> resultMap = new HashMap<>();

        Map<String, Object> conditions = new HashMap<>();
        conditions.put("carStatus", 1);
        conditions.put("orderStatus", 1);
        conditions.put("startTime", startTime);
        conditions.put("endTime", endTime);
        List<String> data = this.carInfoService.selectModelsByConditions(conditions);
        resultMap.put("data", data);

        return resultMap;
    }

    @PostMapping("/{model}")
    public Map<String, Object> book(@PathVariable String model, String username, Date startTime, Date endTime) {
        return null;
    }

    @DeleteMapping("/{orderId}")
    public Map<String, Object> cancel(@PathVariable String orderId) {
        return null;
    }

    @PutMapping("/{orderId}")
    public Map<String, Object> finish(@PathVariable String orderId) {
        return null;
    }
}
