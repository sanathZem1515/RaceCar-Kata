package tddmicroexercises.telemetrysystem;

public class TelemetryDiagnosticControls implements TelemetryDiagnosticsInterface
{
    private final String DiagnosticChannelConnectionString = "*111#";
    private final TelemetryClient telemetryClient;
    private String diagnosticInfo = "";

        public TelemetryDiagnosticControls(TelemetryClient telemetryClient)
        {
            this.telemetryClient = telemetryClient;
        }
        
        public String getDiagnosticInfo(){
            return diagnosticInfo;
        }
        
        public void setDiagnosticInfo(String diagnosticInfo){
            this.diagnosticInfo = diagnosticInfo;
        }
 
        public void checkTransmission() throws Exception
        {
            diagnosticInfo = "";

            telemetryClient.disconnect();
    
            int retryLeft = 3;

            Authenticate authenticate = new Authenticate();
            authenticate.authenticate(telemetryClient,retryLeft);
    
            telemetryClient.send(TelemetryClient.DIAGNOSTIC_MESSAGE);
            diagnosticInfo = telemetryClient.receive();
    }
}
