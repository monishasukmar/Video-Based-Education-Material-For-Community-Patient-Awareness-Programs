Imports MySql.Data.MySqlClient

Public Class WebForm8
    Inherits System.Web.UI.Page

    Protected Sub Page_Load(ByVal sender As Object, ByVal e As System.EventArgs) Handles Me.Load
        On Error Resume Next
        Dim con As New MySqlConnection(constr)
        con.Open()
        Dim com As New MySqlCommand(String.Format("select * from quiz1 where CourseCode='{0}';", Session("selid")), con)
        Dim rs As MySqlDataReader
        rs = com.ExecuteReader
        Dim sno As Integer = 1
        While rs.Read
            Dim tr As New TableRow
            Dim tsno, ttitle, top1, top2, top3, top4, tedit, tdel As New TableCell
            Dim ledit, ldel As New LinkButton
            ledit.Text = "Edit"
            ldel.Text = "Delete"
            ledit.Attributes.Add("ide1", rs("q_no"))
            ldel.Attributes.Add("ide1", rs("q_no"))
            AddHandler ldel.Click, AddressOf delrecord
            AddHandler ledit.Click, AddressOf editrecord
            ttitle.Text = rs("Questions")
            top1.Text = rs("Op1")
            top2.Text = rs("Op2")
            top3.Text = rs("Op3")
            top4.Text = rs("Op4")
            Dim ans As String = rs("Ans")
            If ans.Equals(top1.Text) Then
                top1.Attributes.Add("class", "tdnormalbold")
                top2.Attributes.Add("class", "tdnormal")
                top3.Attributes.Add("class", "tdnormal")
                top4.Attributes.Add("class", "tdnormal")
            ElseIf ans.Equals(top2.Text) Then
                top2.Attributes.Add("class", "tdnormalbold")
                top1.Attributes.Add("class", "tdnormal")
                top3.Attributes.Add("class", "tdnormal")
                top4.Attributes.Add("class", "tdnormal")
            ElseIf ans.Equals(top3.Text) Then
                top3.Attributes.Add("class", "tdnormalbold")
                top2.Attributes.Add("class", "tdnormal")
                top1.Attributes.Add("class", "tdnormal")
                top4.Attributes.Add("class", "tdnormal")
            Else
                top4.Attributes.Add("class", "tdnormalbold")
                top2.Attributes.Add("class", "tdnormal")
                top3.Attributes.Add("class", "tdnormal")
                top1.Attributes.Add("class", "tdnormal")
            End If
            tsno.Text = sno
            tedit.Controls.Add(ledit)
            tdel.Controls.Add(ldel)
            tsno.Attributes.Add("class", "tdcenter")
            tedit.Attributes.Add("class", "tdcenter")
            tdel.Attributes.Add("class", "tdcenter")
            tr.Cells.Add(tsno)
            tr.Cells.Add(ttitle)
            tr.Cells.Add(top1)
            tr.Cells.Add(top2)
            tr.Cells.Add(top3)
            tr.Cells.Add(top4)
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
        Dim com As New MySqlCommand(String.Format("delete from quiz1 where q_no='{0}'", ll.Attributes("ide1")), con)
        com.ExecuteNonQuery()
        con.Close()
        Response.Redirect("ViewPostQuestions.aspx")
    End Sub


    Public Sub editrecord(sender As Object, e As EventArgs)
        Dim l As LinkButton = sender
        Dim id As Integer = l.Attributes("ide1")
        Session("eid") = id
        Response.Redirect("EditPostQuestions.aspx")
    End Sub

End Class