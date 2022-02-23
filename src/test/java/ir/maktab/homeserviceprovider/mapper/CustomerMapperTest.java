package ir.maktab.homeserviceprovider.mapper;

import ir.maktab.homeserviceprovider.config.AppUnitTestConfig;
import ir.maktab.homeserviceprovider.domain.model.user.CustomerModel;
import ir.maktab.homeserviceprovider.domain.model.wallet.WalletModel;
import ir.maktab.homeserviceprovider.dto.user.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles(value = "test")
@SpringJUnitConfig(value = AppUnitTestConfig.class)//find beans in service layer
class CustomerMapperTest {

    @Autowired
    CustomerMapper mapper;

    @Test
    void mapToDto() {
        CustomerModel model = CustomerModel.customerBuilder()
                .email("example@gmail.com")
                .password("password1234")
                .build();

        CustomerDto resultDto = mapper.mapToDto(model);

        assertEquals(model.getEmail(), resultDto.getEmail());
        assertEquals(model.getPassword(), resultDto.getPassword());
    }

    @Test
    void mapToModel() {
        CustomerDto dto = CustomerDto.builder()
                .email("example@gmail.com")
                .password("password1234")
                .build();

        CustomerModel resultModel = this.mapper.mapToModel(dto);

        assertEquals(dto.getEmail(), resultModel.getEmail());
        assertEquals(dto.getPassword(), resultModel.getPassword());
    }

    @Test
    void updateDtoByModel() {
        CustomerDto dto = CustomerDto.builder()
                .email("example@gmail.com")
                .password("password1234")
                .build();

        CustomerModel model = CustomerModel.customerBuilder()
                .email("updated@gmail.com")
                .password("updatedPassword1234")
                .build();


        this.mapper.updateDtoByModel(dto, model);

        assertEquals(model.getEmail(), dto.getEmail());
        assertEquals(model.getPassword(), dto.getPassword());
    }

    @Test
    void updateModelByDto() {
        CustomerModel model = CustomerModel.customerBuilder()
                .email("example@gmail.com")
                .password("password1234")
                .build();

        CustomerDto dto = CustomerDto.builder()
                .email("updated@gmail.com")
                .password("updatedPassword1234")
                .build();

        this.mapper.updateModelByDto(model, dto);

        assertEquals(dto.getEmail(), model.getEmail());
        assertEquals(dto.getPassword(), model.getPassword());
    }
}