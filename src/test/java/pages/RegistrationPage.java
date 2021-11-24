package pages;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final String FORM_TITLE = "Student Registration Form";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGenderRadio = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            checkboxHobbies = $("#hobbiesWrapper"),
            uploadFileButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#state"),
            citySelect = $("#city"),
            submitButton = $("#submit"),
            resultTable = $(".table-responsive");


    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage typeUserEmail(String mail) {
        userEmailInput.setValue(mail);
        return this;
    }

    public RegistrationPage setGender(String gender) {
        userGenderRadio.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setNumber(String phone) {
        userNumber.setValue(phone);
        return this;
    }

    public RegistrationPage setDate(String month, String year, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText(month)).click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();
        return this;
    }

    public RegistrationPage typeSubjects(String subject) {
        subjectsInput.setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage setHobbies(String hobbies) {
        checkboxHobbies.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage uploadFile(String path) {
        uploadFileButton.uploadFile(new File(path));
        return this;
    }

    public RegistrationPage typeAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        stateSelect.scrollIntoView(true);
        stateSelect.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        citySelect.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPage submit() {
        submitButton.scrollIntoView(true);
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultValue(String key, String value) {
        resultTable.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

}
