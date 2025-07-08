package school.hei.storedint.endpoint.rest.controller.health;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import school.hei.storedint.service.StoredIntService;

@RestController
public class StoredIntController {

  private final StoredIntService service;

  public StoredIntController(StoredIntService service) {
    this.service = service;
  }

  @GetMapping("/stored-int")
  public ResponseEntity<Integer> getStoredInt() {
    return ResponseEntity.ok(service.retrieveStoredInt());
  }
}
