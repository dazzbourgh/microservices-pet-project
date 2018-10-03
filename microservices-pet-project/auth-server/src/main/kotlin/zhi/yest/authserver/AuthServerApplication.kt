package zhi.yest.authserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer

@SpringBootApplication
@EnableEurekaClient
@EnableAuthorizationServer
class AuthServerApplication
@Autowired
constructor(val authenticationManager: AuthenticationManager) : AuthorizationServerConfigurerAdapter() {
    override fun configure(clients: ClientDetailsServiceConfigurer) {
        clients.inMemory()
                    .withClient("sample-client")
                    .authorizedGrantTypes("authorization_code")
                    .authorities("ROLE_USER")
                    .scopes("read")
                    .redirectUris("http://anywhere?key=value")
                    .secret("secret123")
    }

    override fun configure(endpoints: AuthorizationServerEndpointsConfigurer) {
        endpoints.authenticationManager(authenticationManager)
    }
}

fun main(args: Array<String>) {
    runApplication<AuthServerApplication>(*args)
}
