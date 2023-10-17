package dev.timurcelikel.medium.modelmapper;

import dev.timurcelikel.medium.modelmapper.dto.CatDto;
import dev.timurcelikel.medium.modelmapper.entity.LegacyCatEntity;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ModelMapperTest {

	@Autowired
	SingleModelMapper singleModelMapper;

	@Autowired
	ListModelMapper listModelMapper;

	@Autowired
	ModelMapper modelMapper;

	@Test
	void modelMapperShouldMapEntityToDto() {

		LegacyCatEntity legacyCatEntity = LegacyCatEntity.builder()
				.id(12345L).f_name("Felix")
				.l_name("DaHouseCat")
				.orderNumber(55511L).build();

		CatDto catDto = singleModelMapper.mapLegacyCatEntityToCatDto(legacyCatEntity);
		
		assertThat(catDto).isNotNull();
		assertThat(catDto.getId()).isEqualTo(legacyCatEntity.getId());
		assertThat(catDto.getFirstName()).isEqualTo(legacyCatEntity.getF_name());
		assertThat(catDto.getLastName()).isEqualTo(legacyCatEntity.getL_name());
		assertThat(catDto.getOrderNumber()).isEqualTo(legacyCatEntity.getOrderNumber());
	}

	@Test
	void modelMapperShouldMapListToList() {

		List<LegacyCatEntity> legacyCatEntities =
				new ArrayList<>(List.of(
						LegacyCatEntity.builder()
								.id(12345L).f_name("Felix")
								.l_name("DaHouseCat")
								.orderNumber(55511L).build(),
						LegacyCatEntity.builder()
								.id(83535L).f_name("Pink")
								.l_name("Panther")
								.orderNumber(412847L).build()));

		List<CatDto> catDtos = listModelMapper.mapLegacyCatEntityListToCatDtoList(legacyCatEntities);

		assertThat(catDtos).hasSize(2);

		LegacyCatEntity firstLegacyCatEntity = legacyCatEntities.get(0);
		assertThat(catDtos.get(0).getId()).isEqualTo(firstLegacyCatEntity.getId());
		assertThat(catDtos.get(0).getFirstName()).isEqualTo(firstLegacyCatEntity.getF_name());
		assertThat(catDtos.get(0).getLastName()).isEqualTo(firstLegacyCatEntity.getL_name());
		assertThat(catDtos.get(0).getOrderNumber()).isEqualTo(firstLegacyCatEntity.getOrderNumber());
	}
}
