package tddmicroexercises.telemetrysystem;

public class Authenticate {
    private final String DiagnosticChannelConnectionString = "*111#";

    void authenticate(TelemetryClient telemetryClient,Integer retryLeft) throws Exception {
        while (telemetryClient.getOnlineStatus() == false && retryLeft > 0)
        {
            telemetryClient.connect(DiagnosticChannelConnectionString);
            retryLeft -= 1;
        }

        if(telemetryClient.getOnlineStatus() == false)
        {
            throw new Exception("Unable to connect.");
        }
    }
}
