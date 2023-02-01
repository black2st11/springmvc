package hello.springmvc.basic;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    // 롬복이 대신 해줌
//    private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        // 틀린 방식, 출력을 안하더라도 문자를 더하는 연산이 일어난다.
        log.trace("trace log=" + name);

        // 옳은 방식, 파라미터만 넘기고 출력을 해야하면 그때 동작 1, 2 는 비슷한 방식
        // 1
        if (log.isTraceEnabled()){
            log.trace("trace log=" + name);
        }
        // 2
        log.trace("trace log={}", name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.warn("warn log={}", name);
        log.info("info log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
