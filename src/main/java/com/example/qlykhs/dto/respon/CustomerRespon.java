package com.example.qlykhs.dto.respon;

import com.example.qlykhs.entity.Role;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRespon {

    private String customerName;
    private String profession;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private boolean gender;
    private int phoneNumber;
    private int idCard;
    @Size(min = 3, message = "Ten it nhat 3 ky tu !")
    private String user;
    @Size(min = 8, message = "Mật khẩu có ít nhất 8 ký tự")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]+$",
            message = "Mật khẩu phải chứa ít nhất 1 chữ cái viết hoa,1 ký tự đặc biệt và 1 số")
    private String password;

    private List<Role> roles;
}
