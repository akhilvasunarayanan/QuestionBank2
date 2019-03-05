package com.example.akhi.questionbank;

import android.graphics.Color;
import android.graphics.Point;

public class Class_OMR {

    public double TL_x;
    public double TL_y;
    public double TR_x;
    public double TR_y;
    public double BL_x;
    public double BL_y;
    public double BR_x;
    public double BR_y;

    private Point[] Right_Ali;
    private Point[] Bottom_Ali;

    public int Squ_Thick = 12;
    public int Squ_Blank_Space_x = 6; //Make a settings for this
    public int Squ_Blank_Space_y = 6;

    public int Squ_Blank_Space_Width_Wise = 1;     //Make a settings for this
    public int Squ_Blank_Space_Length_Wise = 6;

    public double Squ_Thick_Max = 124;// ' 110 '%         'Make a settings for this
    public double Squ_Thick_Min = 80;// '%                'Make a settings for this

    private int Ali_Check_Tolerance = 5;

    private int Ali_Bri_Level;

    public double Def_TL_x;
    public double Def_TL_y;
    public double Def_TR_x;
    public double Def_TR_y;
    public double Def_BL_x;
    public double Def_BL_y;
    public double Def_BR_x;
    public double Def_BR_y;

    public int Right_Ali_Points_Cnt;
    public int Bottom_Ali_Points_Cnt;
    public int Mid_Ali_Shift;

    public int Total_Qu;
    public int Total_Column;
    public int Total_Choice;

    public double Bubble_Thick = 0.3;
    //private Letter_Pen As new Pen(Color.FromArgb(0, 0, 0), 0.3)

    public int Bubble_RollNo_Offset_x;
    public int Bubble_RollNo_Offset_y;

    private int Bubble_Offset_x;
    private int Bubble_Offset_y;
    private int Bubble_Col_Offset;
    public int Bubble_Hori_Space = 23;
    public int Bubble_Vert_Space;
    public int Bubble_Height = 10;
    public int Bubble_Width = 13;

    private double Top_Len;
    private double Bottom_Len;
    private double Left_Len;
    private double Right_Len;

    private double XRatio_Top;
    private double XRatio_Bottom;
    private double YRatio_Left;
    private double YRatio_Right;
    public double XRatio;
    public double YRatio;

    public String[] OMR_Image_Formats = new String[6];
    public int OMR_Ans_Sheet_Count = 3;

    public class PointD {

        public double x;
        public double y;

        public PointD(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public PointD(PointD src) {
            this.x = src.x;
            this.y = src.y;
        }
    }

    public void Load_Alignment(int Ans_Sheet_Type) {
        if (Ans_Sheet_Type == 1) //60 Questions
        {
            Def_TL_x = 80;
            Def_TL_y = 81;
            Def_TR_x = 511;
            Def_TR_y = 81;
            Def_BL_x = 80;
            Def_BL_y = 745;
            Def_BR_x = 511;
            Def_BR_y = 745;

            Right_Ali_Points_Cnt = 2;
            Bottom_Ali_Points_Cnt = 1;
            Mid_Ali_Shift = 10;

            Bubble_Offset_x = 142;
            Bubble_Offset_y = 544;
            Bubble_Vert_Space = 18;
            Bubble_Col_Offset = 149;

            Bubble_RollNo_Offset_x = 15;
            Bubble_RollNo_Offset_y = 387;

            Total_Qu = 60;
            Total_Column = 2;
            Total_Choice = 5;
        } else if (Ans_Sheet_Type == 2) //120 Questions
        {

            Def_TL_x = 80;
            Def_TL_y = 80;
            Def_TR_x = 746;
            Def_TR_y = 80;
            Def_BL_x = 80;
            Def_BL_y = 1089;
            Def_BR_x = 746;
            Def_BR_y = 1089;

            Right_Ali_Points_Cnt = 4;
            Bottom_Ali_Points_Cnt = 2;
            Mid_Ali_Shift = 9;

            Bubble_Offset_x = 362;//362
            Bubble_Offset_y = 968;
            Bubble_Vert_Space = 16;
            Bubble_Col_Offset = 160;

            Bubble_RollNo_Offset_x = 99;
            Bubble_RollNo_Offset_y = 560;

            Total_Qu = 120;
            Total_Column = 2;
            Total_Choice = 5;
        } else if (Ans_Sheet_Type == 3) //180 Questions
        {
            Def_TL_x = 80;
            Def_TL_y = 80;
            Def_TR_x = 746;
            Def_TR_y = 80;
            Def_BL_x = 80;
            Def_BL_y = 1089;
            Def_BR_x = 746;
            Def_BR_y = 1089;

            Right_Ali_Points_Cnt = 4;
            Bottom_Ali_Points_Cnt = 2;
            Mid_Ali_Shift = 9;

            Bubble_Offset_x = 276;// ' 330 ' 362
            Bubble_Offset_y = 968;
            Bubble_Vert_Space = 16;
            Bubble_Col_Offset = 135;// ' 160

            Bubble_RollNo_Offset_x = 77;
            Bubble_RollNo_Offset_y = 560;

            Total_Qu = 180;
            Total_Column = 3;
            Total_Choice = 4;
        } else {
            //Exception
        }

        Right_Ali = new Point[Right_Ali_Points_Cnt + 1];

        for (Point rP : Right_Ali) {
            rP = new Point(0, 0);
        }

        Bottom_Ali = new Point[Bottom_Ali_Points_Cnt + 1];

        for (Point bP : Bottom_Ali) {
            bP = new Point(0, 0);
        }
    }

    //region Draw Answer Sheet
    /*
    Public Sub Draw_Bubble_Letter(ByRef e As Graphics, _
            ByVal Letter_Code As Integer, _
                                          ByVal Dx As Integer, _
                                          ByVal Dy As Integer)

    Dim LWidth As Integer = 6 * XRatio
    Dim LHight As Integer = 6 * YRatio
    Dim Pat(1) As Single

    Dx = Dx - LWidth / 2
    Dy = Dy - LHight / 2

            'e.Graphics.DrawRectangle(New Pen(Color.Green, 0.1), Dx, Dy, LWidth, LHight)

    If Letter_Code = 1 Then 'A
            e.DrawLine(Letter_Pen, Dx, Dy + LHight, CInt(Dx + LWidth / 2), Dy)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 2), Dy, Dx + LWidth, Dy + LHight)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 4), CInt(Dy + LHight / 2), CInt(Dx + LWidth * 3 / 4), CInt(Dy + LHight / 2))
    ElseIf Letter_Code = 2 Then 'B
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 8), Dy, CInt(Dx + LWidth / 8), Dy + LHight)
            e.DrawLine(Letter_Pen, Dx, Dy, CInt(Dx + LWidth * 3 / 4), Dy)
            e.DrawLine(Letter_Pen, Dx, Dy + LHight, CInt(Dx + LWidth * 3 / 4), Dy + LHight)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 8), CInt(Dy + LHight / 2), CInt(Dx + LWidth * 3 / 4), CInt(Dy + LHight / 2))
            e.DrawArc(Letter_Pen, CInt(Dx + LWidth / 2), Dy, CInt(LWidth / 2), CInt(LHight / 2), 90, -180)
            e.DrawArc(Letter_Pen, CInt(Dx + LWidth / 2), CInt(Dy + LHight / 2), CInt(LWidth / 2), CInt(LHight / 2), 90, -180)
    ElseIf Letter_Code = 3 Then 'C
            e.DrawArc(Letter_Pen, Dx, Dy, CInt(LWidth * 9 / 8), LHight, 45, 270)
    ElseIf Letter_Code = 4 Then 'D
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 8), Dy, CInt(Dx + LWidth / 8), Dy + LHight)
            e.DrawArc(Letter_Pen, Dx, Dy, LWidth, LHight, 90, -180)
            e.DrawLine(Letter_Pen, Dx, Dy, CInt(Dx + LWidth / 2), Dy)
            e.DrawLine(Letter_Pen, Dx, Dy + LHight, CInt(Dx + LWidth / 2), Dy + LHight)
    ElseIf Letter_Code = 5 Then 'E
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 8), Dy, CInt(Dx + LWidth / 8), Dy + LHight)
            e.DrawLine(Letter_Pen, Dx, Dy, Dx + LWidth, Dy)
            e.DrawLine(Letter_Pen, Dx, Dy + LHight, Dx + LWidth, Dy + LHight)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 8), CInt(Dy + LHight / 2), CInt(Dx + LWidth * 7 / 8), CInt(Dy + LHight / 2))
    End If

    End Sub

    Public Sub Draw_Bubble_Digit(ByRef e As Graphics, _
            ByVal Digit_Code As Integer, _
                                         ByVal Dx As Integer, _
                                         ByVal Dy As Integer)

    Dim LWidth As Integer = 4 * XRatio
    Dim LHight As Integer = 6 * YRatio
    Dim Pat(1) As Single

    Dx = Dx - LWidth / 2
    Dy = Dy - LHight / 2

            'e.Graphics.DrawRectangle(New Pen(Color.Green, 0.1), Dx, Dy, LWidth, LHight)

    If Digit_Code = 0 Then
            e.DrawEllipse(Letter_Pen, Dx, Dy, LWidth, LHight)
    ElseIf Digit_Code = 1 Then
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 2), Dy, CInt(Dx + LWidth / 2), Dy + LHight)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 4), Dy + LHight, CInt(Dx + LWidth * 3 / 4), Dy + LHight)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 4), Dy, CInt(Dx + LWidth / 2), Dy)
    ElseIf Digit_Code = 2 Then
            e.DrawArc(Letter_Pen, Dx, Dy, LWidth, CInt(LHight * 2 / 3), 180, 180)
            e.DrawLine(Letter_Pen, Dx, Dy + LHight, Dx + LWidth, Dy + LHight)
            e.DrawLine(Letter_Pen, Dx, Dy + LHight, Dx + LWidth, CInt(Dy + LHight * 2 / 6))
    ElseIf Digit_Code = 3 Then
            e.DrawArc(Letter_Pen, Dx, Dy, LWidth, CInt(LHight / 2), 180, 270)
            e.DrawArc(Letter_Pen, Dx, CInt(Dy + LHight / 2), LWidth, CInt(LHight / 2), 270, 270)
    ElseIf Digit_Code = 4 Then
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth * 3 / 4), Dy, CInt(Dx + LWidth * 3 / 4), Dy + LHight)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth * 2 / 4), Dy + LHight, CInt(Dx + LWidth), Dy + LHight)
            e.DrawLine(Letter_Pen, Dx, CInt(Dy + LHight * 2 / 3), Dx + LWidth, CInt(Dy + LHight * 2 / 3))
            e.DrawLine(Letter_Pen, Dx, CInt(Dy + LHight * 2 / 3), CInt(Dx + LWidth * 3 / 4), Dy)
    ElseIf Digit_Code = 5 Then
            e.DrawLine(Letter_Pen, Dx, Dy, Dx + LWidth, Dy)
            e.DrawLine(Letter_Pen, Dx, Dy, Dx, CInt(Dy + LHight / 4))
            e.DrawArc(Letter_Pen, Dx - LWidth, CInt(Dy + LHight / 4), CInt(LWidth * 2), CInt(LHight * 3 / 4), 270, 180)
    ElseIf Digit_Code = 6 Then
            e.DrawArc(Letter_Pen, Dx, Dy, LWidth, CInt(LHight * 0.6), 180, 135)
            e.DrawArc(Letter_Pen, Dx, CInt(Dy + LHight - LHight * 0.6), LWidth, CInt(LHight * 0.6), 0, 360)
            e.DrawLine(Letter_Pen, Dx, CInt(Dy + LHight * 0.6 / 2), Dx, CInt(Dy + LHight - LHight * 0.6 / 2))
    ElseIf Digit_Code = 7 Then
            e.DrawLine(Letter_Pen, Dx, Dy, Dx + LWidth, Dy)
            e.DrawLine(Letter_Pen, CInt(Dx + LWidth / 4), Dy + LHight, Dx + LWidth, Dy)
    ElseIf Digit_Code = 8 Then
            e.DrawArc(Letter_Pen, Dx, Dy, LWidth, CInt(LHight / 2), 0, 360)
            e.DrawArc(Letter_Pen, Dx, CInt(Dy + LHight / 2), LWidth, CInt(LHight / 2), 0, 360)
    ElseIf Digit_Code = 9 Then
            e.DrawArc(Letter_Pen, Dx, Dy, LWidth, CInt(LHight * 0.6), 0, 360)
            e.DrawArc(Letter_Pen, Dx, CInt(Dy + LHight - LHight * 0.6), LWidth, CInt(LHight * 0.6), 0, 135)
            e.DrawLine(Letter_Pen, Dx + LWidth, CInt(Dy + LHight * 0.6 / 2), Dx + LWidth, CInt(Dy + LHight - LHight * 0.6 / 2))
    End If

    End Sub
    */
    //endregion

    public class Ans_Sheet_Questions {
        public int Total_Choice;
        public int Total_Column;

        public Ans_Sheet_Questions() {
            Total_Choice = 5;
            Total_Column = 2;
        }
    }

    public int Get_Ans_Sheet_Questions(int Ans_Sheet_Type, Ans_Sheet_Questions ASQuestions) {
        int Ans_Sheet_Questions_Return = 0;
        if (Ans_Sheet_Type == 1) {
            Ans_Sheet_Questions_Return = 60
            Total_Choice = 5;
            Total_Column = 2;
        } else if (Ans_Sheet_Type == 2) {
            Ans_Sheet_Questions_Return = 120;
            Total_Choice = 5;
            Total_Column = 2;
        } else if (Ans_Sheet_Type == 3) {
            Ans_Sheet_Questions_Return = 180;
            Total_Choice = 4;
            Total_Column = 3;
        } else {
            Ans_Sheet_Questions_Return = 0;
            //MsgBox("Answer Sheet Type Error", MsgBoxStyle.Critical)
        }

        return Ans_Sheet_Questions_Return;
    }

