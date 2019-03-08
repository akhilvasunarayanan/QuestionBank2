package com.example.akhi.questionbank;

import android.graphics.Bitmap;

public class Class_Ans_Check {

    public int[] Ans_Key;
    public int Tot_Question;
    public double Right_Ans_Mark;
    public double Wrong_Ans_Mark;

    public class Ans_Sheet_Result{
        ByRef Reg_Last_Digits As Integer, _
        ByRef Attented_Qu As Integer, _
        ByRef Right_Ans As Integer, _
        ByRef Total_Mark As Single, _
        ByRef ReCheck As Boolean, _
    }

    public String Get_Ans_Sheet_Result(Bitmap BmOmr,
                                       Class_OMR ClsOmr,
                                                 ByVal Ans_Sheet_Type As Integer) As String


    Dim Left_x(4) As Integer
    Dim Right_x(4) As Integer
    Dim Top_y(4) As Integer
    Dim Bottom_y(4) As Integer

    Dim Ali_x(4) As Integer
    Dim Ali_y(4) As Integer

    Dim Digit_Cnt As SByte
    Dim Digit_Place As SByte
    Dim Digit_Mark_Cnt As SByte
    Dim Mark_Digit As SByte
    Dim Qu_Num As Integer
    Dim Choice As SByte
    Dim Ans_Cnt As Byte
    Dim Ans_Choice As Byte

    Dim Digit_Mark(4, 10) As Boolean 'Digit Place, Digit Count
    Dim Answer_Mark(-1, -1) As Boolean 'Tot Qu, Choice

    Get_Ans_Sheet_Result = ""

    Try
            BmOmr = New Bitmap(File_Name)
    Catch ex As Exception
    ReCheck = True
            Get_Ans_Sheet_Result = "File Access Error"
    Exit Function
    End Try

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
    If Digit_Mark(Digit_Place, Digit_Cnt) = True Then
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
    If Answer_Mark(Qu_Num, Choice) = True Then
    Ans_Cnt += 1
    Ans_Choice = Choice
    End If
    Next

    If Ans_Choice > 0 And Ans_Key(Qu_Num) = Ans_Choice And Ans_Cnt = 1 Then
    Right_Ans += 1
    End If

    If Ans_Cnt > 0 Then
    Attented_Qu += 1
    End If

    Next

            Total_Mark = (Right_Ans * Right_Ans_Mark) - ((Attented_Qu - Right_Ans) * Math.Abs(Wrong_Ans_Mark))

    If Total_Mark < 0 Then Total_Mark = 0

        BmOmr.Dispose()

    End Function

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
