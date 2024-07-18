package lu.appsdeveloper.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    private Long userId;
    private List<CartItem> items = new ArrayList<>();
    private  boolean isActive;
}