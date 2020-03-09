package ir.maktab.onlinequiz.specification;

import ir.maktab.onlinequiz.dto.AccountSearchDTO;
import ir.maktab.onlinequiz.enums.AccountStatus;
import ir.maktab.onlinequiz.enums.RoleTypes;
import ir.maktab.onlinequiz.models.Account;
import ir.maktab.onlinequiz.models.Communication;
import ir.maktab.onlinequiz.models.Person;
import ir.maktab.onlinequiz.models.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class AccountSpecification implements Specification<Account> {
    @Getter
    @Setter
    private AccountSearchDTO accountSearchDTO;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        setAttributeForCriteria(predicates, root, criteriaBuilder);
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    protected void setAttributeForCriteria(List<Predicate> predicates, Root<Account> root, CriteriaBuilder criteriaBuilder) {
        setUsername(root, criteriaBuilder, predicates, accountSearchDTO.getUsername());
        setFirstName(root, criteriaBuilder, predicates, accountSearchDTO.getFirstName());
        setLastName(root, criteriaBuilder, predicates, accountSearchDTO.getLastName());
        setFathersName(root, criteriaBuilder, predicates, accountSearchDTO.getFathersName());
        setNationalCode(root, criteriaBuilder, predicates, accountSearchDTO.getNationalCode());
        setDegreeOfEducation(root, criteriaBuilder, predicates, accountSearchDTO.getDegreeOfEducation());
        setPhoneNumber(root, criteriaBuilder, predicates, accountSearchDTO.getPhoneNumber());
        setCellPhoneNumber(root, criteriaBuilder, predicates, accountSearchDTO.getCellPhoneNumber());
        setAddress(root, criteriaBuilder, predicates, accountSearchDTO.getAddress());
        setEmail(root, criteriaBuilder, predicates, accountSearchDTO.getEmail());
        setRole(root, criteriaBuilder, predicates, accountSearchDTO.getRole());
        setStatus(root, criteriaBuilder, predicates, accountSearchDTO.getStatus());
    }

    private void setUsername(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String username) {
        if (username != null && !username.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("username"), "%" + username.trim() + "%"));
        }
    }

    private void setFirstName(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String firstName) {
        if (firstName != null && !firstName.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("firstName"), "%" + firstName.trim() + "%"));
        }
    }

    private void setLastName(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String lastName) {
        if (lastName != null && !lastName.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("lastName"), "%" + lastName.trim() + "%"));
        }
    }

    private void setFathersName(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String fathersName) {
        if (fathersName != null && !fathersName.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("fathersName"), "%" + fathersName.trim() + "%"));
        }
    }

    private void setNationalCode(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String nationalCode) {
        if (nationalCode != null && !nationalCode.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.like(accountPersonJoin.get("nationalCode"), "%" + nationalCode.trim() + "%"));
        }
    }

    private void setDegreeOfEducation(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String degreeOfEducation) {
        if (degreeOfEducation != null && !degreeOfEducation.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            predicates.add(criteriaBuilder.equal(accountPersonJoin.get("degreeOfEducation"), degreeOfEducation));
        }
    }

    private void setPhoneNumber(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            Join<Person, Communication> personCommunicationJoin = accountPersonJoin.join("communication");
            predicates.add(criteriaBuilder.like(personCommunicationJoin.get("phoneNumber"), "%" + phoneNumber.trim() + "%"));
        }
    }

    private void setCellPhoneNumber(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String cellPhoneNumber) {
        if (cellPhoneNumber != null && !cellPhoneNumber.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            Join<Person, Communication> personCommunicationJoin = accountPersonJoin.join("communication");
            predicates.add(criteriaBuilder.like(personCommunicationJoin.get("cellPhoneNumber"), "%" + cellPhoneNumber.trim() + "%"));
        }
    }

    private void setEmail(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String email) {
        if (email != null && !email.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("person");
            Join<Person, Communication> personCommunicationJoin = accountPersonJoin.join("communication");
            predicates.add(criteriaBuilder.like(personCommunicationJoin.get("email"), "%" + email.trim() + "%"));
        }
    }

    private void setAddress(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String address) {
        if (address != null && !address.isEmpty()) {
            Join<Account, Person> accountPersonJoin = root.join("address");
            Join<Person, Communication> personCommunicationJoin = accountPersonJoin.join("communication");
            predicates.add(criteriaBuilder.like(personCommunicationJoin.get("address"), "%" + address.trim() + "%"));
        }
    }

    private void setRole(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String role) {
        if (role != null && !role.isEmpty()) {
            Join<Account, Role> accountRoleJoin = root.join("roles");
            predicates.add(criteriaBuilder.equal(accountRoleJoin.get("roleType"), RoleTypes.valueOf(role)));
        }
    }

    private void setStatus(Root<Account> root, CriteriaBuilder criteriaBuilder, List<Predicate> predicates, String status) {
        if (status != null && !status.isEmpty()) {
            predicates.add(criteriaBuilder.equal(root.get("accountStatus"), AccountStatus.valueOf(accountSearchDTO.getStatus())));
        }
    }
}