    //region Verify Image
    /*
    Public Sub Save_And_Display_VerifyImage(ByVal BmOmr As Bitmap, ByVal File_Name As String)

    Dim Dest_File As String

    If My.Computer.FileSystem.DirectoryExists(Application.StartupPath & "\OMRVerify_Image") = False Then
    Try
                My.Computer.FileSystem.CreateDirectory(Application.StartupPath & "\OMRVerify_Image")
    Catch ex As Exception
    MsgBox("Can't create 'OMRVerify Image' folder")
    End Try
    End If

    For Each Find_File_Name As String In My.Computer.FileSystem.GetFiles(Application.StartupPath & "\OMRVerify_Image", FileIO.SearchOption.SearchTopLevelOnly)

    Try
    If My.Computer.FileSystem.FileExists(Find_File_Name) = True Then
                    My.Computer.FileSystem.DeleteFile(Find_File_Name)
    End If
    Catch ex As Exception
    MsgBox("Error when deleting previous verify image", MsgBoxStyle.Critical)
    End Try

    Next

            Dest_File = Application.StartupPath & "\OMRVerify_Image\OMRVerifyImage." & Get_File_Extension(File_Name)

        BmOmr.Save(Dest_File)

            System.Diagnostics.Process.Start(Dest_File)

    End Sub
    */
    //endregion

    public double Get_Alignment_Point_Brightness_Level() {
        return Ali_Bri_Level;
    }

    //region RGB To Gray
    /*
    public Function Get_RGB_Gray_Bitmap(ByVal File_Name As String)

    Dim BmSource As Bitmap
    Dim BmDest As Bitmap
    Dim x As Integer
    Dim y As Integer
    Dim PColor As System.Drawing.Color

            BmSource = New Bitmap(File_Name)

    BmDest = New Bitmap(BmSource.Width, BmSource.Height, System.Drawing.Imaging.PixelFormat.Format24bppRgb)

    For x = 0 To BmSource.Width - 1
    For y = 0 To BmSource.Height - 1
    PColor = BmSource.GetPixel(x, y)
            BmDest.SetPixel(x, y, PColor)
    Next
            Next

    Get_RGB_Gray_Bitmap = BmDest

        BmSource.Dispose()

    End Function
    */
    //endregion

    //region Show Marked Bubbles
    /*
    Public Function Show_Marked_Bubbles(ByVal File_Name As String, _
            ByRef Error_Msg As String, _
                                                ByVal Ans_Sheet_Type As Integer) As Bitmap

    Dim BmOmr As Bitmap
    Dim Left_x(4) As Integer
    Dim Right_x(4) As Integer
    Dim Top_y(4) As Integer
    Dim Bottom_y(4) As Integer

    Dim i As SByte
    Dim Ali_x(4) As Integer
    Dim Ali_y(4) As Integer

    Dim Digit_Cnt As SByte
    Dim Digit_Place As SByte
    Dim Qu_Num As Integer
    Dim Choice As SByte
    Dim Dx As Integer
    Dim Dy As Integer
    Dim Line_Len As Integer
    Dim Digit_Mark(4, 10) As Boolean 'Digit Place, Digit Count
    Dim Answer_Mark(-1, -1) As Boolean 'Tot Qu, Choice

    BmOmr = Get_RGB_Gray_Bitmap(File_Name)

    Error_Msg = ""

    If Alignment_Detect(BmOmr, Ali_x, Ali_y, Ans_Sheet_Type) = False Then
    Error_Msg = "Alignment Error"
    Show_Marked_Bubbles = BmOmr
    Exit Function
    End If

    Line_Len = Bubble_Width * XRatio * 1.5

    For i = 1 To 4
    Call Mark_Point(BmOmr, Ali_x(i), Ali_y(i), Line_Len)
    Next

    Call Get_All_Bubble_Mark(Total_Qu, BmOmr, Digit_Mark, Answer_Mark)

    For Digit_Cnt = 1 To 10
    For Digit_Place = 1 To 4
    If Digit_Mark(Digit_Place, Digit_Cnt) = True Then

    Call Get_RollNumber_Bubble(Digit_Cnt, Digit_Place, Dx, Dy)

    Error_Msg = Mark_Point(BmOmr, Dx, Dy, Line_Len)

    If Error_Msg <> "" Then
            Show_Marked_Bubbles = BmOmr
    Exit Function
    End If

    End If
    Next
            Next

    For Qu_Num = 1 To Total_Qu
    For Choice = 1 To Total_Choice
    If Answer_Mark(Qu_Num, Choice) = True Then

    Call Get_Bubble(Qu_Num, Choice, Total_Column, Dx, Dy)

    Error_Msg = Mark_Point(BmOmr, Dx, Dy, Line_Len)

    If Error_Msg <> "" Then
            Show_Marked_Bubbles = BmOmr
    Exit Function
    End If

    End If
    Next
            Next

    Show_Marked_Bubbles = BmOmr

    End Function
    */
    //endregion

    //region Show_Detected_Points
    /*
    Public Function Show_Detected_Points(ByVal File_Name As String, _
            ByVal Ans_Sheet_Type As Integer) As Bitmap

    Dim BmOmr As Bitmap
    Dim Left_x(4) As Integer
    Dim Right_x(4) As Integer
    Dim Top_y(4) As Integer
    Dim Bottom_y(4) As Integer

    Dim i As SByte
    Dim Ali_x(4) As Integer
    Dim Ali_y(4) As Integer

    Dim Qu_Num As Integer
    Dim Choice As SByte
    Dim Dx As Integer
    Dim Dy As Integer

    Dim Digit_Cnt As SByte
    Dim Digit_Place As SByte

    BmOmr = Get_RGB_Gray_Bitmap(File_Name)

    If Alignment_Detect(BmOmr, Ali_x, Ali_y, Ans_Sheet_Type) = False Then
    MsgBox("Alignment Error", MsgBoxStyle.Critical)
    Show_Detected_Points = BmOmr
    Exit Function
    End If

    For i = 1 To 4
    Call Mark_Point(BmOmr, Ali_x(i), Ali_y(i), BmOmr.Height / 40)
    Next

    For i = 1 To Right_Ali_Points_Cnt
    Call Mark_Point(BmOmr, Right_Ali_x(i), Right_Ali_y(i), BmOmr.Height / 40)
    Next

    For i = 1 To Bottom_Ali_Points_Cnt
    Call Mark_Point(BmOmr, Bottom_Ali_x(i), Bottom_Ali_y(i), BmOmr.Height / 40)
    Next

    For Qu_Num = 1 To Total_Qu
    For Choice = 1 To Total_Choice
    Call Get_Bubble(Qu_Num, Choice, Total_Column, Dx, Dy)
    Call Mark_Point(BmOmr, Dx, Dy, BmOmr.Height / 40)
    Call Show_Bubble_Mark(BmOmr, Dx, Dy)
    Next
            Next

    For Digit_Cnt = 1 To 10
    For Digit_Place = 1 To 4
    Call Get_RollNumber_Bubble(Digit_Cnt, Digit_Place, Dx, Dy)
    Call Mark_Point(BmOmr, Dx, Dy, BmOmr.Height / 40)
    Call Show_Bubble_Mark(BmOmr, Dx, Dy)
    Next
            Next

    Show_Detected_Points = BmOmr

    End Function
    */
    //endregion

    //region Show_Bubble_Mark
    /*
    Public Sub Show_Bubble_Mark(ByRef BmOmr As Bitmap, _
            ByVal Bubble_x As Integer, _
                                        ByVal Bubble_y As Integer)

    Dim x As Integer
    Dim y As Integer
    Dim Omr_Bubble_Height As Integer
    Dim Omr_Bubble_Width As Integer
    Dim Tot_Bri As Double

    Omr_Bubble_Width = Math.Round(Bubble_Width * XRatio)
    Omr_Bubble_Height = Math.Round(Bubble_Height * YRatio)

    Tot_Bri = 0

    y = Bubble_y - (Omr_Bubble_Height / 2)
    For x = Bubble_x - (Omr_Bubble_Width / 2) To Bubble_x + (Omr_Bubble_Width / 2)
    If x >= BmOmr.Width Or y >= BmOmr.Height Or x < 0 Or y < 0 Then Continue For
            BmOmr.SetPixel(x, y, Color.Red)
    Next

            y = Bubble_y + (Omr_Bubble_Height / 2)
    For x = Bubble_x - (Omr_Bubble_Width / 2) To Bubble_x + (Omr_Bubble_Width / 2)
    If x >= BmOmr.Width Or y >= BmOmr.Height Or x < 0 Or y < 0 Then Continue For
            BmOmr.SetPixel(x, y, Color.Red)
    Next

            x = Bubble_x - (Omr_Bubble_Width / 2)
    For y = Bubble_y - (Omr_Bubble_Height / 2) To Bubble_y + (Omr_Bubble_Height / 2)
    If x >= BmOmr.Width Or y >= BmOmr.Height Or x < 0 Or y < 0 Then Continue For
            BmOmr.SetPixel(x, y, Color.Red)
    Next

            x = Bubble_x + (Omr_Bubble_Width / 2)
    For y = Bubble_y - (Omr_Bubble_Height / 2) To Bubble_y + (Omr_Bubble_Height / 2)
    If x >= BmOmr.Width Or y >= BmOmr.Height Or x < 0 Or y < 0 Then Continue For
            BmOmr.SetPixel(x, y, Color.Red)
    Next

    End Sub
    */
    //endregion

    //region Mark_Point
    /*
    Public Function Mark_Point(ByRef BmOmr As Bitmap, _
            ByVal Mark_x As Integer, _
                                       ByVal Mark_y As Integer, _
                                       ByVal Line_Len As Integer) As String

    Dim x As Integer
    Dim y As Integer

    Mark_Point = ""

    y = Mark_y

    For x = Mark_x - (Line_Len / 2) To Mark_x + (Line_Len / 2)

    If x >= BmOmr.Width Or y >= BmOmr.Height Or x < 0 Or y < 0 Then Continue For

            Try
                BmOmr.SetPixel(x, y, Color.Red)
    Catch ex As Exception
    Mark_Point = "File Format Error"
    End Try

    Next

            x = Mark_x

    For y = Mark_y - (Line_Len / 2) To Mark_y + (Line_Len / 2)

    If x >= BmOmr.Width Or y >= BmOmr.Height Or x < 0 Or y < 0 Then Continue For

            Try
                BmOmr.SetPixel(x, y, Color.Red)
    Catch ex As Exception
    Mark_Point = "File Format Error"
    End Try

    Next

    End Function
    */
    //endregion

    //region ClearFolder
    /*
    Public Sub ClearFolder(ByVal OMR_Folder As String)

    Dim Er_File As Boolean = False

    If My.Computer.FileSystem.DirectoryExists(OMR_Folder) = False Then
    MsgBox("Image Folder Error", MsgBoxStyle.Critical)
    Exit Sub
    End If

    If MsgBox("Clear OMR Image Folder...?" & vbCrLf & "It will delete all the scanned images...", MsgBoxStyle.YesNo + MsgBoxStyle.Question) = MsgBoxResult.No Then Exit Sub

    For Each File_Name As String In My.Computer.FileSystem.GetFiles(OMR_Folder, FileIO.SearchOption.SearchTopLevelOnly)

    Try
    If My.Computer.FileSystem.FileExists(File_Name) = True Then
                    My.Computer.FileSystem.DeleteFile(File_Name)
    End If
    Catch ex As Exception
    Er_File = True
    MsgBox("Can't Delete the following file..." & vbCrLf & Get_File_Name_From_Path(File_Name) & vbCrLf & "Delete it manually", MsgBoxStyle.Critical)
    End Try

    Next

    If Er_File = False Then

    For Each File_Name As String In My.Computer.FileSystem.GetFiles(OMR_Folder, FileIO.SearchOption.SearchTopLevelOnly)

    Try
    If My.Computer.FileSystem.FileExists(File_Name) = True Then
                        My.Computer.FileSystem.DeleteFile(File_Name)
    End If
    Catch ex As Exception
    Er_File = True
    MsgBox("Can't Delete the following file..." & vbCrLf & Get_File_Name_From_Path(File_Name) & vbCrLf & "Delete it manually", MsgBoxStyle.Critical)
    End Try

    Next

    End If

    If Er_File = False Then
    MsgBox("Folder Cleared.", MsgBoxStyle.Information)
    Else
    Call Open_Folder(OMR_Folder)
    End If

    End Sub
    */
    //endregion

    //region Open_Folder
    /*
    Public Sub Open_Folder(ByVal OMR_Folder As String)

    If My.Computer.FileSystem.DirectoryExists(OMR_Folder) = False Then
    MsgBox("Image Folder Error", MsgBoxStyle.Critical)
    Exit Sub
    End If

        System.Diagnostics.Process.Start(OMR_Folder)

    End Sub
    */
    //endregion

    public class Allignment_Mark_Area {
        public int Left_x[];
        public int Right_x[];
        public int Top_y[];
        public int Bottom_y[];
        public int Ali_Squ_Thick_Max_X;
        public int Ali_Squ_Thick_Max_Y;
        public int Ali_Squ_Thick_Min_X;
        public int Ali_Squ_Thick_Min_Y;
        public int Ali_Blank_Space_X;
        public int Ali_Blank_Space_Y;
    }

