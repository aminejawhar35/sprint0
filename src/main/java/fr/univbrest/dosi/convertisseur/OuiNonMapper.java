package fr.univbrest.dosi.convertisseur;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OuiNonMapper {

	OuiNonMapper INSTANCE = Mappers.getMapper( OuiNonMapper.class );
	 	
	default boolean charToBoolean(char ouiNon) {
		if('O' == ouiNon) {
			return true;
		} else {
			return false;
		}
	}
	
	default char booleanToChar(boolean ouiNon) {
		if(ouiNon) {
			return 'O';
		} else {
			return 'N';
		}
}
}
