Imports MySql.Data.MySqlClient

Public Class WebForm7
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        On Error Resume Next
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand("insert into quiz1(CourseCode, Questions, Op1, Op2, Op3, Op4, Ans) values(@CourseCode, @Questions, @Op1, @Op2, @Op3, @Op4, @Ans);", con)
        With com.Parameters
            .AddWithValue("@CourseCode", Session("selid"))
            .AddWithValue("@Questions", TextBox1.Text)
            .AddWithValue("@Op1", TextBox2.Text)
            .AddWithValue("@Op2", TextBox3.Text)
            .AddWithValue("@Op3", TextBox4.Text)
            .AddWithValue("@Op4", TextBox5.Text)
            If DropDownList1.SelectedIndex = 0 Then
                .AddWithValue("@Ans", TextBox2.Text)
            ElseIf DropDownList1.SelectedIndex = 1 Then
                .AddWithValue("@Ans", TextBox3.Text)
            ElseIf DropDownList1.SelectedIndex = 2 Then
                .AddWithValue("@Ans", TextBox4.Text)
            ElseIf DropDownList1.SelectedIndex = 3 Then
                .AddWithValue("@Ans", TextBox5.Text)
            End If
        End With
        Dim c As Integer = com.ExecuteNonQuery
        Session("isshow") = 1
        Session("success") = c
        Response.Redirect("Dashboard.aspx")
        con.Close()
    End Sub
End Class