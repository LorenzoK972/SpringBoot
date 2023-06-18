package Exercise_1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Controller2 {

    @GetMapping ("/info")
    public ResponseEntity<String> index1() {
        return ResponseEntity.status(200).body("info");
    }

    @GetMapping ("/random")
    public ResponseEntity<String> index2() {
        Random random = new Random();
        if (random.nextBoolean()) {
            return ResponseEntity.status(200).body("Ok");
            }
        return ResponseEntity.status(400).body("Bad Request");
    }
}
