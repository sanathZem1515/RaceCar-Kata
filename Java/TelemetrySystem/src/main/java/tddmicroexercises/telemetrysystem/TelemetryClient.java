package tddmicroexercises.telemetrysystem;

import java.util.Random;

public class TelemetryClient implements TelemetryClientInterface
{
    public static final String DIAGNOSTIC_MESSAGE = "AT#UD";

    private boolean onlineStatus;

    private ConnectionInterface connection;

    private TransferInterface transfer;

    private String diagnosticMessageResult = "";

    public boolean getOnlineStatus()
    {
        return onlineStatus; 
    }
    
    TelemetryClient( ConnectionInterface connection,TransferInterface transfer) {
        this.connection = connection;
        this.transfer = transfer;
    }
    public void connect(String telemetryServerConnectionString) {
        connection.connect(telemetryServerConnectionString);
    }
    public void disconnect() {
        connection.disconnect();
    }

    public String receive() {
        return transfer.receive();
    }

    public void send(String message) {
        transfer.send(message);
    }
}

