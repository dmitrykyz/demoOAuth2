package bel.tnp.ui;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

/**
 * Created by Dmitry on 2/28/2017.
 */
@Configuration
@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
@EnableOAuth2Sso
public class UIResourceServerConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().and()
                .logout().and()
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/resource").permitAll()
                .antMatchers("/samplestring").access("hasRole('USER')")
                .antMatchers("/samplestringAdmin").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
