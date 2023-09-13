package greencity.controller;

import greencity.enums.ShoppingListItemStatus;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import greencity.controller.ShoppingListItemController;
import greencity.dto.shoppinglistitem.ShoppingListItemRequestDto;
import greencity.dto.user.UserShoppingListItemResponseDto;
import greencity.dto.user.UserVO;
import greencity.service.ShoppingListItemService;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;

import java.util.Locale;
@RunWith(MockitoJUnitRunner.class)
public class ShoppingListItemControllerTest {
    @InjectMocks
    private ShoppingListItemController shoppingListItemController;

    @Mock
    private ShoppingListItemService shoppingListItemService;

    @Mock
    private UserVO user;

    private Locale locale;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        locale = Locale.US;
    }

    @Test
    public void saveUserShoppingListItemsTest() {
        List<ShoppingListItemRequestDto> requestDtoList = new ArrayList<>();
        Long userId = 1L;
        Long habitId = 2L;

        List<UserShoppingListItemResponseDto> someListOfUserShoppingListItemResponseDto = new ArrayList<>();

        UserShoppingListItemResponseDto item1 = new UserShoppingListItemResponseDto();
        item1.setId(1L);
        item1.setText("Item 1");
        item1.setStatus(ShoppingListItemStatus.ACTIVE);

        UserShoppingListItemResponseDto item2 = new UserShoppingListItemResponseDto();
        item2.setId(2L);
        item2.setText("Item 2");
        item2.setStatus(ShoppingListItemStatus.ACTIVE);

        someListOfUserShoppingListItemResponseDto.add(item1);
        someListOfUserShoppingListItemResponseDto.add(item2);

        when(shoppingListItemService.saveUserShoppingListItems(eq(userId), eq(habitId), anyList(), locale.getLanguage()))
                .thenReturn(someListOfUserShoppingListItemResponseDto);

        ResponseEntity<List<UserShoppingListItemResponseDto>> response =
                shoppingListItemController.saveUserShoppingListItems(requestDtoList, user, 1L, locale);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        // Add more assertions as needed
    }



    @Test
    public void getShoppingListItemsAssignedToUserTest() {
        // Mock the service method
//        when(shoppingListItemService.getUserShoppingList(anyLong(), anyLong(), anyString()))
//                .thenReturn(someListOfUserShoppingListItemResponseDto);

        // Perform the HTTP GET request and assert the response
//        ResponseEntity<List<UserShoppingListItemResponseDto>> response =
//                shoppingListItemController.getShoppingListItemsAssignedToUser(user, 1L, locale);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Add more assertions as needed
    }

//    @Test
//    public void deleteTest() throws Exception {
//        // Create test data
//        Long userId = 1L;
//        Long userShoppingListItemId = 2L;
//        Long habitId = 3L;
//
//        // Mock the service method to do nothing when delete is called
//        doNothing().when(shoppingListItemService)
//                .deleteUserShoppingListItemByItemIdAndUserIdAndHabitId(userShoppingListItemId, userId, habitId);
//
//        // Perform the HTTP DELETE request
//        mockMvc.perform(delete("/user/shopping-list-items")
//                        .param("userShoppingListItemId", userShoppingListItemId.toString())
//                        .param("habitId", habitId.toString())
//                        .principal(new UserPrincipal(userId))) // Simulate a user principal for authentication
//                .andExpect(status().isOk()); // Expect HTTP status code 200 (OK)
//    }

    @Test
    public void bulkDeleteUserShoppingListItemsTest() {
        // Arrange
        ShoppingListItemService shoppingListItemService = mock(ShoppingListItemService.class);
        ShoppingListItemController shoppingListItemController = new ShoppingListItemController(shoppingListItemService);

        String commaSeparatedIds = "1,2,3"; // Example comma-separated IDs
        List<Long> deletedIds = Arrays.asList(1L, 2L, 3L); // IDs that will be deleted
        UserVO user = new UserVO(); // Mock user object

        // Mock the service method to return the list of deleted IDs
        when(shoppingListItemService.deleteUserShoppingListItems(commaSeparatedIds)).thenReturn(deletedIds);

        // Act
        ResponseEntity<List<Long>> response = shoppingListItemController.bulkDeleteUserShoppingListItems(commaSeparatedIds, user);

        // Assert
        verify(shoppingListItemService).deleteUserShoppingListItems(commaSeparatedIds); // Verify that the service method was called
        assertEquals(HttpStatus.OK, response.getStatusCode()); // Verify the response status code
        assertEquals(deletedIds, response.getBody()); // Verify that the response body contains the deleted IDs
    }

}
