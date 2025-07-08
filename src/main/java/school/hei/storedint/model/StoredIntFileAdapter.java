package school.hei.storedint.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.SecureRandom;
import org.springframework.stereotype.Component;

@Component
public class StoredIntFileAdapter {

  private static final Path FILE = Path.of("/tmp/stored-int.txt");
  private static final SecureRandom RNG = new SecureRandom();

  public synchronized int getStoredInt() {
    try {
      if (Files.exists(FILE)) {
        return Integer.parseInt(Files.readString(FILE).trim());
      }
      int value = RNG.nextInt(1_000_000);
      Files.writeString(FILE, Integer.toString(value));
      return value;
    } catch (IOException e) {
      throw new IllegalStateException("Unable to access stored‑int file", e);
    }
  }
}
