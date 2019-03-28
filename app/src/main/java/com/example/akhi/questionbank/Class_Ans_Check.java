package com.example.akhi.questionbank;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.Log;

public class Class_Ans_Check {

    public int Ans_Key[];
    public int Tot_Question;
    public double Right_Ans_Mark;
    public double Wrong_Ans_Mark;

    public String Get_Ans_Sheet_Result(Bitmap BmOmr,
                                       Class_OMR ClsOmr,
                                       int[] Reg_Last_Digits,
                                       int[] Attented_Qu,
                                       int[] Right_Ans,
                                       double[] Total_Mark,
                                       boolean[] ReCheck,
                                       int Ans_Sheet_Type) {

        Point[] Ali = new Point[5];
        int Digit_Cnt;
        int Digit_Place;
        int Digit_Mark_Cnt;
        int Mark_Digit;
        int Qu_Num;
        int Choice;
        int Ans_Cnt;
        int Ans_Choice = 0;
        String Ans_Sheet_Result;

        for (int i = 0; i <= 4; i++){
            Ali[i] = new Point(0,0);
        }

        boolean[][] Digit_Mark = new boolean[5][11]; //Digit Place, Digit Count
        boolean[][] Answer_Mark = new boolean[0][0]; //Tot Qu, Choice

        Ans_Sheet_Result = "";

        if (!ClsOmr.Alignment_Detect(BmOmr, Ali, Ans_Sheet_Type)) {
            Ans_Sheet_Result = "Alignment Error";
            Log.d("Error", Ans_Sheet_Result);
            return Ans_Sheet_Result;
        }

        Log.d("AkhilDebug", "Alignment Points:  " + Ali[1] + ", " + Ali[2] + ", " + Ali[3] + ", " + Ali[4] );

        Answer_Mark = new boolean[Tot_Question + 1][6];
        ClsOmr.Get_All_Bubble_Mark(Tot_Question, BmOmr, Digit_Mark, Answer_Mark);

        //Get Reg. Num.

        Reg_Last_Digits[0] = 0;

        for (Digit_Place = 1; Digit_Place <= 4; Digit_Place++) {
            Digit_Mark_Cnt = 0;
            Mark_Digit = 0;

            for (Digit_Cnt = 1; Digit_Cnt <= 10; Digit_Cnt++) {
                if (Digit_Mark[Digit_Place][Digit_Cnt]) {
                    Digit_Mark_Cnt += 1;
                    Mark_Digit = Digit_Cnt - 1;
                }
            }

            if (Digit_Mark_Cnt == 1) {
                Reg_Last_Digits[0] = Reg_Last_Digits[0] + Mark_Digit * (10 ^ (4 - Digit_Place));
            } else {
                Ans_Sheet_Result = "Reg. Number Error";
                return Ans_Sheet_Result;
            }
        }

        Attented_Qu[0] = 0;
        Right_Ans[0] = 0;

        for (Qu_Num = 1; Qu_Num <= Tot_Question; Qu_Num++) {

            Ans_Cnt = 0;

            for (Choice = 1; Choice <= ClsOmr.Total_Choice; Choice++) {
                if (Answer_Mark[Qu_Num][Choice]) {
                    Ans_Cnt += 1;
                    Ans_Choice = Choice;
                }
            }

            if (Ans_Choice > 0 && Ans_Key[Qu_Num] == Ans_Choice && Ans_Cnt == 1) {
                Right_Ans[0] += 1;
            }

            if (Ans_Cnt > 0) {
                Attented_Qu[0] += 1;
            }
        }

        Total_Mark[0] = (Right_Ans[0] * Right_Ans_Mark) - ((Attented_Qu[0] - Right_Ans[0]) * java.lang.Math.abs(Wrong_Ans_Mark));

        if (Total_Mark[0] < 0) Total_Mark[0] = 0;

        return Ans_Sheet_Result;
    }

    //region Get_QB_Answer_Key
    /*
    public void Get_QB_Answer_Key(int[] Answer_Key, ByRef DsQb As DataSet)

    Dim DrQb As OleDb.OleDbDataReader
    Dim CmdQb As OleDb.OleDbCommand
    Dim Row_Num As Integer
    Dim i As SByte
    Dim Question_Code As Integer
    Dim Option_Num As SByte
    Dim Answer_Option As SByte
    Dim Rtb_DB_Answer(5) As RichTextBox
    Dim Choice_Pos As SByte
    Dim Multiple_Choice As Boolean

    If Tot_Question <= 0 Then Exit Sub

    For i = 0 To 5
    Rtb_DB_Answer(i) = New RichTextBox
    Next

    ReDim Answer_Key(Tot_Question)

    For Row_Num = 0 To (DsQb.Tables("Exam_Questions").Rows.Count - 1)

    Question_Code = DsQb.Tables("Exam_Questions").Rows(Row_Num).Item("Question_Code")

    CmdQb = New OleDb.OleDbCommand("Select * from Question_Bank Where Question_Code = " & Question_Code, ConnQB)

    DrQb = CmdQb.ExecuteReader()
            DrQb.Read()

    If DrQb.HasRows Then

    If IsDBNull(DrQb.Item("Multiple_Choice")) Then
            Multiple_Choice = True
    Else
            Multiple_Choice = IIf(DrQb.Item("Multiple_Choice") = 1, True, False)
    End If

    If Multiple_Choice Then

    Call QuestionBank.Get_Qb_Answer_Only(Question_Code, Rtb_DB_Answer)

    Choice_Pos = 0
    Answer_Option = 0

    For i = 1 To 5

    Option_Num = DsQb.Tables("Exam_Questions").Rows(Row_Num).Item("Option_" & i)

    If Rtb_DB_Answer(Option_Num).TextLength <> 0 Then

            Choice_Pos = Choice_Pos + 1

    If Option_Num = DrQb.Item("Choice_Answer") Then
            Answer_Option = Choice_Pos
    Exit For
    End If

    End If

    Next i

    Answer_Key(Row_Num + 1) = Answer_Option

            Else
    Answer_Key(Row_Num + 1) = 0
    End If

                DrQb.Close()

    End If

    Next Row_Num

    End Sub
    */
    //endregion

    //region Get_User_Ans_Key
    /*
    Public Sub Get_User_Ans_Key(ByRef Answer_Key() As Byte, ByVal Exam_Code As Integer)

    Dim DaQb As New MySqlDataAdapter
    Dim DsQb As New DataSet
    Dim i As Integer

    If Tot_Question <= 0 Then Exit Sub

    ReDim Answer_Key(Tot_Question)

    DaQb.SelectCommand = New MySqlCommand("Select * from User_Answer_Key Where Exam_Code = " & Exam_Code, ConnMySQL)
        DsQb.Clear()
                DaQb.Fill(DsQb, "User_Answer_Key")

    For i = 0 To DsQb.Tables("User_Answer_Key").Rows.Count - 1

    If DsQb.Tables("User_Answer_Key").Rows(i).Item("Question_Num") <= Tot_Question Then
    Answer_Key(DsQb.Tables("User_Answer_Key").Rows(i).Item("Question_Num")) = DsQb.Tables("User_Answer_Key").Rows(i).Item("Choice_Answer")
    End If

    Next

    End Sub
    */
    //endregion
}
