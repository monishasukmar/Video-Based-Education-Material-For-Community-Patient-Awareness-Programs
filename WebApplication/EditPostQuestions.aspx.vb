Imports MySql.Data.MySqlClient

Public Class WebForm14
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        On Error Resume Next
        If IsPostBack Then
            Exit Sub
        End If
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("select * from quiz1 where q_no='{0}'", Session("eid")), con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        If rs.Read Then
            TextBox1.Text = rs("Questions")
            TextBox2.Text = rs("Op1")
            TextBox3.Text = rs("Op2")
            TextBox4.Text = rs("Op3")
            TextBox5.Text = rs("Op4")
            Dim ans As String = rs("Ans")
            If ans.Equals(TextBox2.Text) Then
                DropDownList1.SelectedIndex = 0
            ElseIf ans.Equals(TextBox3.Text) Then
                DropDownList1.SelectedIndex = 1
            ElseIf ans.Equals(TextBox4.Text) Then
                DropDownList1.SelectedIndex = 2
            Else
                DropDownList1.SelectedIndex = 3
            End If
        End If
        rs.Close()
        con.Close()
    End Sub

    Protected Sub Button1_Click(sender As Object, e As EventArgs) Handles Button1.Click
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim str As String
        str = "update quiz1 set Questions=@q1, Op1=@o1, Op2=@o2, Op3=@o3, Op4=@o4, Ans=@a1 where q_no=@qno;"
        Dim com As New MySqlCommand(str, con)
        With com.Parameters
            .AddWithValue("@q1", TextBox1.Text)
            .AddWithValue("@o1", TextBox2.Text)
            .AddWithValue("@o2", TextBox3.Text)
            .AddWithValue("@o3", TextBox4.Text)
            .AddWithValue("@o4", TextBox5.Text)
            If DropDownList1.SelectedIndex = 0 Then
                .AddWithValue("@a1", TextBox2.Text)
            ElseIf DropDownList1.SelectedIndex = 1 Then
                .AddWithValue("@a1", TextBox3.Text)
            ElseIf DropDownList1.SelectedIndex = 2 Then
                .AddWithValue("@a1", TextBox4.Text)
            Else
                .AddWithValue("@a1", TextBox5.Text)
            End If
            .AddWithValue("@qno", Session("eid"))
        End With
        Dim c As Integer = com.ExecuteNonQuery
        Session("isshow") = 1
        Session("success") = c
        Response.Redirect("Dashboard.aspx")
        con.Close()
    End Sub
End Class