package dev.timurcelikel.medium.modelmapper;

import dev.timurcelikel.medium.modelmapper.dto.CatDto;
import dev.timurcelikel.medium.modelmapper.entity.LegacyCatEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SingleModelMapper {

	ModelMapper modelMapper;

	public SingleModelMapper(final ModelMapper modelMapper) {

		this.modelMapper = modelMapper;
	}

	CatDto mapLegacyCatEntityToCatDto(final LegacyCatEntity legacyCatEntity) {

		modelMapper.typeMap(LegacyCatEntity.class, CatDto.class)
				.addMappings((mapper -> {
					mapper.map(src -> src.getF_name(), CatDto::setFirstName);
					mapper.map(src -> src.getL_name(), CatDto::setLastName);
				}));

		return modelMapper.map(legacyCatEntity, CatDto.class);
	}
}
