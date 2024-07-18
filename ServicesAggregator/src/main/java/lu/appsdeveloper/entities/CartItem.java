package lu.appsdeveloper.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {
    private String menu;
    private int quantity;
    private String restaurantid;
    private Double price;
    private String restaurantAddress;
    private LocalDateTime orderTime;
}
