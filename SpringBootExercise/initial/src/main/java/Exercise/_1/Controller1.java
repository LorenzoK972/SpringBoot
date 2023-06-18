package Exercise._1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller1 {
    @GetMapping("/hello")
    public String index2() {
        return "Hello World!";
    }

    @GetMapping ("/greeting")
    public ResponseEntity<String> index3() {
        return ResponseEntity.status(200).body("Good Afternoon!");
    }

}

