package tddmicroexercises.telemetrysystem;

import org.junit.jupiter.api.Test;


public class TelemetryDiagnosticControlsTest
{

	@Test
    public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        boolean onlineStatus = true;
        String diagnosticMessageResult = "";
        Connection connection = new Connection(onlineStatus);
        Transfer transfer = new Transfer(diagnosticMessageResult);
        TelemetryClient telemetryClient = new TelemetryClient(connection,transfer);
        telemetryClient.connect("connect");
        TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClient);
        telemetryDiagnosticControls.checkTransmission();
    }

}
