package zhi.yest.bookservice

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer

private const val RESOURCE_ID: String = "123"

@Configuration
@EnableResourceServer
class SecurityConfig : ResourceServerConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http
                .requestMatchers()
                .antMatchers("/book/**", "")
                .and()
                .authorizeRequests()
                .anyRequest()
                .access("#oauth2.hasScope('read')")
    }

    override fun configure(resources: ResourceServerSecurityConfigurer) {
        resources.resourceId(RESOURCE_ID)
    }
}