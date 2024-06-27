package com.ntt.dev.test.bff_inventory;

import static org.assertj.core.api.Assertions.*;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
class BffInventoryApplicationTests {
	@Autowired private ApplicationContext context;

	@Test
	void contextLoads() {
		assertThat(this.context).isNotNull();
	}

}
