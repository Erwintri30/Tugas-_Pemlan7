package tgs_pemlan7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;

public class Registration extends JFrame {
    private JTextField nama, tanggalLahir, noReg, noTlpn, alamat, email;
    private JButton submit;

    public Registration() {
        setTitle("Form Registrasi Mahasiswa Baru");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(245, 245, 245));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        nama = new JTextField(20);
        tanggalLahir = new JTextField(20);
        noReg = new JTextField(20);
        noTlpn = new JTextField(20);
        alamat = new JTextField(20);
        email = new JTextField(20);
        submit = new JButton("Submit");

        addToPanel(panel, createLabel("Nama Lengkap"), 0, 0, gbc);
        addToPanel(panel, nama, 1, 0, gbc);

        addToPanel(panel, createLabel("Tanggal Lahir"), 0, 1, gbc);
        addToPanel(panel, tanggalLahir, 1, 1, gbc);

        addToPanel(panel, createLabel("No. Registrasi"), 0, 2, gbc);
        addToPanel(panel, noReg, 1, 2, gbc);

        addToPanel(panel, createLabel("No. Telp"), 0, 3, gbc);
        addToPanel(panel, noTlpn, 1, 3, gbc);

        addToPanel(panel, createLabel("Alamat"), 0, 4, gbc);
        addToPanel(panel, alamat, 1, 4, gbc);

        addToPanel(panel, createLabel("E-mail"), 0, 5, gbc);
        addToPanel(panel, email, 1, 5, gbc);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(submit, gbc);

        submit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });

        add(panel);
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        return label;
    }

    private void addToPanel(JPanel panel, Component comp, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        panel.add(comp, gbc);
    }

    private void handleSubmit() {
        JTextComponent[] fields = { nama, tanggalLahir, noReg, noTlpn, alamat, email };

        for (JTextComponent field : fields) {
            if (field.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        int response = JOptionPane.showConfirmDialog(this, "Apakah anda yakin data yang Anda isi sudah benar?",
                "Konfirmasi", JOptionPane.OK_CANCEL_OPTION);

        if (response == JOptionPane.OK_OPTION) {
            Overlay overlay = new Overlay(nama.getText(), tanggalLahir.getText(), noReg.getText(), noTlpn.getText(),
                    alamat.getText(), email.getText());
            overlay.setSize(400, 300);
            overlay.setVisible(true);
        }
    }

    class Overlay extends JFrame {
        public Overlay(String nama, String tanggalLahir, String noReg, String noTlpn, String address, String email) {
            setTitle("Data Mahasiswa");
            setSize(400, 300);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            getContentPane().setBackground(new Color(240, 248, 255));

            JLabel titleLabel = new JLabel("Data Mahasiswa", SwingConstants.CENTER);
            titleLabel.setOpaque(true);
            titleLabel.setBackground(new Color(30, 144, 255));
            titleLabel.setForeground(Color.WHITE);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
            titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            add(titleLabel, BorderLayout.NORTH);

            JTextArea textArea = new JTextArea();
            textArea.setText(
                    "Nama\t\t: " + nama + "\n" +
                            "Tanggal Lahir\t\t: " + tanggalLahir + "\n" +
                            "Nomor Pendaftaran\t: " + noReg + "\n" +
                            "No. Telp\t\t: " + noTlpn + "\n" +
                            "Alamat\t\t: " + address + "\n" +
                            "E-mail\t\t: " + email);
            textArea.setFont(new Font("Arial", Font.PLAIN, 14));
            textArea.setBackground(new Color(224, 255, 255));
            textArea.setForeground(new Color(25, 25, 112));
            textArea.setBorder(new LineBorder(new Color(100, 149, 237), 2));
            textArea.setEditable(false);
            textArea.setMargin(new Insets(10, 10, 10, 10));

            JScrollPane scrollPane = new JScrollPane(textArea);
            add(scrollPane, BorderLayout.CENTER);
        }
    }
}
