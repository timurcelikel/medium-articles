package dev.timurcelikel.medium.modelmapper;

import dev.timurcelikel.medium.modelmapper.dto.CatDto;
import dev.timurcelikel.medium.modelmapper.entity.LegacyCatEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListModelMapper {

	ModelMapper modelMapper;

	public ListModelMapper(final ModelMapper modelMapper) {
		this.modelMapper = modelMapper;
	}

	List<CatDto> mapLegacyCatEntityListToCatDtoList(final List<LegacyCatEntity> legacyCatEntities) {

		modelMapper.typeMap(LegacyCatEntity.class, CatDto.class)
				.addMappings((mapper -> {
					mapper.map(src -> src.getF_name(), CatDto::setFirstName);
					mapper.map(src -> src.getL_name(), CatDto::setLastName);
				}));

		return legacyCatEntities.stream().map(entity -> modelMapper.map(entity, CatDto.class)).toList();
	}
}