    public void Get_Allignment_Mark_Area(int Sheet_Hight, int Sheet_Width, int Ans_Sheet_Type, Allignment_Mark_Area AMArea) {

        double X_Ratio;
        double Y_Ratio;
        int i;

        Load_Alignment(Ans_Sheet_Type);

        Sheet_Hight -= 1;
        Sheet_Width -= 1;

        X_Ratio = Sheet_Width / (Def_TR_x + Def_TL_x);
        Y_Ratio = Sheet_Hight / (Def_BL_y + Def_TL_y);

        //Top Left Allignment Area
        AMArea.Left_x[1] = 0;
        AMArea.Right_x[1] = (int) (X_Ratio * (Def_TL_x + 93));
        AMArea.Top_y[1] = 0;
        AMArea.Bottom_y[1] = (int) (Y_Ratio * (Def_TL_y + 93));

        //Top Right Allignment Area
        AMArea.Left_x[2] = (int) (X_Ratio * (Def_TR_x - 93));
        AMArea.Right_x[2] = Sheet_Width;
        AMArea.Top_y[2] = 0;
        AMArea.Bottom_y[2] = (int) (Y_Ratio * (Def_TR_y + 93));

        //Bottom Right Allignment Area
        AMArea.Left_x[3] = (int) (X_Ratio * (Def_BR_x - 93));
        AMArea.Right_x[3] = Sheet_Width;
        AMArea.Top_y[3] = (int) (Y_Ratio * (Def_BR_y - 93));
        AMArea.Bottom_y[3] = Sheet_Hight;

        //Bottom Left Allignment Area
        AMArea.Left_x[4] = 0;
        AMArea.Right_x[4] = (int) (X_Ratio * (Def_BL_x + 93));
        AMArea.Top_y[4] = (int) (Y_Ratio * (Def_BL_y - 93));
        AMArea.Bottom_y[4] = Sheet_Hight;

        for (i = 0; i <= 4; i++) {
            if (AMArea.Left_x[i] < 0) AMArea.Left_x[i] = 0;
            if (AMArea.Right_x[i] > Sheet_Width) AMArea.Right_x[i] = Sheet_Width;
            if (AMArea.Top_y[i] < 0) AMArea.Top_y[i] = 0;
            if (AMArea.Bottom_y[i] > Sheet_Hight) AMArea.Bottom_y[i] = Sheet_Hight;
        }

        AMArea.Ali_Blank_Space_X = (int) (X_Ratio * Squ_Blank_Space_x);
        AMArea.Ali_Blank_Space_Y = (int) (Y_Ratio * Squ_Blank_Space_y);

        AMArea.Ali_Squ_Thick_Max_X = (int) (X_Ratio * Squ_Thick * Squ_Thick_Max / 100);
        AMArea.Ali_Squ_Thick_Max_Y = (int) (Y_Ratio * Squ_Thick * Squ_Thick_Max / 100);

        AMArea.Ali_Squ_Thick_Min_X = (int) (X_Ratio * Squ_Thick * Squ_Thick_Min / 100);
        AMArea.Ali_Squ_Thick_Min_Y = (int) (Y_Ratio * Squ_Thick * Squ_Thick_Min / 100);
    }

    public Point Get_Right_Ali_Point_Def(int Point_Num) {

        int Right_Ali_Len;
        Point rP = new Point(0, 0);

        rP.x = (int) (Def_TR_x - Def_TL_x + Mid_Ali_Shift);
        rP.y = 0;

        Right_Ali_Len = (int) (Def_BR_y - Def_TR_y) / (Right_Ali_Points_Cnt + 1);

        rP.y += (Right_Ali_Len * Point_Num);

        return rP;
    }

    private class Vertical_Line {

        public double Tfx;
        public double Tfy;
        public double Bfx;
        public double Bfy;

        public Vertical_Line(double _Tfx, double _Tfy, double _Bfx, double _Bfy) {
            this.Tfx = _Tfx;
            this.Tfy = _Tfy;
            this.Bfx = _Bfx;
            this.Bfy = _Bfy;
        }
    }

    private void Get_Vertical_Line_Mid_Ali(double In_x, double In_y, Vertical_Line vLine) {

        double Ll; //Section Formula ' l' at Left
        double Lm; //Section Formula ' m' at Left

        Bottom_Point bPoint = new Bottom_Point((int) vLine.Bfx, (int) vLine.Bfy);
        Get_Bottom_Point(In_x, bPoint);
        vLine.Bfx = bPoint.Bx;
        vLine.Bfy = bPoint.By;

        Ll = vLine.Bfx - BL_x;
        Lm = BR_x - vLine.Bfx;

        Section_Formula_Para sfPara = new Section_Formula_Para(vLine.Tfx, vLine.Tfy);
        Section_Formula(TL_x, TL_y, TR_x, TR_y, Ll, Lm, sfPara);
        vLine.Tfx = sfPara.x;
        vLine.Tfy = sfPara.y;
    }

    private class Section_Formula_Para {

        double x;
        double y;

