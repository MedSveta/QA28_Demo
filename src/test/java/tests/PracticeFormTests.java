package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    //Maths,Physics,Chemistry
    @Test
    public void studentRegFormPositiveTest() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.READING);
        hobbies.add(Hobbies.SPORTS);

        Student student = new Student("Pablo", "Poblito",
                "pablo@meas.com", Gender.MALE, "0123456789",
                "12 Nov 2001", "Maths,Physics,Chemistry",
                hobbies, "", "street 1",
                StateCity.RAJASTHAN.getState(), StateCity.RAJASTHAN.getCity()[1]);

        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormPage(getDriver()).typePracticeForm(student);
        Assert.assertTrue(new PracticeFormPage(getDriver()).validateModalMessage());
    }
}
