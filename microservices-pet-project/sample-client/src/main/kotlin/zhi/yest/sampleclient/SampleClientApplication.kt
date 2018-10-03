package zhi.yest.sampleclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
@EnableEurekaClient
@Controller
class SampleClientApplication {
    @GetMapping("/")
    fun home(): String {
        return "home"
    }
}

fun main(args: Array<String>) {
    runApplication<SampleClientApplication>(*args)
}