        public Section_Formula_Para(double _x, double _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    private void Section_Formula(double x1, double y1, double x2, double y2, double l, double m, Section_Formula_Para para) {

        para.x = ((l * x2) + (m * x1)) / (l + m);
        para.y = ((l * y2) + (m * y1)) / (l + m);
    }

    private class Bottom_Point {
        int Bx;
        int By;

        public Bottom_Point(int _Bx, int _By) {
            this.Bx = _Bx;
            this.By = _By;
        }
    }

    private void Get_Bottom_Point(double In_x, Bottom_Point bPoint) {

        Point Right = new Point(0, 0);
        int Left_x;
        int Left_y;
        int i;
        boolean Find_Ok;
        double Rl; //Section Formula ' l' at Right
        double Rm; //Section Formula ' m' at Right
        Point Act_Right = new Point(0, 0);
        int Act_Left_x;
        int Act_Left_y;

        Left_x = 0;
        Left_y = 0;
        Act_Left_x = (int) BL_x;
        Act_Left_y = (int) BL_y;
        Find_Ok = false;

        for (i = 1; i <= Bottom_Ali_Points_Cnt; i++) {

            Right = Get_Bottom_Ali_Point_Def(i);

            Act_Right.x = Bottom_Ali[i].x;
            Act_Right.y = Bottom_Ali[i].y;

            if (Left_x <= In_x && In_x < Right.x) {
                Find_Ok = true;
                break;
            }

            Left_x = Right.x;
            Left_y = Right.y;

            Act_Left_x = Act_Right.x;
            Act_Left_y = Act_Right.y;
        }

        if (!Find_Ok) {
            Right.x = (int) (Def_BR_x - Def_BL_x);
            Right.y = 0;
            Act_Right.x = (int) BR_x;
            Act_Right.y = (int) BR_y;
        }

        Rl = In_x - Left_x;
        Rm = Right.x - In_x;

        Section_Formula_Para sfPara = new Section_Formula_Para(bPoint.Bx, bPoint.By);
        Section_Formula(Act_Left_x, Act_Left_y, Act_Right.x, Act_Right.y, Rl, Rm, sfPara);
        bPoint.Bx = (int) sfPara.x;
        bPoint.By = (int) sfPara.y;
    }

    public Point Get_Bottom_Ali_Point_Def(int Point_Num) {

        int Bottom_Ali_Len;
        Point rP = new Point(0, 0);

        rP.x = 0;
        rP.y = -Mid_Ali_Shift;

        Bottom_Ali_Len = (int) (Def_BR_x - Def_BL_x) / (Bottom_Ali_Points_Cnt + 1);

        rP.x += (Bottom_Ali_Len * Point_Num);

        return rP;
    }

    public Point Get_Point(double In_x, double In_y) {

        double Tfx = 0;
        double Tfy = 0;
        double Bfx = 0;
        double Bfy = 0;
        double Lfx = 0;
        double Lfy = 0;
        double Rfx = 0;
        double Rfy = 0;

        Vertical_Line vLine = new Vertical_Line(Tfx, Tfy, Bfx, Bfy);
        Get_Vertical_Line(In_x, In_y, vLine);
        Tfx = vLine.Tfx;
        Tfy = vLine.Tfy;
        Bfx = vLine.Bfx;
        Bfy = vLine.Bfy;

        Horizontal_Line hLine = new Horizontal_Line(Lfx, Lfy, Rfx, Rfy);
        Get_Horizontal_Line(In_x, In_y, hLine);
        Lfx = hLine.Lfx;
        Lfy = hLine.Lfy;
        Rfx = hLine.Rfx;
        Rfy = hLine.Rfy;

        return Get_Intersection_Of_Two_Line_A_And_B((int) Lfx, (int) Lfy, (int) Rfx, (int) Rfy, (int) Bfx, (int) Bfy, (int) Tfx, (int) Tfy);
    }

    private class Horizontal_Line {

        public double Lfx;
        public double Lfy;
        public double Rfx;
        public double Rfy;

        public Horizontal_Line(double _Lfx, double _Lfy, double _Rfx, double _Rfy) {
            this.Lfx = _Lfx;
            this.Lfy = _Lfy;
            this.Rfx = _Rfx;
            this.Rfy = _Rfy;
        }
    }

    private void Get_Horizontal_Line(double In_x, double In_y, Horizontal_Line hLine) {

        double Ll; //Section Formula 'l' at Left
        double Lm; //Section Formula 'm' at Left
        double Rl; //Section Formula 'l' at Right
        double Rm; //Section Formula 'm' at Right

        Ll = In_y;
        Lm = Def_BL_y - Def_TL_y - In_y;

        Rl = In_y;
        Rm = Def_BR_y - Def_TR_y - Rl;

        Section_Formula_Para sfParaL = new Section_Formula_Para(hLine.Lfx, hLine.Lfy);
        Section_Formula(BL_x, BL_y, TL_x, TL_y, Ll, Lm, sfParaL);
        hLine.Lfx = sfParaL.x;
        hLine.Lfy = sfParaL.y;

        Section_Formula_Para sfParaR = new Section_Formula_Para(hLine.Rfx, hLine.Rfy);
        Section_Formula(BR_x, BR_y, TR_x, TR_y, Rl, Rm, sfParaR);
        hLine.Rfx = sfParaR.x;
        hLine.Rfy = sfParaR.y;
    }

    private void Get_Vertical_Line(double In_x, double In_y, Vertical_Line vLine) {

        double Tl; //Section Formula ' l ' at Top
        double Tm; //Section Formula ' m ' at Top
        double Bl; //Section Formula ' l ' at Bottom
        double Bm; //Section Formula ' m ' at Bottom

        Tl = In_x;
        Tm = Def_TR_x - Def_TL_x - In_x;

        Bl = In_x;
        Bm = Def_BR_x - Def_BL_x - In_x;

        Section_Formula_Para sfParaT = new Section_Formula_Para(vLine.Tfx, vLine.Tfy);
        Section_Formula(TL_x, TL_y, TR_x, TR_y, Tl, Tm, sfParaT);
        vLine.Tfx = sfParaT.x;
        vLine.Tfy = sfParaT.y;

        Section_Formula_Para sfParaB = new Section_Formula_Para(vLine.Bfx, vLine.Bfy);
        Section_Formula(BL_x, BL_y, BR_x, BR_y, Bl, Bm, sfParaB);
        vLine.Bfx = sfParaB.x;
        vLine.Bfy = sfParaB.y;
    }

    public Point Get_Intersection_Of_Two_Line_A_And_B(int Ax1, int Ay1, int Ax2, int Ay2, int Bx1, int By1, int Bx2, int By2) {

        Point iP = new Point(0, 0);
        double PartA;
        double PartB;
        double PartC;

        if (Ax1 == Ax2) {
            iP.x = Ax1;
        } else if (Bx1 == Bx2) {
            iP.x = Bx1;
        } else {
            PartA = ((Ay1 - Ay2) / (Ax1 - Ax2)) - ((By1 - By2) / (Bx1 - Bx2));
            PartB = ((Bx1 * By2) - (Bx2 * By1)) / (Bx1 - Bx2);
            PartC = ((Ax1 * Ay2) - (Ax2 * Ay1)) / (Ax1 - Ax2);

            try {
                iP.x = (int) ((PartB - PartC) / PartA);
            } catch (Exception e) {
                iP.x = 0;
            }
        }

        if (By1 == By2) {
            iP.y = By1;
        } else if (Ay1 == Ay2) {
            iP.y = Ay1;
        } else {

            PartA = ((Ax1 - Ax2) / (Ay1 - Ay2)) - ((Bx1 - Bx2) / (By1 - By2));
            PartB = ((By1 * Bx2) - (By2 * Bx1)) / (By1 - By2);
            PartC = ((Ay1 * Ax2) - (Ay2 * Ax1)) / (Ay1 - Ay2);

            try {
                iP.y = (int) ((PartB - PartC) / PartA);
            } catch (Exception e) {
                iP.y = 0;
            }
        }

        return iP;
    }

    public void Set_Default_Alignment(int Ans_Sheet_Code) {

        int i;

        Load_Alignment(Ans_Sheet_Code);

        TL_x = Def_TL_x;
        TL_y = Def_TL_y;

        TR_x = Def_TR_x;
        TR_y = Def_TR_y;

        BL_x = Def_BL_x;
        BL_y = Def_BL_y;

        BR_x = Def_BR_x;
        BR_y = Def_BR_y;

        for (i = 1; i <= Right_Ali_Points_Cnt; i++) {
            Right_Ali[i] = Get_Right_Ali_Point_Def(i);
            Right_Ali[i] = Get_Point(Right_Ali[i].x, Right_Ali[i].y);
        }

        for (i = 1; i <= Bottom_Ali_Points_Cnt; i++) {
            Bottom_Ali[i] = Get_Bottom_Ali_Point_Def(i);
            Bottom_Ali[i] = Get_Point(Bottom_Ali[i].x, Bottom_Ali[i].y);
        }

        Calculate_Side_Length_And_Ratio();
    }

    public void Set_Alignment(double In_TL_x, double In_TL_y, double In_TR_x, double In_TR_y, double In_BL_x, double In_BL_y, double In_BR_x, double In_BR_y, int Ans_Sheet_Type) {

        Load_Alignment(Ans_Sheet_Type);

        TL_x = In_TL_x;
        TL_y = In_TL_y;

        TR_x = In_TR_x;
        TR_y = In_TR_y;

        BL_x = In_BL_x;
        BL_y = In_BL_y;

        BR_x = In_BR_x;
        BR_y = In_BR_y;

        Calculate_Side_Length_And_Ratio();
    }

    public void Calculate_Side_Length_And_Ratio() {

        Top_Len = java.lang.Math.sqrt(java.lang.Math.pow((TL_x - TR_x), 2) + java.lang.Math.pow((TL_y - TR_y), 2));
        Bottom_Len = java.lang.Math.sqrt(java.lang.Math.pow((BL_x - BR_x), 2) + java.lang.Math.pow((BL_y - BR_y), 2));
        Left_Len = java.lang.Math.sqrt(java.lang.Math.pow((TL_x - BL_x), 2) + java.lang.Math.pow((TL_y - BL_y), 2));
        Right_Len = java.lang.Math.sqrt(java.lang.Math.pow((TR_x - BR_x), 2) + java.lang.Math.pow((TR_y - BR_y), 2));

        XRatio_Top = Top_Len / (Def_TR_x - Def_TL_x);
        XRatio_Bottom = Bottom_Len / (Def_BR_x - Def_BL_x);

        YRatio_Left = Left_Len / (Def_TL_y - Def_BL_y);
        YRatio_Right = Right_Len / (Def_TR_y - Def_BR_y);

        XRatio = (Top_Len + Bottom_Len) / ((Def_TR_x - Def_TL_x) + ((Def_BR_x - Def_BL_x)));
        YRatio = (Left_Len + Right_Len) / ((Def_TL_y - Def_BL_y) + (Def_TR_y - Def_BR_y));

        XRatio_Top = java.lang.Math.abs(XRatio_Top);
        XRatio_Bottom = java.lang.Math.abs(XRatio_Bottom);
        YRatio_Left = java.lang.Math.abs(YRatio_Left);
        YRatio_Right = java.lang.Math.abs(YRatio_Right);
        XRatio = java.lang.Math.abs(XRatio);
        YRatio = java.lang.Math.abs(YRatio);
    }

    public PointD Get_Point_Mid_Ali(PointD In) {

        PointD Out = new PointD(0, 0);
        PointD Tf = new PointD(0,0);
        PointD Bf = new PointD(0,0);
        Dim Lfx As Double
        Dim Lfy As Double
        Dim Rfx As Double
        Dim Rfy As Double

        Call Get_Vertical_Line_Mid_Ali (In_x, In_y, Tfx, Tfy, Bfx, Bfy)
        Call Get_Horizontal_Line_Mid_Ali (In_x, In_y, Lfx, Lfy, Rfx, Rfy)

        Call Get_Intersection_Of_Two_Line_A_And_B
        (Lfx, Lfy, Rfx, Rfy, Bfx, Bfy, Tfx, Tfy, Out_x, Out_y)

        End Sub

        Private Sub Get_Horizontal_Line_Mid_Ali(ByVal In_x As Double, _
                ByVal In_y As Double, _
                ByRef Lfx As Double, _
                ByRef Lfy As Double, _
                ByRef Rfx As Double, _
                ByRef Rfy As Double)

        Dim Ll As Double 'Section Formula ' l ' at Left
        Dim Lm As Double 'Section Formula ' m ' at Left

        Call Get_Right_Point (In_y, Rfx, Rfy)

        Ll = Rfy - BR_y
        Lm = TR_y - Rfy

        Call Section_Formula (BL_x, BL_y, TL_x, TL_y, Ll, Lm, Lfx, Lfy)

    }







    Private Sub Get_Right_Point(ByVal In_y As Double, _
            ByRef Rx As Integer, _
                                        ByRef Ry As Integer)

    Dim Top_x As Integer
    Dim Top_y As Integer
    Dim Bottom_x As Integer
    Dim Bottom_y As Integer
    Dim i As Integer
    Dim Find_Ok As Boolean
    Dim Rl As Double 'Section Formula 'l' at Right
    Dim Rm As Double 'Section Formula 'm' at Right
    Dim Act_Top_x As Integer
    Dim Act_Top_y As Integer
    Dim Act_Bottom_x As Integer
    Dim Act_Bottom_y As Integer

    Bottom_x = Def_BR_x - Def_BL_x
            Bottom_y = 0
    Act_Bottom_x = BR_x
            Act_Bottom_y = BR_y
    Find_Ok = False

    For i = 1 To Right_Ali_Points_Cnt

    Call Get_Right_Ali_Point_Def(i, Top_x, Top_y)

    Act_Top_x = Right_Ali_x(i)
    Act_Top_y = Right_Ali_y(i)

    If Bottom_y <= In_y And In_y < Top_y Then
    Find_Ok = True
    Exit For
    End If

    Bottom_x = Top_x
            Bottom_y = Top_y

    Act_Bottom_x = Act_Top_x
            Act_Bottom_y = Act_Top_y

    Next

    If Find_Ok = False Then
            Top_x = Def_TR_x - Def_TL_x
    Top_y = Def_BR_y - Def_TR_y
            Act_Top_x = TR_x
    Act_Top_y = TR_y
    End If

    Rl = In_y - Bottom_y
            Rm = Top_y - In_y

    Call Section_Formula(Act_Bottom_x, Act_Bottom_y, Act_Top_x, Act_Top_y, Rl, Rm, Rx, Ry)

    End Sub







    Public Function Get_RollNo_Mark_Brightness(ByRef BmOmr As Bitmap, _
            ByVal Digit_Cnt As Integer, _
                                                       ByVal Digit_Place As SByte) As Double

    Dim Bubble_x As Integer
    Dim Bubble_y As Integer

    Call Get_RollNumber_Bubble(Digit_Cnt, Digit_Place, Bubble_x, Bubble_y)

    Get_RollNo_Mark_Brightness = Get_Bubble_Mark_Brightness(BmOmr, Bubble_x, Bubble_y)

    End Function

    Public Sub Get_Bubble(ByVal Qu_Num As Integer, _
            ByVal Choice As SByte, _
                                  ByVal Total_Column As SByte, _
                                  ByRef Bubble_x As Integer, _
                                  ByRef Bubble_y As Integer)

    Dim Bx As Double
    Dim By As Double
    Dim ColumnIndex As Integer
    Dim By_Num As Integer

    If Qu_Num > Total_Qu Or Choice > 5 Then MsgBox("Error", MsgBoxStyle.Critical)

    Bx = Bubble_Offset_x + Choice * Bubble_Hori_Space

            ColumnIndex = Int((Qu_Num - 1) / (Total_Qu / Total_Column))

    Bx = Bx + (Bubble_Col_Offset * ColumnIndex)

    By_Num = Qu_Num - (ColumnIndex * (Total_Qu / Total_Column))

    By = Bubble_Offset_y - ((By_Num - 1) * Bubble_Vert_Space)

            'Call Get_Point(Bx, By, Bubble_x, Bubble_y)
    Call Get_Point_Mid_Ali(Bx, By, Bubble_x, Bubble_y)

    End Sub

    Public Function Get_Ans_Bubble_Mark_Brightness(ByRef BmOmr As Bitmap, _
            ByVal Qu_Num As Integer, _
                                                           ByVal Choice As SByte) As Double

    Dim Bubble_x As Integer
    Dim Bubble_y As Integer

    Call Get_Bubble(Qu_Num, Choice, Total_Column, Bubble_x, Bubble_y)
    Get_Ans_Bubble_Mark_Brightness = Get_Bubble_Mark_Brightness(BmOmr, Bubble_x, Bubble_y)

    End Function

    Public Function Get_Bubble_Mark_Brightness(ByRef BmOmr As Bitmap, _
            ByVal Bubble_x As Integer, _
                                                       ByVal Bubble_y As Integer) As Double

    Dim x As Integer
    Dim y As Integer
    Dim Omr_Bubble_Height As Integer
    Dim Omr_Bubble_Width As Integer
    Dim Tot_Bri As Double
    Dim Tot_Cnt As Integer

    Omr_Bubble_Width = Math.Round(Bubble_Width * XRatio)
    Omr_Bubble_Height = Math.Round(Bubble_Height * YRatio)

    Tot_Bri = 0
    Tot_Cnt = 0

    For x = Bubble_x - (Omr_Bubble_Width / 2) To Bubble_x + (Omr_Bubble_Width / 2)
    For y = Bubble_y - (Omr_Bubble_Height / 2) To Bubble_y + (Omr_Bubble_Height / 2)
    Tot_Bri += BmOmr.GetPixel(x, y).GetBrightness
    Tot_Cnt += 1
    Next
            Next

    Get_Bubble_Mark_Brightness = Tot_Bri / Tot_Cnt

    End Function

    Public Function Get_Ali_Rotation_Mark(ByRef BmOmr As Bitmap, _
            ByVal Ax As Integer, _
                                                  ByVal Ay As Integer, _
                                                  Optional ByRef Avg_Bri As Double = 0) As Boolean

    Dim x As Integer
    Dim y As Integer
    Dim Omr_Bubble_Height As Integer
    Dim Omr_Bubble_Width As Integer
    Dim Tot_Bri As Double
    Dim Tot_Cnt As Integer

    Omr_Bubble_Width = Math.Round(Bubble_Width * XRatio)
    Omr_Bubble_Height = Math.Round(Bubble_Height * YRatio)

    Tot_Bri = 0
    Tot_Cnt = 0

    For x = Ax - (Squ_Thick / 2) To Ax + (Squ_Thick / 2)
    For y = Ay - (Squ_Thick / 2) To Ay + (Squ_Thick / 2)
    Tot_Bri += BmOmr.GetPixel(x, y).GetBrightness
    Tot_Cnt += 1
    Next
            Next

    Avg_Bri = Tot_Bri / Tot_Cnt

    If Avg_Bri < Ali_Bri_Level Then
            Get_Ali_Rotation_Mark = True
    Else
            Get_Ali_Rotation_Mark = False
    End If

    End Function

    Public Function Get_Center_Alignment_Mark(ByRef BmOmr As Bitmap) As Boolean

    Dim Ax As Integer
    Dim Ay As Integer
    Dim i As Integer

    For i = 1 To Bottom_Ali_Points_Cnt
    Call Get_Bottom_Ali_Point_Def(i, Ax, Ay)
    Call Get_Point(Ax, Ay, Ax, Ay)
    Get_Center_Alignment_Mark = Get_Ali_Rotation_Mark(BmOmr, Ax, Ay)
    If Get_Center_Alignment_Mark = False Then Exit For
            Next

    End Function

    Public Sub Get_RollNumber_Bubble(ByVal Digit_Cnt As Integer, _
            ByVal Digit_Place As SByte, _
                                             ByRef Bubble_x As Integer, _
                                             ByRef Bubble_y As Integer)

    Dim Bx As Double
    Dim By As Double

    If Digit_Cnt > 10 Or Digit_Place > 5 Then MsgBox("Error", MsgBoxStyle.Critical)

    Bx = Bubble_RollNo_Offset_x + Digit_Place * Bubble_Hori_Space

    If Digit_Cnt > 30 Then
    Bx += 180
    By = Bubble_RollNo_Offset_y - ((Digit_Cnt - 31) * Bubble_Vert_Space)
    Else
            By = Bubble_RollNo_Offset_y - ((Digit_Cnt - 1) * Bubble_Vert_Space)
    End If

    Call Get_Point_Mid_Ali(Bx, By, Bubble_x, Bubble_y)
        'Call Get_Point(Bx, By, Bubble_x, Bubble_y)

    End Sub

    Public Function Alignment_Detect(ByRef BmOmr As Bitmap, _
            ByRef Ali_x() As Integer, _
    ByRef Ali_y() As Integer, _
    ByVal Ans_Sheet_Type As Integer) As Boolean

    Dim Left_x(4) As Integer
    Dim Right_x(4) As Integer
    Dim Top_y(4) As Integer
    Dim Bottom_y(4) As Integer
    Dim Ali_Squ_Thick_Max_X As Integer
    Dim Ali_Squ_Thick_Max_Y As Integer
    Dim Ali_Squ_Thick_Min_X As Integer
    Dim Ali_Squ_Thick_Min_Y As Integer
    Dim Ali_Blank_Space_X As Integer
    Dim Ali_Blank_Space_Y As Integer
    Dim X_Tolerance As Double
    Dim Y_Tolerance As Double
    Dim Right_Ali As Boolean
    Dim Bottom_Ali As Boolean

    If BmOmr.Height < BmOmr.Width Then
            BmOmr.RotateFlip(RotateFlipType.Rotate90FlipNone)
    End If

    Call Get_Allignment_Mark_Area(BmOmr.Height, BmOmr.Width, Left_x, Right_x, Top_y, Bottom_y, Ali_Squ_Thick_Max_X, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_X, Ali_Squ_Thick_Min_Y, Ali_Blank_Space_X, Ali_Blank_Space_Y, Ans_Sheet_Type)

    Alignment_Detect = Detect_Alignment_Points(BmOmr, False, Ali_Blank_Space_X, Ali_Blank_Space_Y, Ali_Squ_Thick_Max_X, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_X, Ali_Squ_Thick_Min_Y, Left_x, Right_x, Top_y, Bottom_y, Ali_x, Ali_y)

    If Alignment_Detect = True Then

            X_Tolerance = BmOmr.Width * Ali_Check_Tolerance / 100
    Y_Tolerance = BmOmr.Height * Ali_Check_Tolerance / 100

    Call Set_Alignment(Ali_x(1), Ali_y(1), Ali_x(2), Ali_y(2), Ali_x(4), Ali_y(4), Ali_x(3), Ali_y(3), Ans_Sheet_Type)

    If Math.Abs(Top_Len - Bottom_Len) > X_Tolerance Then
    Alignment_Detect = False
    Exit Function
    End If

    If Get_Center_Alignment_Mark(BmOmr) = False Then

    Call Rotate_Plane(Ali_x, Ali_y)
    Call Rotate_Plane(Ali_x, Ali_y)

    Call Set_Alignment(Ali_x(1), Ali_y(1), Ali_x(2), Ali_y(2), Ali_x(4), Ali_y(4), Ali_x(3), Ali_y(3), Ans_Sheet_Type)

    If Get_Center_Alignment_Mark(BmOmr) = False Then
    Alignment_Detect = False
    Exit Function
    End If

    End If

    Right_Ali = Get_Right_Ali_Positions(BmOmr, Ans_Sheet_Type)
    Bottom_Ali = Get_Bottom_Ali_Positions(BmOmr, Ans_Sheet_Type)

    If Right_Ali = True And Bottom_Ali = True Then
            Alignment_Detect = True
    Else
            Alignment_Detect = False
    End If

    End If

    End Function

    Private Sub Draw_Rectangle(ByRef Bm As Bitmap, _
            ByVal Left_x As Integer, _
                                       ByVal Right_x As Integer, _
                                       ByVal Top_y As Integer, _
                                       ByVal Bottom_y As Integer)

    Dim i As Integer

    For i = Left_x To Right_x Step (Right_x - Left_x) / Math.Abs(Right_x - Left_x)
            Bm.SetPixel(i, Top_y, Color.Red)
            Bm.SetPixel(i, Bottom_y, Color.Red)
    Next

    For i = Top_y To Bottom_y Step (Bottom_y - Top_y) / Math.Abs(Bottom_y - Top_y)
            Bm.SetPixel(Left_x, i, Color.Red)
            Bm.SetPixel(Right_x, i, Color.Red)
    Next

    End Sub

    Private Function Get_Bottom_Ali_Positions(ByRef BmOmr As Bitmap, _
            ByRef Ans_Sheet_Type As Integer) As Boolean

    Dim Point_Num As Integer
    Dim Ax As Integer
    Dim Ay As Integer
    Dim Left_x As Integer
    Dim Right_x As Integer
    Dim Top_y As Integer
    Dim Bottom_y As Integer
    Dim Hori_Squ_Thick_Max_X As Integer
    Dim Hori_Squ_Thick_Max_Y As Integer
    Dim Hori_Squ_Thick_Min_X As Integer
    Dim Hori_Squ_Thick_Min_Y As Integer
    Dim Hori_Blank_Space_X As Integer
    Dim Hori_Blank_Space_Y As Integer
    Dim Ali_x As Integer
    Dim Ali_y As Integer

    For Point_Num = 1 To Bottom_Ali_Points_Cnt

    Call Get_Bottom_Ali_Point_Def(Point_Num, Ax, Ay)
    Call Get_Point(Ax, Ay, Ax, Ay)
    Call Get_Bottom_Ali_Search_Area(Ax, Ay, BmOmr.Height, BmOmr.Width, Left_x, Right_x, Top_y, Bottom_y, Hori_Squ_Thick_Max_X, Hori_Squ_Thick_Max_Y, Hori_Squ_Thick_Min_X, Hori_Squ_Thick_Min_Y, Hori_Blank_Space_X, Hori_Blank_Space_Y, Ans_Sheet_Type)

            'Call Draw_Rectangle(BmOmr, Left_x, Right_x, Top_y, Bottom_y)

    Get_Bottom_Ali_Positions = Get_Alignment_Point(BmOmr, False, Hori_Blank_Space_X, Hori_Blank_Space_Y, Hori_Squ_Thick_Max_X, Hori_Squ_Thick_Max_Y, Hori_Squ_Thick_Min_X, Hori_Squ_Thick_Min_Y, Left_x, Right_x, Top_y, Bottom_y, Ali_x, Ali_y)

    Bottom_Ali_x(Point_Num) = Ali_x
    Bottom_Ali_y(Point_Num) = Ali_y

    If Get_Bottom_Ali_Positions = False Then
    Exit For
    End If

    Next

    End Function

    Private Function Get_Right_Ali_Positions(ByRef BmOmr As Bitmap, _
            ByRef Ans_Sheet_Type As Integer) As Boolean

    Dim Point_Num As Integer
    Dim Ax As Integer
    Dim Ay As Integer
    Dim Left_x As Integer
    Dim Right_x As Integer
    Dim Top_y As Integer
    Dim Bottom_y As Integer
    Dim Vert_Squ_Thick_Max_X As Integer
    Dim Vert_Squ_Thick_Max_Y As Integer
    Dim Vert_Squ_Thick_Min_X As Integer
    Dim Vert_Squ_Thick_Min_Y As Integer
    Dim Vert_Blank_Space_X As Integer
    Dim Vert_Blank_Space_Y As Integer
    Dim Ali_x As Integer
    Dim Ali_y As Integer

    For Point_Num = 1 To Right_Ali_Points_Cnt

    Call Get_Right_Ali_Point_Def(Point_Num, Ax, Ay)
    Call Get_Point(Ax, Ay, Ax, Ay)
    Call Get_Right_Ali_Search_Area(Ax, Ay, BmOmr.Height, BmOmr.Width, Left_x, Right_x, Top_y, Bottom_y, Vert_Squ_Thick_Max_X, Vert_Squ_Thick_Max_Y, Vert_Squ_Thick_Min_X, Vert_Squ_Thick_Min_Y, Vert_Blank_Space_X, Vert_Blank_Space_Y, Ans_Sheet_Type)

            'Call Draw_Rectangle(BmOmr, Left_x, Right_x, Top_y, Bottom_y)

    Get_Right_Ali_Positions = Get_Alignment_Point(BmOmr, True, Vert_Blank_Space_Y, Vert_Blank_Space_X, Vert_Squ_Thick_Max_Y, Vert_Squ_Thick_Max_X, Vert_Squ_Thick_Min_Y, Vert_Squ_Thick_Min_X, Top_y, Bottom_y, Left_x, Right_x, Ali_y, Ali_x)

    Right_Ali_x(Point_Num) = Ali_x
    Right_Ali_y(Point_Num) = Ali_y

    If Get_Right_Ali_Positions = False Then
    Exit For
    End If

    Next

    End Function

    Private Sub Get_Right_Ali_Search_Area(ByVal Ax As Integer, ByVal Ay As Integer, _
            ByVal Sheet_Hight As Integer, ByVal Sheet_Width As Integer, _
                                                  ByRef Left_x As Integer, ByRef Right_x As Integer, _
                                                  ByRef Top_y As Integer, ByRef Bottom_y As Integer, _
                                                  ByRef Vert_Squ_Thick_Max_X As Integer, _
                                                  ByRef Vert_Squ_Thick_Max_Y As Integer, _
                                                  ByRef Vert_Squ_Thick_Min_X As Integer, _
                                                  ByRef Vert_Squ_Thick_Min_Y As Integer, _
                                                  ByRef Vert_Blank_Space_X As Integer, _
                                                  ByRef Vert_Blank_Space_Y As Integer, _
                                                  ByVal Ans_Sheet_Type As Integer)

    Sheet_Hight -= 1
    Sheet_Width -= 1

            'Top Left Allignment Area
    Left_x = Ax - (15 * XRatio)
    Right_x = Ax + (15 * XRatio)
    Top_y = Ay - (24 * YRatio_Right)
    Bottom_y = Ay + (24 * YRatio_Right)

    If Left_x < 0 Then Left_x = 0
    If Right_x > Sheet_Width Then Right_x = Sheet_Width
    If Top_y < 0 Then Top_y = 0
    If Bottom_y > Sheet_Hight Then Bottom_y = Sheet_Hight

            Vert_Blank_Space_X = Math.Round(XRatio * Squ_Blank_Space_Width_Wise)
    Vert_Blank_Space_Y = Math.Round(YRatio_Right * Squ_Blank_Space_Length_Wise)

    Vert_Squ_Thick_Max_X = Math.Round(XRatio * Squ_Thick * Squ_Thick_Max / 100)
    Vert_Squ_Thick_Max_Y = Math.Round(YRatio_Right * Squ_Thick * Squ_Thick_Max / 100)

    Vert_Squ_Thick_Min_X = Math.Round(XRatio * Squ_Thick * Squ_Thick_Min / 100)
    Vert_Squ_Thick_Min_Y = Math.Round(YRatio_Right * Squ_Thick * Squ_Thick_Min / 100)

    End Sub

    Private Sub Get_Bottom_Ali_Search_Area(ByVal Ax As Integer, ByVal Ay As Integer, _
            ByVal Sheet_Hight As Integer, ByVal Sheet_Width As Integer, _
                                                   ByRef Left_x As Integer, ByRef Right_x As Integer, _
                                                   ByRef Top_y As Integer, ByRef Bottom_y As Integer, _
                                                   ByRef Hori_Squ_Thick_Max_X As Integer, _
                                                   ByRef Hori_Squ_Thick_Max_Y As Integer, _
                                                   ByRef Hori_Squ_Thick_Min_X As Integer, _
                                                   ByRef Hori_Squ_Thick_Min_Y As Integer, _
                                                   ByRef Hori_Blank_Space_X As Integer, _
                                                   ByRef Hori_Blank_Space_Y As Integer, _
                                                   ByVal Ans_Sheet_Type As Integer)

    Sheet_Hight -= 1
    Sheet_Width -= 1

            'Top Left Allignment Area
    Left_x = Ax - (24 * XRatio)
    Right_x = Ax + (24 * XRatio)
    Top_y = Ay + (15 * YRatio_Right) 'Top become bottom for scaning from bottom to top
    Bottom_y = Ay - (15 * YRatio_Right)

    If Left_x < 0 Then Left_x = 0
    If Right_x > Sheet_Width Then Right_x = Sheet_Width
    If Top_y < 0 Then Top_y = 0
    If Bottom_y > Sheet_Hight Then Bottom_y = Sheet_Hight

            Hori_Blank_Space_X = Math.Round(XRatio_Bottom * Squ_Blank_Space_Length_Wise)
    Hori_Blank_Space_Y = Math.Round(YRatio * Squ_Blank_Space_Width_Wise)

    Hori_Squ_Thick_Max_X = Math.Round(XRatio_Bottom * Squ_Thick * Squ_Thick_Max / 100)
    Hori_Squ_Thick_Max_Y = Math.Round(YRatio * Squ_Thick * Squ_Thick_Max / 100)

    Hori_Squ_Thick_Min_X = Math.Round(XRatio_Bottom * Squ_Thick * Squ_Thick_Min / 100)
    Hori_Squ_Thick_Min_Y = Math.Round(YRatio * Squ_Thick * Squ_Thick_Min / 100)

    End Sub






    Private Function Detect_Alignment_Points(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                                     ByVal Ali_Blank_Space_X As Integer, _
                                                     ByVal Ali_Blank_Space_Y As Integer, _
                                                     ByVal Ali_Squ_Thick_Max_X As Integer, _
                                                     ByVal Ali_Squ_Thick_Max_Y As Integer, _
                                                     ByVal Ali_Squ_Thick_Min_X As Integer, _
                                                     ByVal Ali_Squ_Thick_Min_Y As Integer, _
                                                     ByRef Left_x() As Integer, _
    ByRef Right_x() As Integer, _
    ByRef Top_y() As Integer, _
    ByRef Bottom_y() As Integer, _
    ByRef Ali_x() As Integer, _
    ByRef Ali_y() As Integer) As Boolean

    Dim i As SByte
    Dim FTop_y As Integer
    Dim FBottom_y As Integer
    Dim FLeft_x As Integer
    Dim FRight_x As Integer

    For i = 1 To 4

    Detect_Alignment_Points = False

    If i = 1 Or i = 2 Then
            FTop_y = Top_y(i)
    FBottom_y = Bottom_y(i)
    Else
            FTop_y = Bottom_y(i)
    FBottom_y = Top_y(i)
    End If

    If i = 1 Or i = 4 Then
            FLeft_x = Left_x(i)
    FRight_x = Right_x(i)
    Else
            FLeft_x = Right_x(i)
    FRight_x = Left_x(i)
    End If

    Detect_Alignment_Points = Get_Alignment_Point(BmOmr, Swap_xy, Ali_Blank_Space_X, Ali_Blank_Space_Y, Ali_Squ_Thick_Max_X, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_X, Ali_Squ_Thick_Min_Y, FLeft_x, FRight_x, FTop_y, FBottom_y, Ali_x(i), Ali_y(i))

    If Detect_Alignment_Points = False Then Exit For

            Next

    End Function

    Private Function Get_Alignment_Point(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                                 ByVal Ali_Blank_Space_X As Integer, _
                                                 ByVal Ali_Blank_Space_Y As Integer, _
                                                 ByVal Ali_Squ_Thick_Max_X As Integer, _
                                                 ByVal Ali_Squ_Thick_Max_Y As Integer, _
                                                 ByVal Ali_Squ_Thick_Min_X As Integer, _
                                                 ByVal Ali_Squ_Thick_Min_Y As Integer, _
                                                 ByVal Left_x As Integer, ByVal Right_x As Integer, _
                                                 ByVal Top_y As Integer, ByVal Bottom_y As Integer, _
                                                 ByRef Ali_x As Integer, ByRef Ali_y As Integer) As Boolean

    Dim Sy As Integer
    Dim Step_y As Integer

    Get_Alignment_Point = False

    If Top_y <= Bottom_y Then
    Step_y = 1
    Else
            Step_y = -1
    End If

    For Sy = Top_y To Bottom_y Step Step_y
    If Find_X_Pattern(BmOmr, Swap_xy, Ali_Blank_Space_X, Ali_Blank_Space_Y, Ali_Squ_Thick_Max_X, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_X, Ali_Squ_Thick_Min_Y, Sy, Left_x, Right_x, Top_y, Bottom_y, Ali_x, Ali_y) = True Then
    Get_Alignment_Point = True
    Exit For
    End If
    Next

    End Function

    Private Sub Rotate_Plane(ByRef Ali_x() As Integer, _
    ByRef Ali_y() As Integer)

    Dim i As SByte

    Ali_x(0) = Ali_x(4)
    Ali_y(0) = Ali_y(4)

    For i = 4 To 1 Step -1
    Ali_x(i) = Ali_x(i - 1)
    Ali_y(i) = Ali_y(i - 1)
    Next

    End Sub

    Private Function Find_X_Pattern(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                            ByVal Ali_Blank_Space_X As Integer, _
                                            ByVal Ali_Blank_Space_Y As Integer, _
                                            ByRef Ali_Squ_Thick_Max_X As Integer, _
                                            ByRef Ali_Squ_Thick_Max_Y As Integer, _
                                            ByRef Ali_Squ_Thick_Min_X As Integer, _
                                            ByRef Ali_Squ_Thick_Min_Y As Integer, _
                                            ByVal y As Integer, _
                                            ByVal Left_x As Integer, ByVal Right_x As Integer, _
                                            ByVal Top_y As Integer, ByVal Bottom_y As Integer, _
                                            ByRef Ali_x As Integer, _
                                            ByRef Ali_y As Integer) As Boolean

    Dim PixBri As Single
    Dim Bri_Dar As Boolean
    Dim First_Block As Boolean
    Dim Second_Block As Boolean
    Dim Third_Block As Boolean
    Dim Block_Len As Integer
    Dim x As Integer
    Dim Mark_Start_x As Integer
    Dim Mark_End_x As Integer
    Dim Step_x As Integer

    Find_X_Pattern = False
            Block_Len = 0
    First_Block = False
            Second_Block = False
    Third_Block = False

    If Left_x <= Right_x Then
    Step_x = 1
    Else
            Step_x = -1
    End If

    For x = Left_x To Right_x Step Step_x

    If Swap_xy = False Then
            PixBri = BmOmr.GetPixel(x, y).GetBrightness()
    Else
            PixBri = BmOmr.GetPixel(y, x).GetBrightness()
    End If

    If PixBri >= Ali_Bri_Level Then
    Bri_Dar = True
            Else
    Bri_Dar = False
    End If

    If First_Block = False Then

    If Bri_Dar = True Then
    Block_Len += 1
    Else

    If Block_Len >= Ali_Blank_Space_X Then
    First_Block = True
            Mark_Start_x = x
    Block_Len = 1
    Else
            Block_Len = 0
    End If

    End If

    ElseIf Second_Block = False Then

    If Bri_Dar = False Then
    Block_Len += 1
    Else

    If Block_Len <= Ali_Squ_Thick_Max_X And Block_Len >= Ali_Squ_Thick_Min_X Then
    Second_Block = True
            Mark_End_x = x - 1
    Block_Len = 1
    Else
            First_Block = False
    Block_Len = 0
    End If

    End If

    ElseIf Third_Block = False Then

    If Bri_Dar = True Then

    Block_Len += 1

    If Block_Len >= Ali_Blank_Space_X Then

    Third_Block = True

    If Find_Y_Pattern(BmOmr, Swap_xy, Ali_Blank_Space_Y, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_Y, y, Top_y, Bottom_y, Mark_Start_x, Mark_End_x, Ali_y) = True Then
    Ali_x = (Mark_Start_x + Mark_End_x) / 2
    Return True
    Else
            First_Block = False
    Second_Block = False
            Third_Block = False
    End If

    End If

    Else
            First_Block = False
    Second_Block = False
            Block_Len = 0
    End If

    End If

    Next

    End Function

    Private Sub Check_Y_Line(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                     ByVal Sx As Integer, ByVal Sy As Integer, _
                                     ByVal Top_y As Integer, ByVal Bottom_y As Integer, _
                                     ByRef Top_Blank_Len As Integer, _
                                     ByRef Mark_Len As Integer, _
                                     ByRef Bottom_Blank_Len As Integer, _
                                     ByRef Ali_y As Integer)

    Dim Mark_Len_1 As Integer
    Dim Mark_Len_2 As Integer
    Dim Mark_End_1 As Integer
    Dim Mark_End_2 As Integer

    Call Check_Y_Line_Half(BmOmr, Swap_xy, Sx, Sy, Top_y, Mark_Len_1, Top_Blank_Len, Mark_End_1)
    Call Check_Y_Line_Half(BmOmr, Swap_xy, Sx, Sy, Bottom_y, Mark_Len_2, Bottom_Blank_Len, Mark_End_2)
    Mark_Len = Mark_Len_1 + Mark_Len_2 - 1
    Ali_y = (Mark_End_1 + Mark_End_2) / 2

    End Sub

    Private Sub Check_Y_Line_Half(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                          ByVal Sx As Integer, _
                                          ByVal Start_y As Integer, ByVal Stop_y As Integer, _
                                          ByRef Mark_Len As Integer, _
                                          ByRef Blank_Len As Integer, _
                                          ByRef Mark_End_y As Integer)

    Dim y As Integer
    Dim Step_y As Integer
    Dim PixBri As Single
    Dim Bri As Boolean
    Dim Mark_Ok As Boolean

    If Start_y <= Stop_y Then
    Step_y = 1
    Else
            Step_y = -1
    End If

    Mark_Len = 0
    Blank_Len = 0
    Mark_Ok = False

    For y = Start_y To Stop_y Step Step_y

    If Swap_xy = False Then
            PixBri = BmOmr.GetPixel(Sx, y).GetBrightness()
    Else
            PixBri = BmOmr.GetPixel(y, Sx).GetBrightness()
    End If

    If PixBri >= Ali_Bri_Level Then
    Bri = True
            Else
    Bri = False
    End If

    If Bri = False Then

    If Mark_Ok = True Then
    Exit For
    Else
    Mark_Len += 1
    End If

    Else

    If Mark_Ok = False Then
            Mark_End_y = y - 1
    Mark_Ok = True
    End If

    Blank_Len += 1

    End If

    Next

    End Sub

    Private Function Find_Y_Pattern(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                            ByVal Ali_Blank_Space_Y As Integer, _
                                            ByRef Ali_Squ_Thick_Max_Y As Integer, _
                                            ByRef Ali_Squ_Thick_Min_Y As Integer, _
                                            ByVal Sel_y As Integer, _
                                            ByVal Top_y As Integer, ByVal Bottom_y As Integer, _
                                            ByVal Mark_Start_x As Integer, ByVal Mark_End_x As Integer, _
                                            ByRef Ali_y As Integer) As Boolean

    Dim Mid_Mark_Start_x As Integer
    Dim Mid_Mark_End_x As Integer

    Mid_Mark_Start_x = Mark_Start_x
            Mid_Mark_End_x = Mark_Start_x + (Mark_End_x - Mark_Start_x) / 2

    Find_Y_Pattern = Find_Y_Pattern_Sub(BmOmr, Swap_xy, Ali_Blank_Space_Y, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_Y, Sel_y, Top_y, Bottom_y, Mid_Mark_Start_x, Mid_Mark_End_x, Ali_y)

    If Find_Y_Pattern = False Then Exit Function

            Mid_Mark_Start_x = Mid_Mark_End_x + Math.Sign(Mark_End_x - Mark_Start_x)
    Mid_Mark_End_x = Mark_End_x

            Find_Y_Pattern = Find_Y_Pattern_Sub(BmOmr, Swap_xy, Ali_Blank_Space_Y, Ali_Squ_Thick_Max_Y, Ali_Squ_Thick_Min_Y, Sel_y, Top_y, Bottom_y, Mid_Mark_Start_x, Mid_Mark_End_x, Ali_y)

    End Function

    Private Function Find_Y_Pattern_Sub(ByRef BmOmr As Bitmap, _
            ByVal Swap_xy As Boolean, _
                                                ByVal Ali_Blank_Space_Y As Integer, _
                                                ByRef Ali_Squ_Thick_Max_Y As Integer, _
                                                ByRef Ali_Squ_Thick_Min_Y As Integer, _
                                                ByVal Sel_y As Integer, _
                                                ByVal Top_y As Integer, ByVal Bottom_y As Integer, _
                                                ByVal Mark_Start_x As Integer, ByVal Mark_End_x As Integer, _
                                                ByRef Ali_y As Integer) As Boolean

    Dim x As Integer
    Dim Mark_Len As Integer
    Dim Top_Blank_Len As Integer
    Dim Bottom_Blank_Len As Integer
    Dim Step_x As Integer

    Find_Y_Pattern_Sub = False

    If Mark_Start_x <= Mark_End_x Then
    Step_x = 1
    Else
            Step_x = -1
    End If

    For x = Mark_Start_x To Mark_End_x Step Step_x

    Call Check_Y_Line(BmOmr, Swap_xy, x, Sel_y, Top_y, Bottom_y, Top_Blank_Len, Mark_Len, Bottom_Blank_Len, Ali_y)

    If Mark_Len <= Ali_Squ_Thick_Max_Y And Mark_Len >= Ali_Squ_Thick_Min_Y And Top_Blank_Len >= Ali_Blank_Space_Y And Bottom_Blank_Len >= Ali_Blank_Space_Y Then
    Find_Y_Pattern_Sub = True
    Exit For
    End If

    Next

    End Function

    Public Sub New()

    Dim Bri_Lev As String

    Bri_Lev = Get_Soft_Settings_From_File("Ali_Point_Brightness")

    If Bri_Lev = "" Then
            Ali_Bri_Level = 0.8 ' 0.6
    Else
            Ali_Bri_Level = Val(Bri_Lev)
    End If

    OMR_Image_Formats(0) = "*.jpg"
    OMR_Image_Formats(1) = "*.jpeg"
    OMR_Image_Formats(2) = "*.bmp"
    OMR_Image_Formats(3) = "*.tif"
    OMR_Image_Formats(4) = "*.tiff"
    OMR_Image_Formats(5) = "*.png"

    Letter_Pen.DashPattern = New Single() {3, 3}
    Letter_Pen.DashStyle = Drawing2D.DashStyle.Custom

    End Sub

    Public Function Create_OMR_Ans_Sheet(ByVal Ans_Sheet_Code As Integer, ByRef BmOmr As Bitmap) As Graphics

    Dim GrOmr As Graphics

    If Ans_Sheet_Code = 1 Then
            BmOmr = New Bitmap(7014, 4956) '(826, 1169)
    GrOmr = Graphics.FromImage(BmOmr)
            GrOmr.FillRectangle(Brushes.White, 0, 0, 7014, 4956)
    Else
            BmOmr = New Bitmap(4956, 7014) '(826, 1169)
    GrOmr = Graphics.FromImage(BmOmr)
            GrOmr.FillRectangle(Brushes.White, 0, 0, 4956, 7014)
    End If

    GrOmr.SmoothingMode = Drawing2D.SmoothingMode.HighQuality
        GrOmr.ScaleTransform(6, 6)
                BmOmr.SetResolution(600, 600)

    Call Set_Default_Alignment(Ans_Sheet_Code)

    If Ans_Sheet_Code = 1 Then
    Call Display_Page_60(GrOmr, 0)
    Call Display_Page_60(GrOmr, 578)
            GrOmr.DrawLine(New Pen(Brushes.Black, 0.5), 585, 0, 585, 826) 'Mid Line
    ElseIf Ans_Sheet_Code = 2 Then
    Call Display_Page_120(GrOmr)
    Else
    MsgBox("Error")
    End If

    Create_OMR_Ans_Sheet = GrOmr

    End Function

    Public Function Get_Omr_Ans_Sheet(ByVal Ans_Sheet_Code As Integer) As Bitmap

    Dim GrOmr As Graphics
    Dim BmOmr As New Bitmap(1, 1)

    GrOmr = Create_OMR_Ans_Sheet(Ans_Sheet_Code, BmOmr)

    Get_Omr_Ans_Sheet = BmOmr

    End Function

    Public Sub Display_Page_120(ByRef e As Graphics)

    Dim Sheet_Hight As Integer
    Dim Sheet_Width As Integer
    Dim Dx As Integer
    Dim Dy As Integer
    Dim Dx2 As Integer
    Dim Dy2 As Integer

    Sheet_Hight = BL_y + TL_y
            Sheet_Width = TR_x + TL_x

        'Right Margin
    Call Get_Point(-30, -30, Dx, Dy)
    Call Get_Point(696, 1039, Dx2, Dy2)
        e.DrawLine(New Pen(Brushes.Black, 0.5), Dx, Dy, Dx, Dy2)
            e.DrawLine(New Pen(Brushes.Black, 0.5), Dx2, Dy, Dx2, Dy2)
            e.DrawLine(New Pen(Brushes.Black, 0.5), Dx, Dy, Dx2, Dy)
            e.DrawLine(New Pen(Brushes.Black, 0.5), Dx, Dy2, Dx2, Dy2)

    Call Display_Allignment_Points(e, 0)
    Call Display_St_Details_Columns_120(e)
    Call Important_Column_120(e)
    Call Display_RollNumber_Bubble(e, 0)
    Call Signature_Column_120(e)
    Call Marks_Column_120(e)

    Call Display_Answer_Bubble(e, 0, 1, 2)
    Call Display_Answer_Bubble(e, 0, 61, 2)

    End Sub

    Public Sub Display_Page_60(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Sheet_Hight As Integer
    Dim Sheet_Width As Integer
    Dim Dx As Integer
    Dim Dy As Integer
    Dim Dx2 As Integer
    Dim Dy2 As Integer

    Sheet_Hight = BL_y + TL_y
            Sheet_Width = TR_x + TL_x

        'Right Margin
    Call Get_Point(-30, -30, Dx, Dy)
    Call Get_Point(461, 694, Dx2, Dy2)
        e.DrawLine(New Pen(Brushes.Black, 0.5), Offset + Dx, Dy, Offset + Dx, Dy2)
            e.DrawLine(New Pen(Brushes.Black, 0.5), Offset + Dx2, Dy, Offset + Dx2, Dy2)
            e.DrawLine(New Pen(Brushes.Black, 0.5), Offset + Dx, Dy, Offset + Dx2, Dy)
            e.DrawLine(New Pen(Brushes.Black, 0.5), Offset + Dx, Dy2, Offset + Dx2, Dy2)

    Call Display_Allignment_Points(e, Offset)
    Call Display_St_Details_Columns(e, Offset)
    Call Important_Column_60(e, Offset)
    Call Display_RollNumber_Bubble(e, Offset)
    Call Signature_Column(e, Offset)
    Call Marks_Column(e, Offset)

    Call Display_Answer_Bubble(e, Offset, 1, 1)
    Call Display_Answer_Bubble(e, Offset, 31, 1)

    End Sub

    Private Sub Display_Allignment_Points(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Ax As Integer
    Dim Ay As Integer
    Dim i As Integer

        e.FillRectangle(Brushes.Black, Offset + CInt(TL_x - Squ_Thick / 2), CInt(TL_y - Squ_Thick / 2), Squ_Thick, Squ_Thick)
            e.FillRectangle(Brushes.Black, Offset + CInt(TR_x - Squ_Thick / 2), CInt(TR_y - Squ_Thick / 2), Squ_Thick, Squ_Thick)
            e.FillRectangle(Brushes.Black, Offset + CInt(BL_x - Squ_Thick / 2), CInt(BL_y - Squ_Thick / 2), Squ_Thick, Squ_Thick)
            e.FillRectangle(Brushes.Black, Offset + CInt(BR_x - Squ_Thick / 2), CInt(BR_y - Squ_Thick / 2), Squ_Thick, Squ_Thick)

    For i = 1 To Right_Ali_Points_Cnt
    Get_Right_Ali_Point_Def(i, Ax, Ay)
    Call Get_Point(Ax, Ay, Ax, Ay)
            e.FillRectangle(Brushes.Black, Offset + CInt(Ax - Squ_Thick / 2), CInt(Ay - Squ_Thick / 2), Squ_Thick, Squ_Thick)
    Next

    For i = 1 To Bottom_Ali_Points_Cnt
    Get_Bottom_Ali_Point_Def(i, Ax, Ay)
    Call Get_Point(Ax, Ay, Ax, Ay)
            e.FillRectangle(Brushes.Black, Offset + CInt(Ax - Squ_Thick / 2), CInt(Ay - Squ_Thick / 2), Squ_Thick, Squ_Thick)
    Next

        'e.Graphics.DrawLine(Pens.Red, 505, 0, 505, 826)
                'e.Graphics.DrawLine(Pens.Red, 502, 0, 502, 826)

                'e.Graphics.DrawLine(Pens.Red, 740, 0, 740, 1169)
                'e.Graphics.DrawLine(Pens.Red, 733, 0, 733, 1169)

    End Sub

    Private Sub Display_St_Details_Columns_120(ByRef e As Graphics)

    Dim Col_Hight As Integer
    Dim Col_Top As Integer
    Dim Col_Right As Integer
    Dim PrintFont As Font
    Dim Label_Width As Integer
    Dim Col_Width As Integer
    Dim Dx As Integer
    Dim Dy As Integer
    Dim State As System.Drawing.Drawing2D.GraphicsState

            Col_Hight = 25 * YRatio
    Label_Width = 75 * XRatio
            Col_Width = 295 * XRatio

        'Main Heading
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Bold)
    Call Get_Point(9, 996, Dx, Dy)
        e.DrawString(Mid(Get_Soft_Settings("Inst_Name"), 1, 28), PrintFont, Brushes.Black, Dx, Dy)

    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Regular)

    Call Get_Point(9, 966, Dx, Col_Top)
        e.DrawRectangle(Pens.Black, Dx, Col_Top, Col_Width, Col_Hight * 4)
            e.DrawString("Name", PrintFont, Brushes.Black, Dx + 5, Col_Top + 2)
            e.DrawLine(Pens.Black, Dx + Label_Width, Col_Top, Dx + Label_Width, Col_Top + Col_Hight * 4)
    Col_Top += Col_Hight

            Col_Right = Dx + Col_Width
        e.DrawLine(Pens.Black, Dx, Col_Top, Col_Right, Col_Top)
            e.DrawString("Course", PrintFont, Brushes.Black, Dx + 5, Col_Top + 2)
    Col_Top += Col_Hight

            Col_Right = Dx + Col_Width
        e.DrawLine(Pens.Black, Dx, Col_Top, Col_Right, Col_Top)
            e.DrawString("Division", PrintFont, Brushes.Black, Dx + 5, Col_Top + 2)
    Col_Top += Col_Hight

        e.DrawLine(Pens.Black, Dx, Col_Top, Col_Right, Col_Top)
            e.DrawString("Subject", PrintFont, Brushes.Black, Dx + 5, Col_Top + 2)

    State = e.Save()
    PrintFont = New System.Drawing.Font("Times New Roman", 14, FontStyle.Bold)
    Get_Point(315, 441, Dx, Dy)
        e.RotateTransform(-90)
                e.DrawString("ANSWERS", PrintFont, Brushes.Black, -Dy, Dx)
            e.Restore(State)

    End Sub

    Private Sub Important_Column_120(ByRef e As Graphics)

    Dim Dx As Integer
    Dim Dy As Integer
    Dim PrintFont As Font
    Dim Imp_Col_x As Integer
    Dim Imp_Col_y As Integer

    Imp_Col_x = 42
    Imp_Col_y = 835

            'Important Rectangle
    Call Get_Point(Imp_Col_x, Imp_Col_y, Dx, Dy)
        e.DrawRectangle(Pens.Black, Dx, Dy, CInt(230 * XRatio), CInt(180 * YRatio))

            'Important Heading
    Call Get_Point(Imp_Col_x + 63, Imp_Col_y - 12, Dx, Dy)
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Bold)
            e.DrawString("IMPORTANT", PrintFont, Brushes.Black, Dx, Dy)

