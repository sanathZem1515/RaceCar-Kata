package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class Connection implements ConnectionInterface{

    private Boolean onlineStatus;

    private final Random connectionEventsSimulator = new Random(42);

    Connection(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    @Override
    public void connect(String telemetryServerConnectionString) {
        if (telemetryServerConnectionString == null || "".equals(telemetryServerConnectionString))
        {
            throw new IllegalArgumentException();
        }

        // simulate the operation on a real modem
        boolean success = connectionEventsSimulator.nextInt(10) <= 8;

        onlineStatus = success;
    }

    @Override
    public void disconnect() {
        onlineStatus = false;
    }
}
