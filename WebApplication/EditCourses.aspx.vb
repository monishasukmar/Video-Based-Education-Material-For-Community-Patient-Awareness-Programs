Imports MySql.Data.MySqlClient

Public Class WebForm12
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        On Error Resume Next
        If IsPostBack Then
            Exit Sub
        End If
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("select * from courses where idcourses='{0}'", Session("eid")), con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        If rs.Read Then
            TextBox1.Text = rs("CourseCode")
            TextBox2.Text = rs("CourseName")
        End If
        rs.Close()
        con.Close()
    End Sub

    Protected Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        On Error Resume Next
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand("update courses set CourseCode=@CourseCode, CourseName=@CourseName where idcourses=@old;", con)
        With com.Parameters
            .AddWithValue("@CourseCode", TextBox1.Text)
            .AddWithValue("@CourseName", TextBox2.Text)
            .AddWithValue("@old", Session("eid"))
        End With
        Dim c As Integer = com.ExecuteNonQuery
        Session("isshow") = 1
        Session("success") = c
        Response.Redirect("Dashboard.aspx")
        con.Close()
    End Sub
End Class