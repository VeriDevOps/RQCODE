package rqcode.tutorial;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import rqcode.concepts.Requirement;

public class PasswordUpdateRequirement extends Requirement {
    private final PasswordStorage passwordStorage;
    private final String username;
    private static final int PASSWORD_EXPIRATION_DAYS = 90;

    public PasswordUpdateRequirement(PasswordStorage passwordStorage, String username) {
        this.passwordStorage = passwordStorage;
        this.username = username;
        setStatement("Password must be updated every " + PASSWORD_EXPIRATION_DAYS + " days.");
    }

    @Override
    public CheckStatus check() {
        LocalDateTime lastUpdated = passwordStorage.getPasswordTimestamp(username);

        if (lastUpdated == null) {
            return CheckStatus.INCOMPLETE; // Password not set
        }

        long daysSinceUpdate = ChronoUnit.DAYS.between(lastUpdated, LocalDateTime.now());
        if (daysSinceUpdate <= PASSWORD_EXPIRATION_DAYS) {
            return CheckStatus.PASS; // Password updated within 90 days
        } else {
            return CheckStatus.FAIL; // Password expired
        }
    }
}