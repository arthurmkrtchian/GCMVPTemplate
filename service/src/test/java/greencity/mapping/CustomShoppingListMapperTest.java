package greencity.mapping;

import greencity.dto.shoppinglistitem.CustomShoppingListItemResponseDto;
import greencity.entity.CustomShoppingListItem;
import greencity.enums.ShoppingListItemStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomShoppingListMapperTest {

    CustomShoppingListMapper customShoppingListMapper;
    @BeforeEach
    void setUp() {
        customShoppingListMapper = new CustomShoppingListMapper();
    }

    @Test
    @DisplayName("CustomShoppingListMapper test")
    public void testConvert() {
        CustomShoppingListItemResponseDto customShoppingListItemResponseDto = new CustomShoppingListItemResponseDto().setId(1L).setText("Text").setStatus(ShoppingListItemStatus.ACTIVE);

        CustomShoppingListItem customShoppingListItem = customShoppingListMapper.convert(customShoppingListItemResponseDto);

        assertEquals(1L, customShoppingListItem.getId());
        assertEquals("Text", customShoppingListItem.getText());
        assertEquals(ShoppingListItemStatus.ACTIVE, customShoppingListItem.getStatus());
    }
}