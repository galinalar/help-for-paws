package paws.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Token {
    private String token;
    private String refreshToken;
}
