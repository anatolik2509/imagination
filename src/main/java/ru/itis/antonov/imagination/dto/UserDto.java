package ru.itis.antonov.imagination.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.antonov.imagination.models.User;

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

    private boolean isSubscribed;

    public static UserDto from(User user){
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .nickname(user.getNickname())
                .role(user.getRole())
                .state(user.getState())
                .build();
    }
}
