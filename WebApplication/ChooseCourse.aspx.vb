Imports MySql.Data.MySqlClient

Public Class WebForm9
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
            Dim tsno, tcid, tcn, tchoose As New TableCell
            Dim lchoose As New LinkButton
            lchoose.Text = "Choose"
            lchoose.Attributes.Add("ide1", rs("CourseCode"))
            AddHandler lchoose.Click, AddressOf choose
            tcid.Text = rs("CourseCode")
            tcn.Text = rs("CourseName")
            tsno.Text = sno
            tchoose.Controls.Add(lchoose)
            tsno.Attributes.Add("class", "tdcenter")
            tchoose.Attributes.Add("class", "tdcenter")
            tr.Cells.Add(tsno)
            tr.Cells.Add(tcid)
            tr.Cells.Add(tcn)
            tr.Cells.Add(tchoose)
            Table1.Rows.Add(tr)
            sno = sno + 1
        End While
        rs.Close()
        con.Close()
    End Sub

    Public Sub choose(s As Object, e As EventArgs)
        Dim ll As LinkButton = s
        Session("selid") = ll.Attributes("ide1")
        Response.Redirect(Session("where"))
    End Sub

End Class