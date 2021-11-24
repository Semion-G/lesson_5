package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class AutomationPracticeForm extends TestBase {

    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = "test@test.com",
            gender = "Male",
            streetAddress = faker.address().streetAddress(),
            phone = "1234567890",
            day = "22", month = "October", year = "2000",
            subject = "arts",
            hobby = "Sports",
            path = "src/test/resources/", fileName = "test.png",
            state = "NCR", city = "Delhi";

    @Test
    void automationPracticeForm() {

        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(email)
                .setGender(gender)
                .setNumber(phone)
                .setDate(month, year, day)
                .typeSubjects(subject)
                .setHobbies(hobby)
                .uploadFile(path + fileName)
                .typeAddress(streetAddress)
                .selectState(state)
                .selectCity(city)
                .submit();

        registrationPage.checkResultValue("Student Name", firstName + " " + lastName)
                .checkResultValue("Student Email", email)
                .checkResultValue("Gender", gender)
                .checkResultValue("Mobile", phone)
                .checkResultValue("Date of Birth", day + " " + month + "," + year)
                .checkResultValue("Subjects", subject)
                .checkResultValue("Hobbies", hobby)
                .checkResultValue("Picture", fileName)
                .checkResultValue("Address", streetAddress)
                .checkResultValue("State and City", state + " " + city);
    }
}
