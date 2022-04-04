package line2.line2_back2;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class RestApiController {
    private final RestApiService restApiService;

    @GetMapping("/test")
    public void test() {
        restApiService.test();
    }
}
