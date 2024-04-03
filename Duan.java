package laptrinhjava;
import java.util.Scanner;



import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
class DoAn {
   
	 private int maDoAn;
	 private String tenDoAn;
	 private double giaBan;
	    
    public DoAn(int maDoAn, String tenDoAn, double giaBan) {
    
        this.maDoAn = maDoAn;
        this.tenDoAn = tenDoAn;
        this.giaBan = giaBan;
    }

    public int getMaDoAn() {
        return maDoAn;
    }

    public void setMaDoAn(int maDoAn) {
        this.maDoAn = maDoAn;
    }

    public String getTenDoAn() {
        return tenDoAn;
    }

    public void setTenDoAn(String tenDoAn) {
        this.tenDoAn = tenDoAn;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return "Mã đồ ăn: " + maDoAn + ", Tên đồ ăn: " + tenDoAn + ", Giá bán: " + giaBan;
    }
}

class QuanLyBanDoAn {
    private ArrayList<DoAn> danhSachDoAn;

    public QuanLyBanDoAn() {
        danhSachDoAn = new ArrayList<>();
    }

    public void themDoAn() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã đồ ăn: ");
        int maDoAn = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập tên đồ ăn: ");
        String tenDoAn = scanner.nextLine();

        System.out.print("Nhập giá bán: ");
        double giaBan = scanner.nextDouble();

        DoAn doAn = new DoAn(maDoAn, tenDoAn, giaBan);
        danhSachDoAn.add(doAn);

        System.out.println("Thêm đồ ăn thành công!");
    }

    public void hienThiDanhSachDoAn() {
        if (danhSachDoAn.isEmpty()) {
            System.out.println("Danh sách đồ ăn rỗng.");
            return;
        }

        System.out.println("Danh sách đồ ăn:");
        for (DoAn doAn : danhSachDoAn) {
            System.out.println(doAn);
        }
    }

    public void timKiemDoAn() {
        if (danhSachDoAn.isEmpty()) {
            System.out.println("Danh sách đồ ăn rỗng.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã đồ ăn cần tìm: ");
        int maDoAn = scanner.nextInt();

        boolean timThay = false;

        for (DoAn doAn : danhSachDoAn) {
            if (doAn.getMaDoAn() == maDoAn) {
                System.out.println("Tìm thấy đồ ăn:");
                System.out.println(doAn);
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Không tìm thấy đồ ăn với mã đồ ăn đã nhập.");
        }
    }



    public void suaDoAn() {
        if (danhSachDoAn.isEmpty()) {
            System.out.println("Danh sách đồ ăn rỗng.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã đồ ăn cần sửa: ");
        int maDoAn = scanner.nextInt();

        boolean suaThanhCong = false;

        for (DoAn doAn : danhSachDoAn) {
            if (doAn.getMaDoAn() == maDoAn) {
                System.out.print("Nhập tên đồ ăn mới: ");
                scanner.nextLine();
                String tenDoAn = scanner.nextLine();

                System.out.print("Nhập giá bán mới: ");
                double giaBan = scanner.nextDouble();

                doAn.setTenDoAn(tenDoAn);
                doAn.setGiaBan(giaBan);

                suaThanhCong = true;
                System.out.println("Sửa đồ ăn thành công!");
                break;
            }
        }

        if (!suaThanhCong) {
            System.out.println("Không tìm thấy đồ ăn với mã đồ ăn đã nhập.");
        }
    }

public void xoaDoAn() {
    if (danhSachDoAn.isEmpty()) {
        System.out.println("Danh sách đồ ăn rỗng.");
        return;
    }

    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập mã đồ ăn cần xoá: ");
    int maDoAn = scanner.nextInt();

    boolean xoaThanhCong = false;

    for (DoAn doAn : danhSachDoAn) {
        if (doAn.getMaDoAn() == maDoAn) {
            danhSachDoAn.remove(doAn);
            xoaThanhCong = true;
            System.out.println("Xoá đồ ăn thành công!");
            break;
        }
    }

    if (!xoaThanhCong) {
        System.out.println("Không tìm thấy đồ ăn với mã đồ ăn đã nhập.");
    }
}

	 
	 
 
public void xuatDanhSachDoAnRaFile(String tenFile) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(tenFile))) {
        if (danhSachDoAn.isEmpty()) {
            writer.write("Danh sách đồ ăn rỗng.");
            return;
        }

        for (DoAn doAn : danhSachDoAn) {
            writer.write(doAn.getMaDoAn() + "," + doAn.getTenDoAn() + "," + doAn.getGiaBan() + "\n");
        }

        System.out.println("Xuất danh sách đồ ăn ra file thành công!");
    } catch (IOException e) {
        System.out.println("Lỗi khi xuất danh sách đồ ăn ra file: " + e.getMessage());
    }

}
}
        
public class Duan {
    public static void main(String[] args) {
        QuanLyBanDoAn quanLyBanDoAn = new QuanLyBanDoAn();
        Scanner scanner = new Scanner(System.in);
       
        int choice;
      
        do {
            System.out.println("=== Quản lý bán đồ ăn ===");
            System.out.println("1. Thêm đồ ăn");
            System.out.println("2. Hiển thị danh sách đồ ăn");
            System.out.println("3. Tìm kiếm đồ ăn");
            System.out.println("4. Sửa đồ ăn");
            System.out.println("5. Xóa đồ ăn");
            System.out.println("6. Xuất danh sách đồ ăn ra file");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                case 1:
                    quanLyBanDoAn.themDoAn();
                    break;
                case 2:
                    quanLyBanDoAn.hienThiDanhSachDoAn();
                    break;
                case 3:
                    quanLyBanDoAn.timKiemDoAn();
                    break;
                case 4:
                    quanLyBanDoAn.suaDoAn();
                    break;
                case 5:
                    quanLyBanDoAn.xoaDoAn();
                    break;
                case 6:
                    System.out.print("Đã xuất file thành công ");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
        } while (choice != 0);
    }
}