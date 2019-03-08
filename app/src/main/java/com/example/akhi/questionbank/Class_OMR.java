package com.example.akhi.questionbank;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.support.v4.graphics.ColorUtils;

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

    private double Ali_Bri_Level;

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

    public void Class_OMR() {

        String Bri_Lev;

        Bri_Lev = ""; //Get_Soft_Settings_From_File("Ali_Point_Brightness");

        if (Bri_Lev == "") {
            Ali_Bri_Level = 0.8; //0.6
        } else {
            Ali_Bri_Level = java.lang.Double.parseDouble(Bri_Lev);
        }

        OMR_Image_Formats[0] = "*.jpg";
        OMR_Image_Formats[1] = "*.jpeg";
        OMR_Image_Formats[2] = "*.bmp";
        OMR_Image_Formats[3] = "*.tif";
        OMR_Image_Formats[4] = "*.tiff";
        OMR_Image_Formats[5] = "*.png";

        //Letter_Pen.DashPattern = New Single() {3, 3}
        //Letter_Pen.DashStyle = Drawing2D.DashStyle.Custom
    }

    public class PointD {

        public double x;
        public double y;

        public PointD() {
            this.x = 0;
            this.y = 0;
        }

        public PointD(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public PointD(PointD src) {
            this.x = src.x;
            this.y = src.y;
        }

        public PointD(Point src) {
            this.x = (double) src.x;
            this.y = (double) src.y;
        }

        public Point ToPoint() {
            return new Point((int) java.lang.Math.round(x), (int) java.lang.Math.round(y));
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
            Ans_Sheet_Questions_Return = 60;
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

    public void Get_Allignment_Mark_Area(int Sheet_Hight, int Sheet_Width, int[] Left_x, int[] Right_x, int[] Top_y, int[] Bottom_y, Point Ali_Squ_Thick_Max, Point Ali_Squ_Thick_Min, Point Ali_Blank_Space, int Ans_Sheet_Type) {

        double X_Ratio;
        double Y_Ratio;
        int i;

        Load_Alignment(Ans_Sheet_Type);

        Sheet_Hight -= 1;
        Sheet_Width -= 1;

        X_Ratio = Sheet_Width / (Def_TR_x + Def_TL_x);
        Y_Ratio = Sheet_Hight / (Def_BL_y + Def_TL_y);

        //Top Left Allignment Area
        Left_x[1] = 0;
        Right_x[1] = (int) java.lang.Math.round(X_Ratio * (Def_TL_x + 93));
        Top_y[1] = 0;
        Bottom_y[1] = (int) java.lang.Math.round(Y_Ratio * (Def_TL_y + 93));

        //Top Right Allignment Area
        Left_x[2] = (int) java.lang.Math.round(X_Ratio * (Def_TR_x - 93));
        Right_x[2] = Sheet_Width;
        Top_y[2] = 0;
        Bottom_y[2] = (int) java.lang.Math.round(Y_Ratio * (Def_TR_y + 93));

        //Bottom Right Allignment Area
        Left_x[3] = (int) java.lang.Math.round(X_Ratio * (Def_BR_x - 93));
        Right_x[3] = Sheet_Width;
        Top_y[3] = (int) java.lang.Math.round(Y_Ratio * (Def_BR_y - 93));
        Bottom_y[3] = Sheet_Hight;

        //Bottom Left Allignment Area
        Left_x[4] = 0;
        Right_x[4] = (int) java.lang.Math.round(X_Ratio * (Def_BL_x + 93));
        Top_y[4] = (int) java.lang.Math.round(Y_Ratio * (Def_BL_y - 93));
        Bottom_y[4] = Sheet_Hight;

        for (i = 0; i <= 4; i++) {
            if (Left_x[i] < 0) Left_x[i] = 0;
            if (Right_x[i] > Sheet_Width) Right_x[i] = Sheet_Width;
            if (Top_y[i] < 0) Top_y[i] = 0;
            if (Bottom_y[i] > Sheet_Hight) Bottom_y[i] = Sheet_Hight;
        }

        Ali_Blank_Space.x = (int) java.lang.Math.round(X_Ratio * Squ_Blank_Space_x);
        Ali_Blank_Space.y = (int) java.lang.Math.round(Y_Ratio * Squ_Blank_Space_y);

        Ali_Squ_Thick_Max.x = (int) java.lang.Math.round(X_Ratio * Squ_Thick * Squ_Thick_Max / 100);
        Ali_Squ_Thick_Max.y = (int) java.lang.Math.round(Y_Ratio * Squ_Thick * Squ_Thick_Max / 100);

        Ali_Squ_Thick_Min.x = (int) java.lang.Math.round(X_Ratio * Squ_Thick * Squ_Thick_Min / 100);
        Ali_Squ_Thick_Min.y = (int) java.lang.Math.round(Y_Ratio * Squ_Thick * Squ_Thick_Min / 100);
    }

    public Point Get_Right_Ali_Point_Def(int Point_Num) {

        int Right_Ali_Len;
        Point rP = new Point(0, 0);

        rP.x = (int) java.lang.Math.round(Def_TR_x - Def_TL_x + Mid_Ali_Shift);
        rP.y = 0;

        Right_Ali_Len = (int) java.lang.Math.round((Def_BR_y - Def_TR_y) / (Right_Ali_Points_Cnt + 1));

        rP.y += (Right_Ali_Len * Point_Num);

        return rP;
    }

    private void Get_Vertical_Line_Mid_Ali(PointD _In, PointD Tf, PointD Bf) {

        PointD In = new PointD(_In);
        double Ll; //Section Formula ' l' at Left
        double Lm; //Section Formula ' m' at Left

        Bottom_Point bPoint = new Bottom_Point((int) java.lang.Math.round(Bf.x), (int) java.lang.Math.round(Bf.y));
        Bf = new PointD(Get_Bottom_Point(In.x));
        Bf.x = bPoint.Bx;
        Bf.y = bPoint.By;

        Ll = Bf.x - BL_x;
        Lm = BR_x - Bf.x;

        Tf = Section_Formula(new PointD(TL_x, TL_y), new PointD(TR_x, TR_y), Ll, Lm);
    }

    private PointD Section_Formula(PointD _A, PointD _B, double _l, double _m) {

        PointD rP = new PointD();
        PointD A = new PointD(_A);
        PointD B = new PointD(_B);

        rP.x = ((_l * B.x) + (_m * A.x)) / (_l + _m);
        rP.y = ((_l * B.y) + (_m * A.y)) / (_l + _m);
        return rP;
    }

    private class Bottom_Point {
        int Bx;
        int By;

        public Bottom_Point(int _Bx, int _By) {
            this.Bx = _Bx;
            this.By = _By;
        }
    }

    private Point Get_Bottom_Point(double In_x) {

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
        Act_Left_x = (int) java.lang.Math.round(BL_x);
        Act_Left_y = (int) java.lang.Math.round(BL_y);
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
            Right.x = (int) java.lang.Math.round(Def_BR_x - Def_BL_x);
            Right.y = 0;
            Act_Right.x = (int) java.lang.Math.round(BR_x);
            Act_Right.y = (int) java.lang.Math.round(BR_y);
        }

        Rl = In_x - Left_x;
        Rm = Right.x - In_x;

        return Section_Formula(new PointD(Act_Left_x, Act_Left_y), new PointD(Act_Right), Rl, Rm).ToPoint();
    }

    public Point Get_Bottom_Ali_Point_Def(int Point_Num) {

        int Bottom_Ali_Len;
        Point rP = new Point(0, 0);

        rP.x = 0;
        rP.y = -Mid_Ali_Shift;

        Bottom_Ali_Len = (int) java.lang.Math.round((Def_BR_x - Def_BL_x) / (Bottom_Ali_Points_Cnt + 1));

        rP.x += (Bottom_Ali_Len * Point_Num);

        return rP;
    }

    public Point Get_Point(PointD _In) {

        PointD In = new PointD(_In);
        PointD Tf = new PointD();
        PointD Bf = new PointD();
        PointD Lf = new PointD();
        PointD Rf = new PointD();

        Get_Vertical_Line(In, Tf, Bf);
        Get_Horizontal_Line(In, Lf, Rf);

        return Get_Intersection_Of_Two_Line_A_And_B(new Point(Lf.ToPoint()), new Point(Rf.ToPoint()), new Point(Bf.ToPoint()), new Point(Tf.ToPoint()));
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

    private void Get_Horizontal_Line(PointD _In, PointD Lf, PointD Rf) {

        PointD In = new PointD(_In);
        double Ll; //Section Formula 'l' at Left
        double Lm; //Section Formula 'm' at Left
        double Rl; //Section Formula 'l' at Right
        double Rm; //Section Formula 'm' at Right

        Ll = In.y;
        Lm = Def_BL_y - Def_TL_y - In.y;

        Rl = In.y;
        Rm = Def_BR_y - Def_TR_y - Rl;

        Lf = Section_Formula(new PointD(BL_x, BL_y), new PointD(TL_x, TL_y), Ll, Lm);
        Rf = Section_Formula(new PointD(BR_x, BR_y), new PointD(TR_x, TR_y), Rl, Rm);
    }

    private void Get_Vertical_Line(PointD _In, PointD Tf, PointD Bf) {

        PointD In = new PointD(_In);
        double Tl; //Section Formula ' l ' at Top
        double Tm; //Section Formula ' m ' at Top
        double Bl; //Section Formula ' l ' at Bottom
        double Bm; //Section Formula ' m ' at Bottom

        Tl = In.x;
        Tm = Def_TR_x - Def_TL_x - In.x;

        Bl = In.x;
        Bm = Def_BR_x - Def_BL_x - In.x;

        Tf = Section_Formula(new PointD(TL_x, TL_y), new PointD(TR_x, TR_y), Tl, Tm);
        Bf = Section_Formula(new PointD(BL_x, BL_y), new PointD(BR_x, BR_y), Bl, Bm);
    }

    public Point Get_Intersection_Of_Two_Line_A_And_B(Point _A1, Point _A2, Point _B1, Point _B2) {

        Point A1 = new Point(_A1);
        Point A2 = new Point(_A2);
        Point B1 = new Point(_B1);
        Point B2 = new Point(_B2);
        Point iP = new Point(0, 0);
        double PartA;
        double PartB;
        double PartC;

        if (A1.x == A2.x) {
            iP.x = A1.x;
        } else if (B1.x == B2.x) {
            iP.x = B1.x;
        } else {
            PartA = ((A1.y - A2.y) / (A1.x - A2.x)) - ((B1.y - B2.y) / (B1.x - B2.x));
            PartB = ((B1.x * B2.y) - (B2.x * B1.y)) / (B1.x - B2.x);
            PartC = ((A1.x * A2.y) - (A2.x * A1.y)) / (A1.x - A2.x);

            try {
                iP.x = (int) java.lang.Math.round((PartB - PartC) / PartA);
            } catch (Exception e) {
                iP.x = 0;
            }
        }

        if (B1.y == B2.y) {
            iP.y = B1.y;
        } else if (A1.y == A2.y) {
            iP.y = A1.y;
        } else {

            PartA = ((A1.x - A2.x) / (A1.y - A2.y)) - ((B1.x - B2.x) / (B1.y - B2.y));
            PartB = ((B1.y * B2.x) - (B2.y * B1.x)) / (B1.y - B2.y);
            PartC = ((A1.y * A2.x) - (A2.y * A1.x)) / (A1.y - A2.y);

            try {
                iP.y = (int) java.lang.Math.round((PartB - PartC) / PartA);
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
            Right_Ali[i] = Get_Point(new PointD(Right_Ali[i]));
        }

        for (i = 1; i <= Bottom_Ali_Points_Cnt; i++) {
            Bottom_Ali[i] = Get_Bottom_Ali_Point_Def(i);
            Bottom_Ali[i] = Get_Point(new PointD(Bottom_Ali[i]));
        }

        Calculate_Side_Length_And_Ratio();
    }

    public void Set_Alignment(PointD In_TL, PointD In_TR, PointD In_BL, PointD In_BR, int Ans_Sheet_Type) {

        Load_Alignment(Ans_Sheet_Type);

        TL_x = In_TL.x;
        TL_y = In_TL.y;

        TR_x = In_TR.x;
        TR_y = In_TR.y;

        BL_x = In_BL.x;
        BL_y = In_BL.y;

        BR_x = In_BR.x;
        BR_y = In_BR.y;

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

    public PointD Get_Point_Mid_Ali(PointD _In) {

        PointD In = new PointD(_In);
        PointD Tf = new PointD(0, 0);
        PointD Bf = new PointD(0, 0);
        PointD Lf = new PointD(0, 0);
        PointD Rf = new PointD(0, 0);

        Get_Vertical_Line_Mid_Ali(In, Tf, Bf);
        Get_Horizontal_Line_Mid_Ali(In, Lf, Rf);

        Point Out = Get_Intersection_Of_Two_Line_A_And_B(new Point(Lf.ToPoint()), new Point(Rf.ToPoint()), new Point(Bf.ToPoint()), new Point(Tf.ToPoint()));

        return new PointD(Out);
    }

    private void Get_Horizontal_Line_Mid_Ali(PointD _In, PointD Lf, PointD Rf) {

        PointD In = new PointD(_In);
        double Ll; //Section Formula ' l ' at Left
        double Lm; //Section Formula ' m ' at Left

        Rf = new PointD(Get_Right_Point(In.y));

        Ll = Rf.y - BR_y;
        Lm = TR_y - Rf.y;

        Lf = Section_Formula(new PointD(BL_x, BL_y), new PointD(TL_x, TL_y), Ll, Lm);
    }

    private Point Get_Right_Point(double In_y) {

        Point Top = new Point(0, 0);
        Point Bottom = new Point(0, 0);
        int i;
        boolean Find_Ok;
        double Rl; //Section Formula 'l' at Right
        double Rm; //Section Formula 'm' at Right
        Point Act_Top = new Point(0, 0);
        Point Act_Bottom = new Point(0, 0);

        Bottom.x = (int) java.lang.Math.round(Def_BR_x - Def_BL_x);
        Bottom.y = 0;
        Act_Bottom.x = (int) java.lang.Math.round(BR_x);
        Act_Bottom.y = (int) java.lang.Math.round(BR_y);
        Find_Ok = false;

        for (i = 1; i <= Right_Ali_Points_Cnt; i++) {

            Top = Get_Right_Ali_Point_Def(i);
            Act_Top.x = Right_Ali[i].x;
            Act_Top.y = Right_Ali[i].y;

            if (Bottom.y <= In_y && In_y < Top.y) {
                Find_Ok = true;
                break;
            }

            Bottom.x = Top.x;
            Bottom.y = Top.y;
            Act_Bottom.x = Act_Top.x;
            Act_Bottom.y = Act_Top.y;
        }

        if (!Find_Ok) {
            Top.x = (int) java.lang.Math.round(Def_TR_x - Def_TL_x);
            Top.y = (int) java.lang.Math.round(Def_BR_y - Def_TR_y);
            Act_Top.x = (int) java.lang.Math.round(TR_x);
            Act_Top.y = (int) java.lang.Math.round(TR_y);
        }

        Rl = In_y - Bottom.y;
        Rm = Top.y - In_y;

        return Section_Formula(new PointD(Act_Bottom), new PointD(Act_Top), Rl, Rm).ToPoint();
    }

    public double Get_RollNo_Mark_Brightness(Bitmap BmOmr, int Digit_Cnt, int Digit_Place) {

        Point Bubble = new Point(0, 0);

        Bubble = Get_RollNumber_Bubble(Digit_Cnt, Digit_Place);

        return Get_Bubble_Mark_Brightness(BmOmr, Bubble);
    }

    public Point Get_RollNumber_Bubble(int Digit_Cnt, int Digit_Place) {

        Point Bubble = new Point(0, 0);
        Point B = new Point(0, 0);

        if (Digit_Cnt > 10 || Digit_Place > 5) return null;

        B.x = Bubble_RollNo_Offset_x + Digit_Place * Bubble_Hori_Space;

        if (Digit_Cnt > 30) {
            B.x += 180;
            B.y = Bubble_RollNo_Offset_y - ((Digit_Cnt - 31) * Bubble_Vert_Space);
        } else {
            B.y = Bubble_RollNo_Offset_y - ((Digit_Cnt - 1) * Bubble_Vert_Space);
        }

        Bubble = Get_Point_Mid_Ali(new PointD(B)).ToPoint(); //Call Get_Point(Bx, By, Bubble_x, Bubble_y)
        return Bubble;
    }

    public double Get_Bubble_Mark_Brightness(Bitmap BmOmr, Point _Bubble) {

        Point Bubble = new Point(_Bubble);
        int x;
        int y;
        int Omr_Bubble_Height;
        int Omr_Bubble_Width;
        double Tot_Bri;
        int Tot_Cnt;

        Omr_Bubble_Width = (int) java.lang.Math.round(Bubble_Width * XRatio);
        Omr_Bubble_Height = (int) java.lang.Math.round(Bubble_Height * YRatio);

        Tot_Bri = 0;
        Tot_Cnt = 0;

        for (x = Bubble.x - (Omr_Bubble_Width / 2); x <= Bubble.x + (Omr_Bubble_Width / 2); x++) {
            for (y = Bubble.y - (Omr_Bubble_Height / 2); y <= Bubble.y + (Omr_Bubble_Height / 2); y++) {
                Tot_Bri += GetBrightness(BmOmr.getPixel(x, y));
                Tot_Cnt += 1;
            }
        }

        return (Tot_Bri / Tot_Cnt);
    }

    private double GetBrightness(int color) {

        float[] hsl = new float[3];
        ColorUtils.colorToHSL(color, hsl);
        return (double) hsl[2];
    }

    public Point Get_Bubble(int Qu_Num, int Choice, int Total_Column) {

        PointD B = new PointD();
        int ColumnIndex;
        int By_Num;

        if (Qu_Num > Total_Qu || Choice > 5) return null;

        B.x = Bubble_Offset_x + Choice * Bubble_Hori_Space;

        ColumnIndex = (int) ((Qu_Num - 1) / (Total_Qu / Total_Column)); //Take Integer part

        B.x = B.x + (Bubble_Col_Offset * ColumnIndex);
        By_Num = Qu_Num - (ColumnIndex * (Total_Qu / Total_Column));
        B.y = Bubble_Offset_y - ((By_Num - 1) * Bubble_Vert_Space);

        //Call Get_Point(Bx, By, Bubble_x, Bubble_y)
        return Get_Point_Mid_Ali(B).ToPoint();
    }

    public double Get_Ans_Bubble_Mark_Brightness(Bitmap BmOmr, int Qu_Num, int Choice) {

        Point Bubble = new Point(0, 0);

        Bubble = Get_Bubble(Qu_Num, Choice, Total_Column);
        return Get_Bubble_Mark_Brightness(BmOmr, Bubble);
    }

    private class Ali_Rotation_Mark {

        double Avg_Bri;
        boolean Ali_Rotation_Mark;
    }

    public Ali_Rotation_Mark Get_Ali_Rotation_Mark(Bitmap BmOmr, Point _A) {

        Point A = new Point(_A);
        int x;
        int y;
        int Omr_Bubble_Height;
        int Omr_Bubble_Width;
        double Tot_Bri = 0;
        int Tot_Cnt = 0;
        Ali_Rotation_Mark ret = new Ali_Rotation_Mark();

        Omr_Bubble_Width = (int) java.lang.Math.round(Bubble_Width * XRatio);
        Omr_Bubble_Height = (int) java.lang.Math.round(Bubble_Height * YRatio);

        for (x = A.x - (Squ_Thick / 2); x <= (A.x + (Squ_Thick / 2)); x++) {
            for (y = (A.y - (Squ_Thick / 2)); y <= (A.y + (Squ_Thick / 2)); y++) {
                Tot_Bri += GetBrightness(BmOmr.getPixel(x, y));
                Tot_Cnt += 1;
            }
        }

        ret.Avg_Bri = Tot_Bri / Tot_Cnt;

        if (ret.Avg_Bri < Ali_Bri_Level) {
            ret.Ali_Rotation_Mark = true;
        } else {
            ret.Ali_Rotation_Mark = false;
        }

        return ret;
    }

    public boolean Get_Center_Alignment_Mark(Bitmap BmOmr) {

        Point A;
        int i;
        Ali_Rotation_Mark ret = new Ali_Rotation_Mark();
        ret.Ali_Rotation_Mark = false;

        for (i = 1; i <= Bottom_Ali_Points_Cnt; i++) {
            A = Get_Bottom_Ali_Point_Def(i);
            A = Get_Point(new PointD(A));
            ret = Get_Ali_Rotation_Mark(BmOmr, A);
            if (ret.Ali_Rotation_Mark == false) break;
        }

        return ret.Ali_Rotation_Mark;
    }

    private Bitmap RotateBitmap(Bitmap BmOmr, float Degrees){

        Bitmap bOutput;
        Matrix matrix = new Matrix();
        matrix.setRotate(Degrees);
        bOutput = Bitmap.createBitmap(BmOmr, 0, 0, BmOmr.getWidth(), BmOmr.getHeight(), matrix, true);
        return bOutput;
    }

    private boolean Detect_Alignment_Points(Bitmap BmOmr, boolean Swap_xy,
                                            Point _Ali_Blank_Space,
                                            Point _Ali_Squ_Thick_Max,
                                            Point _Ali_Squ_Thick_Min,
                                            int[] Left_x,
                                            int[] Right_x,
                                            int[] Top_y,
                                            int[] Bottom_y,
                                            Point[] Ali) {

        Point Ali_Blank_Space = new Point(_Ali_Blank_Space);
        Point Ali_Squ_Thick_Max = new Point(_Ali_Squ_Thick_Max);
        Point Ali_Squ_Thick_Min = new Point(_Ali_Squ_Thick_Min);

        int i;
        int FTop_y;
        int FBottom_y;
        int FLeft_x;
        int FRight_x;
        boolean ret = false;

        for (i = 1; i <= 4; i++) {

            ret = false;

            if( i == 1 || i == 2) {
                FTop_y = Top_y[i];
                FBottom_y = Bottom_y[i];
            }
            else {
                FTop_y = Bottom_y[i];
                FBottom_y = Top_y[i];
            }

            if(i == 1 || i == 4) {
                FLeft_x = Left_x[i];
                FRight_x = Right_x[i];
            }
            else {
                FLeft_x = Right_x[i];
                FRight_x = Left_x[i];
            }

            ret = Get_Alignment_Point(BmOmr, Swap_xy, Ali_Blank_Space, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, FLeft_x, FRight_x, FTop_y, FBottom_y, Ali[i]);

            if(ret == false) break;
        }

        return ret;
    }

    private boolean Get_Alignment_Point(Bitmap BmOmr,
                                        boolean Swap_xy,
                                        Point _Ali_Blank_Space,
                                        Point _Ali_Squ_Thick_Max,
                                        Point _Ali_Squ_Thick_Min,
                                        int Left_x, int Right_x,
                                        int Top_y, int Bottom_y,
                                        Point Ali) {

        Point Ali_Blank_Space = new Point(_Ali_Blank_Space);
        Point Ali_Squ_Thick_Max = new Point(_Ali_Squ_Thick_Max);
        Point Ali_Squ_Thick_Min = new Point(_Ali_Squ_Thick_Min);
        int Sy;
        int Step_y;
        boolean ret = false;

        if (Top_y <= Bottom_y) {
            Step_y = 1;
        } else {
            Step_y = -1;
        }

        for (Sy = Top_y; CheckLoop(Top_y, Bottom_y, Sy); Sy += Step_y) {
            if (Find_X_Pattern(BmOmr, Swap_xy, Ali_Blank_Space, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, Sy, Left_x, Right_x, Top_y, Bottom_y, Ali)) {
                ret = true;
                break;
            }
        }

        return ret;
    }

    private boolean Find_X_Pattern(Bitmap BmOmr,
                                   boolean Swap_xy,
                                   Point _Ali_Blank_Space,
                                   Point Ali_Squ_Thick_Max,
                                   Point Ali_Squ_Thick_Min,
                                   int y,
                                   int Left_x, int Right_x,
                                   int Top_y, int Bottom_y,
                                   Point Ali) {

        Point Ali_Blank_Space = new Point(_Ali_Blank_Space);
        double PixBri;
        boolean Bri_Dar;
        boolean First_Block = false;
        boolean Second_Block = false;
        boolean Third_Block = false;
        int Block_Len = 0;
        int x;
        int Mark_Start_x = 0;
        int Mark_End_x = 0;
        int Step_x;
        boolean ret = false;

        if (Left_x <= Right_x) {
            Step_x = 1;
        } else {
            Step_x = -1;
        }

        for (x = Left_x; CheckLoop(Left_x,Right_x, x); x += Step_x) {

            if (!Swap_xy) {
                PixBri = GetBrightness(BmOmr.getPixel(x, y));
            } else {
                PixBri = GetBrightness(BmOmr.getPixel(y, x));
            }

            if (PixBri >= Ali_Bri_Level) {
                Bri_Dar = true;
            } else {
                Bri_Dar = false;
            }

            if (!First_Block) {

                if (Bri_Dar) {
                    Block_Len += 1;
                } else {

                    if (Block_Len >= Ali_Blank_Space.x) {
                        First_Block = true;
                        Mark_Start_x = x;
                        Block_Len = 1;
                    } else {
                        Block_Len = 0;
                    }

                }

            } else if (!Second_Block) {

                if (!Bri_Dar) {
                    Block_Len += 1;
                } else {

                    if (Block_Len <= Ali_Squ_Thick_Max.x && Block_Len >= Ali_Squ_Thick_Min.x) {
                        Second_Block = true;
                        Mark_End_x = x - 1;
                        Block_Len = 1;
                    } else {
                        First_Block = false;
                        Block_Len = 0;
                    }
                }
            } else if (!Third_Block) {

                if (Bri_Dar) {

                    Block_Len += 1;

                    if (Block_Len >= Ali_Blank_Space.x) {

                        Third_Block = true;

                        if (Find_Y_Pattern(BmOmr, Swap_xy, Ali_Blank_Space.y, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, y, Top_y, Bottom_y, Mark_Start_x, Mark_End_x, Ali)) {
                            Ali.x = (Mark_Start_x + Mark_End_x) / 2;
                            return true;
                        } else {
                            First_Block = false;
                            Second_Block = false;
                            Third_Block = false;
                        }
                    }
                } else {
                    First_Block = false;
                    Second_Block = false;
                    Block_Len = 0;
                }
            }
        }

        return ret;
    }

    private boolean Find_Y_Pattern(Bitmap BmOmr,
                                   boolean Swap_xy,
                                   int Ali_Blank_Space_Y,
                                   Point Ali_Squ_Thick_Max,
                                   Point Ali_Squ_Thick_Min,
                                   int Sel_y,
                                   int Top_y, int Bottom_y,
                                   int Mark_Start_x, int Mark_End_x,
                                   Point Ali) {

        int Mid_Mark_Start_x;
        int Mid_Mark_End_x;
        boolean ret;

        Mid_Mark_Start_x = Mark_Start_x;
        Mid_Mark_End_x = Mark_Start_x + (Mark_End_x - Mark_Start_x) / 2;

        ret = Find_Y_Pattern_Sub(BmOmr, Swap_xy, Ali_Blank_Space_Y, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, Sel_y, Top_y, Bottom_y, Mid_Mark_Start_x, Mid_Mark_End_x, Ali);

        if (!ret) return ret;

        Mid_Mark_Start_x = (int) java.lang.Math.round(Mid_Mark_End_x + java.lang.Math.signum(Mark_End_x - Mark_Start_x));
        Mid_Mark_End_x = Mark_End_x;

        ret = Find_Y_Pattern_Sub(BmOmr, Swap_xy, Ali_Blank_Space_Y, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, Sel_y, Top_y, Bottom_y, Mid_Mark_Start_x, Mid_Mark_End_x, Ali);

        return ret;
    }

    private boolean Find_Y_Pattern_Sub(Bitmap BmOmr,
                                       boolean Swap_xy,
                                       int Ali_Blank_Space_Y,
                                       Point Ali_Squ_Thick_Max,
                                       Point Ali_Squ_Thick_Min,
                                       int Sel_y,
                                       int Top_y, int Bottom_y,
                                       int Mark_Start_x, int Mark_End_x,
                                       Point Ali) {

        int x;
        Check_Y_Line_Par CYLPar = new Check_Y_Line_Par();
        int Step_x;
        boolean ret = false;

        if (Mark_Start_x <= Mark_End_x) {
            Step_x = 1;
        } else {
            Step_x = -1;
        }

        for (x = Mark_Start_x; CheckLoop(Mark_Start_x,Mark_End_x, x ); x += Step_x) {

            Check_Y_Line(BmOmr, Swap_xy, new Point(x, Sel_y), Top_y, Bottom_y, Ali, CYLPar);

            if (CYLPar.Mark_Len <= Ali_Squ_Thick_Max.y && CYLPar.Mark_Len >= Ali_Squ_Thick_Min.y && CYLPar.Top_Blank_Len >= Ali_Blank_Space_Y && CYLPar.Bottom_Blank_Len >= Ali_Blank_Space_Y) {
                ret = true;
                break;
            }
        }

        return ret;
    }

    private class Check_Y_Line_Par {

        public int Top_Blank_Len;
        public int Mark_Len;
        public int Bottom_Blank_Len;

        public Check_Y_Line_Par(int _Top_Blank_Len, int _Mark_Len, int _Bottom_Blank_Len){
            Top_Blank_Len = _Top_Blank_Len;
            Mark_Len = _Mark_Len;
            Bottom_Blank_Len = _Bottom_Blank_Len;
        }

        public Check_Y_Line_Par(){
            Top_Blank_Len = 0;
            Mark_Len = 0;
            Bottom_Blank_Len = 0;
        }
    }

    private void Check_Y_Line(Bitmap BmOmr,
                              boolean Swap_xy,
                              Point _S,
                              int Top_y, int Bottom_y,
                              Point Ali,
                              Check_Y_Line_Par par) {

        Point S = new Point(_S);
        Check_Y_Line_Half_Par CYLHPar_1 = new Check_Y_Line_Half_Par(0, par.Top_Blank_Len, 0);
        Check_Y_Line_Half_Par CYLHPar_2 = new Check_Y_Line_Half_Par(0, par.Bottom_Blank_Len, 0);

        Check_Y_Line_Half(BmOmr, Swap_xy, S.x, S.y, Top_y, CYLHPar_1);
        par.Top_Blank_Len = CYLHPar_1.Blank_Len;

        Check_Y_Line_Half(BmOmr, Swap_xy, S.x, S.y, Bottom_y, CYLHPar_2);
        par.Bottom_Blank_Len = CYLHPar_1.Blank_Len;

        par.Mark_Len = CYLHPar_1.Mark_Len + CYLHPar_2.Mark_Len - 1;
        Ali.y = (CYLHPar_1.Mark_End_y + CYLHPar_2.Mark_End_y) / 2;
    }

    private class Check_Y_Line_Half_Par{

        public int Mark_Len;
        public int Blank_Len;
        public int Mark_End_y;

        public Check_Y_Line_Half_Par(){
            Mark_Len = 0;
            Blank_Len = 0;
            Mark_End_y = 0;
        }

        public Check_Y_Line_Half_Par(int _Mark_Len, int _Blank_Len, int _Mark_End_y){
            Mark_Len = _Mark_Len;
            Blank_Len = _Blank_Len;
            Mark_End_y = _Mark_End_y;
        }
    }

    private void Check_Y_Line_Half(Bitmap BmOmr,
                                   boolean Swap_xy,
                                   int Sx,
                                   int Start_y, int Stop_y,
                                   Check_Y_Line_Half_Par par) {

        int y;
        int Step_y;
        double PixBri;
        boolean Bri;
        boolean Mark_Ok;

        if (Start_y <= Stop_y) {
            Step_y = 1;
        } else {
            Step_y = -1;
        }

        par.Mark_Len = 0;
        par.Blank_Len = 0;
        Mark_Ok = false;

        for (y = Start_y; CheckLoop(Start_y, Stop_y, y); y += Step_y) {

            if (!Swap_xy) {
                PixBri = GetBrightness(BmOmr.getPixel(Sx, y));
            } else {
                PixBri = GetBrightness(BmOmr.getPixel(y, Sx));
            }

            if (PixBri >= Ali_Bri_Level) {
                Bri = true;
            } else {
                Bri = false;
            }

            if (!Bri) {
                if (Mark_Ok) {
                    break;
                } else {
                    par.Mark_Len += 1;
                }
            } else {

                if (!Mark_Ok) {
                    par.Mark_End_y = y - 1;
                    Mark_Ok = true;
                }

                par.Blank_Len += 1;
            }
        }
    }

    public boolean Alignment_Detect(Bitmap BmOmr, Point[] Ali, int Ans_Sheet_Type) {

        int[] Left_x = new int[5];
        int[] Right_x = new int[5];
        int[] Top_y = new int[5];
        int[] Bottom_y = new int[5];
        Point Ali_Squ_Thick_Max = new Point(0, 0);
        Point Ali_Squ_Thick_Min = new Point(0, 0);
        Point Ali_Blank_Space = new Point(0, 0);
        PointD Tolerance = new PointD();
        boolean Right_Ali;
        boolean Bottom_Ali;
        boolean ret;

        if (BmOmr.getHeight() < BmOmr.getWidth()) {
            BmOmr = RotateBitmap(BmOmr, 90);
        }

        Get_Allignment_Mark_Area(BmOmr.getHeight(), BmOmr.getWidth(), Left_x, Right_x, Top_y, Bottom_y, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, Ali_Blank_Space, Ans_Sheet_Type);

        ret = Detect_Alignment_Points(BmOmr, false, Ali_Blank_Space, Ali_Squ_Thick_Max, Ali_Squ_Thick_Min, Left_x, Right_x, Top_y, Bottom_y, Ali);

        if (ret) {

            Tolerance.x = BmOmr.getWidth() * Ali_Check_Tolerance / 100;
            Tolerance.y = BmOmr.getHeight() * Ali_Check_Tolerance / 100;

            Set_Alignment(new PointD(Ali[1]), new PointD(Ali[2]), new PointD(Ali[4]), new PointD(Ali[3]), Ans_Sheet_Type);

            if (java.lang.Math.abs(Top_Len - Bottom_Len) > Tolerance.x) {
                return false;
            }

            if (!Get_Center_Alignment_Mark(BmOmr)) {

                Rotate_Plane(Ali);
                Rotate_Plane(Ali);

                Set_Alignment(new PointD(Ali[1]), new PointD(Ali[2]), new PointD(Ali[4]), new PointD(Ali[3]), Ans_Sheet_Type);

                if (!Get_Center_Alignment_Mark(BmOmr)) {
                    return false;
                }
            }

            Right_Ali = Get_Right_Ali_Positions(BmOmr, Ans_Sheet_Type);
            Bottom_Ali = Get_Bottom_Ali_Positions(BmOmr, Ans_Sheet_Type);

            if (Right_Ali && Bottom_Ali) {
                ret = true;
            } else {
                ret = false;
            }
        }

        return ret;
    }

    private void Rotate_Plane(Point[] Ali) {
        int i;
        Ali[0].x = Ali[4].x;
        Ali[0].y = Ali[4].y;

        for (i = 4; i != 1; i--) {
            Ali[i].x = Ali[i - 1].x;
            Ali[i].y = Ali[i - 1].y;
        }
    }

    private boolean Get_Right_Ali_Positions(Bitmap BmOmr, int Ans_Sheet_Type) {

        int Point_Num;
        Point A = new Point(0, 0);
        Point Left = new Point(0,0);
        Point Right = new Point(0,0);
        Point Top = new Point(0,0);
        Point Bottom = new Point(0,0);
        Point Vert_Squ_Thick_Max = new Point(0, 0);
        Point Vert_Squ_Thick_Min = new Point(0, 0);
        Point Vert_Blank_Space = new Point(0, 0);
        Point Ali = new Point(0, 0);
        boolean ret = false;

        for (Point_Num = 1; Point_Num <= Right_Ali_Points_Cnt; Point_Num++) {

            A = Get_Right_Ali_Point_Def(Point_Num);
            A = Get_Point(new PointD(A));
            Get_Right_Ali_Search_Area(A, BmOmr.getHeight(), BmOmr.getWidth(), Left, Right, Top, Bottom, Vert_Squ_Thick_Max, Vert_Squ_Thick_Min, Vert_Blank_Space, Ans_Sheet_Type);

            //Call Draw_Rectangle(BmOmr, Left_x, Right_x, Top_y, Bottom_y)

            ret = Get_Alignment_Point(BmOmr, true, new Point(Vert_Blank_Space.y, Vert_Blank_Space.x), new Point(Vert_Squ_Thick_Max.y, Vert_Squ_Thick_Max.x), new Point(Vert_Squ_Thick_Min.y, Vert_Squ_Thick_Min.x), Top.y, Bottom.y, Left.x, Right.x, Ali);

            Right_Ali[Point_Num].x = Ali.x;
            Right_Ali[Point_Num].y = Ali.y;

            if (!ret) {
                break;
            }
        }

        return ret;
    }

    private void Get_Right_Ali_Search_Area(Point _A,
                                           int Sheet_Hight,
                                           int Sheet_Width,
                                           Point Left,
                                           Point Right,
                                           Point Top,
                                           Point Bottom,
                                           Point Vert_Squ_Thick_Max,
                                           Point Vert_Squ_Thick_Min,
                                           Point Vert_Blank_Space,
                                           int Ans_Sheet_Type) {

        Point A = new Point(_A);
        Sheet_Hight -= 1;
        Sheet_Width -= 1;

        //Top Left Allignment Area
        Left.x = (int) java.lang.Math.round(A.x - (15 * XRatio));
        Right.x = (int) java.lang.Math.round(A.x + (15 * XRatio));
        Top.y = (int) java.lang.Math.round(A.y - (24 * YRatio_Right));
        Bottom.y = (int) java.lang.Math.round(A.y + (24 * YRatio_Right));

        if (Left.x < 0) Left.x = 0;
        if (Right.x > Sheet_Width) Right.x = Sheet_Width;
        if (Top.y < 0) Top.y = 0;
        if (Bottom.y > Sheet_Hight) Bottom.y = Sheet_Hight;

        Vert_Blank_Space.x = (int) java.lang.Math.round(XRatio * Squ_Blank_Space_Width_Wise);
        Vert_Blank_Space.y = (int) java.lang.Math.round(YRatio_Right * Squ_Blank_Space_Length_Wise);

        Vert_Squ_Thick_Max.x = (int) java.lang.Math.round(XRatio * Squ_Thick * Squ_Thick_Max / 100);
        Vert_Squ_Thick_Max.y = (int) java.lang.Math.round(YRatio_Right * Squ_Thick * Squ_Thick_Max / 100);

        Vert_Squ_Thick_Min.x = (int) java.lang.Math.round(XRatio * Squ_Thick * Squ_Thick_Min / 100);
        Vert_Squ_Thick_Min.y = (int) java.lang.Math.round(YRatio_Right * Squ_Thick * Squ_Thick_Min / 100);
    }

    private boolean Get_Bottom_Ali_Positions(Bitmap BmOmr, int Ans_Sheet_Type) {

        int Point_Num;
        Point A = new Point(0, 0);
        Point Left = new Point(0, 0);
        Point Right = new Point(0, 0);
        Point Top = new Point(0, 0);
        Point Bottom = new Point(0, 0);
        Point Hori_Squ_Thick_Max = new Point(0, 0);
        Point Hori_Squ_Thick_Min = new Point(0, 0);
        Point Hori_Blank_Space = new Point(0, 0);
        Point Ali = new Point(0, 0);
        boolean ret = false;

        for (Point_Num = 1; Point_Num <= Bottom_Ali_Points_Cnt; Point_Num++) {

            A = Get_Bottom_Ali_Point_Def(Point_Num);
            A = Get_Point(new PointD(A));
            Get_Bottom_Ali_Search_Area(A, BmOmr.getHeight(), BmOmr.getWidth(), Left, Right, Top, Bottom, Hori_Squ_Thick_Max, Hori_Squ_Thick_Min, Hori_Blank_Space);

            //Call Draw_Rectangle(BmOmr, Left_x, Right_x, Top_y, Bottom_y)

            ret = Get_Alignment_Point(BmOmr, false, Hori_Blank_Space, Hori_Squ_Thick_Max, Hori_Squ_Thick_Min, Left.x, Right.x, Top.y, Bottom.y, Ali);

            Bottom_Ali[Point_Num].x = Ali.x;
            Bottom_Ali[Point_Num].y = Ali.y;

            if (!ret) break;
        }

        return ret;
    }

    private boolean CheckLoop(int from, int to, int i){

        if(from < to) {
            if (i <= to) {
                return true;
            }
            else {
                return false;
            }
        }
        else if(from > to){
            if(i >= to){
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if(i == from){
                return true;
            }
            else {
                return false;
            }
        }
    }

    private void Draw_Rectangle(Bitmap Bm, int Left_x, int Right_x, int Top_y, int Bottom_y) {

        int i;

        for (i = Left_x; CheckLoop(Left_x, Right_x, i); i += ((Right_x - Left_x) / java.lang.Math.abs(Right_x - Left_x))) {
            Bm.setPixel(i, Top_y, Color.RED);
            Bm.setPixel(i, Bottom_y, Color.RED);
        }

        for (i = Top_y; CheckLoop(Top_y, Bottom_y, i); i += (Bottom_y - Top_y) / java.lang.Math.abs(Bottom_y - Top_y)) {
            Bm.setPixel(Left_x, i, Color.RED);
            Bm.setPixel(Right_x, i, Color.RED);
        }
    }

    private void Get_Bottom_Ali_Search_Area(Point _A,
                                            int Sheet_Hight,
                                            int Sheet_Width,
                                            Point Left,
                                            Point Right,
                                            Point Top,
                                            Point Bottom,
                                            Point Hori_Squ_Thick_Max,
                                            Point Hori_Squ_Thick_Min,
                                            Point Hori_Blank_Space) {

        Point A = new Point(_A);
        Sheet_Hight -= 1;
        Sheet_Width -= 1;

        //Top Left Allignment Area
        Left.x = (int) java.lang.Math.round(A.x - (24 * XRatio));
        Right.x = (int) java.lang.Math.round(A.x + (24 * XRatio));
        Top.y = (int) java.lang.Math.round(A.y + (15 * YRatio_Right)); //Top become bottom for scaning from bottom to top
        Bottom.y = (int) java.lang.Math.round(A.y - (15 * YRatio_Right));

        if (Left.x < 0) Left.x = 0;
        if (Right.x > Sheet_Width) Right.x = Sheet_Width;
        if (Top.y < 0) Top.y = 0;
        if (Bottom.y > Sheet_Hight) Bottom.y = Sheet_Hight;

        Hori_Blank_Space.x = (int) java.lang.Math.round(XRatio_Bottom * Squ_Blank_Space_Length_Wise);
        Hori_Blank_Space.y = (int) java.lang.Math.round(YRatio * Squ_Blank_Space_Width_Wise);

        Hori_Squ_Thick_Max.x = (int) java.lang.Math.round(XRatio_Bottom * Squ_Thick * Squ_Thick_Max / 100);
        Hori_Squ_Thick_Max.y = (int) java.lang.Math.round(YRatio * Squ_Thick * Squ_Thick_Max / 100);

        Hori_Squ_Thick_Min.x = (int) java.lang.Math.round(XRatio_Bottom * Squ_Thick * Squ_Thick_Min / 100);
        Hori_Squ_Thick_Min.y = (int) java.lang.Math.round(YRatio * Squ_Thick * Squ_Thick_Min / 100);
    }

    //region Create_OMR_Ans_Sheet
    /*
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
    */
    //endregion

    /*
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
    */

    public void Get_All_Bubble_Mark(int Tot_Question, Bitmap BmOmr, boolean[][] Digit_Mark, boolean[][] Answer_Mark) {

        double[][] Digit_Bri = new double[5][11]; //Digit Place, Digit Count
        double[][] Answer_Bri; //Tot Qu, Choice
        double Brightness_Level;
        int Digit_Place;
        int Digit_Cnt;
        int Qu_Num;
        int Choice;

        Brightness_Level = Get_All_Bubble_Brightness(Tot_Question, BmOmr, Digit_Bri, Answer_Bri);

        Answer_Mark = new boolean[Tot_Question + 1][6];

        for (Digit_Place = 1; Digit_Place <= 4; Digit_Place++) {
            for (Digit_Cnt = 1; Digit_Cnt <= 10; Digit_Cnt++) {

                if (Digit_Bri[Digit_Place][Digit_Cnt] < Brightness_Level) {
                    Digit_Mark[Digit_Place][Digit_Cnt] = true;
                } else {
                    Digit_Mark[Digit_Place][Digit_Cnt] = false;
                }

            }
        }

        for (Qu_Num = 1; Qu_Num <= Tot_Question; Qu_Num++) {
            for (Choice = 1; Choice <= Total_Choice; Choice++) {

                if (Answer_Bri[Qu_Num][Choice] < Brightness_Level) {
                    Answer_Mark[Qu_Num][Choice] = true;
                } else {
                    Answer_Mark[Qu_Num][Choice] = false;
                }
            }
        }
    }

    public double Get_All_Bubble_Brightness(int Tot_Question , Bitmap BmOmr, double Digit_Bri[][], double Answer_Bri[][]) {

        int Digit_Place;
        int Digit_Cnt;
        int Qu_Num;
        int Choice;
        double Max_Bri = -100;
        double Min_Bri = 100;
        double Brightness_Level;

        Answer_Bri = new double[Tot_Question + 1][6];

        for (Digit_Place = 1; Digit_Place <= 4; Digit_Place++) {
            for (Digit_Cnt = 1; Digit_Cnt <= 10; Digit_Cnt++) {

                Digit_Bri[Digit_Place][Digit_Cnt] = Get_RollNo_Mark_Brightness(BmOmr, Digit_Cnt, Digit_Place);

                if (Digit_Bri[Digit_Place][Digit_Cnt] > Max_Bri) {
                    Max_Bri = Digit_Bri[Digit_Place][Digit_Cnt];
                }

                if (Digit_Bri[Digit_Place][Digit_Cnt] < Min_Bri) {
                    Min_Bri = Digit_Bri[Digit_Place][Digit_Cnt]
                }
            }
        }

        for (Qu_Num = 1; Qu_Num <= Tot_Question; Qu_Num++) {
            for (Choice = 1; Choice <= Total_Choice; Choice++) {

                Answer_Bri[Qu_Num][Choice] = Get_Ans_Bubble_Mark_Brightness(BmOmr, Qu_Num, Choice);

                if (Answer_Bri[Qu_Num][Choice] > Max_Bri) {
                    Max_Bri = Answer_Bri[Qu_Num][Choice];
                }

                if (Answer_Bri[Qu_Num][Choice] < Min_Bri) {
                    Min_Bri = Answer_Bri[Qu_Num][Choice];
                }
            }
        }

        if ((Max_Bri - Min_Bri) < 0.2) {
            Brightness_Level = 0.5;
        } else {
            Brightness_Level = (Max_Bri + Min_Bri) / 2.0;
        }

        return Brightness_Level;
    }
}
