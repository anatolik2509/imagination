package ru.itis.antonov.imagination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.antonov.imagination.models.User;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String email;
    private String nickname;
    private User.Role role;
    private User.State state;
    private LocalDate birthDate;

    private boolean isSubscribed;
    private boolean isViewerAdmin;
    private boolean isViewerOwner;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .role(user.getRole())
                .state(user.getState())
                .birthDate(user.getBirthDate())
                .isSubscribed(false)
                .isViewerAdmin(false)
                .isViewerOwner(true)
                .build();
    }

    public static List<UserDto> from(List<User> users){
        return users.stream().map(UserDto::from).collect(Collectors.toList());
    }
}