            'Important Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Regular)
    Call Get_Point(Imp_Col_x + 12, Imp_Col_y - 40, Dx, Dy)
        e.DrawString("1. Handle this sheet carefully." & vbCrLf & _
                              "2. Use only blue or black" & vbCrLf & "    ball-point pen" & vbCrLf & _
                              "3. Any error in filling this" & vbCrLf & "    sheet may prejudice your" & vbCrLf & "    selection.", PrintFont, Brushes.Black, Dx, Dy)

    End Sub

    Private Sub Display_RollNumber_Bubble(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Qu_Num As Integer
    Dim Roll_Digit As SByte
    Dim PrintFont As Font
    Dim Dx As Integer
    Dim Dy As Integer
    Dim Line_Left_x As Integer
    Dim Line_Right_x As Integer
    Dim Digit_Line_x As Integer

    Dim B_Lx As Integer 'Boarder Left x
    Dim B_Ty As Integer 'Boarder Top y
    Dim B_Rx As Integer 'Boarder Right x
    Dim B_By As Integer 'Boarder Bottom y

    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Bold)
    Get_Point(Bubble_RollNo_Offset_x + 29, Bubble_RollNo_Offset_y + 61, Dx, Dy)
        e.DrawString("REG NO", PrintFont, Brushes.Black, Offset + Dx, Dy)

    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Bold)

