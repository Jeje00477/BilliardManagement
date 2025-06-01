/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jeje
 */

public class Karyawan {
    private int idKaryawan;
    private String nama;
    private String jabatan;
    private String noTelepon;
    private java.sql.Date tanggalMasuk;
    private int idTransaksi;

    // Constructor
    public Karyawan() {}

    public Karyawan(int idKaryawan, String nama, String jabatan, String noTelepon, java.sql.Date tanggalMasuk, int idTransaksi) {
        this.idKaryawan = idKaryawan;
        this.nama = nama;
        this.jabatan = jabatan;
        this.noTelepon = noTelepon;
        this.tanggalMasuk = tanggalMasuk;
        this.idTransaksi = idTransaksi;
    }

    // Getter & Setter
    public int getIdKaryawan() { return idKaryawan; }
    public void setIdKaryawan(int idKaryawan) { this.idKaryawan = idKaryawan; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getJabatan() { return jabatan; }
    public void setJabatan(String jabatan) { this.jabatan = jabatan; }

    public String getNoTelepon() { return noTelepon; }
    public void setNoTelepon(String noTelepon) { this.noTelepon = noTelepon; }

    public java.sql.Date getTanggalMasuk() { return tanggalMasuk; }
    public void setTanggalMasuk(java.sql.Date tanggalMasuk) { this.tanggalMasuk = tanggalMasuk; }

    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    
    
}


