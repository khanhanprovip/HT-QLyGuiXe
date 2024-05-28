/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.DTO;

/**
 *
 * @author Admin
 */
public class userDTO {
    private String vaiTro;
    
    private String taiKhoan;
    private String matKhau;
    private String tenNV;

    public userDTO() {
    }

    public userDTO(String vaiTro,  String taiKhoan, String matKhau, String tenNV) {
        this.vaiTro= vaiTro;
        
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.tenNV = tenNV;
    }

    public String getvaiTro() {
        return vaiTro;
    }

    public void setvaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    

    

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }
    
}
