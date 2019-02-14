package com.example.akhi.questionbank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Global {

    public static List<AnswerSheetType> answerSheetType = new ArrayList<>();

    public static void FillAnswerSheetType() {
        answerSheetType.add(new AnswerSheetType("60 Questions", 1, 60));
        answerSheetType.add(new AnswerSheetType("120 Questions", 2, 120));
        answerSheetType.add(new AnswerSheetType("180 Questions", 3, 180));
    }

    public static AnswerSheetType GetAnswerSheet(int Id)
    {
        for (AnswerSheetType sheetType : answerSheetType)
        {
            if(sheetType.Id == Id)
            {
                return sheetType;
            }
        }

        return new AnswerSheetType();
    }

    public static class AnswerSheetType {

        public String Name;
        public int Id;
        public int Questions;

        public AnswerSheetType() {
        }

        public AnswerSheetType(String name, int id, int questions) {
            this.Name = name;
            this.Id = id;
            this.Questions = questions;
        }

        /**
         * Pay attention here, you have to override the toString method as the
         * ArrayAdapter will reads the toString of the given object for the name
         *
         * @return name
         */
        @Override
        public String toString() {
            return Name;
        }
    }
}

