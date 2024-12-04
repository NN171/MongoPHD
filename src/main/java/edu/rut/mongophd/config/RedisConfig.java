package edu.rut.mongophd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfig {

	@Value("${redis.host}")
	private String host;

	@Value("${redis.port}")
	private int port;

	@Value("${redis.password}")
	private String password;

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(host, port);
		configuration.setPassword(password);

		return new LettuceConnectionFactory(configuration);
	}

	@Bean
	public RedisCacheManager manager(RedisConnectionFactory conFactory) {

		return RedisCacheManager.create(conFactory);
	}
}
