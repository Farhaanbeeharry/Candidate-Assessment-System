package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.LoginDto;
import ch.elca.candidateassess.dto.PersonDto;
import ch.elca.candidateassess.dto.ReviewerDto;
import ch.elca.candidateassess.persistence.entity.Person;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public Person mapToPerson(PersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        Person person = new Person();

        person.setId( personDto.getId() );
        person.setFirstName( personDto.getFirstName() );
        person.setLastName( personDto.getLastName() );
        person.setPhoneNumber( personDto.getPhoneNumber() );
        person.setEmailAddress( personDto.getEmailAddress() );
        person.setPassword( personDto.getPassword() );
        person.setAccountType( personDto.getAccountType() );

        return person;
    }

    @Override
    public ReviewerDto mapToReviewerDto(Person person) {
        if ( person == null ) {
            return null;
        }

        ReviewerDto reviewerDto = new ReviewerDto();

        reviewerDto.setId( person.getId() );
        reviewerDto.setFirstName( person.getFirstName() );
        reviewerDto.setLastName( person.getLastName() );

        return reviewerDto;
    }

    @Override
    public void mapToLoginDto(LoginDto loginDto, Person person) {
        if ( person == null ) {
            return;
        }

        loginDto.setId( person.getId() );
        loginDto.setFirstName( person.getFirstName() );
        loginDto.setLastName( person.getLastName() );
        loginDto.setEmailAddress( person.getEmailAddress() );
        loginDto.setAccountType( person.getAccountType() );
    }
}
