/**
 * 
 */
package com.techolution.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author shyamjumberu
 *
 */
@Configuration
@EnableAutoConfiguration
@Profile("cloud")
public class CloudConfig {

	@Bean
	public Cloud createCloud() {
		return new CloudFactory().getCloud();
	}

}
