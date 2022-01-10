package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreatePositionDto;
import ch.elca.candidateassess.dto.PositionDto;
import ch.elca.candidateassess.persistence.entity.Position;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class PositionMapperImpl implements PositionMapper {

    @Override
    public Position mapToPosition(CreatePositionDto createPositionDto) {
        if ( createPositionDto == null ) {
            return null;
        }

        Position position = new Position();

        position.setName( createPositionDto.getName() );

        return position;
    }

    @Override
    public PositionDto mapToPositionDto(Position position) {
        if ( position == null ) {
            return null;
        }

        PositionDto positionDto = new PositionDto();

        positionDto.setId( position.getId() );
        positionDto.setName( position.getName() );

        return positionDto;
    }
}