    For Qu_Num = 1 To 10
    For Roll_Digit = 1 To 4
    Call Get_RollNumber_Bubble(Qu_Num, Roll_Digit, Dx, Dy)
                e.DrawEllipse(New Pen(Brushes.Black, Bubble_Thick), CInt(Offset + Dx - Bubble_Width / 2), CInt(Dy - Bubble_Height / 2), Bubble_Width, Bubble_Height)
    Draw_Bubble_Digit(e, Qu_Num - 1, Offset + Dx, Dy)
    Next
            Next

        'Right Line of Digits
    Call Get_RollNumber_Bubble(1, 1, B_Lx, B_Ty)
    Call Get_RollNumber_Bubble(10, 4, B_Rx, B_By)
    Digit_Line_x = CInt(B_Lx - Bubble_Hori_Space + Bubble_Width / 2)
        e.DrawLine(Pens.Black, Offset + Digit_Line_x, CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2), Offset + Digit_Line_x, CInt(B_By + Bubble_Vert_Space - Bubble_Height / 2))

            'Digits
    For Qu_Num = 1 To 10
    Call Get_RollNumber_Bubble(Qu_Num, 1, Dx, Dy)
            e.DrawString(Qu_Num - 1, PrintFont, Brushes.Black, Offset + Digit_Line_x - 12, Dy - PrintFont.Height / 2) ' ClsOMR.Bubble_Height + 1)
    Next

