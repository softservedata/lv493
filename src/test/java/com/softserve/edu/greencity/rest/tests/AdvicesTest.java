package com.softserve.edu.greencity.rest.tests;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.softserve.edu.greencity.rest.data.Advices;
import com.softserve.edu.greencity.rest.data.AdvicesRepository;
import com.softserve.edu.greencity.rest.data.User;
import com.softserve.edu.greencity.rest.data.UserRepository;
import com.softserve.edu.greencity.rest.entity.AdvicesRandomEntity;
import com.softserve.edu.greencity.rest.services.TipsTricksService;
import com.softserve.edu.greencity.ui.data.Languages;

public class AdvicesTest extends GreencityRestTestRunner {

    @DataProvider
    public Object[][] habitId() {
        return new Object[][] { { UserRepository.get().getAdminUser(), Languages.ENGLISH, AdvicesRepository.getHabitID() } };
    }

    @Test(dataProvider = "habitId")
    public void getAdvice(User user, Languages language, Advices habitId ) {
        TipsTricksService tipsTricksService = loadApplication()
                .successfulUserLogin(user)
                .gotoTipsTricksService();
        List<AdvicesRandomEntity> adv =  tipsTricksService.advice(language, habitId);
        System.out.println("***adv= " + adv);
    }

}
