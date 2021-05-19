package ru.itis.antonov.imagination.dto.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import ru.itis.antonov.imagination.validation.EqualPasswords;
import ru.itis.antonov.imagination.validation.HasLetters;
import ru.itis.antonov.imagination.validation.HasNumber;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualPasswords(password = "password", passwordRepeat = "passwordRepeat", message = "{signUp.valid.passwordEqualsError}")
public class SignUpForm {
    @Email(message = "{signUp.valid.emailError}")
    private String email;
    private String nickname;
    @Length(min = 8, message = "{signUp.valid.shortPassword}")
    @HasLetters(message = "{signUp.valid.hasLetterError}")
    @HasNumber(message = "{signUp.valid.hasNumberError}")
    private String password;
    private String passwordRepeat;
}
