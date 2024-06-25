Imports MySql.Data.MySqlClient

Public Class WebForm3
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load

    End Sub

    Protected Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        On Error Resume Next
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand("insert into courses(CourseCode, CourseName) values(@CourseCode, @CourseName);", con)
        With com.Parameters
            .AddWithValue("@CourseCode", TextBox1.Text)
            .AddWithValue("@CourseName", TextBox2.Text)
        End With
        Dim c As Integer = com.ExecuteNonQuery
        Session("isshow") = 1
        Session("success") = c
        Response.Redirect("Dashboard.aspx")
        con.Close()
    End Sub
End Class