package mvcDatabaseContactList;

import jdk.nashorn.internal.scripts.JO;

import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.*;

public class Controller implements ActionListener {
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        if (model.getBanyakData() != 0) {
            String dataContact[][] = model.readContact();
            view.tabel.setModel((new JTable(dataContact, view.namaKolom)).getModel());
            updateDataCombo(model.readNama());
        } else {
            JOptionPane.showMessageDialog(null, "There are no data");
        }

        view.btnInsertPanel.addActionListener(this);
        view.btnCancel1Panel.addActionListener(this);
        view.btnUpdatePanel.addActionListener(this);
        view.btnCancel2Panel.addActionListener(this);

        view.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = view.tabel.getSelectedRow();
                int kolom = view.tabel.getSelectedColumn();

                String dataterpilih = view.tabel.getValueAt(baris,0).toString();

                System.out.println(dataterpilih);

                int input = JOptionPane.showConfirmDialog(null, "Do yo want to delete " + dataterpilih + "?", "Pilih Opsi...", JOptionPane.YES_NO_OPTION);

                if (input == 0) {
                    model.deleteContact(dataterpilih);
                    String dataContact[][] = model.readContact();
                    view.tabel.setModel(new JTable(dataContact, view.namaKolom).getModel());
                    updateDataCombo(model.readNama());
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak Jadi Dihapus");
                }
            }
        }
        );
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.btnInsertPanel) {
            String nama = view.getNama();
            String noHP = view.getNoHP();
            String umur = view.getUmur();
            String email = view.getEmail();

            if (nama.equals("")) {
                JOptionPane.showMessageDialog(null, "Nama Cannot Be Empty");
            } else if (nama.length() > 50) {
                JOptionPane.showMessageDialog(null, "Max. Characters of Nama: 50");
            } else {
                model.insertContact(nama, noHP, umur, email);
                String newData[][] = model.readContact();
                view.tabel.setModel(new JTable(newData, view.namaKolom).getModel());
                updateDataCombo(model.readNama());
            }
        } else if (e.getSource() == view.btnCancel1Panel) {
            view.tfnama.setText("");
            view.tfnohp.setText("");
            view.tfumur.setText("");
            view.tfemail.setText("");
        } else if (e.getSource() == view.btnUpdatePanel) {
            String nama = view.getNamaCombo();
            String noHP = view.getNoHPUpdate();
            String umur = view.getUmurUpdate();
            String email = view.getEmailUpdate();

            if (noHP.equals("") || umur.equals("") || email.equals("")){
                JOptionPane.showMessageDialog(null, "Form Cannot Be Empty");
            } else {
                model.updateContact(nama, noHP, umur, email);
                String newData[][] = model.readContact();
                view.tabel.setModel(new JTable(newData, view.namaKolom).getModel());
                updateDataCombo(model.readNama());
            }
        } else if (e.getSource() == view.btnCancel2Panel) {
            view.tfnamaUpdate.setText("");
            view.tfnohpUpdate.setText("");
            view.tfumurUpdate.setText("");
            view.tfemailUpdate.setText("");
        }
    }

    public void updateDataCombo(ArrayList<String> data){
        view.daftarNama.removeAllItems();
        for (String item : data) {
            view.daftarNama.addItem(item);
        }
    }
}
