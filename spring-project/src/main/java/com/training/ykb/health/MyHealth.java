package com.training.ykb.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;

public class MyHealth implements HealthIndicator {

	@Override
	public Health health() {
		return Health.status(Status.DOWN).withDetail("my health", "çöktü").build();
	}
}
