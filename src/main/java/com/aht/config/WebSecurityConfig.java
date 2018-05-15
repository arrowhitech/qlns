package com.aht.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//@Configuration xác định lớp WebSecurityConfig của ta là một lớp dùng để cấu hình.
@Configuration
//@EnableWebSecurity sẽ kích hoạt việc tích hợp Spring Security với Spring MVC.
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//BCryptPasswordEncoder sẽ giúp chúng ta mã hóa mật khẩu bằng thuật toán BCrypt
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	//cấu hình các chi tiết về bảo mật:
	@Override
    protected void configure(HttpSecurity http) throws Exception {        
		http
            .authorizeRequests()
          //antMatchers(): khai báo đường dẫn của request 
                .antMatchers("/register").permitAll()
                //permitAll(): cho phép tất cả các user đều được phép truy cập.
                .antMatchers("/").hasRole("MEMBER")
                .antMatchers("/department").hasRole("MEMBER")
                
                .antMatchers("/employeesadmin/**").hasRole("ADMIN")
                //chỉ cho phép các user có GrantedAuthority là USER mới được phép truy cập
                .antMatchers("/admin/**").hasRole("ADMIN")//chỉ cho phép các user có GrantedAuthority là ADMIN mới được phép truy cập
                .antMatchers("/departments/**").hasRole("ADMIN")
                
                .and()
            .formLogin()
            	.loginPage("/login")//đường dẫn tới trang chứa form đăng nhập
            	.usernameParameter("email")
            	//gía trị của thuộc tính name của 2 input nhập username và password
            	.passwordParameter("password")
            	.defaultSuccessUrl("/")//defaultSuccessUrl(): đường dẫn tới trang đăng nhập thành công
            	.failureUrl("/login?error")//đường dẫn tới trang đăng nhập thất bại
            	.and()
        	.exceptionHandling()//Khi người dùng không đủ quyền để truy cập vào một trang, 
        	//ta sẽ redirect người dùng về một trang 403
    			.accessDeniedPage("/403");
		
		

        
    }
	
}
