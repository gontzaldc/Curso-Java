package com.gontzal.inmobiliaria.mf0493_gontzal.configuraciones;

import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

		// AUTORIZACIÓN
		@Bean
	    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeHttpRequests((authz) -> authz
					.antMatchers("/inmuebles/admin/**").authenticated()
					.anyRequest().permitAll()
	            )
	            .formLogin()
					.permitAll()
					.and()
				.logout()
					.permitAll();
		        return http.build();
	    }

		@Bean
	    UserDetailsManager users(DataSource dataSource) {
	        return new JdbcUserDetailsManager(dataSource);
	    }
		
		@Bean
		PasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
		
		
//		create table users(
//			username varchar(50) not null primary key,
//			password varchar(100) not null,
//			enabled boolean not null
//		);
//	
//		create table authorities (
//			username varchar(50) not null,
//			authority varchar(0) not null,
//			constraint fk_authorities_users foreign key(username) references users(username)
//		);
//		create unique index ix_auth_username on authorities (username,authority);

	}

