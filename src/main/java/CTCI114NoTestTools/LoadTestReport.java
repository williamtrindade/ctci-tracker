package CTCI114NoTestTools;

public record LoadTestReport(int totalRequests, int failures, double averageLatencyMillis, double maxLatencyMillis) {
}
