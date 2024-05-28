/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baiguixe.Service;

import baiguixe.DAO.baixeDAO;
import baiguixe.DAO.hoadonDAO;
import baiguixe.DAO.phuongtienDAO;
import baiguixe.DAO.userDAO;
import baiguixe.DAO.veNgayDAO;
import baiguixe.DAO.veThangDAO;
import baiguixe.DAO.viphamDAO;
import baiguixe.DTO.hoadonDTO;
import baiguixe.DTO.khachhangDTO;
import baiguixe.DTO.phuongtienDTO;
import baiguixe.DTO.veDTO;
import baiguixe.DTO.veNgayDTO;
import baiguixe.DTO.veThangDTO;
import baiguixe.DTO.viphamDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SystemService {
    private baixeDAO bx;
    private phuongtienDAO pt;
    private veNgayDAO vn;
    private veThangDAO vt;
    private userDAO us;
    private hoadonDAO hd;
    private viphamDAO vph;
    public SystemService() {
        bx=new baixeDAO();
        pt=new phuongtienDAO();
        vn=new veNgayDAO();
        vt=new veThangDAO();
        us=new userDAO();
        hd=new hoadonDAO();
        vph=new viphamDAO();
    }
    
    public ArrayList<phuongtienDTO> hienthiXe(){
       return bx.hienthiXe();
    }
    public void nhapXe(veDTO veInfo,phuongtienDTO vehInfo ){
       pt.nhapXe(veInfo, vehInfo);
    }
    public void xoaXe(String masoVe){
        pt.xoaXe(masoVe);
    }
    public ArrayList<veNgayDTO> xuatVe(){
       return vn.xuatVe();
    }
    public phuongtienDTO timkiemBienSo(String biensoXe){
       return bx.timkiemBienSo(biensoXe);
    }
    public phuongtienDTO timkiemMaVe(String maVe){
       return bx.timkiemMaVe(maVe);
    }
    //public int KtVe(String masoVe,String biensoXe,String loaiXe){
      // return bx.KtVe(masoVe, biensoXe, loaiXe);
    //}
    public ArrayList<veDTO> xuatVeTrongBai(){
       return bx.xuatVeTrongBai();
    }
    public ArrayList<phuongtienDTO> xuatXeTrongBai(){
        return bx.xuatXeTrongBai();
    }
    public void DKVeThang(veThangDTO veInfo,phuongtienDTO vehInfo,khachhangDTO khInfo ){
        vt.DKVeThang(veInfo, vehInfo, khInfo);
    }
    public ArrayList<veThangDTO> thongkeVeThang(String tungay,String denngay){
        return vt.thongkeVeThang(tungay,denngay);
    }
    public int TongThuVeThang(String tungay,String denngay){
         return vt.TongThuVeThang(tungay, denngay);
    }
    public String DangNhap(String tk,String mk){
         return us.DangNhap(tk, mk);
    }
    public int KtTK(String taiKhoan,String matKhau){
         return us.KtTK(taiKhoan, matKhau);
    }
    public int LuongVeThang(String tungay,String denngay){
         return vt.LuongVeThang(tungay, denngay);
    }
    public ArrayList<veThangDTO> xuatVeThang(){
         return vt.xuatVeThang();
    }
    public void layVeThang(String masoVe){
         vt.layVeThang(masoVe);
    }
    public void layVe(String masoVe){
        vn.layVe(masoVe);
    }
    public void traVe(String masoVe){
        vn.traVe(masoVe);
    }
    public void traVeThang(String masoVe){
        vt.traVeThang(masoVe);
     }
    public void nhapHoaDon(veDTO veInfo,phuongtienDTO vehInfo,hoadonDTO hoadonInfo ){
        hd.nhapHoaDon(veInfo, vehInfo, hoadonInfo);
    }
    public int thongkeLuotGui(String tungay,String denngay){
        return hd.thongkeLuotGui(tungay, denngay);
    }
    public int thongkePhanLoai(String tungay,String denngay,String loai){
        return hd.thongkePhanLoai(tungay, denngay, loai);
    }
    public int TongThu(String tungay,String denngay){
        return hd.TongThu(tungay, denngay);
    }
    public int TongThuPhanLoai(String tungay,String denngay,String loai){
        return hd.TongThuPhanLoai(tungay, denngay, loai);
    }
    public ArrayList<hoadonDTO> hienthihoadon(String tungay,String denngay){
        return hd.hienthihoadon(tungay, denngay);
    }
    public ArrayList<hoadonDTO> hienthiphanloai(String tungay,String denngay,String loai){
        return hd.hienthiphanloai(tungay, denngay, loai);
    }
    public veThangDTO thongtinVeThang(String masoVe){
        return vt.thongtinVeThang(masoVe);
    }
    public void GiaHanVeThang(String hethan,String masoVe){
        vt.GiaHanVeThang(hethan,masoVe);
    }
    public void ViPhamMatVe(viphamDTO vp,veDTO veInfo,phuongtienDTO vehInfo,khachhangDTO khInfo ){
         vph.ViPhamMatVe(vp, veInfo, vehInfo, khInfo);
    }
     public int TongTienPhat(String tungay,String denngay){
          return vph.TongTienPhat(tungay, denngay);
     }
      public int TongLuotPhat(String tungay,String denngay){
          return vph.TongLuotPhat(tungay, denngay);
      }
     public ArrayList<viphamDTO> thongkeVeMat(String tungay,String denngay){
          return vph.thongkeVeMat(tungay, denngay);
     }
      public void ViPhamViTri(viphamDTO vp,phuongtienDTO vehInfo){
          vph.ViPhamViTri(vp, vehInfo);
      }
       public ArrayList<viphamDTO> thongkeData(){
          return vph.thongkeData();
       }
      public void LuuVeThang(veThangDTO veInfo,phuongtienDTO vehInfo){
          vt.LuuVeThang(veInfo, vehInfo);
      }
    public int KtVeThang(String masoVe,String biensoXe){
          return vt.KtVeThang(masoVe, biensoXe);
    }
     public void xoaVeNgay(String masoVe){ 
           vn.xoaVeNgay(masoVe);
     }
     public void xoaVeThang(String masoVe){ 
           vt.xoaVeThang(masoVe);
     }
     public int thongkePhanLoai(String loaiXe){
            return bx.thongkePhanLoai(loaiXe);
     }
     public int KtViPham(String bienso){
            return vph.KtViPham(bienso);
     }
     public viphamDTO minhchung(String bienso){
             return vph.minhchung(bienso);
     }
     public int KtXe(String loaiXe,String bienso){
            return bx.KtXe(loaiXe, bienso);
     }
     public void xoaHinhAnh(String bienso){
           vph.xoaHinhAnh(bienso);
     }
     public ArrayList<phuongtienDTO> xuatds(){
           return vph.xuatds();
     }
     public int KtVe(String masoVe){
           return vn.KtVe(masoVe);
     }
    
   
}
