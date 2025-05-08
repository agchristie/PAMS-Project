
import org.junit.Test;
import static org.junit.Assert.*;

public class AppointmentBSTTest {
    @Test
    public void testAddAppointment() {
        AppointmentBST bst = new AppointmentBST();
        PatientAppointment p1 = new PatientAppointment(1, "Test Patient", "09:00");
        bst.addAppointment(p1);
        assertNotNull(bst.getRoot());
    }

    @Test
    public void testInOrder() {
        AppointmentBST bst = new AppointmentBST();

        PatientAppointment app1 = new PatientAppointment(1, "Patient 1", "09:00");
        PatientAppointment app2 = new PatientAppointment(2, "Patient 2", "12:00");
        PatientAppointment app3 = new PatientAppointment(3, "Patient 3", "07:30");

        bst.addAppointment(app1);
        bst.addAppointment(app2);
        bst.addAppointment(app3);

        AppointmentNode root = bst.getRoot();

        assertNotNull(root);
        assertNotNull(root.left);
        assertNotNull(root.right);

        assertEquals("Patient 1", root.data.patientName);
        assertEquals("09:00", root.data.appointmentTime);

        assertEquals("Patient 3", root.left.data.patientName);
        assertEquals("07:30", root.left.data.appointmentTime);

        assertEquals("Patient 2", root.right.data.patientName);
        assertEquals("12:00", root.right.data.appointmentTime);

    }

    @Test
    public void testDuplicate() {
        AppointmentBST bst = new AppointmentBST();

        PatientAppointment app1 = new PatientAppointment(1, "Patient", "09:00");
        PatientAppointment app2 = new PatientAppointment(2, "Duplicate", "09:00");

        bst.addAppointment(app1);
        bst.addAppointment(app2);

        //duplicate should not insert
        AppointmentNode root = bst.getRoot();
        assertEquals("Patient", root.data.patientName);
        assertNull(root.left);
        assertNull(root.right);
    }
}
