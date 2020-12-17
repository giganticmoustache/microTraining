package com.order.accouning.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="ACCOUNTING")
@RequestMapping("/accounting")
public interface IAccountingClient {

}
