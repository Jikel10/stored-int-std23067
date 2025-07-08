package school.hei.storedint.service;

import org.springframework.stereotype.Service;
import school.hei.storedint.model.StoredIntFileAdapter;

@Service
public class StoredIntService {

  private final StoredIntFileAdapter adapter;

  public StoredIntService(StoredIntFileAdapter adapter) {
    this.adapter = adapter;
  }

  public int retrieveStoredInt() {
    return adapter.getStoredInt();
  }
}
