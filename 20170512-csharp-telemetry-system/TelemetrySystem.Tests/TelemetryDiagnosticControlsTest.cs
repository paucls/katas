using NUnit.Framework;
using Rhino.Mocks;

namespace TDDMicroExercises.TelemetrySystem.Tests
{
    [TestFixture]
    public class TelemetryDiagnosticControlsTest
    {
        [Test]
        public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
        {
            ITelemetryClient telemetryClientMock = MockRepository.GenerateMock<ITelemetryClient>();
            telemetryClientMock.Stub(client => client.OnlineStatus).Return(true);
            TelemetryDiagnosticControls telemetryDiagnosticControls = new TelemetryDiagnosticControls(telemetryClientMock);

            telemetryDiagnosticControls.CheckTransmission();

            telemetryClientMock.AssertWasCalled(client => client.Send(TelemetryClient.DiagnosticMessage));
            Assert.IsNotEmpty(telemetryDiagnosticControls.DiagnosticInfo);
        }
    }
}
