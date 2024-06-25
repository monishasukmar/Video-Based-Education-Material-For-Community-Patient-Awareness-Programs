Imports MySql.Data.MySqlClient

Public Class WebForm1
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        On Error Resume Next
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand("select * from courses;", con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        Dim sno As Integer = 1
        While rs.Read
            Dim tr As New TableRow
            Dim tsno, tcid, tcn, tedit, tdel As New TableCell
            Dim ledit, ldel As New LinkButton
            ledit.Text = "Edit"
            ldel.Text = "Delete"
            ledit.Attributes.Add("ide1", rs("idcourses"))
            ldel.Attributes.Add("ide1", rs("idcourses"))
            AddHandler ldel.Click, AddressOf delrecord
            AddHandler ledit.Click, AddressOf editrecord
            tcid.Text = rs("CourseCode")
            tcn.Text = rs("CourseName")
            tsno.Text = sno
            tedit.Controls.Add(ledit)
            tdel.Controls.Add(ldel)
            tsno.Attributes.Add("class", "tdcenter")
            tedit.Attributes.Add("class", "tdcenter")
            tdel.Attributes.Add("class", "tdcenter")
            tr.Cells.Add(tsno)
            tr.Cells.Add(tcid)
            tr.Cells.Add(tcn)
            tr.Cells.Add(tedit)
            tr.Cells.Add(tdel)
            Table1.Rows.Add(tr)
            sno = sno + 1
        End While
        rs.Close()
        con.Close()
    End Sub

    Public Sub delrecord(sender As Object, e As EventArgs)
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim ll As LinkButton = sender
        Dim com As New MySqlCommand(String.Format("delete from courses where idcourses='{0}'", ll.Attributes("ide1")), con)
        com.ExecuteNonQuery()
        con.Close()
        Response.Redirect("ViewCourse.aspx")
    End Sub

    Public Sub editrecord(s As Object, e As EventArgs)
        Dim ll As LinkButton = s
        Dim id As String = ll.Attributes("ide1")
        Session("eid") = id
        Response.Redirect("EditCourses.aspx")
    End Sub
End Class