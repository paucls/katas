package tddmicroexercises.telemetrysystem;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TelemetryDiagnosticControlsTest {

    @Test
    public void checkTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response() throws Exception {
        TelemetryClient clientMock = mock(TelemetryClient.class);
        TelemetryDiagnosticControls diagnosticControls = new TelemetryDiagnosticControls(clientMock);
        String diagnosticInfo = "a diagnostic message";

        when(clientMock.getOnlineStatus()).thenReturn(true);
        when(clientMock.receive()).thenReturn(diagnosticInfo);

        diagnosticControls.checkTransmission();

        verify(clientMock).send(TelemetryClient.DIAGNOSTIC_MESSAGE);
        assertThat(diagnosticControls.getDiagnosticInfo(), is(diagnosticInfo));
    }

    @Test
    public void checkTransmission_should_connect_to_server_if_is_not_online_yet() throws Exception {
        TelemetryClient clientMock = mock(TelemetryClient.class);
        TelemetryDiagnosticControls diagnosticControls = new TelemetryDiagnosticControls(clientMock);
        when(clientMock.getOnlineStatus())
                .thenReturn(false)
                .thenReturn(true);

        diagnosticControls.checkTransmission();

        verify(clientMock, times(1)).connect(anyString());
    }

}
