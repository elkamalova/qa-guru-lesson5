package tests;

import com.codeborne.selenide.Configuration;
import components.CalendarComponent;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

public class TextBoxFormPageObjectsTests {
    String firstName = "Elka",
            lastName = "Sun",
            email = "elka@mail.com",
            gender = "Female",
            mobile = "1234567890",
            monthOfBirth = "May",
            yearOfBirth = "2004",
            dayOfBirth = "27",
            subject1 = "English",
            hobby1 = "Sports",
            picture = "1.png",
            address = "Samara",
            state = "Haryana",
            city = "Karnal";

    RegistrationPage registrationpage = new RegistrationPage();
    CalendarComponent calendarcomponent = new CalendarComponent();

    @BeforeAll
    static void setUpConfig() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulSubmitFormTest() {
        open("https://demoqa.com/automation-practice-form");
        registrationpage.typeFirstName(firstName);
        registrationpage.typeLastName(lastName);
        registrationpage.typeUserEmail(email);
        registrationpage.chooseGender(gender);
        registrationpage.typePhoneNumber(mobile);
        calendarcomponent.chooseDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth);
        registrationpage.chooseSubject(subject1);
        registrationpage.chooseHobby(hobby1);
        registrationpage.selectPicture(picture);
        registrationpage.typeCurrentAddress(address);
        registrationpage.chooseState(state);
        registrationpage.chooseCity(city);
        registrationpage.submitForm();
        registrationpage.checkRegistrationResults(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                dayOfBirth,
                monthOfBirth,
                yearOfBirth,
                subject1,
                hobby1,
                picture,
                address,
                state,
                city);
    }

}
