package ch.elca.candidateassess.mapper;

import ch.elca.candidateassess.dto.CreateReviewDto;
import ch.elca.candidateassess.dto.ReviewerDto;
import ch.elca.candidateassess.persistence.entity.Person;
import ch.elca.candidateassess.persistence.entity.Review;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-10T13:58:09+0400",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.11 (AdoptOpenJDK)"
)
@Component
public class ReviewMapperImpl implements ReviewMapper {

    @Override
    public Review mapToReview(CreateReviewDto createReviewDto) {
        if ( createReviewDto == null ) {
            return null;
        }

        Review review = new Review();

        review.setStatus( createReviewDto.getStatus() );

        return review;
    }

    @Override
    public ReviewerDto mapToReviewerDto(Review review) {
        if ( review == null ) {
            return null;
        }

        ReviewerDto reviewerDto = new ReviewerDto();

        reviewerDto.setFirstName( reviewPersonFirstName( review ) );
        reviewerDto.setLastName( reviewPersonLastName( review ) );
        reviewerDto.setId( review.getId() );

        return reviewerDto;
    }

    private String reviewPersonFirstName(Review review) {
        if ( review == null ) {
            return null;
        }
        Person person = review.getPerson();
        if ( person == null ) {
            return null;
        }
        String firstName = person.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String reviewPersonLastName(Review review) {
        if ( review == null ) {
            return null;
        }
        Person person = review.getPerson();
        if ( person == null ) {
            return null;
        }
        String lastName = person.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }
}
