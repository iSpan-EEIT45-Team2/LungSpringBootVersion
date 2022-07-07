package com.eeit45team2.lungspringbootversion.backend.springmvc.config;

import com.eeit45team2.lungspringbootversion.backend.member.model.UserAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()  //開始自訂授權規則
                .anyRequest().permitAll()  // 第一次登入前都要先打開這個!! 然後建一個會員，才會拿到帳號和加密後的密碼!!
//                .antMatchers(HttpMethod.GET,"/loginPage**").permitAll()  //不限授權皆可進到登入
//                .antMatchers(HttpMethod.GET,"/BackEnd/css/**").permitAll()
//                .antMatchers(HttpMethod.GET,"/BackEnd/images/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/Backendmember/**").hasAuthority(UserAuthority.ADMIN.name())
//                .anyRequest().authenticated()  //其他請求，都要經過驗證
                .and()
                    .formLogin().loginPage("/loginPage").failureUrl("/loginPage-error")
                .and()
                    .exceptionHandling().accessDeniedPage("/loginPage") //如果有權限錯誤時，重導到「/login」
                .and()
                    .logout().logoutSuccessUrl("/login?logout")
                .and()
                    .csrf().disable(); //關閉對 CSRF（跨站請求偽造）攻擊的防護。這樣 Security 機制才不會拒絕外部直接對 API 發出的請求
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder()); //登入時輸入的密碼便會被加密，與資料庫中使用者的已加密密碼進行比對
//                .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER")
//                .and()
//                .withUser("admin").password("password").roles("ADMIN");
    }




}
