package com.kgutic.api.stepdefinitions;

import com.kgutic.api.config.TestUtils;
import com.kgutic.api.datatables.Order;
import com.kgutic.api.order.OrderService;
import com.kgutic.api.world.PetWorld;
import com.kgutic.pss.generated.model.OrderDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Shared;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.then;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderSteps {
    private OrderDTO orderDTO;
    @Shared
    private PetWorld petWorld;
    @Shared
    private OrderService orderService;


    @When("the request is sent to place a new order for this pet with")
    public void theRequestIsSentToPlaceANewOrderForThisPetWith(List<Map<String, String>> orderTable) {
        orderService.createOrder(createNewOrderDtoFromDataTable(orderTable));
        orderDTO = then().extract().body().as(OrderDTO.class);
    }

    @And("the returned details in the response are")
    public void theReturnedDetailsInTheResponseAre(List<Order> orderData) {
        Order expectedOrder = orderData.get(0);

        assertThat(orderDTO.getId()).isEqualTo(petWorld.getOrderId());
        assertThat(orderDTO.getPetId()).isEqualTo(petWorld.getPetId());
        assertThat(orderDTO.getQuantity()).isEqualTo(expectedOrder.getQuantity());
        assertThat(orderDTO.getShipDate()).isEqualTo(expectedOrder.getShipDate());
        assertThat(orderDTO.getStatus()).isEqualByComparingTo(OrderDTO.StatusEnum.fromValue(expectedOrder.getStatus()));
        assertThat(orderDTO.getComplete()).isEqualTo(expectedOrder.isComplete());
    }

    private OrderDTO createNewOrderDtoFromDataTable(List<Map<String, String>> orderTable) {
        petWorld.setOrderId(TestUtils.getRandomOrderId());
        return new OrderDTO()
                .id(petWorld.getOrderId())
                .petId(petWorld.getPetId())
                .quantity(Integer.valueOf(orderTable.get(0).get("quantity")))
                .shipDate(OffsetDateTime.parse(orderTable.get(0).get("shipDate")))
                .status(OrderDTO.StatusEnum.fromValue(orderTable.get(0).get("status")))
                .complete(Boolean.valueOf(orderTable.get(0).get("complete")));
    }

}
