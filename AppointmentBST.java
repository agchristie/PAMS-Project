public class AppointmentBST {
    private AppointmentNode root;

    public AppointmentBST() {
        root = null;
    }

    public void addAppointment(PatientAppointment appointment) {
        root = insertRec(root, appointment);
    }

    private AppointmentNode insertRec(AppointmentNode root, PatientAppointment appointment) {
        // TODO: Implement logic to insert by appointment time (avoid duplicates)

        //base
        if(root == null) {
            return new AppointmentNode(appointment);
        }

        //get comparison value
        int compare = appointment.appointmentTime.compareTo(root.data.appointmentTime);

        //left is for before, right is for after, gives error message for duplicates
        if(compare < 0) {
            root.left = insertRec(root.left, appointment);
        }
        else if(compare > 0) {
            root.right = insertRec(root.right, appointment);
        }
        else {
            System.out.println();
            System.out.println("An appointment already exists at " + appointment.appointmentTime + ".");
        }

        return root;
    }

    public void inOrderTraversal(AppointmentNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.println(node.data);
            inOrderTraversal(node.right);
        }
    }

    public AppointmentNode getRoot() {
        return root;
    }
}
