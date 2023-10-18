package dev.timurcelikel.medium.modelmapper;

import dev.timurcelikel.medium.modelmapper.dto.CatDto;
import dev.timurcelikel.medium.modelmapper.entity.LegacyCatEntity;
import org.springframework.stereotype.Component;

@Component
public class GetSetMapper {

	public CatDto mapGetSetLegacyCatEntityToCatDtoTo(final LegacyCatEntity legacyCatEntity) {

		CatDto catDto = new CatDto();
		catDto.setId(legacyCatEntity.getId());
		catDto.setFirstName(legacyCatEntity.getF_name());
		catDto.setLastName(legacyCatEntity.getL_name());
		catDto.setOrderNumber(legacyCatEntity.getOrderNumber());

		return catDto;
	}
}
