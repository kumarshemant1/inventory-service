package app.inventory.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class InventoryScheduler {
	
	@Scheduled(cron = "${cron.expression}")
	public void scheduleTaskByCronExpression() {
		System.out.println("cron job working");
	}
	
	@Scheduled(fixedDelay = 2000)
	public void scheduleTaskByFixedDelay() {
		System.out.println("fixed delay working");
	}

}
