package line2.line2_back2;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RestApiService {
    public void test() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://localhost:8080/test";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        log.info("{}", response.getBody());
    }
}
