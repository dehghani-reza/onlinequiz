package ir.maktab.onlinequiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@AllArgsConstructor
public class NewUsersIdsListDTO {
    private String secret;
    private List<String> listId;
}
