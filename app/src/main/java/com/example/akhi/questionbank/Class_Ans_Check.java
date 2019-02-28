package com.example.akhi.questionbank;

import android.graphics.Bitmap;

public class Class_Ans_Check {

    public int[] Ans_Key;
    public int Tot_Question;
    public double Right_Ans_Mark;
    public double Wrong_Ans_Mark;

    public class Ans_Sheet_Result {
        public Class_OMR ClsOmr;
        public int Reg_Last_Digits;
        public int Attented_Qu;
        public int Right_Ans;
        public double Total_Mark;
        public boolean ReCheck;
    }

    public String Get_Ans_Sheet_Result(int Ans_Sheet_Type, Bitmap BmOmr, Ans_Sheet_Result ASResult)
    {
        int[] Left_x  = new int[5];
        int[] Right_x = new int[5];
        int[] Top_y = new int[5];
        int[] Bottom_y = new int[5];

        int[] Ali_x = new int[5];
        int[] Ali_y = new int[5];

        int Digit_Cnt;
        int Digit_Place;
        int Digit_Mark_Cnt;
        int Mark_Digit;
        int Qu_Num;
        int Choice ;
        int Ans_Cnt;
        int Ans_Choice;

        boolean[][] Digit_Mark = new boolean[5][11]; //Digit Place, Digit Count
        boolean[][] Answer_Mark; //Tot Qu, Choice

        String Ans_Sheet_Result_Return = "";

        If ClsOmr.Alignment_Detect(BmOmr, Ali_x, Ali_y, Ans_Sheet_Type) = False Then
                Get_Ans_Sheet_Result = "Alignment Error"
        BmOmr.Dispose()
        Exit Function
        End If

        Call ClsOmr.Get_All_Bubble_Mark(Tot_Question, BmOmr, Digit_Mark, Answer_Mark)

        'Get Reg. Num.

        Reg_Last_Digits = 0

        For Digit_Place = 1 To 4

        Digit_Mark_Cnt = 0
        Mark_Digit = 0

        For Digit_Cnt = 1 To 10
        If Digit_Mark (Digit_Place, Digit_Cnt) =True Then
        Digit_Mark_Cnt += 1
        Mark_Digit = Digit_Cnt - 1
        End If
        Next

        If Digit_Mark_Cnt = 1 Then
                Reg_Last_Digits = Reg_Last_Digits + Mark_Digit * (10 ^ (4 - Digit_Place))
        Else
                Get_Ans_Sheet_Result = "Reg. Number Error"
        Exit For
        End If

        Next

                Attented_Qu = 0
        Right_Ans = 0

        For Qu_Num = 1 To Tot_Question

        Ans_Cnt = 0

        For Choice = 1 To ClsOmr.Total_Choice
        If Answer_Mark (Qu_Num, Choice) =True Then
        Ans_Cnt += 1
        Ans_Choice = Choice
        End If
        Next

        If Ans_Choice >0 And Ans_Key (Qu_Num) = Ans_Choice And Ans_Cnt = 1 Then
        Right_Ans += 1
        End If

        If Ans_Cnt >0 Then
        Attented_Qu += 1
        End If

        Next

                Total_Mark = (Right_Ans * Right_Ans_Mark) - ((Attented_Qu - Right_Ans) * Math.Abs(Wrong_Ans_Mark))

        If Total_Mark <0 Then Total_Mark = 0

        BmOmr.Dispose();

        return Ans_Sheet_Result;
    }

    Public Sub Get_QB_Answer_Key(ByRef Answer_Key() As Byte, ByRef DsQb As DataSet)

    {
        Dim DrQb As OleDb.OleDbDataReader
        Dim CmdQb As OleDb.OleDbCommand
        Dim Row_Num As Integer
        Dim i As SByte
        Dim Question_Code As Integer
        Dim Option_Num As SByte
        Dim Answer_Option As SByte
        Dim Rtb_DB_Answer (5) As RichTextBox
        Dim Choice_Pos As SByte
        Dim Multiple_Choice As Boolean

        If Tot_Question <=0 Then Exit Sub

        For i = 0 To 5
        Rtb_DB_Answer(i) = New RichTextBox
            Next

        ReDim Answer_Key (Tot_Question)

            For Row_Num = 0 To(DsQb.Tables("Exam_Questions").Rows.Count - 1)

        Question_Code = DsQb.Tables("Exam_Questions").Rows(Row_Num).Item("Question_Code")

        CmdQb = New
        OleDb.OleDbCommand("Select * from Question_Bank Where Question_Code = " & Question_Code, ConnQB)

        DrQb = CmdQb.ExecuteReader()
        DrQb.Read()

        If DrQb.HasRows Then

        If IsDBNull (DrQb.Item("Multiple_Choice")) Then
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

        If Rtb_DB_Answer (Option_Num).TextLength <>0 Then

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

        Public Sub Get_User_Ans_Key(ByRef Answer_Key()As Byte, ByVal Exam_Code As Integer)

        Dim DaQb As New MySqlDataAdapter
        Dim DsQb As New DataSet
        Dim i As Integer

        If Tot_Question <=0 Then Exit Sub

        ReDim Answer_Key (Tot_Question)

            DaQb.SelectCommand = New
        MySqlCommand("Select * from User_Answer_Key Where Exam_Code = " & Exam_Code, ConnMySQL)
        DsQb.Clear()
        DaQb.Fill(DsQb, "User_Answer_Key")

        For i = 0 To DsQb.Tables("User_Answer_Key").Rows.Count - 1

        If DsQb.Tables("User_Answer_Key").Rows(i).Item("Question_Num") <= Tot_Question Then
        Answer_Key(DsQb.Tables("User_Answer_Key").Rows(i).Item("Question_Num")) = DsQb.Tables("User_Answer_Key").Rows(i).Item("Choice_Answer")
        End If

        Next

    }

}
