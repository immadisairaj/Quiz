package com.example.immadisairaj.quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public List<String> question;
    public List<String> optA;
    public List<String> optB;
    public List<String> optC;
    public List<String> optD;
    public List<Integer> Answer;

    public void setQuestion() {

        question = new ArrayList<>();
        question.add("According to data on language released as part of Census 2011, which is the most spoken language in India?");
        question.add("Who has been sworn-in as the first-ever visually impaired judge of Pakistan?");
        question.add("Who has broken the legendary Sriram Singh’s four-decade-old 800m National record at the 58th National Inter State Senior Athletics Championships 2018?");
        question.add("Which flagship programme of Ministry of Shipping got ‘Gold Award’ in infrastructure sector in 52nd Skoch Summit 2018?");
        question.add("To detect cervical cancer, a new technique “Liquid Based Cytology (LBC)” has launched in which state?");
        question.add("India has committed to increase its grant to $15 million to the Global Environment Facility (GEF). Who is the representative of India in the GEF Council?");
        question.add("Which state government has announced a new scheme ‘Kanya Van Samruddhi Yojana’?");
        question.add("Which committee has been constituted by the Maharashtra Government to study issues related to floating solar power plant at Ujani dam?");
        question.add("The 2018 Kabir Mahotsav has started in which state to mark the 500th death anniversary of mystic poet and saint Kabir Das?");
        question.add("The Raja Lakhamagouda dam is located in which state?");

        optA = new ArrayList<>();
        optA.add("Marathi");
        optA.add("Yawar Ali");
        optA.add("Sangram Singh");
        optA.add("Sagarmela");
        optA.add("Tamil Nadu");
        optA.add("M S Mehta");
        optA.add("Punjab");
        optA.add("Puneet Mehta committee");
        optA.add("Madhya Pradesh");
        optA.add("Kerala");

        optB = new ArrayList<>();
        optB.add("Bengali");
        optB.add("Sana Afzal");
        optB.add("Jinson Johnson");
        optB.add("Sagarmala");
        optB.add("Karnataka");
        optB.add("Chandra Shekhar");
        optB.add("Mizoram");
        optB.add("Satish Chavan committee");
        optB.add("Rajasthan");
        optB.add("Karnataka");

        optC = new ArrayList<>();
        optC.add("Telugu");
        optC.add("Yousaf Saleem");
        optC.add("Arka Bhattacharya");
        optC.add("Sagarmatha");
        optC.add("Haryana");
        optC.add("Aparna Subramani");
        optC.add("Madhya Pradesh");
        optC.add("Akshita Patil committee");
        optC.add("Uttar Pradesh");
        optC.add("Tamil Nadu");

        optD = new ArrayList<>();
        optD.add("Hindi");
        optD.add("Zubair Sabir");
        optD.add("Mohammad Afsal");
        optD.add("Sagarmatka");
        optD.add("Punjab");
        optD.add("Rama Choudhary");
        optD.add("Maharashtra");
        optD.add("Nidhi Patel committee");
        optD.add("Gujarat");
        optD.add("Andhra Pradesh");

        Answer = new ArrayList<>();
        Answer.add(4);
        Answer.add(3);
        Answer.add(2);
        Answer.add(2);
        Answer.add(1);
        Answer.add(3);
        Answer.add(4);
        Answer.add(2);
        Answer.add(3);
        Answer.add(2);
    }
}
