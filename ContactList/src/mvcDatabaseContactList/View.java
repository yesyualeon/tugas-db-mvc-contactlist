package mvcDatabaseContactList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import   java.awt.*;

public class View extends JFrame {
    JLabel title;

    JLabel lNama = new JLabel("Nama :");
    JTextField tfnama = new JTextField("");
    JLabel lNoHP = new JLabel("No. HP :");
    JTextField tfnohp = new JTextField("");
    JLabel lUmur = new JLabel("Umur :");
    JTextField tfumur = new JTextField("");
    JLabel lEmail = new JLabel("E-mail :");
    JTextField tfemail = new JTextField("");

    JLabel lNamaUpdate = new JLabel("Nama :");
    JTextField tfnamaUpdate = new JTextField();
    JLabel lNoHPUpdate = new JLabel("No. HP :");
    JTextField tfnohpUpdate = new JTextField();
    JLabel lUmurUpdate = new JLabel("Umur :");
    JTextField tfumurUpdate = new JTextField();
    JLabel lEmailUpdate = new JLabel("E-mail :");
    JTextField tfemailUpdate = new JTextField();

    JComboBox daftarNama = new JComboBox();

    JButton btnInsertPanel = new JButton("Insert");
    JButton btnCancel1Panel = new JButton("Cancel");
    JButton btnUpdatePanel = new JButton("Update");
    JButton btnCancel2Panel = new JButton("Cancel");

    JTable tabel;

    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"Nama","No.HP","Umur","E-mail"};

    Color background = new Color(255, 214, 231);
    Color button1 = new Color(255,89,131);
    Color button2 = new Color(171,245,182);
    Color box = new Color(192,252,244);
    Color box2 = new Color(228,193,249);
    Color tbl  = new Color(237,231,177);

    public  View() {
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);

        getContentPane().setBackground(background);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(600, 450);
        tabel.setBackground(tbl);

        title = new JLabel("CONTACTS");
        add(title);
        title.setBounds(250, 5, 100, 20);

        title = new JLabel("Insert Contact");
        add(title);
        title.setBounds(100, 35, 100, 20);

        title = new JLabel("Update Contact");
        add(title);
        title.setBounds(100, 200, 100, 20);

        title = new JLabel("Contact List");
        add(title);
        title.setBounds(380, 55, 100, 20);

        add(scrollPane);
        scrollPane.setBounds(250,80,320,250);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        add(lNama);
        lNama.setBounds(20,65,90,20);
        add(tfnama);
        tfnama.setBounds(110, 65, 120,20);
        tfnama.setBackground(box);
        add(lNoHP);
        lNoHP.setBounds(20, 90, 90, 20);
        add(tfnohp);
        tfnohp.setBounds(110, 90, 120, 20);
        tfnohp.setBackground(box);
        add(lUmur);
        lUmur.setBounds(20, 115, 90, 20);
        add(tfumur);
        tfumur.setBounds(110, 115, 120, 20);
        tfumur.setBackground(box);
        add(lEmail);
        lEmail.setBounds(20, 140, 90, 20);
        add(tfemail);
        tfemail.setBounds(110, 140, 120, 20);
        tfemail.setBackground(box);

        add(btnInsertPanel);
        btnInsertPanel.setBounds(20, 165, 90, 20);
        btnInsertPanel.setBackground(button2);
        add(btnCancel1Panel);
        btnCancel1Panel.setBounds(135, 165, 90, 20);
        btnCancel1Panel.setBackground(button1);


        add(lNamaUpdate);
        lNamaUpdate.setBounds(20,225,90,20);
        add(daftarNama);
        daftarNama.setBounds(110, 225, 120, 20);
        daftarNama.setBackground(box2);
        add(lNoHPUpdate);
        lNoHPUpdate.setBounds(20, 250, 90, 20);
        add(tfnohpUpdate);
        tfnohpUpdate.setBounds(110, 250, 120, 20);
        tfnohpUpdate.setBackground(box2);
        add(lUmurUpdate);
        lUmurUpdate.setBounds(20, 275, 90, 20);
        add(tfumurUpdate);
        tfumurUpdate.setBounds(110, 275, 120, 20);
        tfumurUpdate.setBackground(box2);
        add(lEmailUpdate);
        lEmailUpdate.setBounds(20, 300, 90, 20);
        add(tfemailUpdate);
        tfemailUpdate.setBounds(110, 300, 120, 20);
        tfemailUpdate.setBackground(box2);

        add(btnUpdatePanel);
        btnUpdatePanel.setBounds(20, 325, 90, 20);
        btnUpdatePanel.setBackground(button2);
        add(btnCancel2Panel);
        btnCancel2Panel.setBounds(135, 325, 90, 20);
        btnCancel2Panel.setBackground(button1);
    }

    public String getNama() {
        return tfnama.getText();
    }

    public String getNoHP() {
        return tfnohp.getText();
    }

    public String getUmur() {
        return tfumur.getText();
    }

    public String getEmail() {
        return tfemail.getText();
    }

    public String getNamaCombo(){
        return daftarNama.getSelectedItem().toString();
    }

    public String getNoHPUpdate(){
        return tfnohpUpdate.getText();
    }

    public String getUmurUpdate(){
        return tfumurUpdate.getText();
    }

    public String getEmailUpdate(){
        return tfemailUpdate.getText();
    }

}
