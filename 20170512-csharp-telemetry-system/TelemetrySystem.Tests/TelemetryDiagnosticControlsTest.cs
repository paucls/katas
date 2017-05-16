using NUnit.Framework;
using Rhino.Mocks;
using System;

namespace TDDMicroExercises.TelemetrySystem.Tests
{
    [TestFixture]
    public class TelemetryDiagnosticControlsTest
    {
        [Test]
        public void CheckTransmission_should_send_a_diagnostic_message_and_receive_a_status_message_response()
        {
            ITelemetryClient telemetryClientMock = MockRepository.GenerateMock<ITelemetryClient>();
            TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(telemetryClientMock);
            telemetryClientMock.Stub(client => client.OnlineStatus).Return(true);

            controls.CheckTransmission();

            telemetryClientMock.AssertWasCalled(client => client.Send(TelemetryClient.DiagnosticMessage));
            Assert.IsNotEmpty(controls.DiagnosticInfo);
        }

        [Test]
        public void CheckTransmission_should_throw_exception_if_could_not_stablish_conexion_after_3_attempts() {
			ITelemetryClient telemetryClientMock = MockRepository.GenerateMock<ITelemetryClient>();
            TelemetryDiagnosticControls controls = new TelemetryDiagnosticControls(telemetryClientMock);
            telemetryClientMock.Stub(client => client.OnlineStatus).Return(false);

            Assert.Throws<Exception>(() => controls.CheckTransmission());

            telemetryClientMock.AssertWasCalled(client => client.Connect("*111#")
                                                , options => options.Repeat.Times(3));
            telemetryClientMock.AssertWasNotCalled(client => client.Send(Arg<String>.Is.Anything));
        }
    }
}
