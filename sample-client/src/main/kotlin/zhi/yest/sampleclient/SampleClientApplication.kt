package zhi.yest.sampleclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
@Controller
class SampleClientApplication {
    @GetMapping("/home")
    fun home(): String {
        return "home"
    }
}

fun main(args: Array<String>) {
    runApplication<SampleClientApplication>(*args)
}
