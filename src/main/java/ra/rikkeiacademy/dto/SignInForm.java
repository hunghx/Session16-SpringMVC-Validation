package ra.rikkeiacademy.dto;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignInForm {
    // @Empty - không để trống (null và "")
    // @NotNull - Không được null
    // @NotBlank - không được rỗng ("")
    // @Min, @Max (các kiểu dạng số giới hạn gtNN và GTLN)
    // @Size (các kiểu dạng chuỗi cho phép định nghĩa độ dài chuỗi)
    // @Pattern (chuỗi theo định dạng biểu thức chính qui)

    @NotBlank(message = "không được để trống!")
    private String username;
    @NotBlank(message = "không được để trống!")
    @Size(min = 6,message = "Dộ dài tối thiểu 6 kí tự")
    private String password;
    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SignInForm() {
    }

    public SignInForm(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
