package com.example.eventplanner.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Value("${spring.queries.user-query}")
    private String usersQuery;

    @Value("${spring.queries.role-query}")
    private String rolesQuery;

   @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        //http.authorizeRequests().anyRequest().permitAll();

                http.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/course").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/user/signup").permitAll()
                        .antMatchers("/home.html").permitAll()
                        .antMatchers("/templates/home").permitAll()
                        .antMatchers("/templates/home.html").permitAll()
                        .antMatchers("/templates/Contact.html").permitAll()
                        .antMatchers("/templates/Course Details.html").permitAll()
                        .antMatchers("/templates/Login.html").permitAll()
                        .antMatchers("/Login.html").permitAll()
                        .antMatchers("/Contact.html").permitAll()
                        .antMatchers("/Course Details.html").permitAll()
                        .antMatchers("/templates/home.html").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/viewmore/course").permitAll()
                        .antMatchers("/home/forgetpasswordhome.html").permitAll()
                        .antMatchers("/forgetpasswordhome.html").permitAll()
                        .antMatchers("/home/forgetpasswordhome").permitAll()
                        .antMatchers("/forgetpassword/").permitAll()
                        .antMatchers("/contact/enquirysubmit").permitAll()


                        .antMatchers("/apply/{cid}").hasAuthority("user").and().authorizeRequests()
                .antMatchers("/home/admin/**").hasAuthority("admin").anyRequest()
             //           .antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
                .authenticated().and().csrf().disable().formLogin()
                .loginPage("/login").failureUrl("/login?error=true")
                .defaultSuccessUrl("/home/userpage")
                .usernameParameter("useremail")
                .passwordParameter("userpassword")
                .and().logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/home").and().exceptionHandling()
                .accessDeniedPage("/access-denied");
//spring will redirsct to its homepage where thelogin page was accesed
    }
//
}
