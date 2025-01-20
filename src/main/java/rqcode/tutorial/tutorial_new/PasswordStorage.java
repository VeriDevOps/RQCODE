package rqcode.tutorial.tutorial_new;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class PasswordStorage {
    private final Map<String, LocalDateTime> passwordTimestamps = new HashMap<>();

    public void storePassword(String username, String password) {
        passwordTimestamps.put(username, LocalDateTime.now());
    }

    public LocalDateTime getPasswordTimestamp(String username) {
        return passwordTimestamps.getOrDefault(username, null);
    }
}