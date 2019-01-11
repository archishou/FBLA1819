package com.skooltchdev.multiplechoicequiz.Tests;

import com.skooltchdev.multiplechoicequiz.Models.QuestionModel;
import com.skooltchdev.multiplechoicequiz.Models.TestModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Archishmaan Peyyety on 1/9/19.
 * Project: FBLA1819
 */
public class FinancialMathTest {
    List<QuestionModel> questions;
    static TestModel model;
    public FinancialMathTest() {
        questions = new ArrayList<>();

        questions.add(new QuestionModel("What is 18 + (-)26",
                new String[]{"-8", "-44", "8", "44"}));

        questions.add(new QuestionModel("Find the product of 0.973 and 1.918",
                new String[]{"1.866214", ".01866214", "18.66214", ".1866214"}));

        questions.add(new QuestionModel("A 25 lb. bag of dog food cost $9.25. What is the unit price per pound? ",
                new String[]{"$0.37", "$0.35",
                        "$0.34", "$3.70"}));

        questions.add(new QuestionModel("Mary Jones worked 44 hours last week earning an hourly rate of $17.25. What is Mary’s gross pay for the week? They work a 40-hour week and anything over is considered time and a half. ",
                new String[]{"$793.50 ", " $739.50 ",
                        " $759.00 ", " $690.00 "}));

        questions.add(new QuestionModel("A businessman decided to lose 15 2/3 pounds before applying for health insurance. How much did he weigh after his weight loss if he originally weighed 208 1/8 pounds? ",
                new String[]{"192 11/24 ",
                        " 193 11/24 ",
                        " 191 11/24 ",
                        " 193 7/8 "}));
        questions.add(new QuestionModel("Phyllis paid $22.3293 in sales tax on an item costing $318.99. What sales tax percentage did Phyllis pay?",
                new String[]{"7.0%", " .07%",
                        " .1428% ", " 14.28%"}));
        questions.add(new QuestionModel("You are on a 5-hour trip, and your speed for the first two hours only averaged 58 mph because of slow traffic. How fast must you drive for the last 3 hours to average 65 mph for the entire trip(round up if needed)?",
                new String[]{"70 m.p.h.", " 72 m.p.h. ",
                        " 68 m.p.h.", " 75 m.p.h."}));
        questions.add(new QuestionModel("Which of the following 4 numbers is the largest: 3/8, .0375, 2/5, or .25? ",
                new String[]{"2/5", " 3/8 ",
                        " .25", " .0375"}));
        questions.add(new QuestionModel("Convert the annual percentage rate of 21% into a monthly rate. ",
                new String[]{"1.75%", " 17.5%",
                        " 2.10% ", " .0175%"}));
        questions.add(new QuestionModel("5/8 pound of cheese costs $1.59. What is the cost of one pound of cheese?",
                new String[]{"$2.54", " $0.99",
                        " $0.88", " $2.45"}));

        model = new TestModel("account", "Accountin 1", questions);
    }

    public TestModel getModel() {
        return model;
    }
}
