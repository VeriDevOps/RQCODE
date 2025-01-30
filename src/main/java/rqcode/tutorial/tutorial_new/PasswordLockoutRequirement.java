package rqcode.tutorial.tutorial_new;

import rqcode.concepts.Checkable;
import rqcode.concepts.Requirement;

import java.util.HashMap;
import java.util.Map;

public class PasswordLockoutRequirement extends Requirement {
    private static final int MAX_FAILED_ATTEMPTS = 5; // Maximum allowed failed attempts
    private static final long LOCKOUT_DURATION_MS = 15 * 60 * 1000; // Lockout duration in milliseconds (15 minutes)
    private final Map<String, UserLoginStatus> userStatusMap = new HashMap<>();
    private final String username;

    public PasswordLockoutRequirement(String username) {
        this.username = username;
        userStatusMap.putIfAbsent(username, new UserLoginStatus());
    }

    @Override
    public Checkable.CheckStatus check() {
        UserLoginStatus status = userStatusMap.get(username);

        if (status.isLocked()) {
            if (System.currentTimeMillis() - status.getLockoutStartTime() > LOCKOUT_DURATION_MS) {
                status.resetLockout(); // Unlock after the lockout period
            } else {
                return Checkable.CheckStatus.FAIL;
            }
        }

        return status.getFailedAttempts() >= MAX_FAILED_ATTEMPTS
                ? Checkable.CheckStatus.FAIL
                : Checkable.CheckStatus.PASS;
    }

    public void recordFailedAttempt() {
        userStatusMap.get(username).incrementFailedAttempts();
    }

    public void resetFailedAttempts() {
        userStatusMap.get(username).resetFailedAttempts();
    }

    @Override
    public String toString() {
        return "The system must lock a user’s account after " + MAX_FAILED_ATTEMPTS + " consecutive failed login attempts.";
    }

    private static class UserLoginStatus {
        private int failedAttempts = 0;
        private long lockoutStartTime = 0;

        public int getFailedAttempts() {
            return failedAttempts;
        }

        public void incrementFailedAttempts() {
            failedAttempts++;
            if (failedAttempts >= MAX_FAILED_ATTEMPTS) {
                lockoutStartTime = System.currentTimeMillis();
            }
        }

        public void resetFailedAttempts() {
            failedAttempts = 0;
            lockoutStartTime = 0;
        }

        public boolean isLocked() {
            return lockoutStartTime > 0;
        }

        public long getLockoutStartTime() {
            return lockoutStartTime;
        }

        public void resetLockout() {
            lockoutStartTime = 0;
        }
    }
}