    Call Get_RollNumber_Bubble(1, 1, B_Lx, B_Ty)
    Call Get_RollNumber_Bubble(10, 4, B_Rx, B_By)

        'ABCDE
    For Roll_Digit = 1 To 5
    Call Get_RollNumber_Bubble(1, Roll_Digit, Dx, Dy)
    If Roll_Digit = 1 Then Line_Left_x = Dx
    If Roll_Digit = 5 Then Line_Right_x = Dx
            e.DrawLine(Pens.Black, CInt(Offset + Dx - Bubble_Hori_Space / 2), B_Ty - 45, CInt(Offset + Dx - Bubble_Hori_Space / 2), CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2))
    Next

        '1st Top Line
                e.DrawLine(Pens.Black, CInt(Offset + Line_Left_x - Bubble_Hori_Space / 2), B_Ty - 45, CInt(Offset + Line_Right_x - Bubble_Hori_Space / 2), B_Ty - 45)

            '2nd Top Line
            e.DrawLine(Pens.Black, CInt(Offset + B_Lx - Bubble_Hori_Space + Bubble_Width / 2), CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2), CInt(Offset + B_Rx + Bubble_Hori_Space - Bubble_Width / 2), CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2))

    B_Lx -= 46
    B_Ty -= Bubble_Vert_Space - Bubble_Height / 2

    B_Rx += Bubble_Hori_Space - Bubble_Width / 2
    B_By += Bubble_Vert_Space - Bubble_Height / 2

            e.DrawRectangle(Pens.Black, Digit_Line_x - 12 + Offset, B_Ty, B_Rx - Digit_Line_x + 12, B_By - B_Ty)

    End Sub

    Private Sub Signature_Column_120(ByRef e As Graphics)

    Dim Dx As Integer
    Dim Dy As Integer
    Dim PrintFont As Font

        'Signature Column
    Call Get_Point(9, 370, Dx, Dy)
        e.DrawRectangle(Pens.Black, Dx, Dy, CInt(295 * XRatio), CInt(75 * YRatio))
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Regular)
    Call Get_Point(77, 317, Dx, Dy)
        e.DrawString("Signature of Candidate", PrintFont, Brushes.Black, Dx + 1, Dy)

    End Sub

    Private Sub Marks_Column_120(ByRef e As Graphics)

    Dim Dx As Integer
    Dim Dy As Integer
    Dim Mark_Col_Top As Integer
    Dim Dx2 As Integer
    Dim Dy2 As Integer
    Dim PrintFont As Font
    Dim Col_Width As Integer

    Col_Width = 295

            'Mark Columns
    Call Get_Point(9, 260, Dx, Mark_Col_Top)
        e.DrawRectangle(Pens.Black, Dx, Mark_Col_Top, CInt(Col_Width * XRatio), CInt(120 * YRatio))
    Call Get_Point(153, 152, Dx2, Dy2)
        e.DrawLine(Pens.Black, Dx, Mark_Col_Top + CInt(60 * YRatio), Dx + CInt(Col_Width * XRatio), Mark_Col_Top + CInt(60 * YRatio)) 'Horizontal Line
    Call Get_Point(100, 0, Dx, Dy)
        e.DrawLine(Pens.Black, Dx, Mark_Col_Top, Dx, Mark_Col_Top + CInt(120 * YRatio)) 'Vertical Line

            'Answered Mark Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Regular)
    Call Get_Point(14, 0, Dx, Dy)
        e.DrawString("Answered" & vbCrLf & "Questions", PrintFont, Brushes.Black, Dx, Mark_Col_Top + 11)

            'Correct Answers Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Regular)
            e.DrawString("Correct" & vbCrLf & "Answers", PrintFont, Brushes.Black, Dx, Mark_Col_Top + CInt(68 * YRatio))

            'Total Mark Column
    Call Get_Point(9, 0, Dx, Dy)
        e.DrawRectangle(Pens.Black, Dx, Mark_Col_Top + CInt((69 + 60) * YRatio), CInt(Col_Width * XRatio), CInt(118 * YRatio))

            'Total Mark Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Bold Or FontStyle.Underline)
    Call Get_Point(97, 0, Dx, Dy)
        e.DrawString("TOTAL MARK", PrintFont, Brushes.Black, Dx, Mark_Col_Top + CInt((75 + 60) * YRatio))

    End Sub

    Private Sub Display_Answer_Bubble(ByRef e As Graphics, _
            ByVal Offset As Integer, _
                                              ByVal Start_Qu_Num As Integer, _
                                              ByVal Ans_Sheet_Type As Integer)

    Dim Qu_Num As Integer
    Dim Choice As SByte
    Dim PrintFont As Font
    Dim Dx As Integer
    Dim Dy As Integer
    Dim Total_Qu As Integer

    Dim B_Lx As Integer 'Boarder Left x
    Dim B_Ty As Integer 'Boarder Top y
    Dim B_Rx As Integer 'Boarder Right x
    Dim B_By As Integer 'Boarder Bottom y

    Dim Qu_Line_x As Integer

    Total_Qu = Get_Ans_Sheet_Questions(Ans_Sheet_Type)

    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Bold)

    For Qu_Num = Start_Qu_Num To Start_Qu_Num + Total_Qu / 2 - 1
    For Choice = 1 To Total_Choice
    Call Get_Bubble(Qu_Num, Choice, Total_Column, Dx, Dy)
                e.DrawEllipse(New Pen(Brushes.Black, Bubble_Thick), CInt(Offset + Dx - Bubble_Width / 2), CInt(Dy - Bubble_Height / 2), Bubble_Width, Bubble_Height)
    Call Draw_Bubble_Letter(e, Choice, Offset + Dx, Dy)
    Next
            Next

        'ABCDE
    For Choice = 1 To Total_Choice
    Call Get_Bubble(Start_Qu_Num, Choice, Total_Column, Dx, Dy)
            e.DrawString(Chr(64 + Choice), PrintFont, Brushes.Black, Offset + Dx - 7, Dy - 28)
    Next

    Call Get_Bubble(Start_Qu_Num, 1, Total_Column, B_Lx, B_Ty)
    Call Get_Bubble(Start_Qu_Num + (Total_Qu / 2) - 1, 5, Total_Column, B_Rx, B_By)

            'Right Line of Question Number
    Qu_Line_x = B_Lx - Bubble_Hori_Space + Bubble_Width / 2
            e.DrawLine(Pens.Black, Offset + Qu_Line_x, CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2), Offset + Qu_Line_x, CInt(B_By + Bubble_Vert_Space - Bubble_Height / 2))

            'Question Number
    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Bold)
    For Qu_Num = Start_Qu_Num To Start_Qu_Num + (Total_Qu / 2) - 1
    Call Get_Bubble(Qu_Num, 1, Total_Column, Dx, Dy)
            e.DrawString(Qu_Num, PrintFont, Brushes.Black, Offset + Qu_Line_x - 6 - (Qu_Num.ToString.Length * 7), Dy - PrintFont.Height / 2) 'ClsOMR.Bubble_Height +2 )
    Next

        'Top Line
                e.DrawLine(Pens.Black, CInt(Offset + B_Lx - Bubble_Hori_Space + Bubble_Width / 2), CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2), CInt(Offset + B_Rx + Bubble_Hori_Space - Bubble_Width / 2), CInt(B_Ty - Bubble_Vert_Space + Bubble_Height / 2))

    If Ans_Sheet_Type = 1 Then
    B_Lx -= 38
    ElseIf Ans_Sheet_Type = 2 Then
    B_Lx -= 45
    End If

    B_Ty -= 28

    B_Rx += Bubble_Hori_Space - Bubble_Width / 2
    B_By += Bubble_Vert_Space - Bubble_Height / 2

            e.DrawRectangle(Pens.Black, B_Lx + Offset, B_Ty, B_Rx - B_Lx, B_By - B_Ty)

    End Sub

    Private Sub Display_St_Details_Columns(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Col_Hight As Integer
    Dim Col_Top As Integer
    Dim Col_Right As Integer
    Dim Col_Gap As Integer
    Dim Mid_Col_Width As Integer
    Dim PrintFont As Font
    Dim Label_Width As Integer
    Dim Dx As Integer
    Dim Dy As Integer

    Col_Hight = 20 * YRatio
            Col_Gap = 5 * YRatio
    Label_Width = 75 * XRatio

        'Main Heading
    PrintFont = New System.Drawing.Font("Times New Roman", 12, FontStyle.Bold)
    Call Get_Point(9, 655, Dx, Dy)
        e.DrawString(Mid(Get_Soft_Settings("Inst_Name"), 1, 38), PrintFont, Brushes.Black, Offset + Dx, Dy)

    PrintFont = New System.Drawing.Font("Times New Roman", 11, FontStyle.Regular)

    Call Get_Point(9, 635, Dx, Col_Top)
        e.DrawRectangle(Pens.Black, Offset + Dx, Col_Top, CInt(413 * XRatio), Col_Hight * 3)
            e.DrawString("Name", PrintFont, Brushes.Black, Offset + Dx + 5, Col_Top + 2)
            e.DrawLine(Pens.Black, Offset + Dx + Label_Width, Col_Top, Offset + Dx + Label_Width, Col_Top + Col_Hight * 3)
    Col_Top += Col_Hight

            Col_Right = Dx + 413 * XRatio
    Mid_Col_Width = ((XRatio * 413) - Col_Gap) / 2
            e.DrawLine(Pens.Black, Offset + Dx, Col_Top, Offset + Col_Right, Col_Top)
            e.DrawString("Course", PrintFont, Brushes.Black, Offset + Dx + 5, Col_Top + 2)

            e.DrawLine(Pens.Black, Offset + Dx + Mid_Col_Width, Col_Top, Offset + Dx + Mid_Col_Width, Col_Top + Col_Hight)
            e.DrawString("Division", PrintFont, Brushes.Black, Offset + Dx + Mid_Col_Width + Col_Gap + 5, Col_Top + 2)
            e.DrawLine(Pens.Black, Offset + Dx + Mid_Col_Width + Col_Gap + Label_Width, Col_Top, Offset + Dx + Mid_Col_Width + Col_Gap + Label_Width, Col_Top + Col_Hight)
    Col_Top += Col_Hight

        e.DrawLine(Pens.Black, Offset + Dx, Col_Top, Offset + Col_Right, Col_Top)
            e.DrawString("Subject", PrintFont, Brushes.Black, Offset + Dx + 5, Col_Top + 2)

    End Sub

    Private Sub Important_Column_60(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Dx As Integer
    Dim Dy As Integer
    Dim PrintFont As Font

        'Important Rectangle
    Call Get_Point(9, 572, Dx, Dy)
        e.DrawRectangle(Pens.Black, Offset + Dx, Dy, CInt(114 * XRatio), CInt(123 * YRatio))

            'Important Heading
    Call Get_Point(21, 570, Dx, Dy)
    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Bold)
            e.DrawString("IMPORTANT", PrintFont, Brushes.Black, Offset + Dx, Dy)

            'Important Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 8, FontStyle.Regular)
    Call Get_Point(9, 555, Dx, Dy)
        e.DrawString("1. Handle this sheet" & vbCrLf & "    carefully." & vbCrLf & _
                              "2. Use only blue or" & vbCrLf & "    black ball-point pen" & vbCrLf & _
                              "3. Any error in filling" & vbCrLf & "    this sheet may" & vbCrLf & "    prejudice your" & vbCrLf & "    selection.", PrintFont, Brushes.Black, Offset + Dx, Dy)

    End Sub

    Private Sub Signature_Column(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Dx As Integer
    Dim Dy As Integer
    Dim PrintFont As Font

        'Signature Column
    Call Get_Point(9, 200, Dx, Dy)
        e.DrawRectangle(Pens.Black, Offset + Dx, Dy, CInt(114 * XRatio), CInt(50 * YRatio))
    PrintFont = New System.Drawing.Font("Times New Roman", 8, FontStyle.Regular)
    Call Get_Point(9, 166, Dx, Dy)
        e.DrawString("Signature of Candidate", PrintFont, Brushes.Black, Offset + Dx + 1, Dy)

    End Sub

    Private Sub Marks_Column(ByRef e As Graphics, _
            ByVal Offset As Integer)

    Dim Dx As Integer
    Dim Dy As Integer
    Dim Mark_Col_Top As Integer
    Dim Dx2 As Integer
    Dim Dy2 As Integer
    Dim PrintFont As Font

        'Mark Columns
    Call Get_Point(9, 147, Dx, Mark_Col_Top)
        e.DrawRectangle(Pens.Black, Offset + Dx, Mark_Col_Top, CInt(114 * XRatio), CInt(66 * YRatio))
    Call Get_Point(153, 152, Dx2, Dy2)
        e.DrawLine(Pens.Black, Offset + Dx, Mark_Col_Top + CInt(33 * YRatio), Offset + Dx + CInt(114 * XRatio), Mark_Col_Top + CInt(33 * YRatio)) 'Horizontal Line
    Call Get_Point(72, 0, Dx, Dy)
        e.DrawLine(Pens.Black, Offset + Dx, Mark_Col_Top, Offset + Dx, Mark_Col_Top + CInt(66 * YRatio)) 'Vertical Line

            'Answered Mark Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Regular)
    Call Get_Point(9, 0, Dx, Dy)
        e.DrawString("Answered" & vbCrLf & "Questions", PrintFont, Brushes.Black, Offset + Dx, Mark_Col_Top)

            'Correct Answers Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Regular)
            e.DrawString("Correct" & vbCrLf & "Answers", PrintFont, Brushes.Black, Offset + Dx, Mark_Col_Top + CInt(33 * YRatio))

            'Total Mark Column
            e.DrawRectangle(Pens.Black, Offset + Dx, Mark_Col_Top + CInt(69 * YRatio), CInt(114 * XRatio), CInt(69 * YRatio))

            'Total Mark Matter
    PrintFont = New System.Drawing.Font("Times New Roman", 10, FontStyle.Bold Or FontStyle.Underline)
    Call Get_Point(15, 0, Dx, Dy)
        e.DrawString("TOTAL MARK", PrintFont, Brushes.Black, Offset + Dx, Mark_Col_Top + CInt(72 * YRatio))

    End Sub

    Public Sub Get_All_Bubble_Mark(ByVal Tot_Question As Integer, _
            ByRef BmOmr As Bitmap, _
                                           ByRef Digit_Mark(,) As Boolean, _
    ByRef Answer_Mark(,) As Boolean)

    Dim Digit_Bri(4, 10) As Double 'Digit Place, Digit Count
    Dim Answer_Bri(-1, -1) As Double 'Tot Qu, Choice
    Dim Brightness_Level As Double
    Dim Digit_Place As Integer
    Dim Digit_Cnt As Integer
    Dim Qu_Num As Integer
    Dim Choice As Integer

    Call Get_All_Bubble_Brightness(Tot_Question, BmOmr, Digit_Bri, Answer_Bri, Brightness_Level)

    ReDim Answer_Mark(Tot_Question, 5)

    For Digit_Place = 1 To 4
    For Digit_Cnt = 1 To 10

    If Digit_Bri(Digit_Place, Digit_Cnt) < Brightness_Level Then
    Digit_Mark(Digit_Place, Digit_Cnt) = True
            Else
    Digit_Mark(Digit_Place, Digit_Cnt) = False
    End If

    Next
            Next

    For Qu_Num = 1 To Tot_Question
    For Choice = 1 To Total_Choice

    If Answer_Bri(Qu_Num, Choice) < Brightness_Level Then
    Answer_Mark(Qu_Num, Choice) = True
            Else
    Answer_Mark(Qu_Num, Choice) = False
    End If

    Next
            Next

    End Sub

    Public Sub Get_All_Bubble_Brightness(ByVal Tot_Question As Integer, _
            ByRef BmOmr As Bitmap, _
                                                 ByRef Digit_Bri(,) As Double, _
    ByRef Answer_Bri(,) As Double, _
    ByRef Brightness_Level As Double)

    Dim Digit_Place As Integer
    Dim Digit_Cnt As Integer
    Dim Qu_Num As Integer
    Dim Choice As Integer
    Dim Max_Bri As Double = -100
    Dim Min_Bri As Double = 100

    ReDim Answer_Bri(Tot_Question, 5)

    For Digit_Place = 1 To 4
    For Digit_Cnt = 1 To 10

    Digit_Bri(Digit_Place, Digit_Cnt) = Get_RollNo_Mark_Brightness(BmOmr, Digit_Cnt, Digit_Place)

    If Digit_Bri(Digit_Place, Digit_Cnt) > Max_Bri Then
    Max_Bri = Digit_Bri(Digit_Place, Digit_Cnt)
    End If

    If Digit_Bri(Digit_Place, Digit_Cnt) < Min_Bri Then
            Min_Bri = Digit_Bri(Digit_Place, Digit_Cnt)
    End If

    Next
            Next

    For Qu_Num = 1 To Tot_Question
    For Choice = 1 To Total_Choice

    Answer_Bri(Qu_Num, Choice) = Get_Ans_Bubble_Mark_Brightness(BmOmr, Qu_Num, Choice)

    If Answer_Bri(Qu_Num, Choice) > Max_Bri Then
    Max_Bri = Answer_Bri(Qu_Num, Choice)
    End If

    If Answer_Bri(Qu_Num, Choice) < Min_Bri Then
            Min_Bri = Answer_Bri(Qu_Num, Choice)
    End If

    Next
            Next

    If (Max_Bri - Min_Bri) < 0.2 Then
            Brightness_Level = 0.5
    Else
            Brightness_Level = (Max_Bri + Min_Bri) / 2.0
    End If

    End Sub

}
