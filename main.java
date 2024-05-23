package tgs_pemlan7;

import javax.swing.SwingUtilities;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                Registration DataMahasiswa = new Registration();
                DataMahasiswa.setVisible(true);
            }
        });
    }
}
